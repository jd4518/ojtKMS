package com.project.member.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.board.dao.BoardDao;
import com.project.board.model.Board;
import com.project.member.dao.MemberDao;

@Service
public class MemberUpgradeService {

	
	@Autowired
	private MemberDao memberDao;
	
	public void memberUpgrade(String memberId){
		memberDao.memberUpgrade(memberId);
	}

}
