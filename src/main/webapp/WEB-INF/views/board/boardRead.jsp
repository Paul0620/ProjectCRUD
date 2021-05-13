<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>게시글 읽기화면</title>
</head>
<body>
<div class="container">
	<!-- 게시판 이름 -->
	<div class="card">
		<div class="card-header bg-dark text-white"><h2>자유게시판</h2></div>
	</div>
	
	<!-- 작성 후 게시글 화면 -->
	<div class="table" id="read_table">
		<div class="row">
			<!-- 프로필 사진(미구현) -->
			<div class="col-sm-2" id="read_profile">
				<tr>
					<td><img src="http://ssl.gstatic.com/accounts/ui/avatar_2x.png" class="img-thumbnail" alt="avatar" id="read_profile_img"></td>
				</tr>
			</div>
			<!-- 작성자 정보, 게시글 정보 -->
			<div class="col-sm-10" id="read2_profile">
				<!-- 게시물 정보 가져오기 -->
				<input type="hidden" id="postnum" name="postnum" value="${board.postnum}">
				<input type="hidden" id="postnum" name="postnum" value="${board.id}">
				<!-- 게시물 제목 -->
				<table class="col-sm-12">
					<thead class="text-center">
						<tr>
							<th id="read_title">${board.title}</th>
						</tr>
					</thead>
				</table>
				<!-- 게시물 닉네임, 조회수, 추천수, 파일첨부 내용, 작성날짜 -->
				<table class="col-sm-12">
					<tbody>
						<tr>
							<td>
								닉네임 : <a class="dropdown-toggle" href="#" data-toggle="dropdown" id="message2">${board.nickname}</a>
								<ul class="dropdown-menu" role="menu">
									<li role="presentation"><a class="dropdown-item" role="menuitem" onclick="">쪽지보내기</a></li>
								</ul>
							</td>
							<td>날짜 : ${board.regdate}</td>
							<td></td><!-- 간격 맞추려고 공란으로 둔거 -->
						</tr>
						<tr>
							<td>조회수 : ${board.readcnt}</td>
							<td>좋아요 : ${board.recommand}</td>
							<td id="read_setbtn">
								<input type="button" class="btn btn-dark float-right" id="read_back" value="목록" onClick="location=href='list.do'">
								<c:if test="${sessionScope.resultLogin.id == board.id || sessionScope.resultLogin.id == 'admin'}">
									<input type="button" class="btn btn-dark float-right" id="read_delete" value="삭제" onClick="del(${board.postnum})">
									<c:if test="${sessionScope.resultLogin.id == board.id}">
										<input type="button" class="btn btn-dark float-right" id="read_update" value="수정" onClick="location.href='update.do?postnum=${board.postnum}'">
									</c:if>
								</c:if>
							</td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
		<!-- 내용부분 -->
		<div class="card" id="read_content">
			${board.content}
		</div>
		
		<!-- 파일다운로드를 위한 폼(미구현) 
		<div class="custom-file">
			<form class="form-control" id="fileDown" method="post">
			</form>
		</div> -->
	</div>
	
	<!-- 댓글(수정, 삭제 미구현) -->
	<div class="col-sm-12" id="commentListForm"><br>
		<!-- 댓글작성폼-->
		<c:if test="${sessionScope.resultLogin.id != null}">
			<div>
				<form id="commentForm" name="commentForm" method="post">
				<!-- 로그인 계정 정보 넘기기 -->
				<input type="hidden" id="id" name="id" value="${sessionScope.resultLogin.id}">
				<input type="hidden" id="nickname" name="nickname" value="${sessionScope.resultLogin.nickname}">
			        <div>
			            <div>
			                <span><strong>Comments</strong></span> <span id="commentCnt"></span>
			            </div>
			            <div>
			                <table class="table">                    
			                    <tr>
			                        <td id="commentTextForm">
			                            <textarea class="form-control" rows="3" cols="30" id="content" name="content" placeholder="댓글을 입력하세요"></textarea>
			                            <div>
			                                <input type="button" class="btn btn-dark float-right" id="commentSubmit" value="등록" onClick="fn_comment(${board.postnum})">
			                            </div>
			                        </td>
			                    </tr>
			                </table>
			            </div>
			        </div>
			        <input type="hidden" id="postnum" name="postnum" value="${board.postnum}" /> 
			    </form>
		    </div>
	    </c:if>
	    
	    <!-- 댓글리스트폼 -->
	    <div id="commentForm">
			<ol class="commentList" id="commentList">
				<c:forEach items="${commentList}" var="commentList">
					<!-- 댓글리스트 -->
					<li class="collapse multi-collapse-${commentList.id}-${commentList.commentnum} show">
						<img src="http://ssl.gstatic.com/accounts/ui/avatar_2x.png" class="commentProfile" alt="avata">
						<a class="dropdown-toggle" href="#" data-toggle="dropdown" id="message2"><b>${commentList.nickname}</b></a>&nbsp;&nbsp;
						<ul class="dropdown-menu" role="menu">
							<li role="presentation"><a class="dropdown-item" role="menuitem">쪽지보내기</a></li>
						</ul>		
						작성일 : ${commentList.regdate}&nbsp;&nbsp;
						<!-- 로그인한 유저가 아니라면 좋아요 버튼을 누를 수 없게 -->
						<c:if test="${sessionScope.resultLogin.id != null}">
							<button class="far fa-thumbs-up commentLike" id="commentLike"></button>
						</c:if>
						<!-- 수정, 삭제버튼을 관리자 또는 작성자만 볼 수 있게 -->
						<c:if test="${sessionScope.resultLogin.id == commentList.id || sessionScope.resultLogin.id == 'admin'}">
							<c:if test="${sessionScope.resultLogin.id!='admin' }">
								<button class="fas fa-edit commentUpdate" id="commentUpdate" data-toggle="collapse" data-target=".multi-collapse-${commentList.id}-${commentList.commentnum}"></button>
							</c:if>
							<button type="button" class="fas fa-trash-alt commentDelete" id="commentDelete" onClick="del(${commentList.commentnum})"></button>
							<input type="hidden" id="commentnum" value="${commentList.commentnum}">
						</c:if>
						<p>
						<p id="commentContent">${commentList.content}</p><hr>
					</li>
					<!-- 댓글 수정폼 -->
					<form  class="collapse multi-collapse-${commentList.id}-${commentList.commentnum}" id="commentForm" method="post">
						<!-- 아이디,게시글번호 -->
						<input type="hidden" id="id" value="${commentList.id}">
						<input type="hidden" id="commentnum" value="${commentList.commentnum}">
						<!-- 작성자 정보 -->
						<img src="http://ssl.gstatic.com/accounts/ui/avatar_2x.png" class="commentProfile" alt="avata">
						<b id="nickname" id="nickname">${commentList.nickname}</b>
						<button type="button" class="far fa-check-square commentUpdateCheck" id="commentUpdateCheck"></button>
						<button type="button" class="far fa-window-close commentCancel" id="commentCancel" onClick="cancel()"></button>
						<textarea class="form-control" rows="3" cols="30" id="updateContent" name="updateContent">${commentList.content}</textarea>
					</form>
				</c:forEach>
			</ol>
		</div>
	</div>
	
</div>
</body>
</html>