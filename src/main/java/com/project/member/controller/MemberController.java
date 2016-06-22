package com.project.member.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.project.member.model.Member;
import com.project.member.service.MemberJoinService;

@Controller
@RequestMapping(value="/member")
public class MemberController {
	
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	@Autowired
	MemberJoinService memberJoinService;
	
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

 

	}
}
