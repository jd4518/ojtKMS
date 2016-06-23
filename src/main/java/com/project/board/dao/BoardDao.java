package com.project.board.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.board.model.Board;
import com.project.util.Pagination;

@Repository
public class BoardDao {

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	private static final Logger logger = LoggerFactory.getLogger(BoardDao.class);
	
	public List<Board> selectBoardList(Pagination page){
		List<Board> board = sqlSession.selectList("com.project.board.selectBoardList", page);
		return board;
	}
	
	public Board selectBoardDetail(Board board){
		Board b = sqlSession.selectOne("com.project.board.selectBoardDetail",board);
		
		return b;
	}
	
	public int selectBoardCount(int categoryNo){
		return sqlSession.selectOne("com.project.board.selectBoardCount", categoryNo);
	}
	
	public void insertBoard(Board board){
		sqlSession.insert("com.project.board.insertBoard", board);
	}
	
}
