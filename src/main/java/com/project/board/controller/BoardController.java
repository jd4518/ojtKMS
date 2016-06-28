package com.project.board.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.project.board.model.Board;
import com.project.board.service.BoardDeleteService;
import com.project.board.service.BoardDetailService;
import com.project.board.service.BoardHitService;
import com.project.board.service.BoardInsertService;
import com.project.board.service.BoardListService;
import com.project.board.service.BoardModifyService;
import com.project.board.service.RecommandService;
import com.project.category.service.CategoryService;
import com.project.comment.model.Comment;
import com.project.comment.service.CommentAddService;
import com.project.comment.service.CommentListService;
import com.project.menu.service.MenuService;
import com.project.util.FileUpload;

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
	BoardModifyService boardModifyService;
	
	@Autowired
	BoardDeleteService boardDeleteService;
	
	@Autowired
	RecommandService recommandService;
	
	@Autowired
	BoardHitService boardHitService;
	
	@Autowired
	CommentListService commentListService;
	
	@Autowired
	CommentAddService commentAddService;
	
	@Autowired
	@Qualifier("fileUpload")
	FileUpload fileUpload;
	
	

public void setMenuService(MenuService menuService) {
		this.menuService = menuService;
	}

	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	public void setBoardService(BoardListService boardService) {
		this.boardService = boardService;
	}

	public void setBoardDetailService(BoardDetailService boardDetailService) {
		this.boardDetailService = boardDetailService;
	}

	public void setBoardInsertService(BoardInsertService boardInsertService) {
		this.boardInsertService = boardInsertService;
	}

	public void setBoardModifyService(BoardModifyService boardModifyService) {
		this.boardModifyService = boardModifyService;
	}

	public void setBoardDeleteService(BoardDeleteService boardDeleteService) {
		this.boardDeleteService = boardDeleteService;
	}

	public void setRecommandService(RecommandService recommandService) {
		this.recommandService = recommandService;
	}

	public void setBoardHitService(BoardHitService boardHitService) {
		this.boardHitService = boardHitService;
	}

	public void setCommentListService(CommentListService commentListService) {
		this.commentListService = commentListService;
	}

	public void setCommentAddService(CommentAddService commentAddService) {
		this.commentAddService = commentAddService;
	}

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
	
	@RequestMapping(value = "/boardModify.do")
	public String getBoardModifyView() {

		return "board/boardModify";
	}
	
	@RequestMapping(value = "/boardDelete.do")
	public String getBoardDeleteView() {

		return "board/boardDelete";
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
	
	
	@RequestMapping(value="/boardWrite.do")
	public ModelAndView boardAdd(@ModelAttribute("board")  Board board, HttpServletRequest request) throws Exception{
		
			boardInsertService.insertBoard(board,request);
			  String viewName = "redirect:/board/boardMain.do#/boardList/"+board.getCategoryNo()+board.getMenuNo();
		      
		      ModelAndView modelAndView = new ModelAndView();
		      modelAndView.setViewName(viewName);
		      
		      return modelAndView;
	}
	
/*	@RequestMapping(value="/fileUp.do",method=RequestMethod.POST)
	@ResponseBody
	public void fileUpload(HttpServletRequest request) throws Exception{
		
			boardInsertService.insertBoard(board,request);
		
	}*/
	
	@RequestMapping(value="/boardModify.do",method=RequestMethod.PUT)
	@ResponseBody
	public void boardUpdate(@RequestBody Board board){
		
		System.out.println(board.getBoardContent());
		System.out.println(board.getCategoryNo());
		System.out.println(board.getMemberId());
		System.out.println(board.getCategoryNo());
		
		boardModifyService.updateBoard(board);
	}
	
	@RequestMapping(value="/boardDelete.do",method=RequestMethod.PUT)
	@ResponseBody
	public void boardDelete(@RequestBody Board board){
		
		System.out.println(board.getBoardContent());
		System.out.println(board.getCategoryNo());
		System.out.println(board.getMemberId());
		System.out.println(board.getCategoryNo());
		
		boardDeleteService.deleteBoard(board);
	}
	
	@RequestMapping(value="/boardHit.do",method=RequestMethod.PUT)
	@ResponseBody
	public void boardHit(@RequestBody Board board){
		boardHitService.increaseBoard(board);
		
	}
	
	@RequestMapping(value="/boardRecommand.do",method=RequestMethod.POST)
	@ResponseBody
	public int boardRecommand(@RequestBody Board board){
		int result = recommandService.recommandBoard(board);
		
		return result;
	}
}
