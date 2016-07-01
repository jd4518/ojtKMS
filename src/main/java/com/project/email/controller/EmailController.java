package com.project.email.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.project.email.model.Email;
import com.project.email.service.EmailSenderService;
import com.project.member.model.Member;
import com.project.member.service.MemberIdFindService;
import com.project.member.service.MemberPwFindService;
import com.project.member.service.MemberRanPwService;

@Controller
@RequestMapping("/find")
public class EmailController {

	@Autowired
	private EmailSenderService emailSenderService;
	
	@Autowired
	private MemberIdFindService memberIdFindService;
	
	@Autowired
	private MemberPwFindService memberPwFindService;
	
	@Autowired
	private MemberRanPwService memberRanPwService;
	
	@Autowired
	private Email email;
	
	
	@RequestMapping("/findMain.do")
	public String findMainView(){
		return "find/findMain";
	}
	
	@RequestMapping("/findId.do")
	public String findIdView(){
		return "find/findId";
	}
	
	@RequestMapping("/findPw.do")
	public String findPwView(){
		return "find/findPw";
	}
	
	@RequestMapping("/findIdComplete.do")
	public String findIdCompleteView(){
		return "find/findIdComplete";
	}
	
	@RequestMapping("/findPwComplete.do")
	public String findPwCompleteView(){
		return "find/findPwComplete";
	}
	   @RequestMapping(value="/findPw.do",method = RequestMethod.POST)
	    public ModelAndView sendEmailAction (@ModelAttribute("member") Member member) throws Exception {
		   String id = member.getMemberId();
		   String eMail = member.getMemberEmail();
		   int pw = memberPwFindService.findPw(member);
		   ModelAndView mav = new ModelAndView();
		   if(pw!=0){
			   String fPw = memberRanPwService.RanPw(member);
			   email.setSubject(id+"님 BIT홈페이지 비밀번호 찾기 이메일입니다.");
			   email.setContent("임시 비밀번호는 "+ fPw +"입니다. 임시 비밀번호로 로그인 후 비밀번호를 변경해주세요.");
			   email.setReceiver(eMail);
			   emailSenderService.SendEmail(email);
		   }
		   
		   mav.addObject("pw",pw);
		   mav.setViewName("find/findPwComplete");
		   return mav;
	    }
	   
	   @RequestMapping(value="/findId.do",method = RequestMethod.POST)
		public ModelAndView findId(@ModelAttribute("member") Member member){
		   
		   String id = memberIdFindService.findId(member);
		   ModelAndView mav = new ModelAndView();
		   
		   mav.addObject("id",id);
		   mav.setViewName("find/findIdComplete");
			return mav;
		}
		   		 
		   
}
