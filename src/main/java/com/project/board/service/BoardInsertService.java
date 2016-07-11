package com.project.board.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.board.dao.BoardDao;
import com.project.board.model.Board;
import com.project.file.dao.FileDao;
import com.project.file.model.Files;
import com.project.util.service.FileUpload;

@Service
public class BoardInsertService {

	static Log log = LogFactory.getLog(BoardInsertService.class);
	
	@Autowired
	private BoardDao boardDao;
	
	@Autowired
	private FileDao fileDao;
	
	@Autowired
	private FileUpload fileUpload;
	
	
	public void insertBoard(Board board,HttpServletRequest request) throws Exception{
		
		boardDao.insertBoard(board);
		String filePath = request.getSession().getServletContext().getRealPath("/fileUpload");
		   List<Files> filesList = fileUpload.fileUploads(request, filePath);   
		   Files files = null;
		   if(filesList.size() > 0){
			   for(int i=0; i<filesList.size();i++){
				   files = filesList.get(i);
				   files.setMenuNo(board.getMenuNo());
				   files.setCategoryNo(board.getCategoryNo());
				   fileDao.insertFile(files);
			   }
		   }
	}

}
