package com.project.util;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.project.member.controller.MemberController;
import com.project.member.dao.MemberDao;
import com.project.member.model.Member;
import com.project.member.model.MemberDetail;

public class CustomAuthenticationProvider implements AuthenticationProvider {
	
	@Autowired
	private BCryptPasswordEncoder bcryptPasswordEncoder;
	
	@Autowired
	private MemberDao memberdao;

	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }

	public Authentication authenticate(Authentication authentication)
			throws AuthenticationException {
		
		String user_id = (String)authentication.getPrincipal();		
		String user_pw = (String)authentication.getCredentials();
		
		UsernamePasswordAuthenticationToken result =null;
		try{
		Member member = memberdao.selectMemberDetail(user_id);
		
		logger.info("Welcome authenticate! {}", user_id + "/" + user_pw);
		
		
		// check whether user's credentials are valid.
		// if false, throw new BadCredentialsException(messages.getMessage("AbstractUserDetailsAuthenticationProvider.badCredentials", "Bad credentials"));
		
		Boolean pMatch = bcryptPasswordEncoder.matches(user_pw, member.getMemberPassword());
		if(pMatch){
		List<GrantedAuthority> roles = new ArrayList<GrantedAuthority>();
        roles.add(new SimpleGrantedAuthority(member.getAuthority()));
        
         result = new UsernamePasswordAuthenticationToken(user_id, user_pw, roles);
        result.setDetails(new MemberDetail(user_id, user_pw));
		}else{
			result = null;
		}
		}catch(Exception e){
			e.printStackTrace();
		}
		return result;
        
		
	}
}
