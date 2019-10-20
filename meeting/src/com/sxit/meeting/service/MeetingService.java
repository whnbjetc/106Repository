package com.sxit.meeting.service;

import java.util.Date;
import java.util.UUID;

import com.sxit.meeting.dao.MeetingDao;

public class MeetingService {
	
	/**
	 * 通过时间查询是否有会议室被占用
	 * @param starttime
	 * @param endtime
	 * @return
	 * @throws Exception 
	 */
	public int findCountByTime(Date starttime,Date endtime,int roomid) throws Exception{
		int count = 0;
		MeetingDao dao = new MeetingDao();
		try {
			count = dao.findCountByTime(starttime, endtime, roomid);
		} catch (Exception e) {
			throw e;
		} finally{
			dao.closeConnection();
		}
		return count;
	}
	
	public void addMeeting(String meetingname,int roomid,int numberofparticipants
			,Date starttime,Date endtime,String description,String selEmpIds,int employeeid) throws Exception{
		MeetingDao dao = new MeetingDao();
		try {
			dao.beginTransaction();
			//保存会议信息
			String meetingid = UUID.randomUUID().toString();
			dao.saveMeeting(meetingid,meetingname,roomid,numberofparticipants,starttime,endtime,description,employeeid);
			//保存关联信息
			String[] empIds = selEmpIds.split(",");
			for(String empid:empIds){
				dao.saveRelMeeting(meetingid,Integer.parseInt(empid));
			}
			dao.commit();
		} catch (Exception e) {
			dao.rollback();
			throw e;
		} finally{
			dao.closeConnection();
		}
	}
}
