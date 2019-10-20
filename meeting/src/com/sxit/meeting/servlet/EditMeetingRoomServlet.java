package com.sxit.meeting.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sxit.meeting.entity.Meetingroom;
import com.sxit.meeting.service.MeetingRoomService;

public class EditMeetingRoomServlet extends HttpServlet  {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MeetingRoomService service = new MeetingRoomService();
		String roomnumber = request.getParameter("roomnumber");
		String capacity = request.getParameter("capacity");
		String roomcapacity = request.getParameter("roomcapacity");
		String status = request.getParameter("status");
		String description = request.getParameter("description");
		String roomid = request.getParameter("roomid");
		try {
			service.editMeetingRoom(Integer.parseInt(roomid),Integer.parseInt(roomnumber), capacity, Integer.parseInt(roomcapacity), status, description);
			request.setAttribute("msg", "ÐÞ¸Ä³É¹¦");
			request.getRequestDispatcher("SearchMeetingroomServlet").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
