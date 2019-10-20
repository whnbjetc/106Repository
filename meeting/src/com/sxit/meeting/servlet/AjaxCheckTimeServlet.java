package com.sxit.meeting.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sxit.meeting.entity.Meetingroom;
import com.sxit.meeting.service.MeetingRoomService;
import com.sxit.meeting.service.MeetingService;

import net.sf.json.JSONObject;

public class AjaxCheckTimeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjaxCheckTimeServlet() {
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
		String endtime = request.getParameter("endtime");
		String starttime = request.getParameter("starttime");
		String roomid = request.getParameter("roomid");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		MeetingService service = new MeetingService();
		try {
			int count = service.findCountByTime(sdf.parse(starttime), sdf.parse(endtime),Integer.parseInt(roomid));
			PrintWriter out = response.getWriter();
			if(count>0){
				out.print("fail");
			}else{
				out.print("success");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}

