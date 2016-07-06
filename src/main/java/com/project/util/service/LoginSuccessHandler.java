package com.project.util.service;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.WebAttributes;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.project.accused.dao.AccusedDao;
import com.project.accused.model.Accused;
import com.project.member.dao.MemberDao;
import com.project.member.model.Member;

public class LoginSuccessHandler implements AuthenticationSuccessHandler{
	
	@Autowired
	private MemberDao memberdao;
	
	@Autowired
	private AccusedDao accusedDao;
	
	
	static final String REQUEST_PARAM_NAME = "_remember_username";
	 static final String COOKIE_NAME = "saved_username";
	 static final int DEFAULT_MAX_AGE = 60*60*24*7;
	 
	 private int maxAge = DEFAULT_MAX_AGE;
	 
	 public void setMaxAge(int maxAge) {
	  this.maxAge = maxAge;
	 }
	 
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		
		clearAuthenticationAttributes(request);
		
		
		HttpSession session = request.getSession();
		session.setMaxInactiveInterval(60*60*24);
		String id = authentication.getName();
	
		int result = accusedDao.selectAccused(id);
		if(result!=0){
			Accused accused = new Accused();
			accused = accusedDao.selectAccusedDate(id);
			Date date = new Date();
			Date last = accused.getStopEndDate();
			
				if(date.getTime()>=last.getTime()){
					System.out.println("gagsdgagafasdfasfsadf");
				Member mem = new Member();
				mem.setMemberId(id);
				mem.setAuthority("ROLE_USER");
				System.out.println("gagsdgagafasdfasfsadf");
				memberdao.updateAuthority(mem);
				accusedDao.saveStopMember(id);
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("id",id);
				
				memberdao.memberLastLogin(id);
				Member member=memberdao.selectMemberDetail(id);
				session.setAttribute("member", member);
				System.out.println("gagsdgagafasdfasfsadf");
				response.sendRedirect(request.getContextPath() + "/stop/endStop.do");
			}else{
				session.setAttribute("accused", accused);
				response.sendRedirect(request.getContextPath() + "/stop/stop.do");
			}
			
		}else{
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id",id);
		
		memberdao.memberLastLogin(id);
		Member member=memberdao.selectMemberDetail(id);
		session.setAttribute("member", member);
		
		  
	
		response.sendRedirect(request.getContextPath() + "/board/boardMain.do#/bMain");
		
		}
	}

	
	private void clearAuthenticationAttributes(HttpServletRequest request){
		HttpSession session = request.getSession(false);
		if(session == null){
			return;
		}
		
		session.removeAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
	}
}
