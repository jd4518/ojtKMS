package com.project.member.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.member.dao.MemberDao;
import com.project.member.model.Member;

@Service
public class MemberIdGetService {

	
	@Autowired
	private MemberDao memberDao;
	
	public int memberIdCheck(Member member){
			int count = memberDao.memberIdCheck(member);
			
			return count;
	}
	
	
	
}
