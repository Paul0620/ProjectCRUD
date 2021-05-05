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
}
