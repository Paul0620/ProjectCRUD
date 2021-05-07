package com.board.controller;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.board.command.BoardCommand;
import com.board.dao.BoardDao;
import com.board.util.PagingUtil;

@Component
@Controller
public class ListController {

	private Logger log=Logger.getLogger(this.getClass());
	
	@Autowired
	private BoardDao boardtDao;
	
	//게시글 리스트 출력
	@RequestMapping("/main/list.do")
	public ModelAndView listsetup(
			@RequestParam(value="pageNum",defaultValue="1") int currentPage,
			@RequestParam(value="keyField",defaultValue="") String keyField,
			@RequestParam(value="keyWord",defaultValue="") String keyWord) {
		
		if(log.isDebugEnabled()) { //로그 객체가 디버깅모드상태라면?, 출력할 준비가 되어있다면
			System.out.println("출력준비 완료!");
			log.debug("currentPage:"+currentPage); //log.debug("출력할 값")
			log.debug("keyField:"+keyField);
			log.debug("keyWord:"+keyWord); 
		}
		
		//검색분야,검색어를 전달 -> parameterType="map"
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("keyField", keyField);
		map.put("keyWord", keyWord);
		
		//총레코드 수 또는 검색되 총 레코드 수
		int count=boardtDao.getTotalCount(map);
		
		//페이징 처리 클래스 생성자
		//1.현재페이지 2.총레코드수 3.페이지당 게시물수 4.블럭당 페이지수 5.요청명령어 
		PagingUtil page=new PagingUtil(currentPage,count,5,3,"list.do");
		
		//start -> 페이지당 맨 첫번째 나오는 게시물 번호
		map.put("start", page.getStartCount());
		//<-> map.get("start") -> #{start}
		map.put("end", page.getEndCount());
		
		List<BoardCommand> list=null;
		if(count > 0) {
			list=boardtDao.list(map); //keyField, keyWord, Start, end값이 각각 분리됨
			//System.out.println("ListController의 list -> "+list);
		} else {
			list=Collections.emptyList(); //0적용
		}
		System.out.println("ListController의 count -> "+count);
		
		ModelAndView mav=new ModelAndView("mainpage"); //이동할 페이지명
		mav.addObject("count",count); //총 레코드 수 ${count(키명)}
		mav.addObject("list",list); //레코드 전체
		mav.addObject("pagingHtml",page.getPagingHtml()); //링크 문자열
		
		return mav; //${pagingHtml}(링크문자열 출력)
	}

}

