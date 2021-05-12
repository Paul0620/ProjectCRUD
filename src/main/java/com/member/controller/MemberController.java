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
import org.springframework.ui.Model;
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

@Component //관리되는 객체임을 표시하기 위한 가장 기본적인 어노테이션, 자동으로 빈을 등록시켜주는 기능
@Controller //해당 클래스가 컨트롤러임을 나타내기 위한 어노테이션
public class MemberController {

	//로그객체->매개변수값,객체값을 출력용도,에러메세지 등 내부적인 처리과정을 콘솔로 출력시켜주는 역할을 하는 객체
	private Logger log=Logger.getLogger(this.getClass());
	
	//DB연동->멤버변수에 @Autowired부여->Setter Method작성no
	@Autowired //Setter Method가 필요없음 대신역할을 해줌
	private MemberDao memberDao;

	//회원가입페이지로 이동
	//요청에 대해 어떤 controller, 어떤 메소드가 처리할지 맵핑하기 위한 어노테이션
	/*@Requestmapping(value="url값 매핑조건을 부여, 주소패턴을 지정", 
								method=ReqeustMethod(HTTP Request 메소드값을 매핑조건으로 부여
								GET, POST, HEAD, OPTIONS, PUT, DELETE, TRACE가 있음)
		value="url"이 다를경우에는 method를 추가 안해줄 경우도 있지만 만약 같다면 추가하여 구분해줘야함 
	*/
	@RequestMapping(value="/main/join.do", method=RequestMethod.GET)
	public String joinForm(){
		//System.out.println("회원가입 페이지로 이동");
		return "join"; //return "이동할 페이지명", 확장자는 생략
	}
	
	//아이디 중복체크
	@ResponseBody
	@RequestMapping(value="/main/idCheck.do", method=RequestMethod.POST)
	public String idCheck(MemberCommand member, HttpServletRequest request){
	    //System.out.println("아이디 중복체크 :: "+request.getRequestURI());
	    int resultId=memberDao.idCheck(member);
	    //System.out.println("resultId -> "+resultId);
	    return String.valueOf(resultId);
	}
	
	//닉네임 중복체크
	@ResponseBody
	@RequestMapping(value="/main/nicknameCheck.do", method=RequestMethod.POST)
	public String nicknameCheck(MemberCommand member, HttpServletRequest request){
	    //System.out.println("닉네임 중복체크 :: "+request.getRequestURI());
	    int resultNick=memberDao.nicknameCheck(member);
	    //System.out.println("resultNick -> "+resultNick);
	    return String.valueOf(resultNick);
	}
	
	//주소팝업
	@RequestMapping("/main/jusoPopup.do")
    public String jusoPopup(@ModelAttribute("member") MemberCommand member) throws Exception {
        return "jusoPopup";
    }
	
	//회원가입
	@RequestMapping(value="/main/join.do",method=RequestMethod.POST)
	public String joinSubmit(@ModelAttribute("member") MemberCommand member){
		//아이디, 닉네임 체크를 위해 변수선언 
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
		//redirect 중복사용 방지를 위해서 
		return "redirect:/main/list.do"; 
	}
	
