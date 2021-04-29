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
public class DeleteController {

	//Logger객체 -> 내부적인 처리과정 그 결과를 콘솔에 출력시켜줘서 확인
	private Logger log=Logger.getLogger(this.getClass()); //(WriteController.class)
	
	@Autowired
	private  BoardDao boardDao;
	
	/*
	//글삭제폼으로 이동(GET방식) -> boardDelete.jsp
	@RequestMapping(value="/main/delete.do",method=RequestMethod.GET) //get방식이라고 구분
	public String form() { //글삭제 폼 -> 페이지 이동만, 데이터 전달은 안함
		return "boardDelete";
	}
	*/
	
	@RequestMapping(value="/main/delete.do") //post방식이라고 구분
	public String submit(@ModelAttribute("command") BoardCommand command) {
		//src/main/java폴어 log4j.xml 복사 -> 편집
		if(log.isDebugEnabled()) { //디버그 모드인지 체크(출력상태)
			log.debug("BoardCommand -> "+command);
		}
	
		boardDao.deletePost(command.getPostnum());
		
		//return "redirect:/요청명령어" -> "이동할 페이지명(boardList.jsp)";
		return "redirect:/main/list.do";
	}
	
}
