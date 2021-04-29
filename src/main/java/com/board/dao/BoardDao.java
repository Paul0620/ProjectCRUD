package com.board.dao;

import java.util.List;
import java.util.Map;

import com.board.command.BoardCommand;

public interface BoardDao {
		
		//글목록보기
		public List<BoardCommand> list(Map<String,Object> map);
		
		//총레코드 수(검색어에 맞는 레코드 수까지 포함)
		public int getTotalCount(Map<String,Object> map);
		
		//최대값 구하기
		public int getNewPostnum();
		
		//게시판에 글쓰기
		public void insertPost(BoardCommand post);
		
		//게시물에 대한 게시물(레코드)한개 찾기
		public BoardCommand selectPost(Integer postnum);
		
		//게시물번호에 해당하는 조회수 증가
		public void readcntUp(Integer postnum);
		
		//글 수정하기
		public void updatePost(BoardCommand post);
		
		//글 삭제하기
		public void deletePost(Integer postnum);
		
		//조회순, 추천순 정렬(필요여부 아직 모름 나중에 구현)
		public List<BoardCommand> listset(Map<String,Object> map);
}
