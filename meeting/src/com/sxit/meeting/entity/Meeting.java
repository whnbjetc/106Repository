package com.sxit.meeting.entity;

import java.util.Date;


public class Meeting  {

	private String meetingid;

	private Date canceledtime;

	private String description;

	private Date endtime;

	private String meetingname;

	private int numberofparticipants;

	private int reservationistid;

	private Date reservationtime;

	private int roomid;

	private Date starttime;

	private String status;

	public Meeting() {
	}

	public String getMeetingid() {
		return this.meetingid;
	}

	public void setMeetingid(String meetingid) {
		this.meetingid = meetingid;
	}

	public Date getCanceledtime() {
		return this.canceledtime;
	}

	public void setCanceledtime(Date canceledtime) {
		this.canceledtime = canceledtime;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getEndtime() {
		return this.endtime;
	}

	public void setEndtime(Date endtime) {
		this.endtime = endtime;
	}

	public String getMeetingname() {
		return this.meetingname;
	}

	public void setMeetingname(String meetingname) {
		this.meetingname = meetingname;
	}

	public int getNumberofparticipants() {
		return this.numberofparticipants;
	}

	public void setNumberofparticipants(int numberofparticipants) {
		this.numberofparticipants = numberofparticipants;
	}

	public int getReservationistid() {
		return this.reservationistid;
	}

	public void setReservationistid(int reservationistid) {
		this.reservationistid = reservationistid;
	}

	public Date getReservationtime() {
		return this.reservationtime;
	}

	public void setReservationtime(Date reservationtime) {
		this.reservationtime = reservationtime;
	}

	public int getRoomid() {
		return this.roomid;
	}

	public void setRoomid(int roomid) {
		this.roomid = roomid;
	}

	public Date getStarttime() {
		return this.starttime;
	}

	public void setStarttime(Date starttime) {
		this.starttime = starttime;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}