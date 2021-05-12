<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
<title>게시글 수정화면</title>
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
	<form method="post" action="update.do" enctype="multipart/form-data">
		<!-- 게시판 번호 설정 미구현 -->
		<input type="hidden" id="boardnum" name="boardnum" value="6">
		<div class="table table-striped">
			<tbody>
				<!-- 게시물 번호 가져오기 -->
				<input type="hidden" id="postnum" name="postnum" value="${command.postnum}">
				<!-- 게시글 작성화면 -->
				<tr>
					<td>
						<label for="subject">제목</label>
						<input type="text" class="form-control" id="title" name="title" value="${command.title}"  autofocus />
					</td>
					<td>
						<div class="form-group has-feedback">
							<label for="type">분류</label>
							<select class="form-control" id="type" name="type" value="${command.type}">
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
							${command.content}
						</textarea>
					</td>
				</tr><br>
			</tbody>
			
			<!-- 게시글 수정, 초기화 버튼 -->
			<div class="col-sm-4 col-sm-offset-3 offset-sm-4" id="submit_write">
				<input class="btn btn-dark " type="reset"  id="reset" value="초기화" onClick="reset()" />
				<input class="btn btn-dark" type="submit" id="write" value="수정" onClick="location.href='list.do'" />
			</div>
		</div>
	</form>
</div>
</body>
</html>