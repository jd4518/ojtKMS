package com.project.stop.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/stop")
public class StopController {
	
	private static final Logger logger = LoggerFactory.getLogger(StopController.class);
	
	
	@RequestMapping("/stop.do")
	public String stopView(){
		return "stop/stop";
	}
	
	@RequestMapping("/endStop.do")
	public String endStopView(){
		return "stop/endStop";
	}
	
	
	
}
