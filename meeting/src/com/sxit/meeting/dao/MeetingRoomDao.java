package com.sxit.meeting.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.sxit.meeting.entity.Meeting;
import com.sxit.meeting.entity.Meetingroom;

public class MeetingRoomDao extends BaseDao{

	public void addMeetingRoom(int roomnumber,String capacity,int roomcapacity,String status,String description) throws Exception{
		this.openConnection();
		String sql = "insert into meetingroom(capacity,description,roomname,roomnum,status) values (?,?,?,?,?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, roomcapacity);
		pstmt.setString(2, description);
		pstmt.setString(3, capacity);
		pstmt.setInt(4, roomnumber);
		pstmt.setString(5, status);
		pstmt.execute();
		pstmt.close();
	}
	
	public void editMeetingRoom(int roomid,int roomnumber,String capacity,int roomcapacity,String status,String description) throws Exception{
		this.openConnection();
		String sql = "update meetingroom set capacity=?,description=?,roomname=?,roomnum=?,status=? where roomid=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, roomcapacity);
		pstmt.setString(2, description);
		pstmt.setString(3, capacity);
		pstmt.setInt(4, roomnumber);
		pstmt.setString(5, status);
		pstmt.setInt(6, roomid);
		pstmt.execute();
		pstmt.close();
	}
	
	public Meetingroom findByRoomnum(int roomnum) throws Exception{
		Meetingroom room = null;
		this.openConnection();
		String sql = "select * from meetingroom where roomnum=? and status!=2";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, roomnum);
		ResultSet rs = pstmt.executeQuery();
		if(rs.next()){
			room = new Meetingroom();
			room.setCapacity(rs.getInt("capacity"));
			room.setDescription(rs.getString("description"));
			room.setRoomid(rs.getInt("roomid"));
			room.setRoomname(rs.getString("roomname"));
			room.setRoomnum(rs.getInt("roomnum"));
			room.setStatus(rs.getString("status"));
		}
		return room;
	}
	
	public Meetingroom findByRoomname(String roomname) throws Exception{
		Meetingroom room = null;
		this.openConnection();
		String sql = "select * from meetingroom where roomname=? and status!=2";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, roomname);
		ResultSet rs = pstmt.executeQuery();
		if(rs.next()){
			room = new Meetingroom();
			room.setCapacity(rs.getInt("capacity"));
			room.setDescription(rs.getString("description"));
			room.setRoomid(rs.getInt("roomid"));
			room.setRoomname(rs.getString("roomname"));
			room.setRoomnum(rs.getInt("roomnum"));
			room.setStatus(rs.getString("status"));
		}
		rs.close();
		pstmt.close();
		return room;
	}
	
	public List<Meetingroom> findAll() throws Exception{
		List<Meetingroom> list = new ArrayList<Meetingroom>();
		this.openConnection();
		String sql = "select * from meetingroom where status!=2";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()){
			Meetingroom room = new Meetingroom();
			room.setCapacity(rs.getInt("capacity"));
			room.setDescription(rs.getString("description"));
			room.setRoomid(rs.getInt("roomid"));
			room.setRoomname(rs.getString("roomname"));
			room.setRoomnum(rs.getInt("roomnum"));
			room.setStatus(rs.getString("status"));
			list.add(room);
		}
		rs.close();
		pstmt.close();
		return list;
	}
	
	public List<Meetingroom> findByStatus(String status) throws Exception{
		List<Meetingroom> list = new ArrayList<Meetingroom>();
		this.openConnection();
		String sql = "select * from meetingroom where status=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, status);
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()){
			Meetingroom room = new Meetingroom();
			room.setCapacity(rs.getInt("capacity"));
			room.setDescription(rs.getString("description"));
			room.setRoomid(rs.getInt("roomid"));
			room.setRoomname(rs.getString("roomname"));
			room.setRoomnum(rs.getInt("roomnum"));
			room.setStatus(rs.getString("status"));
			list.add(room);
		}
		rs.close();
		pstmt.close();
		return list;
	}
	
	public int findMeetingByRoomid(int roomid) throws Exception{
		int count = 0;
		this.openConnection();
		String sql = "select count(*) from meeting where roomid=? and status=0 and endtime>sysdate()";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, roomid);
		ResultSet rs = pstmt.executeQuery();
		if(rs.next()){
			count = rs.getInt(1);
		}
		rs.close();
		pstmt.close();
		return count;
	}
	
	public void deleteMeetingroom(int roomid) throws Exception{
		this.openConnection();
		String sql = "update meetingroom set status=? where roomid=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, "2");
		pstmt.setInt(2, roomid);
		pstmt.execute();
		pstmt.close();
	}
	
	public Meetingroom findByRoomid(int roomid) throws Exception{
		Meetingroom room = null;
		this.openConnection();
		String sql = "select * from meetingroom where roomid=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, roomid);
		ResultSet rs = pstmt.executeQuery();
		if(rs.next()){
			room = new Meetingroom();
			room.setCapacity(rs.getInt("capacity"));
			room.setDescription(rs.getString("description"));
			room.setRoomid(rs.getInt("roomid"));
			room.setRoomname(rs.getString("roomname"));
			room.setRoomnum(rs.getInt("roomnum"));
			room.setStatus(rs.getString("status"));
		}
		return room;
	}
}
