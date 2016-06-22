package com.project.menu.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.board.dao.BoardDao;
import com.project.menu.model.Menu;

@Repository
public class MenuDao {
	
	private static final Logger logger = LoggerFactory.getLogger(MenuDao.class);
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	public List<Menu> getMenu(){
		logger.debug("dao getMenu start");
		List<Menu> menu = sqlSession.selectList("com.project.menu.selectMenu");
		logger.debug("dao getMenu end");
		
		
		return menu;
	}
}
