<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<head>
	<meta charset="UTF-8">
	<!-- html 캐쉬방지 -->
	<meta http-equiv="Cache-Control" content="no-cache, no-store, must-revalidate">
	<meta http-equiv="Expires" content="0">
	<meta http-equiv="Pragma" content="no-cache">
	<!-- 데스크탑, 모바일로 봤을때 디자인 처리를 위한 meta tag -->
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

	<title>상단메뉴바</title>

</head>
<body>
	<!-- 상단 메뉴바 -->
	<!-- 로고, 토글 -->
	<div class="navbar navbar-expand-sm navbar-dark bg-dark fixed-top">
		<div class="container"> <!-- 이중 컨테이너 가능한지? -->
			<!-- 사이트 타이틀 -->
			<a class="navbar-brand" onClick="location.href='list.do'">YOEGIMOYEO</a>
			<button class="navbar-toggler" type="button" data-toggle="collapse" data-target=".navbar-ex1-collapse">
				<span class="navbar-toggler-icon"></span>
			</button>
			<!-- 메뉴바 -->
			<div class="collapse navbar-collapse navbar-ex1-collapse navbar-right">
				<ul class="nav navbar-nav ml-auto" role="menu" id="top_menu">
					<li class="nav-item active" role="presentation"><a class="nav-link" onclick="">HOME</a></li>
					<li class="nav-item active" role="presentation"><a class="nav-link" onclick="">NEWS</a></li>
					<li class="nav-item active" role="presentation"><a class="nav-link" onclick="">사고팔고</a></li>
					<li class="nav-item active" role="presentation"><a class="nav-link" onclick="">여행가자</a></li>
					<li class="nav-item active" role="presentation"><a class="nav-link" onclick="">같이놀자</a></li>
					<!-- 드롭메뉴 -->
					<li class="nav-item active dropdown" role="presentation">
						<a class="nav-link dropdown-toggle" herf="#" data-toggle="dropdown">더보기</a>
						<ul class="dropdown-menu" role="menu">
							<li role="presentation"><a class="dropdown-item" role="menuitem" onclick="">꿀팁게시판</a></li>	
							<li role="presentation"><a class="dropdown-item" role="menuitem" onclick="">자유게시판</a></li>
							<li class="dropdown-divider"></li>
							<li role="presentation"><a class="dropdown-item" role="menuitem" onclick="">공지사항</a></li>										
						</ul>
					</li>
				</ul>
			</div>
		</div>
	</div> 
	
</body>
</html>