package com.member.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.member.command.LoginCommand;
import com.member.command.MemberCommand;

@Repository //DB(Mybatis)의 중간역할자, DAO역할을 하는 클래스임을 알려주는 어노테이션
public class MemberDaoImpl extends SqlSessionDaoSupport implements MemberDao {

	//회원가입
	public void insertMember(MemberCommand member) {
		//입력한 정보를 추가
		getSqlSession().insert("insertMember",member);
	}
	
	//아이디중복체크
	public int idCheck(MemberCommand member) {
		//id값을 체크하여 리턴
		int resultId=getSqlSession().selectOne("idCheck", member);
		return resultId;
	}
		
	//닉네임중복체크
	public int nicknameCheck(MemberCommand member) {
		//nickname값을 체크하여 리턴
		int resultNick=getSqlSession().selectOne("nicknameCheck", member);
		return resultNick;
	}
		
	//비밀번호 체크
	public int pwdCheck(MemberCommand member) {
		//비밀번호값을 체크하여 리턴
		int resultPwd=getSqlSession().selectOne("pwdCheck", member);
		return resultPwd;
	}
	
	//회원 목록보기(페이징 처리)
	public List<MemberCommand> getMemberList(Map<String, Object> map) {
		//목록처리를 위한 List<> 형식, 리스트형식이라 sql도 selectList()로 리턴
		List<MemberCommand> list=getSqlSession().selectList("getMemberList",map);
		return list;
	}

	//총레코드수 구하기
	public int getMemberCount() {
		return getSqlSession().selectOne("getMemberCount");
	}
	
	//회원정보보기
	public MemberCommand selectMember(String id) {
		//pk값인 id값을 통해 해당 id값의 전체정보를 리턴
		MemberCommand member=getSqlSession().selectOne("selectMember",id);
		return member;
	}

	//회원정보수정
	public void updateMember(MemberCommand member) {
		//입력되어있는 값을 수정 후 추가
		getSqlSession().update("updateMember",member);
	}

	//로그인정보수정
	public void updateLogin(LoginCommand login) {
		//입력되어있는 값을 수정 후 추가
		getSqlSession().update("updateLogin",login);
	}
	
	//회원탈퇴
	public void deleteMember(String id) {
		//해당하는 id값의 전체정보를 삭제
		getSqlSession().delete("deleteMember",id);
	}
	
	//로그인
	public MemberCommand loginMember(MemberCommand member) {
		//해당하는 id값의 정보를 선택
		return getSqlSession().selectOne("loginMember", member);
	}

}
