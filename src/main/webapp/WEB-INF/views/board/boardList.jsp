<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<title>게시판목록</title>
</head>
<body>
<div class="container">
	<div class="col-sm" id="board_list">
		<!-- 게시판 이름 및 게시판 정렬 링크 -->
		<div class="card">
			<div class="card-header bg-dark text-white" ><h2 id="head_board">자유게시판</h2></div>
			<div class="card-body" id="head_board2">
				<div class="row justify-content-between">
					<select class="form-control" name="" id="align_board">
						<option value="postnum">최신순</option>
						<option value="recommand">추천순</option>
						<option value="readcnt">조회순</option>
					</select>
					<c:if test="${sessionScope.resultLogin != null}">
						<input class="btn" id="write_btn" type="button" value="글쓰기" onClick="location.href='write.do'">
					</c:if>
				</div>
			</div>
		</div>
		
		<!-- 게시판 -->
		<div class="table-responsive">
			<table class="table table-hover">
				<!-- 게시판 목차헤더부분 -->
				<thead class="text-center">
					<tr class="active">
						<th style="width: 8%">번  호</th>
						<th style="width: 8%">분  류</th>
						<th style="width: 36%">제  목</th>
						<th style="width: 14%">작성자</th>
						<th style="width: 14%">날  짜</th>
						<th style="width: 10%">추천수</th>
						<th style="width: 10%">조회수</th>
					</tr>
				</thead>
				
				<!-- 작성게시물 목록 출력부분 -->
				<tbody class="text-center">
				<c:if test="${count==0}">
					<tr>
						<td colspan="7" align="center">등록된 게시물이 없습니다.</td>
					</tr>
				</c:if>
				<c:forEach var="article" items="${list}">
					<tr>
						<td>${article.postnum}</td>
						<td>${article.type}</td>
						<td><a class="text-dark" id="board_title" href="read.do?postnum=${article.postnum}">${article.title}</a></td>
						<td>${article.nickname}</td>
						<td>${article.regdate}</td>
						<td>${article.recommand}</td>
						<td>${article.readcnt}</td>
						<input type="hidden"  id="id" value="${article.id}">
						<input type="hidden" id="boardnum" value="${article.boardnum}">
						<input type="hidden" id="best" value="${article.best}">
					</tr>
				</c:forEach>
				</tbody>	
			</table>
		</div>
		
		<!-- 페이지 -->
		<ul class="pagination justify-content-center">
			${pagingHtml}
		</ul>
		
		<!-- 검색 -->
		<form class="col-sm-6 col-sm-offset-3 offset-sm-3" name="search" action="list.do" method="get" onsubmit="return searchCheck()">
			<div class="input-group">
				<select class="form-control col-3 offset-sm-1" name="keyField" id="search_board">
					<option value="title">제목</option>
					<option value="nickname">작성자</option>
					<option value="content">내용</option>
					<option value="all">전체</option>
				</select>
				<input class="form-control col-5" type="text" size="15" name="keyWord" id="search_text">
				<input class="btn form-control col-2"  type="submit"  id="search_btn" value="검색">
			</div>
		</form>
	</div>
</div>
</body>
</html>