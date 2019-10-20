package com.sxit.meeting.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sxit.meeting.service.EmployeeService;

/**
 * Servlet implementation class ApproveServlet
 */
public class ApproveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ApproveServlet() {
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
		String status = request.getParameter("status");
		String employeeid = request.getParameter("employeeid");
		String index = request.getParameter("index");
		EmployeeService service = new EmployeeService();
		try {
			service.approveEmployee(status,Integer.parseInt(employeeid));
			if(index!=null && !"".equals(index)){
				request.setAttribute("msg", "操作成功");
				request.getRequestDispatcher("SearchEmployeeServlet").forward(request, response);
			}else{
				request.setAttribute("msg", "审批成功");
				request.getRequestDispatcher("ApproveAccountServlet").forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
