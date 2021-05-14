<!-- Header -->
# CRUD 게시판 - 개인 프로젝트

<!-- Body -->
## 프로젝트 목적
- 첫 프로젝트임으로 제일 많이 사용하는 게시판을 알기위한 공부
- 프로젝트로 사용하는 언어와 프로그램 이해도 상승시키기
- 진행중 부족한 점과 보완해야할 점 알기
___

## 개발환경
>O/S
- Window 10

>Front-End
- Bootstrap 4.6.0
- jQuery 3.6.0

>Back-End
- Spring 3.2.3
- JavaSE-1.7
- Oracle 11g
- MyBatis 3.1.1
- Maven 3.3.0
- Tomcat 8.5
---

## 개발기간 - 2021/03/08 ~ 2021/05/12 (10주)
>1주차 (03-08 ~ 03-14) 주제 선정 및 업무분석
- 개발환경 설정 및 프로젝트 주제 선정
- 참고 사이트 디자인 및 소스코드참고

>2주차 (03-15 ~ 03-21) 주제 선정 및 업무분석, 데이터모델링 & DB구축, 화면설계
- 참고 사이트 디자인 및 소스코드참고, 페이지 동작 기능 참고
- ERD - 모델링 구상
- BootStrap - 메인화면 Header, Aside, Footer, Body의 게시글목록(boardList)화면 디자인


>3주차 (03-22 ~ 03-28) 데이터모델링 & DB구축, 화면설계
- ERD - 사용자(user_tb), 로그인(login_tb), 게시판(board_tb), 게시글(post_tb), 댓글(comment_tb), 파일(File_tb)테이블 논리/물리이름, 데이터 타입, 기본키, 외래키 설정
- Oracle - 프로젝트에 사용할 DB 계정 생성, 권한 부여, ERD에서 작성한 테이블 쿼리 추가
- BootStrap - 회원가입(join), 로그인(login)화면 디자인
-	Spring - pom.xml에서 필요한 라이브러리 설정(springframework, mybatis, ojdbc 등)
- Spring - 회원관리, 게시판 DTO 설정
- Spring - DAO, DAOImpl, Mapper 설정 - 회원가입, 로그인/로그아웃, 게시글목록, 게시글작성 

>4주차 (03-29 ~ 04-04) 데이터모델링 & DB구축, 화면설계
- Oracle - 데이터 타입 수정보완, 테스트할 사용할 회원, 게시글 데이터 추가
- BootStrap - 게시글쓰기(boardWrite), 게시글읽기(boardRead), 게시글수정(boardUpdate), 회원가입(join)화면 디자인, 도로명주소API 회원가입(join)에 추가 설정
- Spring - DAO, DAOImpl, Mapper 설정 - 게시글수정, 게시글삭제,  
- Spring - web.xml에서 기본 url, 기본 화면, 한글필터, Listener, Context 설정
- Spring - SqlMapConfig.xml에서 DTO 경로, sql구문 저장위치, Mybatis 캐싱기능 설정
- Spring - jdbc.properties에서 연결할 DB 설정, Log4j.xml 설정


>5주차 (04-05 ~ 04-11) 데이터모델링 & DB구축, 화면설계, 기능별 모듈 구현 & 통합
- Oracle - 테이블 컬럼 추가 및 제거
- BootStrap - 회원정보(memberRead), 회원수정(memberUpdate), 회원목록(memberList)화면 디자인
- Spring - jsp로 해놨었던 화면 레이아웃을 Tiles로 전환(게시판 부분들만)
- Spring - 회원가입, 로그인/로그아웃, 게시글목록 Controller 설정 및 기능 구현
- Spring - 게시글목록(boardList) 페이징 처리 설정 및 구현
- Spring - DAO, DAOImpl, Mapper 설정 - 게시글읽기, 조회수, 게시글수정, 게시글삭제 
- Spting - DAO, DAOImpl, Mapper 설정 - 회원정보, 회원수정, 회원탈퇴, 회원목록

>6주차 (04-12 ~ 04-18) 화면설계, 기능별 모듈 구현 & 통합
- BootStrap - 로그인 세션을 통한 메뉴상태 변환 설정
- jQuery, js - 게시글작성에서 내용부분 summernote에디터로 설정
- Spring - 게시글 CRUD Controller 설정 및 기능 구현

>7주차 (04-19 ~ 04-25) 기능별 모듈 구현 & 통합
- BootStrap - 접속자에 따른 게시글관련 버튼 변환 설정
- jQuery, js - 회원가입/수정시 아이디/닉네임 중복확인, 비밀번호형식 설정, 로그인시 아이디 비밀번호 확인 설정 
- Spring -  회원정보, 회원수정, 회원탈퇴 Controller 설정 및 기능 구현

>8주차 (04-26 ~ 05-02) 기능별 모듈 구현 & 통합, 테스트 & 보안
- BootStrap - 댓글목록, 댓글CRUD, 파일첨부칸 디자인 게시글읽기에 추가, 접속자에 따른 화면변환 설정
- Spring - 게시글검색 Controller 설정 및 기능 구현

