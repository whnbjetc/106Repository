package com.sxit.meeting.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sxit.meeting.service.MeetingRoomService;

/**
 * Servlet implementation class AddMeetingRoomServlet
 */
public class AddMeetingRoomServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddMeetingRoomServlet() {
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
		String roomnumber = request.getParameter("roomnumber");
		String capacity = request.getParameter("capacity");
		String roomcapacity = request.getParameter("roomcapacity");
		String status = request.getParameter("status");
		String description = request.getParameter("description");
		MeetingRoomService service = new MeetingRoomService();
		try {
			service.addMeetingRoom(Integer.parseInt(roomnumber), capacity, Integer.parseInt(roomcapacity), status, description);
			request.setAttribute("msg", "Ìí¼Ó³É¹¦");
			request.getRequestDispatcher("pages/addmeetingroom.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
