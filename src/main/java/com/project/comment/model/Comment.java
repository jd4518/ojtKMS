package com.project.comment.model;

public class Comment {
	private  int replyNo;
	private  int boardNo;
	private  int menuNo;
	private  int categoryNo;
	private  String replyContent;
	private  String memberId;
	public  int getReplyNo() {
		return replyNo;
	}
	public  void setReplyNo(int replyNo) {
		this.replyNo = replyNo;
	}
	public  int getBoardNo() {
		return boardNo;
	}
	public  void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}
	public  int getMenuNo() {
		return menuNo;
	}
	public  void setMenuNo(int menuNo) {
		this.menuNo = menuNo;
	}
	public  int getCategoryNo() {
		return categoryNo;
	}
	public  void setCategoryNo(int categoryNo) {
		this.categoryNo = categoryNo;
	}
	public  String getReplyContent() {
		return replyContent;
	}
	public  void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}
	public  String getMemberId() {
		return memberId;
	}
	public  void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	
	
	
}
