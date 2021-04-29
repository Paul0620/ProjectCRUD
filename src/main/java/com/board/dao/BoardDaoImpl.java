package com.board.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.board.command.BoardCommand;

@Repository
public class BoardDaoImpl extends SqlSessionDaoSupport implements BoardDao {

	//글목록보기, 검색분야에 따른 검색어까지 조회(페이징 처리)
	public List<BoardCommand> list(Map<String, Object> map) {
		// TODO Auto-generated method stub
		List<BoardCommand> list=getSqlSession().selectList("selectList",map);
		System.out.println("list()호출됨!!");
		return list;
	}

	//총레코드 수(검색어에 맞는 레코드 수까지 포함)
	public int getTotalCount(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return getSqlSession().selectOne("totalCount",map);
	}

	//최대값 구하기
	public int getNewPostnum() {
		// TODO Auto-generated method stub
		//Object -> Integer(래퍼클래스) -> int
		int newPostnum=(Integer)getSqlSession().selectOne("getNewPostnum");
		System.out.println("getNewPostnum()의 newPostnum -> "+newPostnum);
		return newPostnum;
	}
	
	//게시판에 글쓰기
	public void insertPost(BoardCommand board) {
		// TODO Auto-generated method stub
		getSqlSession().insert("insertPost",board); //(xml에서 작성한 id값, 매개변수)
	}
	
	//게시물에 대한 게시물(레코드)한개 찾기
	public BoardCommand selectPost(Integer postnum) {
		// TODO Auto-generated method stub
		//Object -> BoardCommand형으로 형변환 시켜서 가져와야함
		return (BoardCommand)getSqlSession().selectOne("selectPost",postnum);
	}
	
	//게시물번호에 해당하는 조회수 증가
	public void readcntUp(Integer postnum) {
		// TODO Auto-generated method stub
		getSqlSession().update("readcntUp",postnum);
	}
	
	//글수정하기
	public void updatePost(BoardCommand post) {
		// TODO Auto-generated method stub
		//id값을 불러올때 못찾으면 네임스페이스를 앞에 추가 -> Board.updateBoard 
		getSqlSession().update("updatePost",post);
	}
	
	//글삭제하기
	//1.sql구문확인(mapper파일) -> 2.메서드와 매개변수확인
	public void deletePost(Integer postnum) {
		// TODO Auto-generated method stub
		getSqlSession().delete("deletePost",postnum);
		System.out.println("게시물번호 넘기기 -> "+postnum);
	}
	
	//조회순, 추천순 정렬
	public List<BoardCommand> listset(Map<String, Object> map) {
		// TODO Auto-generated method stub
		List<BoardCommand> list=getSqlSession().selectList("listSet",map);
		return list;
	}
}
