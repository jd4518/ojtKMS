package com.project.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.model.Admin;

@Repository
public class AdminDao {

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	public List<Admin> selectAdminAll() throws Exception{
		
		return sqlSession.selectList("com.project.admin.selectAdminListAll");
	}
}
