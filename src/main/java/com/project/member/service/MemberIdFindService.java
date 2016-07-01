package com.project.member.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.project.member.dao.MemberDao;
import com.project.member.model.Member;

@Service
public class MemberIdFindService {

	
	@Autowired
	private MemberDao memberDao;
	
	
	public String findId(Member member){
			String id = memberDao.findMember(member);
			
			return id;
			
		
	}
	
	
}
