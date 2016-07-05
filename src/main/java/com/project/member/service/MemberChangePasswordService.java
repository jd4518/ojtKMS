package com.project.member.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.project.member.dao.MemberDao;
import com.project.member.model.Member;

@Service
public class MemberChangePasswordService {

	
	@Autowired
	private MemberDao memberDao;
	
	@Autowired
	private BCryptPasswordEncoder bcryptPasswordEncoder;
	
	public int memberChangePassword(Member member){
		int result = 0;
		member.setMemberPassword(this.bcryptPasswordEncoder.encode(member.getMemberPassword()));
		result = memberDao.changeMemberPass(member);
		return result;
	}
	
	
	
	
}
