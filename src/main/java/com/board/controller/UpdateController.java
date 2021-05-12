package com.board.controller;

import org.apache.log4j.Logger; //로그객체 import
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.board.command.BoardCommand;
import com.board.dao.BoardDao;

@Component
@Controller
public class UpdateController {
	//Logger객체 -> 내부적인 처리과정 그 결과를 콘솔에 출력시켜줘서 확인
	private Logger log=Logger.getLogger(this.getClass()); //(WriteController.class)
	
	@Autowired
	private  BoardDao boardDao;
	//1.글수정폼으로 이동(GET방식)
	
	@RequestMapping(value="/main/update.do",method=RequestMethod.GET) //get방식이라고 구분
	//public String form() { //글쓰기 폼 -> 페이지 이동만, 데이터 전달은 안함
	public ModelAndView updateForm(@RequestParam("postnum") int postnum) { //수정 폼 -> 페이지 이동, 데이터 전달
		BoardCommand boardCommand=boardDao.selectPost(postnum); //DAO 5번 -> 게시물 한개 찾기
		//1.이동할 페이지명(확장자 생략), 2.전달할 데이터 키명, 3.전달할 값
		return new ModelAndView("boardUpdate","command",boardCommand); 
	}
	
	//2.입력해서 유효성검사(BindingResult result) -> 에러발생이 안됐으면 그대로 전송 or 만약 에러발생이 됐으면 -> forBacking -> form()순으로 재이동
	@RequestMapping(value="/main/update.do",method=RequestMethod.POST) //post방식이라고 구분
	public String updateSubmit(@ModelAttribute("command") BoardCommand command) {
		//src/main/java폴어 log4j.xml 복사 -> 편집
		if(log.isDebugEnabled()) { //디버그 모드인지 체크(출력상태)
			log.debug("BoardCommand -> "+command);
		}
		//글수정 호출
		boardDao.updatePost(command); //DB상에 반영 -> aaa.txt -> ttt.png로 반영(수정했다면)
		//return "redirect:/요청명령어" -> "이동할 페이지명(boardList.jsp)";
		return "redirect:/main/list.do";
	}
}
