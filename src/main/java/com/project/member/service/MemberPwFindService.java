package com.project.member.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.member.dao.MemberDao;
import com.project.member.model.Member;

@Service
public class MemberPwFindService {

	
	@Autowired
	private MemberDao memberDao;
	
	
	public int findPw(Member member){
			int pw = memberDao.findPass(member);
			
			return pw;
			
		
	}
	
	
}
