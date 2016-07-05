package com.project.board.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.board.dao.BoardDao;
import com.project.board.model.Board;
import com.project.comment.model.Comment;
import com.project.util.Pagination;

@Service
public class BoardMainService {

	static Log log = LogFactory.getLog(BoardMainService.class);
	
	@Autowired
	private BoardDao boardDao;
	
	public List<Board> getRecentBoard(){
		List<Board> list = boardDao.selectRecentBoard() ;
		return list;
	}
	
	public List<Board> getTopRecommandBoard(){
		List<Board> list = boardDao.selectTopRecommandBoard();
		return list;
	}


}
