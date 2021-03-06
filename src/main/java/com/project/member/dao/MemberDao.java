package com.project.member.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.member.controller.MemberController;
import com.project.member.model.Member;
import com.project.util.service.Pagination;

@Repository
public class MemberDao {
	
	private static final Logger logger = LoggerFactory.getLogger(MemberDao.class);
	
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
		Member  member = sqlSession.selectOne("com.project.member.memberDetailSelect", memberName);
		return member;
	}
	
	public String findMember(Member member){
		
		return sqlSession.selectOne("com.project.member.findMemberId", member);
	}
	
	public int findPass(Member member){
		return sqlSession.selectOne("com.project.member.findMemberPw", member);
	}
	
	public int updateMemberPass(Member member){
		return sqlSession.update("com.project.member.updateMemberPass", member);
	}
	
	public int changeMemberPass(Member member){
		return sqlSession.update("com.project.member.changeMemberPass", member);
	}
	
	public int memberIdCheck(Member member){
		return sqlSession.selectOne("com.project.member.memberIdCheck", member);
	}
	
	public int memberInfoUp(Member member){
		return sqlSession.update("com.project.member.memberInfoUp", member);
	}
	
	public List<Member> selectMemberList(Pagination page){
		return sqlSession.selectList("com.project.member.selectMemberList", page);
	}
	
	public void memberLastLogin(String id){
		sqlSession.update("com.project.member.memberLastLogin", id);
	}
	
	public int memberTotalCount(){
		return sqlSession.selectOne("com.project.member.memberTotalCount");
	}
	
	public void memberDelete(String memberId){
		sqlSession.update("com.project.member.memberDelete", memberId);
	}
	
	public void memberUpgrade(String memberId){
		sqlSession.update("com.project.member.memberUpgrade", memberId);
	}
	
	public void memberDowngrade(String memberId){
		sqlSession.update("com.project.member.memberDowngrade", memberId);
	}
	
	public void memberWarning(String memberId){
		sqlSession.update("com.project.member.memberWarning", memberId);
	}
	
	public void memberStop(String memberId){
		sqlSession.update("com.project.member.memberStop", memberId);
	}
	
	public void memberSave(String memberId){
		sqlSession.update("com.project.member.memberSave", memberId);
	}
	
	public int selectRpoint(String memberId){
		return sqlSession.selectOne("com.project.member.selectRpoint", memberId);
	}
	
	public void memberWarningThree(String memberId){
		sqlSession.update("com.project.member.memberWarningThree", memberId);
	}
	
	public int selectSpoint(String memberId){
		return sqlSession.selectOne("com.project.member.selectSpoint", memberId);
	}
	
	public void updateAuthority(Member member){
		sqlSession.update("com.project.member.updateAuthority", member);
	}
}
