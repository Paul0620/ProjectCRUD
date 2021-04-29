package com.member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.member.command.MemberCommand;
import com.member.dao.MemberDao;

@Component
@Controller
public class MemberController {

	//로그객체->매개변수값,객체값을 출력용도,에러메세지확용
	private Logger log=Logger.getLogger(this.getClass());
	
	//DB연동->멤버변수에 @Autowired부여->Setter Method작성no
	@Autowired
	private MemberDao memberDao;

	//회원가입페이지로 이동
	@RequestMapping(value="/main/join.do", method=RequestMethod.GET)
	public String form(){
		System.out.println("회원가입 페이지로 이동");
		return "join"; //return "이동할 페이지명"
		                             //확장자는 생략(.jsp)
	}
	
	//아이디 중복체크
	@ResponseBody
	@RequestMapping(value="/main/idCheck.do", method=RequestMethod.POST)
	public String idCheck(MemberCommand member, HttpServletRequest request){
	    System.out.println("아이디 중복체크 :: "+request.getRequestURI());
	    int resultId=memberDao.idCheck(member);
	    System.out.println("resultId -> "+resultId);
	    return String.valueOf(resultId);
	}
	
	//닉네임 중복체크
	@ResponseBody
	@RequestMapping(value="/main/nicknameCheck.do", method=RequestMethod.POST)
	public String nicknameCheck(MemberCommand member, HttpServletRequest request){
	    System.out.println("닉네임 중복체크 :: "+request.getRequestURI());
	    int resultNick=memberDao.nicknameCheck(member);
	    System.out.println("resultNick -> "+resultNick);
	    return String.valueOf(resultNick);
	}
	
	//회원가입
	@RequestMapping(value="/main/join.do",method=RequestMethod.POST)
	public String submit(@ModelAttribute("member") MemberCommand member){
	   
		int resultId=memberDao.idCheck(member);
		int resultNick=memberDao.nicknameCheck(member);
		
		//로그객체로 출력
		if(log.isDebugEnabled()){
			log.debug("memberCommand="+member);
		}
		
		try {
			//아이디, 닉네임 중복체크 존재한다면 다시 가입창
			if(resultId == 1 || resultNick == 1) {
				return "/main/join.do";
			} else if(resultId == 0 && resultNick == 0) {
				//아이디, 닉네임 중복이 아니라면 값 넣기
				memberDao.insertMember(member);
			}
		} catch(Exception e) {
			throw new RuntimeException();
		}
		
		//메인페이지로 이동
		return "redirect:/main/home.do"; 
	}
	
	//로그인 페이지로 이동
	@RequestMapping(value="/main/login.do",method=RequestMethod.GET)
	public String loginForm() {
		return "login";
	}
		
	//로그인
	@RequestMapping(value="/main/loginCheck.do", method=RequestMethod.POST)
	public String loginMember(MemberCommand member, HttpServletRequest req, ModelMap model) {
		if(log.isDebugEnabled()) { //디버그 모드인지 체크(출력상태)
			log.debug("MemberCommand -> "+member);
		}
	         
		HttpSession session=req.getSession();     
		MemberCommand resultLogin=memberDao.loginMember(member);
		
		if(resultLogin==null) {
			session.setAttribute("resultLogin",null);
			model.addAttribute("message",false);
			return "login";
		} else { 
			session.setAttribute("resultLogin", resultLogin);
	        System.out.println("로그인!");   
		}
			return "redirect:/main/home.do";
	}
	
	//로그아웃
	@RequestMapping("/main/logout.do")
		public ModelAndView logout(HttpSession session) {
	    	session.invalidate();
	        ModelAndView mav = new ModelAndView("redirect:/main/home.do");
	        System.out.println("로그아웃!");
	        return mav;
	 	}
}