>9주차 (05-03 ~ 05-09) 기능별 모듈 구현 & 통합, 테스트 & 보안
- jQuery, js - 댓글작성체크 추가
- Spring - 댓글 DTO 추가, DAO, DAOImpl, Mapper 설정 - 댓글작성, 댓글목록
- Spring - 댓글작성, 댓글목록, 회원목록 Controller 설정 및 기능 구현   

>10주차 (05-10 ~ 05-12) 테스트 & 보안
- 구현된 기능들 검토 후 보완
- 코드 재정리, 주석처리
- 마무리
---

## 패키지 구조
<img src="https://user-images.githubusercontent.com/79445646/118147034-24a05900-b44a-11eb-9a97-1cde2c2a17ce.png" width="700">

---

## DB 모델링
<img src="https://user-images.githubusercontent.com/79445646/118147089-308c1b00-b44a-11eb-8843-ec10d1f8c7d8.png" width="700">

---

## Front-End 주요기능
### BootStrap을 이용한 화면 설계 및 생성
>회원가입
- 회원가입시 유효성 검사를 통해 필수입력공백, 비밀번호형식, 중복버튼클릭 유무 확인(공백처리는 로그인도 동일)
```js
/* join.js */
/* 회원가입 버튼 클릭시 필수입력칸 체크후 체크 */
$(document).ready(function(){		
	$("#check-btn").on("click", function(){	
		//아이디
		if($("#id").val()==""){
			alert("아이디를 입력해주세요.");
			$("#id").focus();
			return false;
		}
		//아이디 중복버튼
		var idChkVal = $("#idCheck").val();
		if(idChkVal == "N"){
			alert("중복확인 버튼을 눌러주세요.");
		}
		//비밀번호
		if($("#pwd").val()==""){
			alert("비밀번호를 입력해주세요.");
			$("#pwd").focus();
			return false;
		}
		//비밀번호 확인
		if($("#repwd").val()==""){
			alert("비밀번호를 입력해주세요.");
			$("#repwd").focus();
			return false;
		}
		//닉네임
		if($("#nickname").val()==""){
			alert("닉네임을 입력해주세요.");
			$("#nickname").focus();
			return false;
		}
		//닉네임 중복버튼
		var nicknameChkVal = $("#nicknameCheck").val();
		if(nicknameChkVal == "N"){
			alert("중복확인 버튼을 눌러주세요.");
		}
		//이름
		if($("#name").val()==""){
			alert("이름을 입력해주세요.");
			$("#name").focus();
			return false;
		}
		//이메일
		if($("#email").val()==""){
			alert("이메일을 입력해주세요.");
			$("#email").focus();
			return false;
		}
		//전화번호
		if($("#phone").val()==""){
			alert("전화번호를 입력해주세요.");
			$("#phone").focus();
			return false;
		}
		//비밀번호 입력양식 체크
		var pw = $("#pwd").val();
		var pw2 = $("#repwd").val();
		var num = pw.search(/[0-9]/g);
		var eng = pw.search(/[a-z]/ig);
		var spe = pw.search(/[`~!@@#$%^&*|₩₩₩'₩";:₩/?]/gi);
		if(pw.length < 8 || pw.length > 20){		
			alert("8자리 ~ 20자리 이내로 입력해주세요.");
			return false;
		}else if(pw.search(/\s/) != -1){
			alert("비밀번호는 공백 없이 입력해주세요.");
			return false;
		}else if(num < 0 || eng < 0 || spe < 0 ){
			alert("영문,숫자, 특수문자를 혼합하여 입력해주세요.");
			return false;
		}else if(pw != "" && pw2 == ""){
			null;
		}else if(pw != "" || pw2 != ""){
			if(pw == pw2) {
			} else {
				alert("비밀번호가 일치하지 않습니다. 재확인해주세요.");
				return false;
			}
		}else{
			console.log("통과"); 
			return true;
		} 
	});
});
```
<img src="" width="700">

---

- 아이디 중복버튼 클릭시 공백체크 후 중복확인(=닉네임)
```js
/* join.js */
/* 아이디 중복버튼 클릭시 아이디 확인 */
function fn_idCheck(){
	//중복체크시 아이디 공백체크 알림
	if($("#id").val()==""){
		alert("아이디를 입력해주세요.")
		$("#id").focus();
		return false;
	}
	//아이디 중복체크 결과알림창
	$.ajax({
		url : "idCheck.do",
		type : "post",
		dataType : "json",
		data : {"id" : $("#id").val()},
		success : function(data){
			if(data == 1){
				alert("중복된 아이디입니다.");
				$("#idCheck").val("N");
				return false;
			}else if(data == 0){
				$("#idCheck").val("Y");
			alert("사용가능한 아이디입니다.");
			}
		}
	});
}
```
<img src="" width="700">

---

- 도로명주소API를 활용한 주소검색하기
```js
/* join.js */
/* 주소창 팝업요청 */
function goPopup(){
	// 주소검색을 수행할 팝업 페이지를 호출합니다.
	var pop = window.open("jusoPopup.do","pop","width=570,height=420, scrollbars=yes, resizable=yes"); 	
}

