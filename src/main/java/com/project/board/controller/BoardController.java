package com.project.board.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.project.board.model.Board;
import com.project.board.service.BoardDetailService;
import com.project.board.service.BoardInsertService;
import com.project.board.service.BoardListService;
import com.project.category.service.CategoryService;
import com.project.comment.model.Comment;
import com.project.comment.service.CommentAddService;
import com.project.comment.service.CommentListService;
import com.project.member.controller.MemberController;
import com.project.menu.service.MenuService;

@Controller
@RequestMapping(value = "/board")
public class BoardController {
	
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@Autowired
	MenuService menuService;

	@Autowired
	CategoryService categoryService;
	
	@Autowired
	BoardListService boardService;
	
	@Autowired
	BoardDetailService boardDetailService;
	
	@Autowired
	BoardInsertService boardInsertService;
	
	@Autowired
	CommentListService commentListService;
	
	@Autowired
	CommentAddService commentAddService;

//		angular를 사용하기위한 메인 호출
	@RequestMapping(value = "/boardMain.do")
	public String getBoardMainView() {

		return "board/boardMain";
	}

//	게시판 메인
	@RequestMapping(value = "/bMain.do")
	public String getBMainView() {

		return "board/bMain";
	}

// 게시판 리스트 
	@RequestMapping(value = "/boardList.do")
	public String getBoardListView() {

		return "board/boardList";
	}
	
// 게시글 디테일 뷰
	@RequestMapping(value = "/boardDetail.do")
	public String getBoardDetailView() {

		return "board/boardDetail";
	}
	
	@RequestMapping(value = "/boardInsert.do")
	public String getBoardInsertView() {

		return "board/boardInsert";
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
	      Board b = boardDetailService.getBoardDetail(boardNo,categoryNo);
	      List<Comment> comment = commentListService.getCommentList(boardNo, categoryNo);
	      
	      map.put("b", b);
	      map.put("comment", comment);
	      
	      
	      return map;
	   }
	  
	 
	@RequestMapping(value="/comment.do",method=RequestMethod.POST)
		@ResponseBody
		public void commentAdd(@RequestBody Comment comment){
			commentAddService.getCommentList(comment);
			
		}
	
	@RequestMapping(value="/boardWrite.do",method=RequestMethod.POST)
	@ResponseBody
	public void boardAdd(@RequestBody Board board){
		
		System.out.println(board.getBoardContent());
		System.out.println(board.getMemberId());
		System.out.println(board.getCategoryNo());
		
			boardInsertService.insertBoard(board);
		
	}
}
