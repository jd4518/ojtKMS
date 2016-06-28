package com.project.board.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.board.dao.BoardDao;
import com.project.board.model.Board;

@Service
public class RecommandService {

	
	@Autowired
	private BoardDao boardDao;
	
	public int recommandBoard(Board board){
		int i = 0;
		if(i==boardDao.selectRecommand(board)){
			
			
			boardDao.insertRecommand(board);
			boardDao.increaseRecommand(board);
			
		}else{
			
			i = 1;
		}
		return i;
		
	}

}
