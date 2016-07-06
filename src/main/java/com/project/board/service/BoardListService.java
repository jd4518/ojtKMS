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
import com.project.util.service.Pagination;

@Service
public class BoardListService {

	static Log log = LogFactory.getLog(BoardListService.class);
	
	@Autowired
	private BoardDao boardDao;
	
	public Map<String, Object> getBoardList(int categoryNo,int pageNo){
		System.out.println("select board start");
		Pagination page = new Pagination();
		page.setPageNo(pageNo);
		page.setTotalItem(boardDao.selectBoardCount(categoryNo));
		page.setCategoryNo(categoryNo);
		System.out.println(pageNo);
		List<Board> board = boardDao.selectBoardList(page);
		
		Comment comment = new Comment();
		for(int i = 0 ; i<board.size(); i++){
			comment.setBoardNo(board.get(i).getBoardNo());
			comment.setCategoryNo(board.get(i).getCategoryNo());
			int num = boardDao.selectReplyCount(comment);
			board.get(i).setNum(num);
		}
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("board", board);
		map.put("page", page);
		System.out.println("select board end");
		return map;
	}


}
