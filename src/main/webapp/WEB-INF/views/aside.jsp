<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
	<title>사이드 메뉴바</title>
</head>
<body>
	<!-- 오른쪽 메뉴바 -->
	<!-- 로그인 안했을 때 -->
	<c:if test="${sessionScope.resultLogin == null}">
	<!-- 로그인버튼 -->
		<div class="card my login-form">
			<input type="button" class="btn" id="login_btn"value="로 그 인" onclick="location.href='login.do'" >
		</div>
		<!-- 회원가입버튼 -->
		<div class="card my">
			<input type="button" class="btn" id="join_btn" value="회원가입" onclick="location.href='join.do'" >
		</div>
	</c:if>
	
	<!-- 로그인 했을 때 -->
	<c:if test="${sessionScope.resultLogin != null}">
		<!-- 프로필 사진 -->
		<div class="text-center" id="profile">
			<img src="http://ssl.gstatic.com/accounts/ui/avatar_2x.png" class="avatar img-circle img-thumbnail" id="main_avatar" alt="avatar">
			<h5 id="login_nickname">${sessionScope.resultLogin.nickname}님</h5>		
		</div>
		<!-- 로그아웃버튼 -->
		<div class="card my">
			<input type="button" class="btn" id="logout_btn" value="로그아웃" onclick="location.href='logout.do'" />
		</div>
		<!-- 메세지, 메일, 계정관리(미구현) -->
		<div class="input-group bg-light"  id="btns">
			<button type="button" class="btn col-sm-4" id="message"><i class="fas fa-comments"></i></button>
			<button type="button" class="btn col-sm-4" id="mail"><i class="fas fa-envelope"></i></button>
			<button type="button" class="btn col-sm-4" id="admin" onClick="location.href='memberRead.do?id=${sessionScope.resultLogin.id}'"><i class="fas fa-user-cog"></i></button>
		</div>
		<!-- 활동기록(미구현) -->
		<ul class="list-group" id="my_active">
	           <li class="list-group-item text-muted">나의 활동 <i class="fa fa-dashboard fa-1x"></i></li>
	           <li class="list-group-item text-right"><span class="pull-left"><strong>공유</strong></span> 125</li>
	           <li class="list-group-item text-right"><span class="pull-left"><strong>추천</strong></span> 13</li>
	           <li class="list-group-item text-right"><span class="pull-left"><strong>게시글</strong></span> 37</li>
	           <li class="list-group-item text-right"><span class="pull-left"><strong>댓글</strong></span> 78</li>
        </ul>
		<!-- 관리자가 로그인했을때만 보이는 회원리스트 버튼 -->
		<c:if test="${sessionScope.resultLogin.id == 'admin'}">
			<div class="card my">
				<input type="button" class="btn"  id="memberView_btn" value="회원리스트" onclick="location.href='memberList.do'">
			</div>
		</c:if>
	</c:if>	
	
	<!-- 검색바 -->
	<div class="card-body" id="serch_input_btn">
		<form method="post" action="">
			<div class="input-group">
				<input type="text" class="form-control bg-light" placeholder="검색어입력">
				<span class="input-group-append">
					<button class="btn bg-dark" type="button" id="search"><i class="fas fa-search text-light"></i></button>
				</span>
			</div>
		</form>
	</div>
					
</body>
</html>