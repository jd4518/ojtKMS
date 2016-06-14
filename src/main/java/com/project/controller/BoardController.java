package com.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.project.model.Category;
import com.project.model.Menu;
import com.project.service.CategoryService;
import com.project.service.MenuService;

@Controller
@RequestMapping(value="/board")
public class BoardController {
	
	@Autowired
	MenuService menuService;
	
	@Autowired
	CategoryService categoryService;

	@RequestMapping(value="/boardMain.do")
	public String getBoardMainView(){
		
		return "board/boardMain";
	}
	
	@RequestMapping(value="/bMain.do")
	public String getBMainView(){
		
		return "board/bMain";
	}
	
	@RequestMapping(value="/noticeBoardList.do")
	public String getNoticeBoardListView(){
		
		return "board/noticeBoardList";
	}
	
	@RequestMapping(value="/menu.do", method=RequestMethod.GET)
	@ResponseBody
	public List<Menu> getMenu() {
		
		List<Menu> list = menuService.getMenu();
		
		return list;
	}
	
	@RequestMapping(value="/category.do", method=RequestMethod.GET)
	@ResponseBody
	public List<Category> getCategory(@RequestBody int i) {
		
		List<Category> list = categoryService.getCategory(i);
		
		return list;
	}
	
}
