package com.project.board.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.board.model.Board;
import com.project.comment.model.Comment;
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
	
	public void updateBoard(Board board){
		sqlSession.update("com.project.board.updateBoard", board);
	}
	
	public void deleteBoard(Board board){
		sqlSession.update("com.project.board.deleteBoard", board);
	}
	
	public void increaseHit(Board board){
		sqlSession.update("com.project.board.increaseHit",board);
	}
	
	public int selectRecommand(Board board){
		return sqlSession.selectOne("com.project.board.selectRecommand",board);
	}
	
	public void increaseRecommand(Board board){
		sqlSession.update("com.project.board.increaseRecommand",board);
	}
	
	public void insertRecommand(Board board){
		sqlSession.insert("com.project.board.insertRecommand",board);
	}
	
	public int selectReplyCount(Comment comment){
		return sqlSession.selectOne("com.project.comment.selectReplyCount",comment);
	}
	
	public List<Board> selectRecentBoard(){
		return sqlSession.selectList("com.project.board.selectRecentBoard");
	}
	
	public List<Board> selectTopRecommandBoard(){
		return sqlSession.selectList("com.project.board.selectTopRecommandBoard");
	}
}
