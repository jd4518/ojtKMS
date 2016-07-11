package com.project.menu.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.category.dao.CategoryDao;
import com.project.category.model.Category;
import com.project.menu.dao.MenuDao;
import com.project.menu.model.Menu;

@Service
public class MenuService {

	static Log log = LogFactory.getLog(MenuService.class);
	
	@Autowired
	private MenuDao menuDao;
	
	@Autowired
	private CategoryDao categoryDao;
	
	public Map<String, Object> getMenu(){
		
		List<Menu> menu =  menuDao.getMenu();
		List<Category> category = categoryDao.getCategory();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("menu", menu);
		map.put("cateogry", category);
		return map;
	}

}
