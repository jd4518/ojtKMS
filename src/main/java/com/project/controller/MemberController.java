package com.project.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.project.model.Member;
import com.project.service.MemberAddService;

@Controller
@RequestMapping(value="/member")
public class MemberController {
	
	static Log log = LogFactory.getLog(MemberController.class);
	
	@Autowired
	MemberAddService memberAddService;
	
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
	
	
	@RequestMapping(value="/member.do",method=RequestMethod.POST)
	@ResponseBody
	public void memberAdd(@RequestBody Member member){
		System.out.println("ggggg");
		
		memberAddService.add(member);
		
	}
}
