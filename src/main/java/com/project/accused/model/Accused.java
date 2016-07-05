package com.project.accused.model;

import java.util.Date;

public class Accused {
	private int  accusedNo;
	private String memberId;
	private Date stopStartDate;
	private Date stopEndDate;
	private String accusedFlag;
	
	public int getAccusedNo() {
		return accusedNo;
	}
	public void setAccusedNo(int accusedNo) {
		this.accusedNo = accusedNo;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getAccusedFlag() {
		return accusedFlag;
	}
	public void setAccusedFlag(String accusedFlag) {
		this.accusedFlag = accusedFlag;
	}
	public Date getStopEndDate() {
		return stopEndDate;
	}
	public void setStopEndDate(Date stopEndDate) {
		this.stopEndDate = stopEndDate;
	}
	public Date getStopStartDate() {
		return stopStartDate;
	}
	public void setStopStartDate(Date stopStartDate) {
		this.stopStartDate = stopStartDate;
	}
	
}
