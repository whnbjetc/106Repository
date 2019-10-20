package com.sxit.meeting.service;

import java.util.List;

import com.sxit.meeting.dao.MeetingRoomDao;
import com.sxit.meeting.entity.Meetingroom;

public class MeetingRoomService {
	
	
	public void addMeetingRoom(int roomnumber,String capacity,int roomcapacity,String status,String description) throws Exception{
		MeetingRoomDao dao = new MeetingRoomDao();
		try {
			dao.addMeetingRoom(roomnumber, capacity, roomcapacity, status, description);
		} catch (Exception e) {
			throw e;
		} finally{
			dao.closeConnection();
		}
	}
	
	public void editMeetingRoom(int roomid,int roomnumber,String capacity,int roomcapacity,String status,String description) throws Exception{
		MeetingRoomDao dao = new MeetingRoomDao();
		try {
			dao.editMeetingRoom(roomid,roomnumber, capacity, roomcapacity, status, description);
		} catch (Exception e) {
			throw e;
		} finally{
			dao.closeConnection();
		}
	}
	
	public Meetingroom findByRoomnum(int roomnum) throws Exception{
		Meetingroom room = null;
		MeetingRoomDao dao = new MeetingRoomDao();
		try {
			room = dao.findByRoomnum(roomnum);
		} catch (Exception e) {
			throw e;
		} finally{
			dao.closeConnection();
		}
		return room;
	}
	
	public Meetingroom findByRoomname(String roomname) throws Exception{
		Meetingroom room = null;
		MeetingRoomDao dao = new MeetingRoomDao();
		try {
			room = dao.findByRoomname(roomname);
		} catch (Exception e) {
			throw e;
		} finally{
			dao.closeConnection();
		}
		return room;
	}
	
	public List<Meetingroom> findAll() throws Exception{
		List<Meetingroom> list = null;
		MeetingRoomDao dao = new MeetingRoomDao();
		try {
			list = dao.findAll();
		} catch (Exception e) {
			throw e;
		} finally{
			dao.closeConnection();
		}
		return list;
	}
	
	public List<Meetingroom> findByStatus(String status) throws Exception{
		List<Meetingroom> list = null;
		MeetingRoomDao dao = new MeetingRoomDao();
		try {
			list = dao.findByStatus(status);
		} catch (Exception e) {
			throw e;
		} finally{
			dao.closeConnection();
		}
		return list;
	}
	
	public String deleteMeetingroom(int roomid) throws Exception{
		String msg = "";
		MeetingRoomDao dao = new MeetingRoomDao();
		try {
			//�жϸû������Ƿ��ڱ�ռ�ã�������ռ������ʾ���ܱ�ɾ��
			int count = dao.findMeetingByRoomid(roomid);
			if(count>0){
				msg = "�û���������ռ�ã��޷�ɾ��";
			}else{
				dao.deleteMeetingroom(roomid);
				msg = "ɾ���ɹ�";
			}
		} catch (Exception e) {
			throw e;
		} finally{
			dao.closeConnection();
		}
		return msg;
	}
	
	public Meetingroom findByRoomid(int roomid) throws Exception{
		Meetingroom room = null;
		MeetingRoomDao dao = new MeetingRoomDao();
		try {
			room = dao.findByRoomid(roomid);
		} catch (Exception e) {
			throw e;
		} finally{
			dao.closeConnection();
		}
		return room;
	}
}
