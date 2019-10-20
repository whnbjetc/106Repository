package com.sxit.meeting.entity;

import java.io.Serializable;
import javax.persistence.*;


public class Meetingparticipant  {

	private int id;

	private int employeeid;

	private String meetingid;

	public Meetingparticipant() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getEmployeeid() {
		return this.employeeid;
	}

	public void setEmployeeid(int employeeid) {
		this.employeeid = employeeid;
	}

	public String getMeetingid() {
		return this.meetingid;
	}

	public void setMeetingid(String meetingid) {
		this.meetingid = meetingid;
	}

}