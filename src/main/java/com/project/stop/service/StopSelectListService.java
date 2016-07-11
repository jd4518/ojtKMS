package com.project.stop.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import com.project.util.service.Pagination;

@Service
public class StopSelectListService {

	static Log log = LogFactory.getLog(StopSelectListService.class);
	
	@Autowired
	private BoardDao boardDao;
	
	@Autowired
	private StopDao stopDao;
	
	@Autowired
	private FileDao fileDao;
	
	@Autowired
	private FileUpload fileUpload;
	
	
	public Map<String, Object> selectReportList(int pageNo) throws Exception{
		Map<String, Object> map = new HashMap<String, Object>();
		Pagination page = new Pagination();
		page.setPageNo(pageNo);
		page.setTotalItem(stopDao.selectReportCount());
		
		List<Stop> stop = stopDao.selectStopList(page);
		List<Files> files = null;
		List<Files> f = new ArrayList<Files>();
		for(int i =0; i<stop.size();i++){
		
			files = fileDao.selectReportFileList(stop.get(i).getStopNo());
			f.addAll(files);
		}
		
		
		map.put("stop", stop);
		map.put("page", page);
		map.put("files", f);
		
		
		return map;
	}
}
