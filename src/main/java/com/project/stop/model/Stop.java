package com.project.stop.model;

public class Stop {
	
	private int stopNo;
	private int memberNo;
	private String startDate;
	private String endDate;
	private String sotpReason;
	public int getStopNo() {
		return stopNo;
	}
	public void setStopNo(int stopNo) {
		this.stopNo = stopNo;
	}
	public int getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public String getSotpReason() {
		return sotpReason;
	}
	public void setSotpReason(String sotpReason) {
		this.sotpReason = sotpReason;
	}
	
	
}
