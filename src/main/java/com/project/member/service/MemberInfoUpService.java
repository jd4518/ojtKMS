package com.project.member.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.project.member.dao.MemberDao;
import com.project.member.model.Member;

@Service
public class MemberInfoUpService {

	
	@Autowired
	private MemberDao memberDao;
	
	@Autowired
	private BCryptPasswordEncoder bcryptPasswordEncoder;
	
	public int memberInfoUp(Member member){
		
		int result = 0;
		Member cMember = memberDao.selectMemberDetail(member.getMemberId());
		Boolean pMatch = bcryptPasswordEncoder.matches(member.getMemberPassword(), cMember.getMemberPassword());
		if(pMatch){
			result = memberDao.memberInfoUp(member);
			
		}else{
			result = 0;
		}
		return result;
	}
	
	public int memberPwCheck(Member member){
		int result = 0;
		System.out.println("pwcheck ========== :" + member.getMemberId());
		Member cMember = memberDao.selectMemberDetail(member.getMemberId());
		Boolean pMatch = bcryptPasswordEncoder.matches(member.getMemberPassword(), cMember.getMemberPassword());
		if(pMatch){
			result = 1;
		}
		
		return result;
	}
	
	
	
}
