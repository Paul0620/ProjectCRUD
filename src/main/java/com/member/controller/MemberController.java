package com.member.controller;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.member.command.LoginCommand;
import com.member.command.MemberCommand;
import com.member.dao.MemberDao;
import com.member.util.PagingUtil;

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
	
	//주소팝업
	@RequestMapping("/main/jusoPopup.do")
    public String jusoPopup(@ModelAttribute("member") MemberCommand member) throws Exception {
        return "jusoPopup";
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
		return "redirect:/main/list.do"; 
	}
	
	//회원리스트
	@RequestMapping("/main/memberList.do")
	public ModelAndView listMember(@RequestParam(value="pageNum", defaultValue="1") int currentPage) {
		if(log.isDebugEnabled()){ //로그객체의 정보를 출력할 준비(=디버깅모드)
			//System.out.println(memberDao);
		   log.debug("memberDao="+memberDao);//log.debug("출력할 정보~)
		}
		
		int count=memberDao.getMemberCount();
		System.out.println("count="+count);
		//페이징처리->PagingUtil클래스(현재페이지,총갯수,블럭당페이지수,페이지당레코드수,,,
		PagingUtil page=new PagingUtil(currentPage,count,10,5,"memberList.do");
		List<MemberCommand> list=null;
		//레코드가 한개이상이라면
		if(count > 0){ //페이지당 시작게시물번호->start, 마지막게시물번호 end
			Map<String,Object>map=new HashMap<String,Object>();
			map.put("start",page.getStartCount());
			map.put("end", page.getEndCount());
			list=memberDao.getMemberList(map);
		}else{//아무것도 없는경우
			list=Collections.EMPTY_LIST;//정적상수
		}
		//처리한 결과->selectList.jsp에 전달하면 끝
		ModelAndView mav=new ModelAndView();
		mav.setViewName("memberList");//memberList.jsp
		mav.addObject("count",count); //request.setAttribute("count",count); ${count}
		mav.addObject("list",list);//List객체->forEach로 실행->화면에 출력
		//이전(링크),다음(링크)문자열->반환시켜준다.
		mav.addObject("pagingHtml",page.getPagingHtml());//${pagingHtml}
		return mav;
	}
	
	//회원정보
	@RequestMapping("/main/memberRead.do")
	public ModelAndView selectMember(@RequestParam("id") String id) {
		if(log.isDebugEnabled()){
			log.debug("id="+id);
		}
		MemberCommand member=memberDao.selectMember(id);
		return new ModelAndView("memberRead","member",member);		
	}
	
	//회원수정
	//수정폼으로 이동
	@RequestMapping(value="/main/memberUpdate.do", method=RequestMethod.GET)
	public ModelAndView updateMember(@RequestParam("id") String id) {
		MemberCommand member=memberDao.selectMember(id);
		return new ModelAndView("memberUpdate","member",member);
	}
	//수정제출
	@RequestMapping(value="/main/memberUpdate.do", method=RequestMethod.POST)
	public String updateMember(MemberCommand member, HttpServletRequest req, ModelMap model) {
		if(log.isDebugEnabled()){
			log.debug("MemberCommand="+member);
		}
		
		memberDao.updateMember(member);
		LoginCommand login = new LoginCommand();
		login.setId(member.getId());
		login.setNickname(member.getNickname());
		login.setPwd(member.getPwd());
		memberDao.updateLogin(login);
		
		HttpSession session=req.getSession();     
		MemberCommand resultLogin=memberDao.loginMember(member);
		
		if(resultLogin==null) {
			session.setAttribute("resultLogin",null);
			model.addAttribute("message",false);
			return "login";
		} else { 
			session.setAttribute("resultLogin", resultLogin);
	        System.out.println("수정 후 메인페이지로 변경한 값으로 이동");   
		}
		
		return "redirect:/main/list.do";
	}
	
	//회원삭제
	@RequestMapping("/main/memberDelete.do")
	public String deleteMember(@RequestParam("id") String id, HttpSession session) {
		if(log.isDebugEnabled()){
			log.debug("id="+id);
		}
		
		memberDao.deleteMember(id);
		session.invalidate();
		return "redirect:/main/list.do";
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
			return "redirect:/main/list.do";
	}
	
	//로그아웃
	@RequestMapping("/main/logout.do")
		public ModelAndView logout(HttpSession session) {
	    	session.invalidate();
	        ModelAndView mav = new ModelAndView("redirect:/main/list.do");
	        System.out.println("로그아웃!");
	        return mav;
 	}
}
