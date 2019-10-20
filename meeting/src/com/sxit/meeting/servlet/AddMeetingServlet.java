package com.sxit.meeting.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sxit.meeting.entity.Employee;
import com.sxit.meeting.service.MeetingRoomService;
import com.sxit.meeting.service.MeetingService;

public class AddMeetingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddMeetingServlet() {
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
		String meetingname = request.getParameter("meetingname");
		String roomid = request.getParameter("roomid");
		String numberofparticipants = request.getParameter("numberofparticipants");
		String starttime = request.getParameter("starttime");
		String endtime = request.getParameter("endtime");
		String description = request.getParameter("description");
		String selEmpIds = request.getParameter("selEmpIds");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		MeetingService service = new MeetingService();
		Employee employee = (Employee) request.getSession().getAttribute("employee");
		try {
			service.addMeeting(meetingname,Integer.parseInt(roomid),Integer.parseInt(numberofparticipants)
					,sdf.parse(starttime),sdf.parse(endtime),description,selEmpIds,employee.getEmployeeid());
			request.setAttribute("msg", "Ìí¼Ó³É¹¦");
			request.getRequestDispatcher("BookMeetingServlet").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

