package com.project.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.model.Menu;

@Repository
public class MenuDao {

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	public List<Menu> getMenu(){
		System.out.println("dao getMenu start");
		List<Menu> menu = sqlSession.selectList("com.project.menu.selectMenu");
		for(int i=0;i<menu.size();i++){
			System.out.println(menu.get(i));
		}
		System.out.println("dao getMenu end");
		
		
		return menu;
	}
}
