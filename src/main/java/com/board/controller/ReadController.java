package com.board.controller;

import java.io.File;

import org.apache.log4j.Logger; //로그객체 관련클래스 import
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.board.command.BoardCommand;
import com.board.dao.BoardDao;
import com.board.util.FileUtil;
import com.board.util.StringUtil;

@Component
@Controller
public class ReadController {

	//로그객체를 생성
	private Logger log=Logger.getLogger(this.getClass());
	
	@Autowired  //대신 사용가능한 어노테이션 @Inject
	private BoardDao boardDao; //byType <-> byName(@Resouce)

	/*
	 * 매개변수 한개 -> @RequestParam("전달받은 매개변수명") 반환형 변수명
	 * 레코드 한개 통째로 받을 땐(DTO) -> @ModelAttribute(커맨드 객체 별칭명) DTO자료형 객체명
	 */
	@RequestMapping("/main/read.do")
	public ModelAndView process(@RequestParam("postnum") int postnum) {
		
		//int seq=Integer.parseInt(Request.getParameter("seq"));
		if(log.isDebugEnabled()) {
			log.debug("postnum -> "+postnum);
		}
		
		//1.조회수 증가
		boardDao.readcntUp(postnum); //int -> Integer(자동형변환이 일어나기때문) 그래서 경고줄이 안뜸
		//글내용 -> \r\n aaa \r\n -> 메서드로 구현(<br>로 변경) -> 요즘사용은 <pre></pre>
		BoardCommand board=boardDao.selectPost(postnum);
		board.setContent(StringUtil.parseBr(board.getContent()));
		/*
		ModelAndView mav=new ModelAndView("boardView");
		mav.addObject("board",board);
		return mav;
		*/
		//1.이동할 페이지명, 2.매개변수가 전달할 키명, 3.전달할 값 -> boardView.jsp로 전달
		return new ModelAndView("boardRead","board",board);
	
	}
	
	/*
	//글상세보기와 연관(다운로드)
	@RequestMapping("/board/file.do")
	public ModelAndView download(@RequestParam("filename") String filename) {
		
		//1.다운로드 받을 파일의 위치와 이름을 알아야 된다.
		File downloadFile=new File(FileUtil.UPLOAD_PATH+"/"+filename);
		
		//2.스프링에서 다운로드 받는 뷰를 따로 작성 -> AbstractView를 상속받아 작성
		//1.다운로드 받을 뷰객체(id), 2.모델객체명(키명), 3.전달할값(다운로드 받을 파일정보)
		//1.이동할 페이지x(jsp 페이지 x)
		return new ModelAndView("downloadView","downloadFile",downloadFile);
		
	}
	*/
	
}


