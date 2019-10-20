package com.sxit.meeting.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sxit.meeting.entity.Employee;
import com.sxit.meeting.service.EmployeeService;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			EmployeeService employeeService = new EmployeeService();
			Employee employee = employeeService.login(username, password);
			if(employee!=null){
				String status = employee.getStatus();
				if(status.equals("0")){
					request.setAttribute("msg", "该用户待审批，请审批通过后再登录");
					request.getRequestDispatcher("/login.jsp").forward(request, response);
				}else if(status.equals("1")){
					String role = employee.getRole();
					request.getSession().setAttribute("employee", employee);
					//request.setAttribute("employee", employee);
					if(role.equals("1")){
						request.getRequestDispatcher("/pages/admin_index.jsp").forward(request, response);
					}else if(role.equals("2")){
						request.getRequestDispatcher("/pages/emp_index.jsp").forward(request, response);
					}
					
				}else if(status.equals("2")){
					request.setAttribute("msg", "审批未通过");
					request.getRequestDispatcher("/login.jsp").forward(request, response);
				}else if(status.equals("3")){
					request.setAttribute("msg", "账号已被禁用");
					request.getRequestDispatcher("/login.jsp").forward(request, response);
				}
			}else{
				request.setAttribute("msg", "用户名或密码输入错误");
				request.getRequestDispatcher("/login.jsp").forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("msg", "网络异常，请联系管理员");
			request.getRequestDispatcher("/pages/error.jsp").forward(request, response);
		}
		
		
		
		
	}

}
