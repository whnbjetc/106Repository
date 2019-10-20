package com.sxit.meeting.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.Date;

public class MeetingDao extends BaseDao{

	/**
	 * 通过时间查询是否有会议室被占用
	 * @param starttime
	 * @param endtime
	 * @return
	 * @throws Exception 
	 */
	public int findCountByTime(Date starttime,Date endtime,int roomid) throws Exception{
		int count = 0;
		this.openConnection();
		String sql = "select count(*) from meeting where ((starttime between ? and ?) or (endtime BETWEEN ? and ?) or (starttime<=? and endtime>=?)) and status=0 and roomid=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setTimestamp(1, new Timestamp(starttime.getTime()));
		pstmt.setTimestamp(2, new Timestamp(endtime.getTime()));
		pstmt.setTimestamp(3, new Timestamp(starttime.getTime()));
		pstmt.setTimestamp(4, new Timestamp(endtime.getTime()));
		pstmt.setTimestamp(5, new Timestamp(starttime.getTime()));
		pstmt.setTimestamp(6, new Timestamp(endtime.getTime()));
		pstmt.setInt(7, roomid);
		ResultSet rs = pstmt.executeQuery();
		if(rs.next()){
			count = rs.getInt(1);
		}
		rs.close();
		pstmt.close();
		return count;
	}
	
	public void saveMeeting(String meetingid,String meetingname,int roomid,int numberofparticipants
			,Date starttime,Date endtime,String description,int employeeid) throws Exception{
		this.openConnection();
		String sql = "insert into meeting(meetingid,meetingname,roomid,numberofparticipants,starttime,endtime,reservationtime,description,status,reservationistid) values(?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, meetingid);
		pstmt.setString(2, meetingname);
		pstmt.setInt(3, roomid);
		pstmt.setInt(4, numberofparticipants);
		pstmt.setTimestamp(5, new Timestamp(starttime.getTime()));
		pstmt.setTimestamp(6, new Timestamp(endtime.getTime()));
		pstmt.setTimestamp(7, new Timestamp(new Date().getTime()));
		pstmt.setString(8, description);
		pstmt.setString(9, "0");
		pstmt.setInt(10, employeeid);
		pstmt.execute();
		pstmt.close();
	}
	
	public void saveRelMeeting(String meetingid,int empid) throws Exception{
		this.openConnection();
		String sql = "insert into meetingparticipants(meetingid,employeeid) values (?,?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, meetingid);
		pstmt.setInt(2, empid);
		pstmt.execute();
		pstmt.close();
	}
}
