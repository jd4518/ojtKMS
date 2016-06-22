package com.project.main.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@Secured("ROLE_USER")
public class MainController {
	static Log log = LogFactory.getLog(MainController.class);
	
	@RequestMapping(value="/main.do")
	public void getMainView(){
		
		log.info("getMainVew()..");
	}
	
}
