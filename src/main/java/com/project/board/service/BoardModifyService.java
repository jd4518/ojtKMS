package com.project.board.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.board.dao.BoardDao;
import com.project.board.model.Board;

@Service
public class BoardModifyService {

	
	@Autowired
	private BoardDao boardDao;
	
	public void updateBoard(Board board){
		
		boardDao.updateBoard(board);
	}

}
