package com.project.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class MainController {
	static Log log = LogFactory.getLog(MainController.class);
	
	@RequestMapping(value="/main.do")
	public void getMainView(){
		
		log.info("getMainVew()..");
	}
	
}
