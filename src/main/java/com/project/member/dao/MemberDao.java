package com.project.member.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.member.model.Member;

@Repository
public class MemberDao {

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	public void memberAdd(Member member){
		
		
		sqlSession.insert("com.project.member.memberAdd", member);
		
	}
	
	public Member selectMemberDetail(String memberName){
		
		return sqlSession.selectOne("com.project.member.memberDetailSelect", memberName);
	}
}
