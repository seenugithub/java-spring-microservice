package com.seenu.engagement.engagementservice.model;

import java.util.Date;

public class Meeting {
	
	String id;
	String name;
	Date startTime;
	Date endTime;
	
	public Meeting() {}
	
	public Meeting(String id, String name, Date startTime, Date endTime) {
		this.id = id;
		this.name = name;
		this.startTime = startTime;
		this.endTime = endTime;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	
	
	

}
