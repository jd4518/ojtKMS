package com.project.member.service;

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
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.project.member.controller.MemberController;
import com.project.member.dao.MemberDao;
import com.project.member.model.Member;
import com.project.member.model.MemberDetail;

@Service("memberLoginService")
public class MemberLoginService implements UserDetailsService{
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	@Autowired
	private MemberDao memberDao;
	
	
	
	
	public UserDetails loadUserByUsername(String userId)
	         throws UsernameNotFoundException {
	      System.out.println(":: => loadUserByUsername() start ...");
	      UserDetails userDetails = null;
	      
	      try {
	         Member member = memberDao.selectMemberDetail(userId);
	         
	         String userPassword = new String(member.getMemberPassword());
			
	         //암호화된 값을 가지고있음
	         //System.out.println(":: dbPassword => "+dbPassword);
	         
	         //복호화
	         //passwordEncoding passwordEncoding = new passwordEncoding();
	         
	         //String password = passwordEncoding.decode(userPassword);
	         //System.out.println(":: password => "+password);
	         
	         List<GrantedAuthority> list = new ArrayList<GrantedAuthority>();
	         
	         String [] roles = member.getAuthority().split(",");
	         
	         for(String role : roles){
	            //System.out.println(":: role => "+role);
	            list.add(new SimpleGrantedAuthority(role));
	         
	         }
	         
	         
	         userDetails =  new User(userId, userPassword, list);
	         
	         System.out.println(":: => userDetails.toString() = "+userDetails.toString()+" , userDetails = "+userDetails);
	         
	      } catch (Exception e) {
	         // TODO Auto-generated catch block
	         e.printStackTrace();
	      }
	      System.out.println(userDetails.toString());
	      System.out.println(":: => loadUserByUsername() end ...");
	      
	      
	      return userDetails;
	   }

	
	

	
	
}
