package com.project.board.service;

import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.board.dao.BoardDao;
import com.project.board.model.Board;

@Service
public class BoardInsertService {

	static Log log = LogFactory.getLog(BoardInsertService.class);
	
	@Autowired
	private BoardDao boardDao;
	
	public void insertBoard(Board board){
		
		boardDao.insertBoard(board);
	}

}
