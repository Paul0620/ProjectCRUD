package com.member.command;

import java.sql.Date;

public class MemberCommand {

	private String id, pwd, rePwd, nickname, name, email, gender, phone, job; //개인정보
	private String zipNo,roadAddrPart1,roadAddrPart2,addrDetail; //주소
	private Date regdate; //가입날짜

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = convert(id);
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = convert(pwd);
	}

	public String getRePwd() {
		return rePwd;
	}

	public void setRePwd(String rePwd) {
		this.rePwd = convert(rePwd);
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = convert(nickname);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = convert(name);
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = convert(email);
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = convert(phone);
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public String getZipNo() {
		return zipNo;
	}

	public void setZipNo(String zipNo) {
		this.zipNo = convert(zipNo);
	}

	public String getRoadAddrPart1() {
		return roadAddrPart1;
	}

	public void setRoadAddrPart1(String roadAddrPart1) {
		this.roadAddrPart1 = convert(roadAddrPart1);
	}

	public String getRoadAddrPart2() {
		return roadAddrPart2;
	}

	public void setRoadAddrPart2(String roadAddrPart2) {
		this.roadAddrPart2 = convert(roadAddrPart2);
	}

	public String getAddrDetail() {
		return addrDetail;
	}

	public void setAddrDetail(String addrDetail) {
		this.addrDetail = convert(addrDetail);
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
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
