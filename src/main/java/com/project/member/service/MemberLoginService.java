package com.project.member.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.StandardPasswordEncoder;
import org.springframework.stereotype.Service;

import com.project.member.controller.MemberController;
import com.project.member.dao.MemberDao;
import com.project.member.model.Member;
import com.project.member.model.MemberDetail;

@Service
public class MemberLoginService implements UserDetailsService{
	private static final Logger logger = LoggerFactory.getLogger(MemberLoginService.class);
	@Autowired
	private MemberDao memberDao;
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
			logger.debug(username);
			StandardPasswordEncoder encoder = new StandardPasswordEncoder();
			Member member = memberDao.selectMemberDetail(username);
			logger.debug(member.getMemberPassword().toString());
			String passwordFromDatabase = encoder.encode(member.getMemberPassword().toString());
	        
	        return new MemberDetail(username, passwordFromDatabase);
	}

	

	
	
}
