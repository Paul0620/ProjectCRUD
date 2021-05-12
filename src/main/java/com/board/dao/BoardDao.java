package com.board.dao;

import java.util.List;
import java.util.Map;

import com.board.command.BoardCommand;
import com.board.command.CommentCommand;

public interface BoardDao {
		
		//글목록보기
		public List<BoardCommand> list(Map<String,Object> map);
		
		//총레코드 수(검색어에 맞는 레코드 수까지 포함)
		public int getTotalCount(Map<String,Object> map);
		
		//최대값 구하기
		public int getNewPostnum();
		
		//조회순, 추천순 정렬(미구현)
		public List<BoardCommand> listset(Map<String,Object> map);
		
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
		
		//댓글=========================================================
		
		//댓글읽기
		public List<CommentCommand> listComment(int postnum);
		
		//댓글작성
		public void insertComment(CommentCommand comment);

		//댓글수정(미구현)
		public void updateComment(CommentCommand comment);
		
		//댓글삭제(미구현)
		public void deleteComment(Integer commentnum);
		
		//댓글조회(삭제,수정,좋아요)(미구현)
		public CommentCommand selectComment(int commentnum);
		
}
