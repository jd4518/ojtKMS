package com.project.test;

import org.springframework.context.support.GenericXmlApplicationContext;

import com.project.member.model.Member;
import com.project.member.service.MemberLoginService;

public class haha {

public static void main(String[] args) {
	GenericXmlApplicationContext ctx=null;
	ctx = new GenericXmlApplicationContext(
			"spring/beans_dao.xml");
	
	MemberLoginService mas = ctx.getBean(MemberLoginService.class);
	Member member = (Member) mas.loadUserByUsername("1234");
	System.out.println(member.getMemberId());
	
	
	
	
	
	ctx.close();
}

}
