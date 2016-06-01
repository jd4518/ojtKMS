package com.project.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.dao.MemberDao;
import com.project.model.Member;

@Service
public class MemberAddService {

	static Log log = LogFactory.getLog(MemberAddService.class);
	@Autowired
	private MemberDao memberDao;
	
	public int add(Member member){
		int result = 0;
		try{
			
			result = memberDao.memberAdd(member);
			
		}
		catch(Exception e){
			log.error(e);
		}
		
		return result;
	}
	
	
}
