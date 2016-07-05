package com.project.member.service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.accused.dao.AccusedDao;
import com.project.admin.controller.AdminController;
import com.project.board.dao.BoardDao;
import com.project.board.model.Board;
import com.project.member.dao.MemberDao;
import com.project.member.model.Member;

@Service
public class MemberWarningService {

	private static final Logger logger = LoggerFactory.getLogger(AdminController.class);
	@Autowired
	private MemberDao memberDao;
	
	@Autowired
	private AccusedDao accusedDao;
	
	public void memberWarning(String memberId){
		int result = memberDao.selectRpoint(memberId);
		if(result <3){
			memberDao.memberWarning(memberId);
		}else{
			memberDao.memberWarningThree(memberId);
			memberDao.memberStop(memberId);
			System.out.println("하하");
			int r = memberDao.selectSpoint(memberId);
			Member member = new Member();
			member.setMemberId(memberId);
			member.setAuthority("ROLE_STOP");
			if(r <= 1){
				accusedDao.oneStopMember(memberId);
				memberDao.updateAuthority(member);
				
			}else if(r == 2){
				accusedDao.twoStopMember(memberId);
				memberDao.updateAuthority(member);
			}else{
				accusedDao.allStopMember(memberId);
				memberDao.updateAuthority(member);
			}
		}
	}

}
