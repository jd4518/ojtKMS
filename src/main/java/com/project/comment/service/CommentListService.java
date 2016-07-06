package com.project.comment.service;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.board.service.BoardListService;
import com.project.comment.dao.CommentDao;
import com.project.comment.model.Comment;

@Service
public class CommentListService {

static Log log = LogFactory.getLog(CommentListService.class);
	
	@Autowired
	private CommentDao commentDao;
	
	public List<Comment> getCommentList(int boardNo,int categoryNo){
		Comment comment = new Comment();
		comment.setBoardNo(boardNo);
		comment.setCategoryNo(categoryNo);
		List<Comment> list = commentDao.getCommentList(comment);
		return list;
	}
	
	
}
