package com.project.member.model;


public class Member{
	
	private int memberNo;
	private String memberName;
	private String memberId;
	private String memberPassword;
	private String memberEmail;
	private int memberMasterPoint;
	private int memberReportpoint;
	private int memberStopPoint;
	private int rn;
	private String memberFlag;
	private String authority;
	private String memberHireDate;
	private String memberLastLogin;
	
	public int getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getMemberPassword() {
		return memberPassword;
	}
	public void setMemberPassword(String memberPassword) {
		this.memberPassword = memberPassword;
	}
	public String getMemberEmail() {
		return memberEmail;
	}
	public void setMemberEmail(String memberEmail) {
		this.memberEmail = memberEmail;
	}
	public int getMemberMasterPoint() {
		return memberMasterPoint;
	}
	public void setMemberMasterPoint(int memberMasterPoint) {
		this.memberMasterPoint = memberMasterPoint;
	}
	public int getMemberReportpoint() {
		return memberReportpoint;
	}
	public void setMemberReportpoint(int memberReportpoint) {
		this.memberReportpoint = memberReportpoint;
	}
	public int getMemberStopPoint() {
		return memberStopPoint;
	}
	public void setMemberStopPoint(int memberStopPoint) {
		this.memberStopPoint = memberStopPoint;
	}
	public String getMemberFlag() {
		return memberFlag;
	}
	public void setMemberFlag(String memberFlag) {
		this.memberFlag = memberFlag;
	}
	public String getAuthority() {
		return authority;
	}
	public void setAuthority(String authority) {
		this.authority = authority;
	}
	public String getMemberHireDate() {
		return memberHireDate;
	}
	public void setMemberHireDate(String memberHireDate) {
		this.memberHireDate = memberHireDate;
	}
	public String getMemberLastLogin() {
		return memberLastLogin;
	}
	public void setMemberLastLogin(String memberLastLogin) {
		this.memberLastLogin = memberLastLogin;
	}
	public int getRn() {
		return rn;
	}
	public void setRn(int rn) {
		this.rn = rn;
	}
	
}
