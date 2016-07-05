package com.project.member.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.board.dao.BoardDao;
import com.project.board.model.Board;
import com.project.member.dao.MemberDao;

@Service
public class MemberDowngradeService {

	
	@Autowired
	private MemberDao memberDao;
	
	public void memberDowngrade(String memberId){
		memberDao.memberDowngrade(memberId);
	}

}
