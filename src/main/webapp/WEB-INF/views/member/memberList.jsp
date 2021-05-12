<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>회원리스트</title>
	<!-- html 캐쉬방지 -->
	<meta http-equiv="Cache-Control" content="no-cache, no-store, must-revalidate">
	<meta http-equiv="Expires" content="0">
	<meta http-equiv="Pragma" content="no-cache">
	<!-- 부트스트랩 CSS 추가 -->
	<link rel="stylesheet" href="../css/bootstrap.min.css">
	<!-- memberList CSS 추가 -->
	<link rel="stylesheet" href="../css/memberList.css">
</head>
<body>
	<div class="wrap">
	<div class="col-sm-10">
		<!-- 페이지 제목 -->
		<div class="page-header">
			<h1 class="text-center homepage" onClick="location.href='list.do'">YOEGIMOYEO</h1>
			<h3 class="text-center title">회원목록</h3>
			<input type="button" class="btn btn-dark float-right" value="메인페이지" onClick="location.href='list.do'">
		</div>
		
		<!-- 리스트 내용 -->
		<div class="table-responsive">
			<table class="table table-hover">
				<!-- 리스트 헤더부분 -->
				<thead class="text-center">
					<tr class="active">
						<th>아이디</th>
						<th>닉네임</th>
						<th>이름</th>
						<th>이메일</th>
						<th>전화</th>
						<th>성별</th>
						<th>직업</th>
						<th>주소</th>
						<th>가입일</th>
					</tr>
				</thead>
				
				<!-- 리스트 바디부분 -->
				<tbody class="text-center">
					<!-- 가입자가 없을시 -->
					<c:if test="${count==0}">
						<tr>
							<td colspan="7" align="center">등록된 게시물이 없습니다.</td>
						</tr>
					</c:if>   
					<c:forEach var="member" items="${list}" begin="1">
						<tr>
							<td><a class="text-dark" href="memberRead.do?id=${member.id}">${member.id}</a></td>
							<td>${member.nickname}</td>
							<td>${member.name}</td>
							<td>${member.email}</td>
							<td>${member.phone}</td>
							<td>${member.gender}</td>
							<td>${member.job}</td>
							<td>${member.zipNo}&nbsp;${member.roadAddrPart1}&nbsp;${member.roadAddrPart2}&nbsp;${addrDetail}</td>
							<td>${member.regdate}</td>
						</tr>
					</c:forEach>    
				</tbody>
			</table>
		</div>
		</div>
		
		<!-- 페이지처리 -->
		<ul class="pagination justify-content-center">
			${pagingHtml}
		</ul>
	</div>
</body>
</html>