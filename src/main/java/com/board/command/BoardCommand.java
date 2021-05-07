package com.board.command;

import java.sql.Date;

public class BoardCommand {
	//게시판 분류
	private int boardnum; //게시판코드
	private String boardname; //게시판명
	//게시글
	private int postnum;
	private String id; //아이디
	private String type; //게시판 분류
	private String nickname, title, content; //작성자, 제목, 내용
	private Date regdate; //작성일자
	private int readcnt, recommand, best; //조회수, 추천수, 베스트게시글
	
	public int getBoardnum() {
		return boardnum;
	}
	public void setBoardnum(int boardnum) {
		this.boardnum = boardnum;
	}
	public String getBoardname() {
		return boardname;
	}
	public void setBoardname(String boardname) {
		this.boardname = boardname;
	}
	public int getPostnum() {
		return postnum;
	}
	public void setPostnum(int postnum) {
		this.postnum = postnum;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	public int getReadcnt() {
		return readcnt;
	}
	public void setReadcnt(int readcnt) {
		this.readcnt = readcnt;
	}
	public int getRecommand() {
		return recommand;
	}
	public void setRecommand(int recommand) {
		this.recommand = recommand;
	}
	public int getBest() {
		return best;
	}
	public void setBest(int best) {
		this.best = best;
	}

	//toString()
	@Override
	public String toString() {
		return "BoardCommand [postnum="+postnum+",id="+id+",boardnum="+boardnum+",type="+type+",nickname="+nickname+",title="
				+title+",content="+content+",regdate="+regdate+",readcnt="+readcnt+",recommand="+recommand+",best="+best+"]";
	}
	
}
