package com.sxit.meeting.service;

import java.util.Date;
import java.util.UUID;

import com.sxit.meeting.dao.MeetingDao;

public class MeetingService {
	
	/**
	 * ͨ��ʱ���ѯ�Ƿ��л����ұ�ռ��
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
			//���������Ϣ
			String meetingid = UUID.randomUUID().toString();
			dao.saveMeeting(meetingid,meetingname,roomid,numberofparticipants,starttime,endtime,description,employeeid);
			//���������Ϣ
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
