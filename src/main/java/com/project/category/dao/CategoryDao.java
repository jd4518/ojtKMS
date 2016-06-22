package com.project.category.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.category.model.Category;
import com.project.menu.dao.MenuDao;

@Repository
public class CategoryDao {
	
	private static final Logger logger = LoggerFactory.getLogger(CategoryDao.class);
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	public List<Category> getCategory(){
		logger.debug("dao getCategory start");
		List<Category> category = sqlSession.selectList("com.project.category.selectCategory");
		logger.debug("dao getCategory end");
		
		
		return category;
	}
}
