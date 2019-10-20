package com.sxit.meeting.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sxit.meeting.entity.Meetingroom;
import com.sxit.meeting.service.MeetingRoomService;

public class MeetingroomDetailServlet extends HttpServlet  {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MeetingRoomService service = new MeetingRoomService();
		String roomid = request.getParameter("roomid");
		try {
			Meetingroom meetingroom = service.findByRoomid(Integer.parseInt(roomid));
			request.setAttribute("meetingroom", meetingroom);
			request.getRequestDispatcher("pages/roomdetails.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
