package com.sxit.meeting.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sxit.meeting.entity.Meetingroom;
import com.sxit.meeting.service.MeetingRoomService;

public class AjaxCheckRoomnameServlet extends HttpServlet  {

	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String capacity = request.getParameter("capacity");
		MeetingRoomService service = new MeetingRoomService();
		try {
			Meetingroom room = service.findByRoomname(capacity);
			PrintWriter out = response.getWriter();
			if(room!=null){
				out.print("fail");
			}else{
				out.print("success");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
