package com.member.command;

public class LoginCommand {
	
	private String id,pwd,nickname; //아이디, 비밀번호, 닉네임

	public String getId() {
		//System.out.println("id 호출"+id);
		return id;
	}

	public void setId(String id) {
		this.id = id;
		//System.out.println("id 호출");
	}

	public String getPwd() {
		System.out.println("pwd 호출"+pwd);
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
		//System.out.println("pwd 호출");
	}

	public String getNickname() {
		//System.out.println("nickname 호출"+nickname);
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
		//System.out.println("nickname 호출");
	}	
	
}
