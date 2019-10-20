package com.sxit.meeting.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sxit.meeting.entity.Employee;
import com.sxit.meeting.service.EmployeeService;

/**
 * Servlet implementation class ChangePwdServlet
 */
public class ChangePwdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangePwdServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			Employee employee = (Employee) request.getSession().getAttribute("employee");
			Integer employeeid = employee.getEmployeeid();
			String newPwd = request.getParameter("newPwd");
			EmployeeService employeeService = new EmployeeService();
			employeeService.changePwd(newPwd,employeeid);
			request.getSession().removeAttribute("employee");
			request.setAttribute("msg", "密码修改成功，请重新登录");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("msg", "网络异常，请联系管理员");
			request.getRequestDispatcher("/pages/error.jsp").forward(request, response);
		}
	}

}
