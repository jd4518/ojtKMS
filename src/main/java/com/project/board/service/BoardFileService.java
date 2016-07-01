package com.project.board.service;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.file.dao.FileDao;
import com.project.file.model.Files;

@Service
public class BoardFileService {

	static Log log = LogFactory.getLog(BoardFileService.class);
	
	@Autowired
	private FileDao fileDao;
	
	public List<Files> getboardFileList(int boardNo, int categoryNo){
		Files file = new Files();
		file.setBoardNo(boardNo);
		file.setCategoryNo(categoryNo);
		
		List<Files> files = fileDao.selectFileList(file);
		return files;
	}

}
