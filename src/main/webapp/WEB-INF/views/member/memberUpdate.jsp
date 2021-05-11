<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>회원가입</title>
	<!-- html 캐쉬방지 -->
	<meta http-equiv="Cache-Control" content="no-cache, no-store, must-revalidate">
	<meta http-equiv="Expires" content="0">
	<meta http-equiv="Pragma" content="no-cache">
	<!-- 부트스트랩 CSS 추가 -->
	<link rel="stylesheet" href="../css/bootstrap.min.css">
	<!-- join CSS 추가 -->
	<link rel="stylesheet" href="../css/join.css">
</head>

<body>
	<div id="wrap">
	<div class="container">
		<div class="col-sm-6 col-sm-offset-3 offset-sm-3">
			<div class="page-header">
				<h1 class="text-center" onClick="location.href='list.do'">YOEGIMOYEO</h1>
			</div>
			<form action="memberUpdate.do" method="post" name="updateInfo" role="form" id="update">
				<!-- 아이디, 비밀번호, 닉네임 -->
				<div id="block1">
					<div class="form-group has-feedback">
						<label for="id">아이디</label>
						<input type="text" class="form-control" id="id" name="id" value="${member.id}" readonly>
					</div>
					<div class="form-group has-feedback">
						<label for="pwd">비밀번호</label>
						<input type="password" class="form-control" id="pwd" name="pwd" value="${member.pwd}">
					</div>
					<div class="form-group has-feedback">
						<label for="repwd">비밀번호확인</label>
						<input type="password" class="form-control" id="repwd" name="repwd" value="${member.pwd}">
					</div>
					<div class="form-group has-feedback">
						<div id="check_btn1"><button type="button" class="btn btn-dark float-right" id="nicknameCheck" onClick="fn_nicknameCheck();">닉네임 중복확인</button></div>
						<label for="nickname">닉네임</label>
						<input type="text" class="form-control" id="nickname" name="nickname" value="${member.nickname}">
					</div>
				</div>
				
				<!-- 이름, 이메일, 전화번호, 성별, 직업 -->
				<div id="block2">
					<div class="form-group has-feedback">
						<label for="name">이름</label>
						<input type="text" class="form-control" id="name" name="name" value="${member.name}">
					</div>
					<div class="form-group has-feedback">
						<label for="email">이메일</label>
						<input type="text" class="form-control" id="email" name="email" value="${member.email}">
					</div>
					<div class="form-group has-feedback">
						<label for="phone">전화번호</label>
						<input type="text" class="form-control" id="phone" name="phone" value="${member.phone}">
					</div>
					<div class="form-group has-feedback">
						<label for="gender">성별</label>
						<label class="radio-inline">
							<input type="radio" class="gender" name="gender" id="male" value="남" checked>남
						</label>
						<label class="radio-inline">
							<input type="radio" class="gender" name="gender" id="female" value="여">여
						</label>
					</div>
					<div class="form-group has-feedback">
						<label for="job">직업</label>
						<select class="form-control" name="job" value="${member.job}">
							<option>학생</option>
							<option>회사원</option>
							<option>연구원</option>
							<option>기타</option>
						</select>
						<span class="glyphicon glyphicon-ok form-control-feedback"></span>
					</div>
				</div>
				
				<!-- 주소 -->
				<div id="block3">
					<div class="form-group has-feedback">
						<div id="search_btn"><input type="button" class="btn btn-dark float-right" onClick="goPopup();" value="주소검색"/></div>
						<div class="table" id="callBackDiv">
							<table>
								<tr>
									<label for="zipNo">우편번호</label>
									<input type="text" class="form-control" id="zipNo" name="zipNo" value="${member.zipNo}">
								</tr>
								<tr>
									<label for="roadAddrPart1">도로명주소</label>
									<input type="text" class="form-control" id="roadAddrPart1" name="roadAddrPart1" value="${member.roadAddrPart1}">
								</tr>
								<tr>
									<label for="roadAddrPart2">참고주소</label>
									<input type="text" class="form-control" id="roadAddrPart2" name="roadAddrPart2" value="${member.roadAddrPart2}" >
								</tr>
								<tr>
									<label for="addrDetail">상세주소</label>
									<input type="text" class="form-control" id="addrDetail" name="addrDetail" value="${member.addrDetail}">
								</tr>
							</table>
						</div>
					</div>
				</div>
				
				<!-- 가입버튼 -->
				<div class="block4" id="join_btn">
					<input type="submit" class="btn btn-dark col-sm-3" value="수정" id="check-btn">
					<input type="button" class="btn btn-dark col-sm-3" value="취소" id="check-btn" onClick="location.href='memberRead.do?id=${member.id}'">	
				</div>
			</form>
		</div>
	</div>
	</div>		
	
	<!-- 제이쿼리 자바스크립트 추가 -->
	<script type="text/javascript" src="../js/jquery-3.6.0.min.js"></script>
	<!-- 부트스트랩 자바스크립트 추가 -->
	<script type="text/javascript" src="../js/bootstrap.bundle.min.js"></script>
	<!-- 아이콘 자바스크립트 추가 -->
	<script src="https://kit.fontawesome.com/2d323a629b.js" crossorigin="anonymous"></script>
	<!-- register 자바스크립트 추가 -->
	<script type="text/javascript" src="../js/memberUpdate.js"></script>

</body>
</html>