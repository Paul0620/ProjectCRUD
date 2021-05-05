<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
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
	
	<!-- 작성 후 게시글 화면 -->
	<div class="table" id="read_table">
		<div class="row">
			<!-- 프로필 사진 -->
			<div class="col-sm-2" id="read_profile">
				<tr>
					<td><img src="http://ssl.gstatic.com/accounts/ui/avatar_2x.png" class="img-thumbnail" alt="avatar" id="read_profile_img"></td>
				</tr>
			</div>
			<div class="col-sm-10" id="read2_profile">
				<!-- 게시물 정보 가져오기 -->
				<input type="hidden" id="postnum" name="postnum" value="${board.postnum}">
				<input type="hidden" id="postnum" name="postnum" value="${board.id}">
				<!-- 게시물 제목 -->
				<table class="col-sm-12">
					<thead class="text-center">
						<tr>
							<th id="read_title">${board.title}</td>
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
							<c:if test="${sessionScope.resultLogin.id == board.id || sessionScope.resultLogin.id == 'admin'}">
								<td id="read_setbtn">
									<input type="button" class="btn btn-dark float-right" id="read_delete" value="삭제" onClick="del(${board.postnum})">
									<input type="button" class="btn btn-dark float-right" id="read_update" value="수정" onClick="location.href='update.do?postnum=${board.postnum}'">
								</td>
							</c:if>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
		<!-- 내용부분 -->
		<div class="card" id="read_content">
			${board.content}
		</div>
		<!-- 파일다운로드를 위한 폼 -->
		<div class="custom-file">
			<form class="form-control" id="fileDown" method="post">
			</form>
		</div>
	</div>
	
	<!-- 댓글 -->
	<!-- 댓글작성폼-->
	<div class="col-sm-12" id="commentListForm"><br>
		<div>
			<form id="commentForm" name="commentForm" method="post">
			<!-- 댓글정보 보내기 -->
			<input type="hidden" id="postnum" name="postnum" value="${resultLogin.postnum}">
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
		                                <input type="submit" class="btn btn-dark float-right" value="등록" onClick="fn_comment('${board.postnum}')">
		                            </div>
		                        </td>
		                    </tr>
		                </table>
		            </div>
		        </div>  
		    </form>
	    </div>
	    <!-- 댓글리스트폼 -->
	    <!-- 댓글 -->
		<div id="reply">
		  <ol class="replyList">
		    <c:forEach items="${listComment}" var="listComment">
		      <li>
		        <p>
		        작성자 : ${listComment.nickname}<br />
		        작성 날짜 : ${listComment.regdate}
		        </p>
		
		        <p>${listComment.content}</p>
		      </li>
		    </c:forEach>   
		  </ol>
		</div>
	</div>
	
</div>
</body>
</html>