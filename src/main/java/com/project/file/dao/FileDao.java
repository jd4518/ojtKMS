package com.project.file.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class FileDao {

	@Autowired
	private SqlSessionTemplate sqlSession;
	
}
