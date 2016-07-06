package com.project.member.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.project.member.dao.MemberDao;
import com.project.member.model.Member;
import com.project.util.service.FileUtil;

@Service
public class MemberRanPwService {

	
	@Autowired
	private MemberDao memberDao;
	
	@Autowired
	private FileUtil fileUtil;
	
	@Autowired
	private BCryptPasswordEncoder bcryptPasswordEncoder;
	
	
	public String RanPw(Member member){
			String pw = fileUtil.getRandomString(6);
			member.setMemberPassword(this.bcryptPasswordEncoder.encode(pw));
			memberDao.updateMemberPass(member);
			
			
			return pw;
			
		
	}
	
	
}
