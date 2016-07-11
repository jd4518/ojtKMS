package com.project.board.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.project.board.model.Board;
import com.project.board.service.BoardDeleteService;
import com.project.board.service.BoardDetailService;
import com.project.board.service.BoardFileService;
import com.project.board.service.BoardHitService;
import com.project.board.service.BoardInsertService;
import com.project.board.service.BoardListService;
import com.project.board.service.BoardMainService;
import com.project.board.service.BoardModifyService;
import com.project.board.service.RecommandService;
import com.project.category.service.CategoryService;
import com.project.comment.model.Comment;
import com.project.comment.service.CommentAddService;
import com.project.comment.service.CommentDeleteService;
import com.project.comment.service.CommentListService;
import com.project.file.model.Files;
import com.project.menu.service.MenuService;
import com.project.stop.model.Stop;
import com.project.stop.service.StopInsertService;
import com.project.util.service.FileDownload;

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
	BoardMainService boardMainService;
	
	@Autowired
	BoardDetailService boardDetailService;
	
	@Autowired
	BoardFileService boardFileService;
	
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
	CommentDeleteService commentDeleteService;
	
	@Autowired
	FileDownload fileDownload;
	
	@Autowired
	StopInsertService stopInsertService;
	
	


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
	
	@RequestMapping(value="/memberInfo.do")
	public String memberInfo(){
		
		return "board/memberInfo";
	}
	
	@RequestMapping(value="/changePassword.do")
	public String changePassword(){
	      
		return "board/changePassword";
	}
	
	@RequestMapping(value="/reportInsert.do")
	public String reportInsert(){
	      
		return "board/reportInsert";
	}
	
//	메뉴의 저보를 database에서 가져온다.
	@RequestMapping(value = "/menu.do", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> getMenu() {
		Map<String, Object> map = menuService.getMenu();

		return map;
	}
	
//  boardList에  대한 데이터를 database에서 가져온다.
	  @RequestMapping(value="/boardGet/{categoryNo:[0-9]+}{pageNo:[0-9]+}x.do",method=RequestMethod.GET)
	   @ResponseBody
	   public Map<String, Object> getBoard(@PathVariable int categoryNo,@PathVariable int pageNo){
	      Map<String, Object> map = boardService.getBoardList(categoryNo,pageNo);
	      
	      return map;
	   }
	  
	  @RequestMapping(value="/boardDetail/{boardNo:[0-9]+}{categoryNo:[0-9]+}x.do",method=RequestMethod.GET)
	   @ResponseBody
	   public Map<String, Object> getDetailBoard(@PathVariable int boardNo,@PathVariable int categoryNo){
	      Map<String, Object> map = new HashMap<String, Object>();
	      
	      Board b = boardDetailService.getBoardDetail(boardNo,categoryNo);
	      List<Comment> comment = commentListService.getCommentList(boardNo, categoryNo);
	      List<Files>   files   = boardFileService.getboardFileList(boardNo, categoryNo);
	      
	      map.put("b", b);
	      map.put("comment", comment);
	      map.put("files", files);
	      
	      
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
	
	@RequestMapping(value="/fileDown.do",method=RequestMethod.GET)
	@ResponseBody
	public void fileDown(@RequestParam String fileRealName,@RequestParam String fileFakeName, HttpServletRequest request, HttpServletResponse response ) throws Exception{
		response.setContentType("text/html;charset=UTF-8");

		String originalFile = fileRealName;
		String storedFile 	= fileFakeName;
		String filePath = request.getSession().getServletContext().getRealPath("/fileUpload");
		fileDownload.downloadFiles(originalFile, storedFile, filePath, response, request);
		
	}
	
	@RequestMapping(value="/reportFileDown.do",method=RequestMethod.GET)
	@ResponseBody
	public void reportFileDown(@RequestParam String fileRealName,@RequestParam String fileFakeName, HttpServletRequest request, HttpServletResponse response ) throws Exception{
		response.setContentType("text/html;charset=UTF-8");

		String originalFile = fileRealName;
		String storedFile 	= fileFakeName;
		String filePath = request.getSession().getServletContext().getRealPath("/rfileUpload");
		fileDownload.downloadFiles(originalFile, storedFile, filePath, response, request);
		
	}
	
	@RequestMapping(value="/boardModify.do",method=RequestMethod.PUT)
	@ResponseBody
	public void boardUpdate(@RequestBody Board board){
		
		
		boardModifyService.updateBoard(board);
	}
	
	@RequestMapping(value="/boardDelete.do",method=RequestMethod.PUT)
	@ResponseBody
	public void boardDelete(@RequestBody Board board){
		
		
		boardDeleteService.deleteBoard(board);
	}
	
	@RequestMapping(value="/boardHit.do",method=RequestMethod.PUT)
	@ResponseBody
	public void boardHit(@RequestBody Board board){
		boardHitService.updateIncreaseHitBoard(board);
		
	}
	
	@RequestMapping(value="/boardRecommand.do",method=RequestMethod.POST)
	@ResponseBody
	public int boardRecommand(@RequestBody Board board){
		int result = recommandService.recommandBoard(board);
		
		return result;
	}
	
	@RequestMapping(value="/commentDelete.do",method=RequestMethod.PUT)
	@ResponseBody
	public void commentDelete(@RequestBody Comment comment){
		commentDeleteService.deleteComment(comment);
		
	}
	
	@RequestMapping(value="/reportWrite.do")
	public ModelAndView reportWrite(@ModelAttribute("stop")  Stop stop, HttpServletRequest request) throws Exception{
			 stopInsertService.insertReport(stop, request);
			  String viewName = "redirect:/board/boardMain.do#/boardList/"+stop.getCategoryNo()+stop.getMenuNo();
		      
		      ModelAndView modelAndView = new ModelAndView();
		      modelAndView.setViewName(viewName);
		      
		      return modelAndView;
	}
	
	@RequestMapping(value="/selectRecent.do")
	@ResponseBody
	public List<Board> selectRecent(){
		List<Board> list = boardMainService.getRecentBoard();
		return list;
	}
	
	@RequestMapping(value="/selectTopRecommand.do")
	@ResponseBody
	public List<Board> selectTopRecommand(){
		List<Board> list = boardMainService.getTopRecommandBoard();
		return list;
	}
}
