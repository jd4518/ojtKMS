package com.project.admin.controller;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.project.board.controller.BoardController;
import com.project.board.model.Board;
import com.project.email.model.Email;
import com.project.email.service.EmailSenderService;
import com.project.member.model.Member;
import com.project.member.service.MemberDeleteService;
import com.project.member.service.MemberDowngradeService;
import com.project.member.service.MemberListService;
import com.project.member.service.MemberSaveService;
import com.project.member.service.MemberStopService;
import com.project.member.service.MemberUpgradeService;
import com.project.member.service.MemberWarningService;
import com.project.stop.service.StopSelectListService;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	private static final Logger logger = LoggerFactory.getLogger(AdminController.class);
	
	@Autowired
	private EmailSenderService emailSenderService;
	
	@Autowired
	private StopSelectListService stopSelectListService;
	
	@Autowired
	private MemberListService memberListService;
	
	@Autowired
	private MemberDeleteService memberDeleteService;
	
	@Autowired
	private MemberUpgradeService memberUpgradeService;
	
	@Autowired
	private MemberDowngradeService memberDowngradeService;
	
	@Autowired
	private MemberWarningService memberWarningService;
	
	@Autowired
	private MemberStopService memberStopService;
	
	@Autowired
	private MemberSaveService memberSaveService;
	
	@Autowired
	private Email email;
	
	
	@RequestMapping("/adminMain.do")
	public String adminMainView(){
		return "admin/adminMain";
	}
	
	@RequestMapping("/reportList.do")
	public String reportListView(){
		return "admin/reportList";
	}
	
	@RequestMapping("/memberList.do")
	public String memberListView(){
		return "admin/memberList";
	}
	
	 @RequestMapping(value="/reportGet/{pageNo:[0-9]+}x.do",method=RequestMethod.GET)
	   @ResponseBody
	   public Map<String, Object> getReport(@PathVariable int pageNo) throws Exception{
	      System.out.println("page"+pageNo);
	      
	      Map<String, Object> map = stopSelectListService.selectReportList(pageNo);
	      
	      return map;
	   }	
	 
	 @RequestMapping(value="/memberGet/{pageNo:[0-9]+}x.do",method=RequestMethod.GET)
	   @ResponseBody
	   public Map<String, Object> getMember(@PathVariable int pageNo) throws Exception{
	      System.out.println("page"+pageNo);
	      
	      Map<String, Object> map = memberListService.getMemberList(pageNo);
	      
	      return map;
	   }	
		   
	 @RequestMapping(value="/memberDelete.do",method=RequestMethod.PUT)
		@ResponseBody
		public void memberDelete(@RequestBody Member member){
		 String memberId = member.getMemberId();
		 	memberDeleteService.deleteMember(memberId);
			
		}
	 
	 @RequestMapping(value="/memberUpgrade.do",method=RequestMethod.PUT)
		@ResponseBody
		public void memberUpgrade(@RequestBody Member member){
		 String memberId = member.getMemberId();
		 	memberUpgradeService.memberUpgrade(memberId);
		}
		
		@RequestMapping(value="/memberDowngrade.do",method=RequestMethod.PUT)
		@ResponseBody
		public void memberDowngrade(@RequestBody Member member){
			String memberId = member.getMemberId();
			memberDowngradeService.memberDowngrade(memberId);
		}
		
		 @RequestMapping(value="/memberWarning.do",method=RequestMethod.PUT)
			@ResponseBody
			public void memberWarning(@RequestBody Member member){
			 String memberId = member.getMemberId();
			 memberWarningService.memberWarning(memberId);
				
			}
		 
		 @RequestMapping(value="/memberStop.do",method=RequestMethod.PUT)
			@ResponseBody
			public void memberStop(@RequestBody Member member){
			 String memberId = member.getMemberId();
			 memberStopService.memberStop(memberId);
			}
			
			@RequestMapping(value="/memberSave.do",method=RequestMethod.PUT)
			@ResponseBody
			public void memberSave(@RequestBody Member member){
				String memberId = member.getMemberId();
				memberSaveService.memberSave(memberId);
			}
}
