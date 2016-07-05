package com.project.stop.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.stop.model.Stop;
import com.project.util.Pagination;

@Repository
public class StopDao {

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	
	public void insertReport(Stop stop){
		sqlSession.insert("com.project.stop.insertReport", stop);
	}
	
	public int selectReportCount(){
		return sqlSession.selectOne("com.project.stop.selectReportCount");
	}
	
	public List<Stop> selectStopList(Pagination page){
		return sqlSession.selectList("com.project.stop.selectStopList", page);
	}
}
