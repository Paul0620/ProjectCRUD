package com.board.controller;

import java.net.http.HttpHeaders;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.board.command.CommentCommand;
import com.board.dao.BoardDao;
import com.member.command.LoginCommand;

@Component
@Controller
public class CommentController {
	
	//로그객체를 생성 써야하나?
	private Logger log=Logger.getLogger(this.getClass());
	
	@Autowired  //대신 사용가능한 어노테이션 @Inject
	private BoardDao boardDao;
	

	//댓글작성
	@RequestMapping("/main/cWrite.do")
	@ResponseBody
	private String insertComment(@ModelAttribute("comment") CommentCommand comment, HttpServletRequest request) {
		
		HttpSession session=request.getSession();
		LoginCommand login=(LoginCommand)session.getAttribute("login");
		
		try {
			comment.setId(login.getId());
			boardDao.insertComment(comment);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return "success";
		
	}
	
	//댓글수정
	@RequestMapping("/main/cUpdate.do")
	private void updateComment(@ModelAttribute CommentCommand comment) {		
		
		boardDao.updateComment(comment);
		
	}
	
	//댓글삭제
	@RequestMapping("/main/cDelete.do")
	private void deleteComment(@ModelAttribute CommentCommand comment) {
		
		boardDao.deleteComment(comment.getCommentnum());
		
	}
	
}
