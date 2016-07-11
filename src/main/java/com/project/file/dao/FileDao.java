package com.project.file.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.file.model.Files;

@Repository
public class FileDao {

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	public void insertFile(Files files){
		sqlSession.insert("com.project.file.insertFile",files);
	}
	
	public List<Files> selectFileList(Files files){
		
		return sqlSession.selectList("com.project.file.selectFileList", files);
		
	}
	
	public void insertReportFile(Files files){
		sqlSession.insert("com.project.file.insertReportFile",files);
	}
	
	public List<Files> selectReportFileList(int files){
		
		return sqlSession.selectList("com.project.file.selectReportFileList", files);
		
	}
}
