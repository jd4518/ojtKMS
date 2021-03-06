package com.project.comment.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.comment.model.Comment;

@Repository
public class CommentDao {
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	public List<Comment> getCommentList(Comment comment){
		List<Comment> list = sqlSession.selectList("com.project.comment.selectCommentList",comment);
		
		return list;
	}
	
	public void postComment(Comment comment){
		sqlSession.insert("com.project.comment.insertComment",comment);
	}
	
	public void deleteComment(Comment comment){
		sqlSession.update("com.project.comment.deleteComment", comment);
	}
}
