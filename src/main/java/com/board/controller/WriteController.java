package com.board.controller;

import org.apache.log4j.Logger; //로그객체 import
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.board.command.BoardCommand;
import com.board.dao.BoardDao;

@Component
@Controller
public class WriteController {
	//Logger객체 -> 내부적인 처리과정 그 결과를 콘솔에 출력시켜줘서 확인
	private Logger log=Logger.getLogger(this.getClass()); //(WriteController.class)
	
	@Autowired
	private  BoardDao boardDao;
	
	//글쓰기폼으로 이동
	@RequestMapping(value="/main/write.do",method=RequestMethod.GET) 
	public String wirteForm() {
		//System.out.println("다시 처음부터 값을 입력받기위해서 form()호출됨");
		return "boardWrite"; 
	}
	
	//게시글 작성 후 제출
	@RequestMapping(value="/main/write.do",method=RequestMethod.POST) 
	public String postSubmit(@ModelAttribute("board") BoardCommand board) {
		if(log.isDebugEnabled()) { //디버그 모드인지 체크(출력상태)
			log.debug("BoardCommand -> "+board); //command.toString()
		}
		int newPostnum=boardDao.getNewPostnum()+1; //최대값+1
		//System.out.println("newPostnum -> "+newPostnum);
		//게시물 번호 -> 계산 -> 저장 
		board.setPostnum(newPostnum);
		boardDao.insertPost(board);
		//System.out.println("command -> "+board );
		//return "redirect:/요청명령어" -> "이동할 페이지명(boardList.jsp)";
		return "redirect:/main/list.do";	
	}
	
}
