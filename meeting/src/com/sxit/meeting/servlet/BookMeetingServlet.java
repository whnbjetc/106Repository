package com.sxit.meeting.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sxit.meeting.entity.Department;
import com.sxit.meeting.entity.Meetingroom;
import com.sxit.meeting.service.DepartmentService;
import com.sxit.meeting.service.MeetingRoomService;

/**
 * Servlet implementation class BookMeetingServlet
 */
public class BookMeetingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookMeetingServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MeetingRoomService service = new MeetingRoomService();
		DepartmentService departmentService = new DepartmentService();
		try {
			List<Meetingroom> meetingroomList = service.findByStatus("0");
			List<Department> departmentList = departmentService.findAll();
			request.setAttribute("meetingroomList", meetingroomList);
			request.setAttribute("departmentList", departmentList);
			request.getRequestDispatcher("pages/bookmeeting.jsp").forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
