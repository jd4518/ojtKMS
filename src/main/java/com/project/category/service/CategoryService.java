package com.project.category.service;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.category.dao.CategoryDao;
import com.project.category.model.Category;

@Service
public class CategoryService {

	static Log log = LogFactory.getLog(CategoryService.class);
	
	@Autowired
	private CategoryDao categoryDao;
	
	public List<Category> getCategory(int i){
		
		List<Category> category =  categoryDao.getCategory();
		return category;
	}

}
