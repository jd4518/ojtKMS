package com.project.util;

import java.io.IOException;
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

import com.project.member.dao.MemberDao;
import com.project.member.model.Member;

public class LoginSuccessHandler implements AuthenticationSuccessHandler{
	
	@Autowired
	private MemberDao memberdao;
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
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id",id);
		Member member=memberdao.selectMemberDetail(id);
		session.setAttribute("member", member);
		
		  
	
		response.sendRedirect(request.getContextPath() + "/board/boardMain.do#/bMain");
		
	}

	
	private void clearAuthenticationAttributes(HttpServletRequest request){
		HttpSession session = request.getSession(false);
		if(session == null){
			return;
		}
		
		session.removeAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
	}
}
