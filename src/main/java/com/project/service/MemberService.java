package com.project.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.dao.MemberDao;
import com.project.model.Member;

@Service
public class MemberService {

	static Log log = LogFactory.getLog(MemberService.class);
	@Autowired
	private MemberDao memberDao;
	
	public void add(Member member){
		try{
			
			memberDao.memberAdd(member);
			
		}
		catch(Exception e){
			log.error(e);
		}
		
	}
	
	
}
