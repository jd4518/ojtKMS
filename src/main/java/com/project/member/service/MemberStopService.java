package com.project.member.service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.accused.dao.AccusedDao;
import com.project.admin.controller.AdminController;
import com.project.member.dao.MemberDao;
import com.project.member.model.Member;

@Service
public class MemberStopService {

	private static final Logger logger = LoggerFactory.getLogger(AdminController.class);
	
	@Autowired
	private MemberDao memberDao;
	
	@Autowired
	private AccusedDao accusedDao;
	
	public void memberStop(String memberId){
		System.out.println("!!!!!!!!!!!!!!!!!!"+memberId);
		memberDao.memberStop(memberId);
		int result = memberDao.selectSpoint(memberId);
		Member member = new Member();
		member.setMemberId(memberId);
		member.setAuthority("ROLE_STOP");
		if(result <= 1){
			accusedDao.oneStopMember(memberId);
			memberDao.updateAuthority(member);
			
		}else if(result == 2){
			accusedDao.twoStopMember(memberId);
			memberDao.updateAuthority(member);
		}else{
			accusedDao.allStopMember(memberId);
			memberDao.updateAuthority(member);
		}
	}

}
