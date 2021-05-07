<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
	<!-- 게시글 작성칸 -->
	<form method="post" action="write.do" enctype="multipart/form-data">
		<!-- 게시판,게시글 정보 -->
		<input type="hidden" id="boardnum" name="boardnum" value="6">
		<!-- 로그인 계정 정보 넘기기 -->
		<input type="hidden" id="id" name="id" value="${sessionScope.resultLogin.id}">
		<input type="hidden" id="nickname" name="nickname" value="${sessionScope.resultLogin.nickname}">
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
								<c:if test="${sessionScope.resultLogin.id == 'admin'}">
									<option >공지</option>
								</c:if>
							</select>
							<span class="glyphicon glyphicon-ok form-control-feedback"></span>
						</div>
					</td>
					<td>
						<label for="content">내용</label>
						<textarea class="form-control" id="summernote" name="content">
							
						</textarea>
					</td>
					<!-- 파일 업로드 -->
					<td>
						<div class="input-file">
							<input type="text" readonly="readonly" class="file-name" />
							<label for="upload" class="file-label">파일 업로드</label>
							<input type="file" multiple="multiple" name="" id="upload" class="file-upload" />
						</div>
					</td>
				</tr>
			</tbody>
			<div class="col-sm-4 col-sm-offset-3 offset-sm-4" id="submit_write">
				<input class="btn btn-dark " type="reset"  id="reset" value="초기화" />
				<input class="btn btn-dark" type="submit" id="write" value="작성" onClick="location.href='list.do'"/>
			</div>
		</div>
	</form>
	
</div>
</body>
</html>