package com.board.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger; //로그객체 import
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.board.command.BoardCommand;
import com.board.dao.BoardDao;
import com.member.command.MemberCommand;
import com.member.dao.MemberDao;

@Component
@Controller
public class WriteController {

	//Logger객체 -> 내부적인 처리과정 그 결과를 콘솔에 출력시켜줘서 확인
	private Logger log=Logger.getLogger(this.getClass()); //(WriteController.class)
	
	@Autowired
	private  BoardDao boardDao;
	
	//1.글쓰기폼으로 이동(GET방식)
	//@RequestMapping("/board/writeForm.do") //GET, POST방식 이름이 달라서 구분할 필요가 없다.
	//만약 GET, POST방식 이름이 같다면 구분해줘야함.
	@RequestMapping(value="/main/write.do",method=RequestMethod.GET) //get방식이라고 구분
	public String form(@ModelAttribute("board") BoardCommand board) {
		return "boardWrite"; //return "이동할 페이지명" //definition이름과 동일
	}
	
	//2.에러메세지 출력 -> 다시 초기화 시켜주는 기능 -> @ModelAttribute("커맨드객체 별칭명")
	//반환형(DTO형) 임의의 메서드명
	@ModelAttribute("command")
	public BoardCommand forBacking() {
		System.out.println("forBacking() 호출됨!");
		return new BoardCommand(); //전에 입력한 값을 지우고 새로 저장하기 위해서
												//값을 새로 저장하기 위해서 객체생성
	}
	
	//3.입력해서 유효성검사 -> 에러발생이 안됐으면 그대로 전송 or 만약 에러발생이 됐으면 -> forBacking -> form()순으로 재이동
	@RequestMapping(value="/main/write.do",method=RequestMethod.POST) //post방식이라고 구분
	public String submit(@ModelAttribute("board") BoardCommand board) {
		
		if(log.isDebugEnabled()) { //디버그 모드인지 체크(출력상태)
			log.debug("BoardCommand -> "+board); //command.toString()
		}
		//최대값+1
		int newPostnum=boardDao.getNewPostnum()+1;
		System.out.println("newPostnum -> "+newPostnum);
		
		//게시물 번호 -> 계산 -> 저장 
		board.setPostnum(newPostnum);
		
		boardDao.insertPost(board);
		System.out.println("command -> "+board );
		
		//return "redirect:/요청명령어" -> "이동할 페이지명(boardList.jsp)";
		return "redirect:/main/list.do";
		
	}
	
}
