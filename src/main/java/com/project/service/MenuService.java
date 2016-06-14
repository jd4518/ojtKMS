package com.project.service;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.dao.MenuDao;
import com.project.model.Menu;

@Service
public class MenuService {

	static Log log = LogFactory.getLog(MenuService.class);
	
	@Autowired
	private MenuDao menuDao;
	
	public List<Menu> getMenu(){
		System.out.println("select menu start");
		
		List<Menu> menu =  menuDao.getMenu();
		System.out.println("select menu end");
		return menu;
	}

}
