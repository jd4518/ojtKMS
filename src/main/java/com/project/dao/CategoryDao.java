package com.project.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.model.Category;

@Repository
public class CategoryDao {
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	public List<Category> getCategory(int no){
		System.out.println("dao getCategory start");
		List<Category> category = sqlSession.selectList("com.project.category.selectCategory",no);
		for(int i=0;i<category.size();i++){
			System.out.println(category.get(i));
		}
		System.out.println("dao getCategory end");
		
		
		return category;
	}
}
