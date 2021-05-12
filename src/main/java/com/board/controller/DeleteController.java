package com.board.controller;

import org.apache.log4j.Logger; //로그객체 import
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.board.command.BoardCommand;
import com.board.dao.BoardDao;

@Component
@Controller
public class DeleteController {
	//Logger객체 -> 내부적인 처리과정 그 결과를 콘솔에 출력시켜줘서 확인
	private Logger log=Logger.getLogger(this.getClass()); //(WriteController.class)
	
	@Autowired
	private  BoardDao boardDao;
	
	@RequestMapping(value="/main/delete.do") 
	public String deleteSubmit(@ModelAttribute("command") BoardCommand command) {
		//src/main/java폴어 log4j.xml 복사 -> 편집
		if(log.isDebugEnabled()) { //디버그 모드인지 체크(출력상태)
			log.debug("BoardCommand -> "+command); //command.toString()
		}
		 boardDao.deletePost(command.getPostnum());
		return "redirect:/main/list.do";
	}
}
