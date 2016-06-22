package com.project.board.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.project.board.model.Board;
import com.project.board.service.BoardDetailService;
import com.project.board.service.BoardListService;
import com.project.category.service.CategoryService;
import com.project.comment.model.Comment;
import com.project.comment.service.CommentListService;
import com.project.menu.service.MenuService;

@Controller
@RequestMapping(value = "/board")
public class BoardController {

	@Autowired
	MenuService menuService;

	@Autowired
	CategoryService categoryService;
	
	@Autowired
	BoardListService boardService;
	
	@Autowired
	BoardDetailService boardDetailService;
	
	@Autowired
	CommentListService commentListService;

	@RequestMapping(value = "/boardMain.do")
	public String getBoardMainView() {

		return "board/boardMain";
	}

	@RequestMapping(value = "/bMain.do")
	public String getBMainView() {

		return "board/bMain";
	}

	@RequestMapping(value = "/boardList.do")
	public String getNoticeBoardListView() {

		return "board/boardList";
	}
	
	@RequestMapping(value = "/boardDetail.do")
	public String getNoticeBoardDetailView() {

		return "board/boardDetail";
	}
	
//	메뉴의 저보를 database에서 가져온다.
	@RequestMapping(value = "/menu.do", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> getMenu() {
		 System.out.println("menu");
		Map<String, Object> map = menuService.getMenu();

		return map;
	}
	
//  boardList에  대한 데이터를 database에서 가져온다.
	  @RequestMapping(value="/boardGet/{categoryNo:[0-9]+}{pageNo:[0-9]+}x.do",method=RequestMethod.GET)
	   @ResponseBody
	   public Map<String, Object> getBoard(@PathVariable int categoryNo,@PathVariable int pageNo){
	      System.out.println("catecon"+categoryNo);
	      System.out.println("page"+pageNo);
	      Map<String, Object> map = boardService.getBoardList(categoryNo,pageNo);
	      
	      return map;
	   }
	  
	  @RequestMapping(value="/boardDetail/{boardNo:[0-9]+}{categoryNo:[0-9]+}x.do",method=RequestMethod.GET)
	   @ResponseBody
	   public Map<String, Object> getDetailBoard(@PathVariable int boardNo,@PathVariable int categoryNo){
	      System.out.println("catecon"+boardNo);
	      System.out.println("page"+categoryNo);
	      Map<String, Object> map = new HashMap<String, Object>();
	      List<Board> list = boardDetailService.getBoardDetail(boardNo,categoryNo);
	      List<Comment> comment = commentListService.getCommentList(boardNo, categoryNo);
	      
	      map.put("list", list);
	      map.put("comment", comment);
	      
	      
	      return map;
	   }
	  

}
