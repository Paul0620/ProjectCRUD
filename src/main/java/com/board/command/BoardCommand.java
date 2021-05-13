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
		this.id = convert(id);
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
		this.nickname = convert(nickname);
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = convert(title);
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
	
	//모든 DTO에 static정적메서드를 작성 -> 적용( (, ), <, > 을 입력받지 못하게 코딩)
	//이 메서드는 현재 있는 클래스에서만 사용이 가능하도록 성정  -> private
	private static String convert(String name) {
		if(name!=null){
		//System.out.println("name->"+name);
		//입력받은 문자열중에서 자바스크립트 구문을 실행시킬 수 있는 특수기호를 입력x(<,>)
		// -> replaceAll(1.변경전 문자열, 2.변경후 문자열)
			name=name.replaceAll("<", "&lt"); //< 가 입력되면 바꿔준다
			name=name.replaceAll(">", "&gt"); //>가 입력되면 바꿔준다
			//추가 eval( 을 입력받지 못하게 해줘야함  " " or ' ')
			name=name.replaceAll("\\(","&#40"); //괄호 (가 입력되면 바꿔준다
			name=name.replaceAll("\\)","&#41"); //괄호 )가 입력되면 바꿔준다
			//"test" 'test'
			name=name.replaceAll("\"","&quot"); //큰따옴표 " 가 입력되면 바꿔준다
			name=name.replaceAll("\'","&apos"); //작은따옴표 ' 가 입력되면 바꿔준다
			//System.out.println("name->"+name);
		} else {
			return null; //입력을 하지 않았다면 더 이상 실행x
		}
		return name;
	}
}
