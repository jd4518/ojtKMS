package com.project.accused.dao;


import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.accused.model.Accused;
import com.project.admin.controller.AdminController;


@Repository
public class AccusedDao {

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	private static final Logger logger = LoggerFactory.getLogger(AccusedDao.class);
	
	public int selectAccused(String memberId){
		int result = sqlSession.selectOne("com.project.accused.selectAccused", memberId);
		return result;
	}
	
	public void oneStopMember(String memberId){
		sqlSession.insert("com.project.accused.oneStopMember", memberId);
	}
	
	public void twoStopMember(String memberId){
		sqlSession.insert("com.project.accused.twoStopMember", memberId);
	}
	
	public void allStopMember(String memberId){
		sqlSession.insert("com.project.accused.allStopMember", memberId);
	}
	
	public void saveStopMember(String memberId){
		sqlSession.update("com.project.accused.saveStopMember", memberId);
	}
	
	
	public Accused selectAccusedDate(String memberId){
		return sqlSession.selectOne("com.project.accused.selectAccusedDate", memberId);
	}
}
