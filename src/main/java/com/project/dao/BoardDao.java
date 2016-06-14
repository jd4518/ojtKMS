package com.project.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.model.Board;
import com.project.model.Category;

@Repository
public class BoardDao {

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	public List<Board> selectBoardList(Category category){
		return sqlSession.selectList("com.project.board.selectBoardList", category);
	}
}
