<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
<title>작성화면</title>
</head>
<body>
<div class="container">
	<!-- 게시판 이름 -->
	<div class="card">
		<div class="card-header bg-dark text-white">
			<h2 id="head_board">자유게시판</h2>
		</div>
		<div class="card-body" id="head_board2">
				<div class="row float-right">
					<input class="btn" id="list_btn" type="button" value="목록보기" onclick="location.href='list.do'">
				</div>
			</div>
	</div>
	
	<!-- enctype -> 파일 첨부를 하기위해서 필요, method="post"
       spring:message 액션태그->code="불러올 키값" (특정한 값을 출력) 액션태그
       <form:errors path="커맨드객체명" />  -> 폼안에서 입력받을 때 에러처리를 지정
       -> path="적용필드명(DTO중 입력받은 필드명)" 에러메세지를 출력하기위해서 설정
       <spring:hasBindErrors name="커맨드객체명" /> -> 에러발생시 처리해주기 위해서  
      
       각 name은 필드명을 지칭함
	-->
	
	<!-- 게시글 작성칸 -->
	<form method="post" action="write.do" enctype="multipart/form-data">
		<input type="hidden" id="boardnum" name="boardnum" value="6">
		<div class="table table-striped">
			<tbody>
				<!-- 게시글 작성화면 -->
				<tr>
					<td>
						<label for="subject">제목</label>
						<input type="text" class="form-control" id="title" name="title" placeholder="제목을 입력해 주세요."  autofocus />
					</td>
					<td>
						<div class="form-group has-feedback">
							<label for="type">분류</label>
							<select class="form-control" id="type" name="type">
								<option >일반</option>
								<option >질문</option>
								<option >정보</option>
								<option >추천</option>
								<option >공지</option>
							</select>
							<span class="glyphicon glyphicon-ok form-control-feedback"></span>
						</div>
					</td>
					<td>
						<label for="content">내용</label>
						<textarea class="form-control" id="summernote" name="content">
							
						</textarea>
					</td>
				</tr><br>
			</tbody>
			<div class="col-sm-4 col-sm-offset-3 offset-sm-4" id="submit_write">
				<input class="btn btn-dark " type="reset"  id="reset" value="초기화" />
				<input class="btn btn-dark" type="submit" id="write" value="작성" onClick="location.href='list.do'"/>
			</div>
		</div>
		<!-- 로그인 계정정보 넘기기 -->
		<input type="hidden" id="id" name="id" value="${sessionScope.resultLogin.id}">
		<input type="hidden" id="nickname" name="nickname" value="${sessionScope.resultLogin.nickname}">
	</form>
	
</div>
</body>
</html>