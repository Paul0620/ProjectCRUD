package com.member.dao;

import java.util.List;
import java.util.Map;

import com.member.command.LoginCommand;
import com.member.command.MemberCommand;
//웹상에서 호출할 메서드를 1.선언->2.구현상속(SQL구문을 작성->메서드작성)->3.xml적용
//SqlMapMemberDAO클래스 상속->MemberMapper.xml와 연결
public interface MemberDao {
	
	//회원 목록보기(관리자용)
	public List<MemberCommand> getMemberList(Map<String,Object> map);
	
	//총레코드수 구하기->형식@Select("실행할 SQL구문")
	public int getMemberCount();
	
	//회원가입
	public void insertMember(MemberCommand member);
	
	//아이디중복체크
	public int idCheck(MemberCommand member);
	
	//닉네임중복체크
	public int nicknameCheck(MemberCommand member);
	
	//비밀번호 체크
	public int pwdCheck(MemberCommand member);
	
	//회원정보보기
	public MemberCommand selectMember(String id);
	
	//회원정보수정
	public void updateMember(MemberCommand member);
	
	//로그인정보수정
	public void updateLogin(LoginCommand login);
	
	//회원탈퇴
	public void deleteMember(String id);
	
	//로그인
	public MemberCommand loginMember(MemberCommand member);
	
}



