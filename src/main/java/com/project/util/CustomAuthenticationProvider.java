package com.project.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import com.project.member.model.MemberDetail;

public class CustomAuthenticationProvider implements AuthenticationProvider{
	
	    public boolean supports(Class<?> authentication) {
	        return authentication.equals(UsernamePasswordAuthenticationToken.class);
	    }

		public Authentication authenticate(Authentication authentication)
				throws AuthenticationException {
			
			String user_id = (String)authentication.getPrincipal();		
			String user_pw = (String)authentication.getCredentials();
			
			
			
			// check whether user's credentials are valid.
			// if false, throw new BadCredentialsException(messages.getMessage("AbstractUserDetailsAuthenticationProvider.badCredentials", "Bad credentials"));
			
			
			List<GrantedAuthority> roles = new ArrayList<GrantedAuthority>();
	        roles.add(new SimpleGrantedAuthority("ROLE_USER"));
	        
	        UsernamePasswordAuthenticationToken result = new UsernamePasswordAuthenticationToken(user_id, user_pw, roles);
	        result.setDetails(new MemberDetail(user_id, user_pw));
			return result;
	        
			
		}
}
