package com.project.test;

import org.springframework.context.support.GenericXmlApplicationContext;

import com.project.model.Member;
import com.project.service.MemberAddService;

public class haha {

public static void main(String[] args) {
	GenericXmlApplicationContext ctx=null;
	ctx = new GenericXmlApplicationContext(
			"spring/beans_dao.xml");
	
	MemberAddService mas = ctx.getBean(MemberAddService.class);
	Member member = null;
	System.out.println(member);
	
	
	
	mas.add(member);
	
	
	ctx.close();
}

}