	//회원리스트
	@RequestMapping("/main/memberList.do")
												//@RequestParam은 HttpServletReqeust와 같은 역할을 함, 
												//Controller메소드의 파라미터와 웹요청 파라미터와 맵핑하기위한 어노테이션												
												//형식) @RequestParam(value="가저올 데이터의 이름", defaultValue="할당할 기본값") 데이터타입 가져온데이터를 담을 변수명
												//defaultValue -> null을 할당할 수 없는 기본데이터 타입의 경우 타입변환 에러가 발생, 에러를 막고자 기본값 할당
	public ModelAndView listMember(@RequestParam(value="pageNum", defaultValue="1") int currentPage) {
		if(log.isDebugEnabled()){ //로그객체의 정보를 출력할 준비(=디버깅모드)
			//System.out.println(memberDao);
		   log.debug("memberDao="+memberDao);//log.debug("출력할 정보~)
		}
		int count=memberDao.getMemberCount(); //가입자수 카운트
		//System.out.println("count="+count);
		//페이징처리->PagingUtil클래스(현재페이지,총갯수,블럭당페이지수,페이지당레코드수,보여줄페이지명)
		PagingUtil page=new PagingUtil(currentPage,count,10,5,"memberList.do");
		//배열과 동일한 역할을 하는 List 하지만 리스트에 담는 내용물이 다름 -> 사용하는 타입이 다를 때 Generic타입을 사용
		List<MemberCommand> list=null;
		//레코드가 한개이상이라면
		if(count > 0){ //페이지당 시작게시물번호->start, 마지막게시물번호 end
			//Map -> 인터페이스, 객체생성이 불가 그래서 자식인 HashMap으로 객체를 생성
			//HashMap은 본인 베소드 외에 부모인 Map의 메소드들을 강제 상속받음
			//2차원 배열의 형태를 가져오기 위해 사용 -> 페이지별로 목록을 만들기 위해
			//Map<Key형,Value형>
			Map<String,Object> map=new HashMap<String,Object>();
			map.put("start",page.getStartCount()); //("key",value)
			map.put("end", page.getEndCount());
			list=memberDao.getMemberList(map);
		}else{//아무것도 없는경우
			list=Collections.EMPTY_LIST;
			//정적상수 -> 싱글톤 객체로 이동(싱글톤 -> 어떤 클래스가 최초 한번만 메모리를 할당하고(Static) 그 메모리에 객체를 만들어 사용하는 디자인 패턴)
			//EmptyList -> List를 구현한 하위 클래스, 비어있는 List로 사용할 목적으로 사용
			//Collections -> 메모리의 낭비를 방지하기 위해 
			//Collections.EMPTY_LIST -> EmptyList를 싱글톤 형태로 제공하면 비어있는 List를 리턴함과 동시에 단 하나의 인스턴스만 참조하여 메모리 낭비 방지
		}
		//처리한 결과->selectList.jsp에 전달하면 끝
		ModelAndView mav=new ModelAndView();
		mav.setViewName("memberList"); //memberList.jsp setViewName("보여줄 페이지명(확장자 작성 안함)")
		mav.addObject("count",count); //request.setAttribute("count",count); ${count}
		mav.addObject("list",list); //List객체->forEach로 실행->화면에 출력
		//이전(링크),다음(링크)문자열->반환시켜준다.
		mav.addObject("pagingHtml",page.getPagingHtml());//${pagingHtml}
		return mav;
	}
	
	//회원정보
	@RequestMapping("/main/memberRead.do")
	public ModelAndView selectMember(@RequestParam("id") String id) { //id값을 가져오기
		//ModelAndView -> 데이터와 이동하고자하는 View페이지를 같이 저장하기 위해 사용
		if(log.isDebugEnabled()){
			log.debug("id="+id);
		}
		MemberCommand member=memberDao.selectMember(id);
		//형식) ModelAndView("이동할 페이지명(확장자 생략)","전달할 데이터 키명",전달할 값)
		return new ModelAndView("memberRead","member",member);		
	}
	
	//회원수정
	//수정폼으로 이동
	@RequestMapping(value="/main/memberUpdate.do", method=RequestMethod.GET)
	public ModelAndView updateMember(@RequestParam("id") String id) {
		MemberCommand member=memberDao.selectMember(id);
		return new ModelAndView("memberUpdate","member",member);
	}
	
	//수정 후 보내기
	@RequestMapping(value="/main/memberUpdate.do", method=RequestMethod.POST)
	public String updateMember(MemberCommand member, HttpServletRequest req, Model model) {
		//String -> 페이지 이동만함, 데이터 전달은 안함
		//데이터를 저장하기 위해서 Model사용 -> Model, ModelMap 차이점 -> Model-인터페이스, ModelMap-클래스 하지만 기능상 큰 차이는 없음
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
		session.setAttribute("resultLogin", resultLogin); //정보 수정 후 변경된 값 세션처리
	    //System.out.println("수정 후 메인페이지로 변경한 값으로 이동");   
		return "redirect:/main/list.do";
	}
	
	//회원삭제
	@RequestMapping("/main/memberDelete.do")
	public String deleteMember(@RequestParam("id") String id, HttpSession session) {
		if(log.isDebugEnabled()){
			log.debug("id="+id);
		}
		memberDao.deleteMember(id);
		session.invalidate(); //탈퇴한 회원의 로그인 세션을 종료
		return "redirect:/main/list.do";
	}
		
	//로그인 페이지로 이동
	@RequestMapping(value="/main/login.do",method=RequestMethod.GET)
	public String loginForm() {
		return "login";
	}
		
	//로그인
	@RequestMapping(value="/main/loginCheck.do", method=RequestMethod.POST)
	public String loginMember(MemberCommand member, HttpServletRequest req, Model model) {
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
    	session.invalidate(); //세션 종료
        ModelAndView mav = new ModelAndView("redirect:/main/list.do");
        //System.out.println("로그아웃!");
        return mav;
 	}
}
