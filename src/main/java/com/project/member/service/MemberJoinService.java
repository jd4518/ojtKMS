package com.project.member.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.project.member.dao.MemberDao;
import com.project.member.model.Member;

@Service
public class MemberJoinService {

	
	@Autowired
	private MemberDao memberDao;
	
	@Autowired
	private BCryptPasswordEncoder bcryptPasswordEncoder;
	
	public void add(Member member){
		try{
			
			member.setMemberPassword(this.bcryptPasswordEncoder.encode(member.getMemberPassword()));
			memberDao.memberAdd(member);
			
		}
		catch(Exception e){
		}
		
	}
	
	
}
