package com.project.service;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.dao.CategoryDao;
import com.project.model.Category;

@Service
public class CategoryService {

	static Log log = LogFactory.getLog(CategoryService.class);
	
	@Autowired
	private CategoryDao categoryDao;
	
	public List<Category> getCategory(int i){
		System.out.println("select cate start");
		
		List<Category> category =  categoryDao.getCategory(i);
		System.out.println("select cate end");
		return category;
	}

}
