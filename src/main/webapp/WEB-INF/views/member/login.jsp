<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<!-- html 캐쉬방지 -->
	<meta http-equiv="Cache-Control" content="no-cache, no-store, must-revalidate">
	<meta http-equiv="Expires" content="0">
	<meta http-equiv="Pragma" content="no-cache">
	<title>로그인 화면</title>
	<!-- 데스크탑, 모바일로 봤을때 디자인 처리를 위한 meta tag -->
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<!-- 부트스트랩 CSS 추가 -->
	<link rel="stylesheet" href="../css/bootstrap.min.css">
	<!-- 로그인 CSS 추가 -->
	<link rel="stylesheet" href="../css/login.css">
</head>
<body>
	<div class="container">
	<div class="d-flex justify-content-center h-100">
		<div class="card">
			<div class="card-header bg-dark">
				<h1 onClick="location.href='list.do'">YOEGIMOYEO</h1>
			</div>
			<div class="card-body">
				<form name="loginCheck" method="post" action="login.do">
					<!-- 로그인입력바 -->
					<div class="input-group form-group">
						<div class="input-group-prepend">
							<span class="input-group-text"><i class="fas fa-user"></i></span>
						</div>
						<input type="text" id="id" name="id" class="form-control" placeholder="아이디" autofocus>
					</div>
					
					<!-- 비밀번호입력바 -->
					<div class="input-group form-group">
						<div class="input-group-prepend">
							<span class="input-group-text"><i class="fas fa-key"></i></span>
						</div>
						<input type="password" id="pwd" name="pwd" class="form-control" placeholder="비밀번호" >
					</div>
					<c:if test="${message == false}">
						<p class="text-danger text-right">아이디 또는 비밀번호를 다시 입력해주십시오.</p>
					</c:if>
					
					<!-- 로그인버튼 -->
					<div class="form-group">
						<input type="submit" class="btn float-right login_btn" id="loginCheck" value="로그인">
					</div>
				</form>
			</div>
			<div class="card-footer bg-dark">
				<div class="d-flex justify-content-center">
					<input type="button" class="btn btn-dark" id="goJoin" value="회원가입" onclick="location.href='join.do'" />
					<input type="button"  class="btn btn-dark" id="goFindPwd" value="비밀번호찾기" onclick="" />
				</div>
			</div>
		</div>
	</div>
	</div>

	<!-- 제이쿼리 자바스크립트 추가 -->
	<script type="text/javascript" src="../js/jquery-3.6.0.min.js"></script>
	<!-- 부트스트랩 자바스크립트 추가 -->
	<script type="text/javascript" src="../js/bootstrap.bundle.min.js"></script>
	<!-- 아이콘 자바스크립트 추가 -->
	<script src="https://kit.fontawesome.com/2d323a629b.js" crossorigin="anonymous"></script>
	<!-- 로그인 자바스크립트 추가 -->
	<script type="text/javascript" src="../js/login.js"></script>
</body>
</html>