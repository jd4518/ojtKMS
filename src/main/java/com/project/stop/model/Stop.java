package com.project.stop.model;

import java.util.Date;

public class Stop {

	private int stopNo;
	private int memberNo;
	private int menuNo;
	private int categoryNo;
	private int boardNo;
	private int rn;
	private Date startDate;
	private Date endDate;
	private String stopReason;
	private String sMemberId;
	private String wMemberId;
	private String stopTitle;
	private String boardTitle;
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
	public int getMenuNo() {
		return menuNo;
	}
	public void setMenuNo(int menuNo) {
		this.menuNo = menuNo;
	}
	public int getCategoryNo() {
		return categoryNo;
	}
	public void setCategoryNo(int categoryNo) {
		this.categoryNo = categoryNo;
	}
	public int getBoardNo() {
		return boardNo;
	}
	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}
	public int getRn() {
		return rn;
	}
	public void setRn(int rn) {
		this.rn = rn;
	}
	
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public String getStopReason() {
		return stopReason;
	}
	public void setStopReason(String stopReason) {
		this.stopReason = stopReason;
	}
	public String getsMemberId() {
		return sMemberId;
	}
	public void setsMemberId(String sMemberId) {
		this.sMemberId = sMemberId;
	}
	public String getwMemberId() {
		return wMemberId;
	}
	public void setwMemberId(String wMemberId) {
		this.wMemberId = wMemberId;
	}
	public String getStopTitle() {
		return stopTitle;
	}
	public void setStopTitle(String stopTitle) {
		this.stopTitle = stopTitle;
	}
	public String getBoardTitle() {
		return boardTitle;
	}
	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}

	

}
