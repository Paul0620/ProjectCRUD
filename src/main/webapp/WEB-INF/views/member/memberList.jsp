<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원리스트</title>
</head>
<body>

	<br><br>
	<b><font size="6" color="gray">전체 회원정보</font></b>
	<br><br>
    
	<table>    
		<tr align="center">
			<td id=title>아이디</td>
			<td id=title>비밀번호</td>
			<td id=title>닉네임</td>
			<td id=title>이름</td>
			<td id=title>이메일</td>
			<td id=title>전화</td>
			<td id=title>성별</td>
			<td id=title>직업</td>
			<td id=title>주소</td>
			<td id=title>가입일</td>
		</tr>
	        
		<c:set var="memberList" value="${requestScope.memberList}"/>
		<c:forEach var="member" items="${memberList}">
			<tr>
				<td>${member.id}</td>
				<td>${member.pwd}</td>
				<td>${member.nickname}</td>
				<td>${member.name}</td>
				<td>${member.email}</td>
				<td>${member.phone}</td>
				<td>${member.gender}</td>
				<td>${member.job}</td>
				<td>${member.zipNo}&nbsp;${member.roadAddrPart1}&nbsp;${member.roadAddrPart2}&nbsp;${addrDetail}</td>
				<td>${member.reg_date}</td>
			</tr>
		</c:forEach>    
	</table>

</body>
</html>