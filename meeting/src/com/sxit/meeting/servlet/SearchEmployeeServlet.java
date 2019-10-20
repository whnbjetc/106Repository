package com.sxit.meeting.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sxit.meeting.entity.Employee;
import com.sxit.meeting.service.EmployeeService;
import com.sxit.meeting.util.Constant;
import com.sxit.meeting.util.PageResult;

/**
 * Servlet implementation class SearchEmployeeServlet
 */
public class SearchEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchEmployeeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String username = request.getParameter("username");
			String employeename = request.getParameter("employeename");
			String status = request.getParameter("status");
			String currentPageParameter = request.getParameter("currentPage");
			if(status==null || "".equals(status)){
				status = "1";
			}
			int currentPage = 1;
			if(currentPageParameter!=null && !"".equals(currentPageParameter)){
				currentPage = Integer.parseInt(currentPageParameter);
			}
			
			PageResult<Employee> page = new PageResult<Employee>();
			page.setCurrentPage(currentPage);
			EmployeeService service = new EmployeeService();
			int firstResult = (currentPage-1)*Constant.pageSize;
			int maxResult = Constant.pageSize;
			service.pageList(page,firstResult,maxResult,username,employeename,status);
			request.setAttribute("page", page);
			request.setAttribute("employeename", employeename);
			request.setAttribute("username", username);
			request.setAttribute("status", status);
			request.getRequestDispatcher("pages/searchemployees.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
