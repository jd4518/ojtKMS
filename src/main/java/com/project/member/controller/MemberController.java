package com.project.member.controller;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.project.member.model.Member;
import com.project.member.service.MemberChangePasswordService;
import com.project.member.service.MemberIdGetService;
import com.project.member.service.MemberInfoUpService;
import com.project.member.service.MemberJoinService;

@Controller
@RequestMapping(value="/member")
public class MemberController {
	
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	@Autowired
	MemberJoinService memberJoinService;
	
	@Autowired
	MemberIdGetService memberIdGetService;
	
	@Autowired
	MemberInfoUpService memberInfoUpService;
	
	@Autowired
	MemberChangePasswordService memberChangePasswordService;
	
	@RequestMapping(value="/memberMain.do")
	public String memberMain(){
		
		return "member/memberMain";
	}
	@RequestMapping(value="/join.do")
	public String memberJoin(){
		
		return "member/join";
	}
	
	@RequestMapping(value="/login.do")
	public String memberLogin(){
		
		return "member/login";
	}
	
	@RequestMapping(value="/member.do", method=RequestMethod.POST)
	@ResponseBody
	public void memberAdd(@RequestBody Member member){
		memberJoinService.add(member);
		
	}
	
	@RequestMapping(value="/login.do", method=RequestMethod.GET)
	public void login(HttpSession session) {
		logger.debug(session.getId());
 

	}
	
	//아이디 중복검사
	@RequestMapping(value="/memberIdGet.do", method=RequestMethod.POST)
	@ResponseBody
	public int memberIdGet(@RequestBody Member member){
		int count = memberIdGetService.memberIdCheck(member);
		return count;
	}
	
	@RequestMapping(value="/memberInfoUpdate.do", method=RequestMethod.PUT)
	@ResponseBody
	public int memberInfoUp(@RequestBody Member member){
		int result = memberInfoUpService.memberInfoUp(member);
		return result;
	}
	
	@RequestMapping(value="/checkPw.do", method=RequestMethod.PUT)
	@ResponseBody
	public int checkPw(@RequestBody Member member){
		int result = memberInfoUpService.memberPwCheck(member);
		return result;
	}
	@RequestMapping(value="/changePassword.do", method=RequestMethod.PUT)
	@ResponseBody
	public int changePassword(@RequestBody Member member){
		int result = memberChangePasswordService.memberChangePassword(member);
		return result;
	}
	
	
}
