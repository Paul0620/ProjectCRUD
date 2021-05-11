package com.member.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.member.command.LoginCommand;
import com.member.command.MemberCommand;

@Repository
public class MemberDaoImpl extends SqlSessionDaoSupport implements MemberDao {

	//회원 목록보기(페이징 처리)
	public List<MemberCommand> getMemberList(Map<String, Object> map) {
		// TODO Auto-generated method stub
		List<MemberCommand> list=getSqlSession().selectList("getMemberList",map);
		return list;
	}

	//총레코드수 구하기->형식@Select("실행할 SQL구문")
	public int getMemberCount() {
		// TODO Auto-generated method stub
		return getSqlSession().selectOne("getMemberCount");
	}

	//회원가입
	public void insertMember(MemberCommand member) {
		// TODO Auto-generated method stub
		getSqlSession().insert("insertMember",member);
	}
	
	//아이디중복체크
	public int idCheck(MemberCommand member) {
		int resultId=getSqlSession().selectOne("idCheck", member);
		return resultId;
	}
		
	//닉네임중복체크
	public int nicknameCheck(MemberCommand member) {
		int resultNick=getSqlSession().selectOne("nicknameCheck", member);
		return resultNick;
	}
		
	//비밀번호 체크
	public int pwdCheck(MemberCommand member) {
		int resultPwd=getSqlSession().selectOne("pwdCheck", member);
		return resultPwd;
	}
	
	//회원정보보기
	public MemberCommand selectMember(String id) {
		// TODO Auto-generated method stub
		MemberCommand member=getSqlSession().selectOne("selectMember",id);
		return member;
	}

	//회원정보수정
	public void updateMember(MemberCommand member) {
		// TODO Auto-generated method stub
		getSqlSession().update("updateMember",member);
	}

	//로그인정보수정
	public void updateLogin(LoginCommand login) {
		// TODO Auto-generated method stub
		getSqlSession().update("updateLogin",login);
	}
	
	//회원탈퇴
	public void deleteMember(String id) {
		// TODO Auto-generated method stub
		getSqlSession().delete("deleteMember",id);
	}
	
	//로그인
	public MemberCommand loginMember(MemberCommand member) {
		// TODO Auto-generated method stub
		return getSqlSession().selectOne("loginMember", member);
	}

}
