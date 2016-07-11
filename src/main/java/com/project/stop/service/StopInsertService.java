package com.project.stop.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.board.dao.BoardDao;
import com.project.file.dao.FileDao;
import com.project.file.model.Files;
import com.project.stop.dao.StopDao;
import com.project.stop.model.Stop;
import com.project.util.service.FileUpload;

@Service
public class StopInsertService {

	static Log log = LogFactory.getLog(StopInsertService.class);
	
	@Autowired
	private BoardDao boardDao;
	
	@Autowired
	private StopDao stopDao;
	
	@Autowired
	private FileDao fileDao;
	
	@Autowired
	private FileUpload fileUpload;
	
	
	public void insertReport(Stop stop,HttpServletRequest request) throws Exception{
		
		stopDao.insertReport(stop);
		String filePath = request.getSession().getServletContext().getRealPath("/rFileUpload");
		   List<Files> filesList = fileUpload.fileUploads(request, filePath);   
		   Files files = null;
		   if(filesList.size() > 0){
			   for(int i=0; i<filesList.size();i++){
				   files = filesList.get(i);
				   files.setMenuNo(stop.getMenuNo());
				   files.setCategoryNo(stop.getCategoryNo());
				   files.setBoardNo(stop.getBoardNo());
				   fileDao.insertReportFile(files);
			   }
		   }
	}

}
