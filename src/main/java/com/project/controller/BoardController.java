package com.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/board")
public class BoardController {

	@RequestMapping(value="/boardMain.do")
	public String getBoardMainView(){
		
		return "board/boardMain";
	}
}
