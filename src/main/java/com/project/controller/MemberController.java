package com.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.project.model.Member;
import com.project.service.MemberAddService;

@Controller
@RequestMapping(value="/member")
public class MemberController {
	
	@Autowired
	MemberAddService memberAddService;
	
	@RequestMapping(value="/join.do")
	public String memberJoin(){
		
		return "member/join";
	}
	
	@RequestMapping(value="/login.do")
	public String memberLogin(){
		
		return "member/login";
	}
	
	public String memberAdd(Member member){
		
		memberAddService.add(member);
		
		return "main.do";
	}
}
