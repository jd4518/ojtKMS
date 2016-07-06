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

@Service
public class MemberSaveService {

	private static final Logger logger = LoggerFactory.getLogger(MemberSaveService.class);
	@Autowired
	private MemberDao memberDao;
	
	@Autowired
	private AccusedDao accusedDao;
	
	public void memberSave(String memberId){
		memberDao.memberSave(memberId);
		accusedDao.saveStopMember(memberId);
	}

}
