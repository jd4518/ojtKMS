package com.project.member.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.member.controller.MemberController;
import com.project.member.model.Member;

@Repository
public class MemberDao {
	
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	
	
	
	public void setSqlSession(SqlSessionTemplate sqlSession) {
		this.sqlSession = sqlSession;
	}

	public void memberAdd(Member member){
		
		
		sqlSession.insert("com.project.member.memberAdd", member);
		
	}
	
	public Member selectMemberDetail(String memberName){
		logger.info("sMd start");
		logger.info(memberName);
		System.out.println(memberName);
		Member  member = sqlSession.selectOne("com.project.member.memberDetailSelect", memberName);
		System.out.println(member.getMemberId());
		System.out.println(member.getMemberPassword());
		System.out.println(member.getAuthority());
		return member;
	}
}
