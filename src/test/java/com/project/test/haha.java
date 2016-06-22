package com.project.test;

import org.springframework.context.support.GenericXmlApplicationContext;

import com.project.member.model.Member;
import com.project.member.service.MemberJoinService;

public class haha {

public static void main(String[] args) {
	GenericXmlApplicationContext ctx=null;
	ctx = new GenericXmlApplicationContext(
			"spring/beans_dao.xml");
	
	MemberJoinService mas = ctx.getBean(MemberJoinService.class);
	Member member = null;
	System.out.println(member);
	
	
	
	mas.add(member);
	
	
	ctx.close();
}

}
