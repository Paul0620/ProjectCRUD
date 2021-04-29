<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<html>
<head>
<title>게시글화면</title>
</head>
<body>
<div class="container">
	<!-- 게시판 이름 -->
	<div class="card">
		<div class="card-header bg-dark text-white"><h2>자유게시판</h2></div>
	</div>
	<div class="card">	
		<form method="post" action="delete.do">
			<input type="hidden" id="id" name="id" value="${command.id}">
			<input class="btn btn-dark" type="submit" value="삭제" onClick="del(${command.postnum})">
			<input class="btn btn-dark" type="button" value="목록" onClick="history.back()">
		</form>
	</div>
</div>
</body>
</html>
