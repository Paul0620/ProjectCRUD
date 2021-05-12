package com.board.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.board.command.CommentCommand;
import com.board.dao.BoardDao;
import com.member.command.MemberCommand;

@Component
@Controller
public class CommentController {
	//로그객체를 생성 써야하나?
	private Logger log=Logger.getLogger(this.getClass());
	
	@Autowired  //대신 사용가능한 어노테이션 @Inject
	private BoardDao boardDao;
	
	//댓글작성
	@RequestMapping(value="/main/cWrite.do", method=RequestMethod.POST)
	@ResponseBody
	public String insertComment(@ModelAttribute("comment") CommentCommand comment, HttpServletRequest request) throws Exception {
		if(log.isDebugEnabled()) {
			log.debug("CommentCommand -> "+comment);
		}
		HttpSession session=request.getSession();
		MemberCommand login=(MemberCommand)session.getAttribute("resultLogin");
		try {
			comment.setId(login.getId());	
			boardDao.insertComment(comment);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return "success";	
	}
	
	//댓글수정
	@RequestMapping(value = "/main/cUpdate.do", method = RequestMethod.POST)
	public Map<String, Object> updateComment(@RequestBody CommentCommand comment) throws Exception {
		if(log.isDebugEnabled()) {
			log.debug("CommentCommand -> "+comment);
		}
		Map<String, Object> result = new HashMap<>();
		try {
			boardDao.updateComment(comment);
			result.put("status", "OK");
		} catch (Exception e) {
			e.printStackTrace();
			result.put("status", "False");
		}
		return result;
	}
	
	/*(댓글 수정 미구현)
	@RequestMapping(value = "/updateReply", method = {RequestMethod.GET, RequestMethod.POST})

	public Map<String, Object> updateReply(@RequestBody ReplyVO replyVO) throws Exception {
		
		Map<String, Object> result = new HashMap<>();
		try {
			boardService.updateReply(replyVO);
			result.put("status", "OK");
		} catch (Exception e) {
			e.printStackTrace();
			result.put("status", "False");
		}
		return result;
	}
	*/
	
	/*댓글삭제(미구현)
	@RequestMapping(value="/main/cDelete.do") 
	public String deleteComment(@ModelAttribute("command") CommentCommand comment, RedirectAttributes rttr) {
		
		if(log.isDebugEnabled()) {
			log.debug("CommentCommand -> "+comment); 
		}
		 boardDao.deleteComment(comment.getCommentnum());
		 BoardCommand board=new BoardCommand();
		 rttr.addAttribute("postnum",board.getPostnum());
		//return "redirect:/요청명령어" -> "이동할 페이지명(boardList.jsp)";
		return "redirect:/main/read.do";
	}*/
	
	/*
	@RequestMapping(value = "/main/cDelete.do")
	public Map<String, Object> deleteComment(@RequestParam("commentnum") int commentnum) throws Exception {
		Map<String, Object> result = new HashMap<>();
		try {
			boardDao.deleteComment(commentnum);
			result.put("status", "OK");
		} catch (Exception e) {
			e.printStackTrace();
			result.put("status", "False");
		}
		return result;
	}
	*/	
}
