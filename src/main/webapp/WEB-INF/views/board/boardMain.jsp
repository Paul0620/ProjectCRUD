<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>메인메뉴</title>
</head>
<body>
<div class="container">
	<!-- 메인화면(미구현) -->
	<!-- 게시판, 로그인, 광고 -->
	<div class="col-sm">
		<!-- 인기게시판 보드 -->
		<!-- 상단 메뉴탭(각 게시판 인기글 보기) -->
		<div class="card" id="board1">
			<div class="card-header bg-dark text-white">
				<h3 class="float-left">인기글</h3>
				<ul class="nav nav-pills float-right" id="board1_menu">
					<li class="nav-item"><a class="nav-link active" data-toggle="pill" href="#deal">사고팔고</a></li>
					<li class="nav-item"><a class="nav-link" data-toggle="pill" href="#trip">여행가자</a></li>
					<li class="nav-item"><a class="nav-link" data-toggle="pill" href="#hobby">같이놀자</a></li>
					<li class="nav-item"><a class="nav-link" data-toggle="pill" href="#tip">꿀팁게시판</a></li>
					<li class="nav-item"><a class="nav-link" data-toggle="pill" href="#free">자유게시판</a></li>
					<li class="nav-item"><a class="nav-link" data-toggle="pill" href="#notice">공지사항</a></li>
				</ul>
			</div>
			<!-- 게시판 내용보드 -->
			<div class="tab-content">
				<!-- 사고팔고 인기게시판 -->
				<div class="tab-pane fade show active" id="deal">
					<div class="card-body">
						<ul class="list-unstyled"><li><a href="#">내용</a></li></ul>
						<ul class="list-unstyled"><li><a href="#">내용</a></li></ul>
						<ul class="list-unstyled"><li><a href="#">내용</a></li></ul>
						<ul class="list-unstyled"><li><a href="#">내용</a></li></ul>
						<ul class="list-unstyled"><li><a href="#">내용</a></li></ul>
						<ul class="list-unstyled"><li><a href="#">내용</a></li></ul>
						<ul class="list-unstyled"><li><a href="#">내용</a></li></ul>
						<ul class="list-unstyled"><li><a href="#">내용</a></li></ul>
					</div>
				</div>
				
				<!-- 여행가자 인기게시판 -->
				<div class="tab-pane fade" id="trip">
					<div class="card-body">
						<ul class="list-unstyled"><li><a href="#">내용2</a></li></ul>
						<ul class="list-unstyled"><li><a href="#">내용2</a></li></ul>
						<ul class="list-unstyled"><li><a href="#">내용2</a></li></ul>
						<ul class="list-unstyled"><li><a href="#">내용2</a></li></ul>
						<ul class="list-unstyled"><li><a href="#">내용2</a></li></ul>
						<ul class="list-unstyled"><li><a href="#">내용</a></li></ul>
						<ul class="list-unstyled"><li><a href="#">내용</a></li></ul>
						<ul class="list-unstyled"><li><a href="#">내용</a></li></ul>
					</div>
				</div>
				
				<!-- 같이놀자 인기게시판 -->
				<div class="tab-pane fade" id="hobby">
					<div class="card-body">
						<ul class="list-unstyled"><li><a href="#">내용3</a></li></ul>
						<ul class="list-unstyled"><li><a href="#">내용3</a></li></ul>
						<ul class="list-unstyled"><li><a href="#">내용</a></li></ul>
						<ul class="list-unstyled"><li><a href="#">내용</a></li></ul>
						<ul class="list-unstyled"><li><a href="#">내용</a></li></ul>
						<ul class="list-unstyled"><li><a href="#">내용</a></li></ul>
						<ul class="list-unstyled"><li><a href="#">내용</a></li></ul>
						<ul class="list-unstyled"><li><a href="#">내용</a></li></ul>
					</div>
				</div>
				
				<!-- 꿀팁 인기게시판 -->
				<div class="tab-pane fade" id="tip">
					<div class="card-body">
						<ul class="list-unstyled"><li><a href="#">내용4</a></li></ul>
						<ul class="list-unstyled"><li><a href="#">내용4</a></li></ul>
						<ul class="list-unstyled"><li><a href="#">내용</a></li></ul>
						<ul class="list-unstyled"><li><a href="#">내용</a></li></ul>
						<ul class="list-unstyled"><li><a href="#">내용</a></li></ul>
						<ul class="list-unstyled"><li><a href="#">내용</a></li></ul>
						<ul class="list-unstyled"><li><a href="#">내용</a></li></ul>
						<ul class="list-unstyled"><li><a href="#">내용</a></li></ul>
					</div>
				</div>
				
				<!-- 자유 인기게시판 -->
				<div class="tab-pane fade" id="free">
					<div class="card-body">
						<ul class="list-unstyled"><li><a href="#">내용5</a></li></ul>
						<ul class="list-unstyled"><li><a href="#">내용5</a></li></ul>
						<ul class="list-unstyled"><li><a href="#">내용</a></li></ul>
						<ul class="list-unstyled"><li><a href="#">내용</a></li></ul>
						<ul class="list-unstyled"><li><a href="#">내용</a></li></ul>
						<ul class="list-unstyled"><li><a href="#">내용</a></li></ul>
						<ul class="list-unstyled"><li><a href="#">내용</a></li></ul>
						<ul class="list-unstyled"><li><a href="#">내용</a></li></ul>
					</div>
				</div>
				
				<!-- 공지 인기게시판 -->
				<div class="tab-pane fade" id="notice">
					<div class="card-body">
						<ul class="list-unstyled"><li><a href="#">내용6</a></li></ul>
						<ul class="list-unstyled"><li><a href="#">내용6</a></li></ul>
						<ul class="list-unstyled"><li><a href="#">내용</a></li></ul>
						<ul class="list-unstyled"><li><a href="#">내용</a></li></ul>
						<ul class="list-unstyled"><li><a href="#">내용</a></li></ul>
						<ul class="list-unstyled"><li><a href="#">내용</a></li></ul>
						<ul class="list-unstyled"><li><a href="#">내용</a></li></ul>
						<ul class="list-unstyled"><li><a href="#">내용</a></li></ul>
					</div>
				</div>
			</div>
		</div>
				
		<!-- 최근게시판 보드 -->
		<!-- 상단 메뉴탭(각 게시판 최신글 보기) -->
		<div class="card" id="board2">
			<div class="card-header bg-dark text-white">
				<h3 class="float-left">최신글</h3>
				<ul class="nav nav-pills float-right" id="board2_menu">
					<li class="nav-item"><a class="nav-link active" data-toggle="pill" href="#deal_new">사고팔고</a></li>
					<li class="nav-item"><a class="nav-link" data-toggle="pill" href="#trip_new">여행가자</a></li>
					<li class="nav-item"><a class="nav-link" data-toggle="pill" href="#hobby_new">같이놀자</a></li>
					<li class="nav-item"><a class="nav-link" data-toggle="pill" href="#tip_new">꿀팁게시판</a></li>
					<li class="nav-item"><a class="nav-link" data-toggle="pill" href="#free_new">자유게시판</a></li>
					<li class="nav-item"><a class="nav-link" data-toggle="pill" href="#notice_new">공지사항</a></li>
				</ul>
			</div>
			<!-- 게시판 내용보드 -->
			<div class="tab-content">
				<!-- 사고팔고 최신게시판 -->
				<div class="tab-pane fade show active" id="deal_new">
					<div class="card-body">
						<ul class="list-unstyled"><li><a href="#">내용</a></li></ul>
						<ul class="list-unstyled"><li><a href="#">내용</a></li></ul>
						<ul class="list-unstyled"><li><a href="#">내용</a></li></ul>
						<ul class="list-unstyled"><li><a href="#">내용</a></li></ul>
						<ul class="list-unstyled"><li><a href="#">내용</a></li></ul>
						<ul class="list-unstyled"><li><a href="#">내용</a></li></ul>
						<ul class="list-unstyled"><li><a href="#">내용</a></li></ul>
						<ul class="list-unstyled"><li><a href="#">내용</a></li></ul>
					</div>
				</div>
				
				<!-- 여행가자 최신게시판 -->
				<div class="tab-pane fade" id="trip_new">
					<div class="card-body">
						<ul class="list-unstyled"><li><a href="#">내용2</a></li></ul>
						<ul class="list-unstyled"><li><a href="#">내용2</a></li></ul>
						<ul class="list-unstyled"><li><a href="#">내용2</a></li></ul>
						<ul class="list-unstyled"><li><a href="#">내용2</a></li></ul>
						<ul class="list-unstyled"><li><a href="#">내용2</a></li></ul>
						<ul class="list-unstyled"><li><a href="#">내용</a></li></ul>
						<ul class="list-unstyled"><li><a href="#">내용</a></li></ul>
						<ul class="list-unstyled"><li><a href="#">내용</a></li></ul>
					</div>
				</div>
				
				<!-- 같이놀자 인기게시판 -->
				<div class="tab-pane fade" id="hobby_new">
					<div class="card-body">
						<ul class="list-unstyled"><li><a href="#">내용3</a></li></ul>
						<ul class="list-unstyled"><li><a href="#">내용3</a></li></ul>
						<ul class="list-unstyled"><li><a href="#">내용</a></li></ul>
						<ul class="list-unstyled"><li><a href="#">내용</a></li></ul>
						<ul class="list-unstyled"><li><a href="#">내용</a></li></ul>
						<ul class="list-unstyled"><li><a href="#">내용</a></li></ul>
						<ul class="list-unstyled"><li><a href="#">내용</a></li></ul>
						<ul class="list-unstyled"><li><a href="#">내용</a></li></ul>
					</div>
				</div>
				
				<!-- 꿀팁 최신게시판 -->
				<div class="tab-pane fade" id="tip_new">
					<div class="card-body">
						<ul class="list-unstyled"><li><a href="#">내용4</a></li></ul>
						<ul class="list-unstyled"><li><a href="#">내용4</a></li></ul>
						<ul class="list-unstyled"><li><a href="#">내용</a></li></ul>
						<ul class="list-unstyled"><li><a href="#">내용</a></li></ul>
						<ul class="list-unstyled"><li><a href="#">내용</a></li></ul>
						<ul class="list-unstyled"><li><a href="#">내용</a></li></ul>
						<ul class="list-unstyled"><li><a href="#">내용</a></li></ul>
						<ul class="list-unstyled"><li><a href="#">내용</a></li></ul>
					</div>
				</div>
				
				<!-- 자유 최신게시판 -->
				<div class="tab-pane fade" id="free_new">
					<div class="card-body">
						<ul class="list-unstyled"><li><a href="#">내용5</a></li></ul>
						<ul class="list-unstyled"><li><a href="#">내용5</a></li></ul>
						<ul class="list-unstyled"><li><a href="#">내용</a></li></ul>
						<ul class="list-unstyled"><li><a href="#">내용</a></li></ul>
						<ul class="list-unstyled"><li><a href="#">내용</a></li></ul>
						<ul class="list-unstyled"><li><a href="#">내용</a></li></ul>
						<ul class="list-unstyled"><li><a href="#">내용</a></li></ul>
						<ul class="list-unstyled"><li><a href="#">내용</a></li></ul>
					</div>
				</div>
				
				<!-- 공지 최신게시판 -->
				<div class="tab-pane fade" id="notice_new">
					<div class="card-body">
						<ul class="list-unstyled"><li><a href="#">내용6</a></li></ul>
						<ul class="list-unstyled"><li><a href="#">내용6</a></li></ul>
						<ul class="list-unstyled"><li><a href="#">내용</a></li></ul>
						<ul class="list-unstyled"><li><a href="#">내용</a></li></ul>
						<ul class="list-unstyled"><li><a href="#">내용</a></li></ul>
						<ul class="list-unstyled"><li><a href="#">내용</a></li></ul>
						<ul class="list-unstyled"><li><a href="#">내용</a></li></ul>
						<ul class="list-unstyled"><li><a href="#">내용</a></li></ul>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
</body>
</html>