/* 주소팝업창 */
function init(){
	var url = location.href;
	var confmKey = "U01TX0FVVEgyMDIxMDMwNjE1NDkxMjExMDg4NjQ=";
	var resultType = "4"; // 도로명주소 검색결과 화면 출력내용, 1 : 도로명, 2 : 도로명+지번+상세보기(관련지번, 관할주민센터), 3 : 도로명+상세보기(상세건물명), 4 : 도로명+지번+상세보기(관련지번, 관할주민센터, 상세건물명)
	var inputYn= "<%=inputYn%>";
	if(inputYn != "Y"){
		document.form.confmKey.value = confmKey;
		document.form.returnUrl.value = url;
		document.form.resultType.value = resultType;
		document.form.action="https://www.juso.go.kr/addrlink/addrLinkUrl.do"; //인터넷망
		//document.form.action="https://www.juso.go.kr/addrlink/addrMobileLinkUrl.do"; //모바일 웹인 경우, 인터넷망
		document.form.submit();
	}else{
		opener.jusoCallBack("<%=zipNo%>","<%=roadAddrPart1%>","<%=roadAddrPart2%>","<%=addrDetail%>");
		window.close();
	}
}

/* 주소값 내보내기 */
function jusoCallBack(zipNo, roadAddrPart1, roadAddrPart2, addrDetail){
	// 팝업페이지에서 주소입력한 정보를 받아서, 현 페이지에 정보를 등록합니다.
	$("#zipNo").val(zipNo);
	$("#roadAddrPart1").val(roadAddrPart1);
	$("#roadAddrPart2").val(roadAddrPart2);
	$("#addrDetail").val(addrDetail);
}
```
<img src="" width="700">

---

>메인페이지
- 로그인 전후 메인페이지 메뉴변환
```jsp
<!-- 로그인 안했을 때 -->
<c:if test="${sessionScope.resultLogin == null}">
	<!-- 로그인버튼 -->
	<div class="card my login-form">
		<input type="button" class="btn" id="login_btn"value="로 그 인" onclick="location.href='login.do'" >
	</div>
	<!-- 회원가입버튼 -->
	<div class="card my">
		<input type="button" class="btn" id="join_btn" value="회원가입" onclick="location.href='join.do'" >
	</div>
</c:if>
	
<!-- 로그인 했을 때 -->
<c:if test="${sessionScope.resultLogin != null}">
	<!-- 프로필 사진(미구현) -->
	<div class="text-center" id="profile">
		<img src="http://ssl.gstatic.com/accounts/ui/avatar_2x.png" class="avatar img-circle img-thumbnail" id="main_avatar" alt="avatar">
		<h5 id="login_nickname">${sessionScope.resultLogin.nickname}님</h5>		
	</div>
	<!-- 로그아웃버튼 -->
	<div class="card my">
		<input type="button" class="btn" id="logout_btn" value="로그아웃" onclick="location.href='logout.do'" />
	</div>
	<!-- 메세지(미구현), 메일(미구현), 계정관리 -->
	<div class="input-group bg-light"  id="btns">
		<button type="button" class="btn col-sm-4" id="message"><i class="fas fa-comments"></i></button>
		<button type="button" class="btn col-sm-4" id="mail"><i class="fas fa-envelope"></i></button>
		<button type="button" class="btn col-sm-4" id="admin" onClick="location.href='memberRead.do?id=${sessionScope.resultLogin.id}'"><i class="fas fa-user-cog"></i></button>
	</div>
	<!-- 활동기록(미구현) -->
	<ul class="list-group" id="my_active">
		<li class="list-group-item text-muted">나의 활동 <i class="fa fa-dashboard fa-1x"></i></li>
		<li class="list-group-item text-right"><span class="pull-left"><strong>공유</strong></span> 125</li>
		<li class="list-group-item text-right"><span class="pull-left"><strong>추천</strong></span> 13</li>
		<li class="list-group-item text-right"><span class="pull-left"><strong>게시글</strong></span> 37</li>
		<li class="list-group-item text-right"><span class="pull-left"><strong>댓글</strong></span> 78</li>
	</ul>
	<!-- 관리자가 로그인했을때만 보이는 회원목록 버튼 -->
	<c:if test="${sessionScope.resultLogin.id == 'admin'}">
		<div class="card my">
			<input type="button" class="btn"  id="memberView_btn" value="회원리스트" onclick="location.href='memberList.do'">
		</div>
	</c:if>
</c:if>	
```
<img src="" width="700">

---


## Back-End 주요기능


---

<!-- Footer -->
## 보완할점


---

## 오류해결


---

## 추가하지 못한 기능들


---

