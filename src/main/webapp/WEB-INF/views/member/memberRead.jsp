<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>회원정보보기</title>
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
			<form action="memberModifyAction" method="post" name="userInfo" role="form" id="modify">
				<!-- 아이디, 비밀번호, 닉네임 -->
				<div id="block1">
					<div class="form-group has-feedback">
						<label for="id">아이디</label>
						<input type="text" class="form-control" name="id" value="${member.id}" readonly>
					</div>
					<div class="form-group has-feedback">
						<label for="nickname">닉네임</label>
						<input type="text" class="form-control" name="nickname" value="${member.nickname}" readonly>
					</div>
				</div>
				
				<!-- 이름, 이메일, 전화번호, 성별, 직업 -->
				<div id="block2">
					<div class="form-group has-feedback">
						<label for="name">이름</label>
						<input type="text" class="form-control" name="name" value="${member.name}" readonly>
					</div>
					<div class="form-group has-feedback">
						<label for="email">이메일</label>
						<input type="text" class="form-control" name="email" value="${member.email}" readonly>
					</div>
					<div class="form-group has-feedback">
						<label for="phone">전화번호</label>
						<input type="text" class="form-control" name="phone" value="${member.phone}" readonly>
					</div>
					<div class="form-group has-feedback">
						<label for="gender">성별</label>
						<input type="text" class="form-control" name="gender" value="${member.gender}" readonly>
					</div>
					<div class="form-group has-feedback">
						<label for="job">직업</label>
						<input class="form-control" name="job" value="${member.job}" readonly>
					</div>
				</div>
				
				<!-- 주소 -->
				<div id="block3">
					<div class="form-group has-feedback">
						<table>
							<tr>
								<label for="zipNo">우편번호</label>
								<input type="text" class="form-control" id="zipNo" name="zipNo" value="${member.zipNo}" readonly>
							</tr>
							<tr>
								<label for="roadAddrPart1">도로명주소</label>
								<input type="text" class="form-control" id="roadAddrPart1" name="roadAddrPart1" value="${member.roadAddrPart1}" readonly>
							</tr>
							<tr>
								<label for="roadAddrPart2">참고주소</label>
								<input type="text" class="form-control" id="roadAddrPart2" name="roadAddrPart2" value="${member.roadAddrPart2}" readonly>
							</tr>
							<tr>
								<label for="addrDetail">상세주소</label>
								<input type="text" class="form-control" id="addrDetail" name="addrDetail" value="${member.addrDetail}" readonly>
							</tr>
						</table>
					</div>
				</div>
				
				<!-- 회원관리버튼 -->
				<div class="block4" id="join_btn">
					<c:if test="${sessionScope.resultLogin.id != 'admin'}">
						<input type="button" class="btn btn-dark col-sm-3" value="회원수정" id="check-btn" onClick="location.href='memberUpdate.do?id=${member.id}'">
						<input type="button" class="btn btn-dark col-sm-3" value="회원탈퇴" id="delete-btn" onClick="location.href='memberDelete.do?id=${member.id}'">
						<input type="button" class="btn btn-dark col-sm-3" value="취소" id="cancel-btn" onClick="location.href='list.do'">
					</c:if>
					<!-- 관리자가 접속시 보는 버튼 -->	
					<c:if test="${sessionScope.resultLogin.id == 'admin'}">
						<input type="button" class="btn btn-dark col-sm-3" value="회원목록" id="memberList-btn" onClick="location.href='memberList.do'">
						<input type="button" class="btn btn-dark col-sm-3" value="메인페이지" id="cancel-btn" onClick="location.href='list.do'">
					</c:if>
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
</body>
</html>