package com.board.command;

import java.sql.Date;

public class CommentCommand {

	private int commentnum; //댓글 번호
	private int postnum; //해당 게시글 번호
	private String id, nickname, content; //댓글 작성자 아이디, 닉네임, 내용
	private Date regdate; //댓글 작성 날짜
	private int good, best; //작성 댓글의 좋아요, 베스트댓글 유무
	
	public int getCommentnum() {
		return commentnum;
	}
	public void setCommentnum(int commentnum) {
		this.commentnum = commentnum;
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
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
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
	public int getGood() {
		return good;
	}
	public void setGood(int good) {
		this.good = good;
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
		return "CommentCommand [commentnum="+commentnum+",postnum="+postnum+",id="+id+",nickname="+nickname+",content="+content
				+",regdate="+regdate+",good="+good+",best="+best+"]";
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
