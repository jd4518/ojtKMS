package com.project.board.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.board.dao.BoardDao;
import com.project.board.model.Board;

@Service
public class BoardDetailService {

	static Log log = LogFactory.getLog(BoardDetailService.class);
	
	@Autowired
	private BoardDao boardDao;
	
	public Board getBoardDetail(int boardNo, int categoryNo){
		System.out.println("select boarddetail start");
		Board board = new Board();
		board.setBoardNo(boardNo);
		board.setCategoryNo(categoryNo);
		Board b = boardDao.selectBoardDetail(board);
		
		System.out.println("select board detail end");
		return b;
	}

}
