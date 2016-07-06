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
public class CommentDeleteService {

static Log log = LogFactory.getLog(CommentDeleteService.class);
	
	@Autowired
	private CommentDao commentDao;
	
	public void deleteComment(Comment comment){
		commentDao.deleteComment(comment);
	}
	
	
}
