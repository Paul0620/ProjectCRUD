<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title><tiles:getAsString name="title" /></title>
	<tiles:insertAttribute name="css" />
	<tiles:insertAttribute name="js" />
</head>
<body>
	<!-- tiles를 활용하여 페이지 레이아웃 처리 게시판 페이지들은 body에서 처리 -->
	<!-- 헤더 -->
	<div class="header">
		<tiles:insertAttribute name="header" />
	</div>
	
	<!-- 중앙 -->
	<div class="container">
		<div class="row" id="body_aside">
			<!-- 메인메뉴 -->
			<div class="col-sm-10" id="body">
	        	<tiles:insertAttribute name="body" />
        	</div>
        	
			<!-- 오른쪽 메뉴바 -->
			<div class="col-sm-2" id="aside">
				<tiles:insertAttribute name="aside" />
			</div>
		</div>
	</div>
	
	<!-- 하단바 -->
	<div class="footer">
		<tiles:insertAttribute name="footer" />
	</div>
	
</body>
</html>