package com.project.stop.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class StopDao {

	@Autowired
	private SqlSessionTemplate sqlSession;
}
