package com.project.comment.model;

public class Comment {
	private static int replyNo;
	private static String replyContent;
	private static int boardNo;
	private static int menuNo;
	private static int categoryNo;
	private static int memberNo;
	public static int getReplyNo() {
		return replyNo;
	}
	public static void setReplyNo(int replyNo) {
		Comment.replyNo = replyNo;
	}
	public static String getReplyContent() {
		return replyContent;
	}
	public static void setReplyContent(String replyContent) {
		Comment.replyContent = replyContent;
	}
	public static int getBoardNo() {
		return boardNo;
	}
	public static void setBoardNo(int boardNo) {
		Comment.boardNo = boardNo;
	}
	public static int getMenuNo() {
		return menuNo;
	}
	public static void setMenuNo(int menuNo) {
		Comment.menuNo = menuNo;
	}
	public static int getCategoryNo() {
		return categoryNo;
	}
	public static void setCategoryNo(int categoryNo) {
		Comment.categoryNo = categoryNo;
	}
	public static int getMemberNo() {
		return memberNo;
	}
	public static void setMemberNo(int memberNo) {
		Comment.memberNo = memberNo;
	}
	
}
