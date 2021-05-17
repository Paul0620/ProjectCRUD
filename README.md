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
<img src="https://user-images.githubusercontent.com/79445646/118147034-24a05900-b44a-11eb-9a97-1cde2c2a17ce.png" width="900">

---


## DB 모델링
<img src="https://user-images.githubusercontent.com/79445646/118147089-308c1b00-b44a-11eb-8843-ec10d1f8c7d8.png" width="900">

---


## Front-End 주요기능
### BootStrap을 이용한 화면 설계 및 생성
>메인페이지
- 로그인 세션을 통해 메인페이지 메뉴변환
```jsp
<!-- aside.jsp -->
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
	<!-- 프로필 사진 -->
	<div class="text-center" id="profile">
		<img src="http://ssl.gstatic.com/accounts/ui/avatar_2x.png" class="avatar img-circle img-thumbnail" id="main_avatar" alt="avatar">
		<h5 id="login_nickname">${sessionScope.resultLogin.nickname}님</h5>		
	</div>
	<!-- 로그아웃버튼 -->
	<div class="card my">
		<input type="button" class="btn" id="logout_btn" value="로그아웃" onclick="location.href='logout.do'" />
	</div>
	<!-- 메세지, 메일, 계정관리 -->
	<div class="input-group bg-light"  id="btns">
		<button type="button" class="btn col-sm-4" id="message"><i class="fas fa-comments"></i></button>
		<button type="button" class="btn col-sm-4" id="mail"><i class="fas fa-envelope"></i></button>
		<button type="button" class="btn col-sm-4" id="admin" onClick="location.href='memberRead.do?id=${sessionScope.resultLogin.id}'"><i class="fas fa-user-cog"></i></button>
	</div>
	<!-- 활동기록 -->
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
<img src="https://user-images.githubusercontent.com/79445646/118356130-c93bab80-b5ae-11eb-8e19-b2f84ebf283f.gif" width="900">

---

>게시판
- 게시글 작성/수정시 SummernoteEditor 적용
```js
/* write.js */
/* 게시글 내용입력부분 에디터 설정(섬머노트) */
$(document).ready(function() {
	var toolbar = [
		// 글꼴 설정
		['fontname', ['fontname']],
		// 글자 크기 설정
		['fontsize', ['fontsize']],
		// 굵기, 기울임꼴, 밑줄,취소 선, 서식지우기
		['style', ['bold', 'italic', 'underline','strikethrough', 'clear']],
		// 글자색
		['color', ['forecolor','color']],
		// 표만들기
		['table', ['table']],
		// 글머리 기호, 번호매기기, 문단정렬
		['para', ['ul', 'ol', 'paragraph']],
		// 줄간격
		['height', ['height']],
		// 그림첨부, 링크만들기
		['insert',['picture','link']],
		// 코드보기, 도움말
		['view', ['codeview', 'help']]
	];
	var setting = {
		height : 300,
			minHeight : null,
			maxHeight : null,
			focus : false,
			lang : 'ko-KR',
			toolbar : toolbar,
			callbacks : { //여기 부분이 이미지를 첨부하는 부분
				onImageUpload : function(files, editor, welEditable) {
					for (var i = files.length - 1; i >= 0; i--) {
						uploadSummernoteImageFile(files[i], this);
					}
				}
			}
		};
	$('#summernote').summernote(setting); 
});
```
<img src="https://user-images.githubusercontent.com/79445646/118446063-290a9180-b72a-11eb-9b25-d7616df84abe.gif" width="900">

---

- jstl "c"를 이용하여 게시글데이터 가져오기
```jsp
<!-- boardList.jsp -->
<!-- 게시물이 없을때 -->
<c:if test="${count==0}">
	<tr>
		<td colspan="7" align="center">등록된 게시물이 없습니다.</td>
	</tr>
</c:if>

<!-- 게시물이 있을때 -->
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
```
<img src="https://user-images.githubusercontent.com/79445646/118447502-d205bc00-b72b-11eb-88e2-7f907889279b.gif" width="900">

---

## Back-End 주요기능
>프로젝트 설정
- Web.xml
```xml
<?xml version="1.0" encoding="UTF-8"?>
<web-app xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns="http://xmlns.jcp.org/xml/ns/javaee" 
xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/javaee http://xmlns.jcp.org/xml/ns/javaee/web-app_3_1.xsd" id="WebApp_ID" version="3.1">
  <display-name>CRUDFest</display-name>
<!-- applicationContext.xml에서 설정한 Bean을 모든 서블릿과 필터에서 공유하는 설정 -->
  <context-param>
    <param-name>contextConfigLocation</param-name>
    <param-value>classpath:config/applicationContext.xml</param-value>
  </context-param>
<!-- 서블릿과 필터에 공유 할 수 있도록 리스너(이벤트 발생시 호출되어 처리)를 설정 -->
  <listener>
    <listener-class>
         org.springframework.web.context.ContextLoaderListener
      </listener-class>
  </listener>
<!-- dispatcher 서블릿 추가 -->
  <servlet>
    <servlet-name>dispatcher</servlet-name>
    <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
  </servlet>
<!-- 모든 페이지에 한글 필터 설정 -->
  <servlet-mapping>
    <servlet-name>dispatcher</servlet-name>
    <url-pattern>*.do</url-pattern>
  </servlet-mapping>
  <filter>
    <filter-name>encodingFilter</filter-name>
    <filter-class>org.springframework.web.filter.CharacterEncodingFilter</filter-class>
    <init-param>
      <param-name>encoding</param-name>
      <param-value>UTF-8</param-value>
    </init-param>
  </filter>
  <filter-mapping>
    <filter-name>encodingFilter</filter-name>
    <url-pattern>/*</url-pattern>
  </filter-mapping>
<!-- 기본페이지 설정 -->
  <welcome-file-list>
    <welcome-file>index.jsp</welcome-file>
  </welcome-file-list>
</web-app>
```
---

- dispatcher-servlet.xml
```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
	xmlns:context="http://www.springframework.org/schema/context" 
	xmlns:p="http://www.springframework.org/schema/p"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://www.springframework.org/schema/beans
       http://www.springframework.org/schema/beans/spring-beans-3.0.xsd
       http://www.springframework.org/schema/context
       http://www.springframework.org/schema/context/spring-context-3.0.xsd">
       
    <!-- component라는 어노테이션을 com가 들어간 모든 패키지에서 찾아서 어노테이션 적용 -->
    <context:component-scan base-package="com" />
 	
    <!-- tiles(ViewResolver)설정 -->
    <bean id="tilesConfigurer" 
     		 class="org.springframework.web.servlet.view.tiles3.TilesConfigurer">
        <property name="definitions">
            <list>
                <value>/WEB-INF/tiles/tiles.xml</value>
            </list>
        </property>
    </bean>
    
    <!-- header, footer, aside, body 레이아웃 -->
    <bean id="tilesViewResolver" 
    		class="org.springframework.web.servlet.view.UrlBasedViewResolver">
        <property name="viewClass"
         value="org.springframework.web.servlet.view.tiles3.TilesView"/>
        <property name="order" value="1"/>
    </bean>
    
    <!-- 회원관리, 로그인 페이지 이동 처리를 위해 -->
    <bean id="viewResolver"
	      class="org.springframework.web.servlet.view.InternalResourceViewResolver">
	     <property name="viewClass" value="org.springframework.web.servlet.view.JstlView" />
	     <property name="prefix" value="/WEB-INF/views/member/" />
	     <property name="suffix" value=".jsp" />
	     <property name="order" value="2"/>
	</bean>
    
    <!-- 예외페이지 작성(에러가 발생이 될 때 개발자가 작성한 예외페이지로 이동) -->
    <bean class="org.springframework.web.servlet.handler.SimpleMappingExceptionResolver">
        <property name="exceptionMappings">
            <props>
                <prop key="java.lang.Exception">pageError</prop>
            </props>
        </property>
    </bean>
 	
</beans>
```
---

- applicationContext.xml
```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
	xmlns:context="http://www.springframework.org/schema/context" 
	xmlns:p="http://www.springframework.org/schema/p"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://www.springframework.org/schema/beans
       http://www.springframework.org/schema/beans/spring-beans-3.0.xsd
       http://www.springframework.org/schema/context
       http://www.springframework.org/schema/context/spring-context-3.0.xsd">

	<!-- 외부 설정 프로퍼티 설정(프로퍼티 파일을 사용하기 위해) -->
    <bean id="propertyConfigurer" 
              class="org.springframework.beans.factory.config.PropertyPlaceholderConfigurer">
		<property name="locations">
			<list>
				<value>classpath:config/jdbc.properties</value>
			</list>
		</property>
	</bean>
      
	<!-- 커넥션 풀을 이용한 DataSource 설정(DB와 연결된 객체를 pool에 저장해서 사용) -->
	<bean id="dataSource" class="org.apache.commons.dbcp.BasicDataSource">
	    <property name="driverClassName" value="${jdbc.driverClassName}"/>
		<property name="url" value="${jdbc.url}"/>
		<property name="username" value="${jdbc.username}"/>
		<property name="password" value="${jdbc.password}"/>
		<!-- 최대 커넥션 개수 -->
		<property name="maxActive" value="50"></property>
		<!-- 접속이 없을 경우 최대 유지 커넥션 개수 -->
		<property name="maxIdle" value="30"></property>
		<!-- 접속이 없을 경우 최소 유지 커넥션 개수 -->
		<property name="minIdle" value="50"></property>
		<!-- 최대 대기시간(초) : 초과시 연결실패 오류 발생 -->
		<property name="maxWait" value="5"></property>
	</bean>

	<!-- Mybatis bean등록(SqlSessionFactoryBean) - dataSource를 이용한 DB와 MyBatis 연결 설정 -->
	<bean id="sqlSessionFactory"  class="org.mybatis.spring.SqlSessionFactoryBean">
		<property name="configLocation"  value="classpath:config/SqlMapConfig.xml"  />
		<property name="dataSource" ref="dataSource" />
   </bean>
	
	<!-- SqlSessionTemplate(sqlSession객체를 더 쉽게 얻어오기 위해서 설정) -->
	<bean id="sqlSessionTemplate"  class="org.mybatis.spring.SqlSessionTemplate">
		<constructor-arg index="0" ref="sqlSessionFactory" />
	</bean>
	
</beans>
```
---

- SqlMapConfig.xml
```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE configuration PUBLIC "-//mybatis.org//DTD Config 3.0//EN" "HTTP://mybatis.org/dtd/mybatis-3-config.dtd">

<!-- DB 접속 후 테이블의 정보를 가져오는 환경설정 -->
<configuration>
	<settings>
		<setting name="cacheEnabled" value="false" />
        <setting name="jdbcTypeForNull" value="NULL" />
	</settings>
	
	<!-- DTO클래스 별칭부여 -->
	<typeAliases>
	    <typeAlias alias="BoardCommand" type="com.board.command.BoardCommand"/>
	    <typeAlias alias="CommentCommand" type="com.board.command.CommentCommand"/>
	    <typeAlias alias="FileCommand" type="com.board.command.FileCommand"/>
	    <typeAlias alias="MemberCommand" type="com.member.command.MemberCommand"/>	    
	    <typeAlias alias="LoginCommand" type="com.member.command.LoginCommand"/>
	</typeAliases>
	
	<!-- DB 접속 후 불러올 Sql구문을 입력해놓을 xml 저장경로 위치 설정 -->
	<mappers>
	    <mapper resource="com/board/dao/BoardMapper.xml"/>
	    <mapper resource="com/member/dao/MemberMapper.xml"/>
	</mappers>

</configuration>
```
---
- jdbc.properties
```properties
#연결할 DB 드라이버이름/주소, 접속할 계정/비밀번호 설정
jdbc.driverClassName=oracle.jdbc.driver.OracleDriver
jdbc.url=jdbc:oracle:thin:@localhost:1521:orcl
jdbc.username=crud
jdbc.password=1234
```
---
- Log4j.xml
```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE log4j:configuration SYSTEM "log4j.dtd">
<log4j:configuration xmlns:log4j='http://jakarta.apache.org/log4j/'>

	<!--기본적인 출력양식이 설정  -->
	<appender name="STDOUT" class="org.apache.log4j.ConsoleAppender">
		<layout class="org.apache.log4j.PatternLayout">
			<param name="ConversionPattern" value="[%p:%C{1}.%M()] %m%n" />
		</layout>
	</appender>

	<!-- dr.mini(패키지)로 시작하는 패키지내의 모든  클래스에서 정보를 출력(매개변수전달,객체값출력) -->
	<category name="dr.mini" additivity="false">
		<priority value="debug" />
		<appender-ref ref="STDOUT" />
	</category>

	<!-- 에러가 발생이 될때 출력하도록 설정  -->
	<root>
		<priority value="error" />
		<appender-ref ref="STDOUT" />
	</root>

</log4j:configuration>
```
---

>화면 레이아웃
- Tiles를 활용하여 header, aside, footer, js/css 반복코드 제거
```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE tiles-definitions PUBLIC
       "-//Apache Software Foundation//DTD Tiles Configuration 3.0//EN"
       "http://tiles.apache.org/dtds/tiles-config_3_0.dtd">

<tiles-definitions>

	<!-- 페이지 레이아웃 처리 및 js,css 관리 -->
    <definition name="mainpage" template="/WEB-INF/views/home.jsp">
        <put-attribute name="title" value="YOEGIMOYEO"/>
        <put-attribute name="css" value="/WEB-INF/views/script/css.jsp" />
        <put-attribute name="js" value="/WEB-INF/views/script/js.jsp" />
        <put-attribute name="header" value="/WEB-INF/views/header.jsp" />
        <put-attribute name="body" value="/WEB-INF/views/board/boardList.jsp" />
        <put-attribute name="aside" value="/WEB-INF/views/aside.jsp" />
        <put-attribute name="footer" value="/WEB-INF/views/footer.jsp" /> 
    </definition>
    
   	<!-- body -->  	
   	<definition name="boardWrite" extends="mainpage">
   		<put-attribute name="title" value="글쓰기"/>
   		<put-attribute name="body" value="/WEB-INF/views/board/boardWrite.jsp" />
   	</definition>
   	
   	<definition name="boardRead" extends="mainpage">
   		<put-attribute name="title" value="글보기"/>
   		<put-attribute name="body" value="/WEB-INF/views/board/boardRead.jsp" />
   	</definition>
   	
   	<definition name="boardUpdate" extends="mainpage">
   		<put-attribute name="title" value="글수정"/>
   		<put-attribute name="body" value="/WEB-INF/views/board/boardUpdate.jsp" />
   	</definition> 

</tiles-definitions>
```
---

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
<img src="https://user-images.githubusercontent.com/79445646/118352727-e4ea8600-b59d-11eb-81de-06da5508eceb.gif" width="900">
<img src="https://user-images.githubusercontent.com/79445646/118484173-e361bf00-b751-11eb-8d63-baba8c8054a4.gif" width="900">

---

- 아이디 중복버튼 클릭시 공백체크 후 중복확인(=닉네임)
- 요청(유효성검사) > Controller > DaoImpl > Mybatis > DB(Oracle) > Controller에서 DB반환
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

```java
/* MembcerController.java */
//아이디 중복체크
@ResponseBody
@RequestMapping(value="/main/idCheck.do", method=RequestMethod.POST)
public String idCheck(MemberCommand member, HttpServletRequest request){
	//System.out.println("아이디 중복체크 :: "+request.getRequestURI());
	int resultId=memberDao.idCheck(member);
	//System.out.println("resultId -> "+resultId);
	return String.valueOf(resultId);
}
```

```java
/* MemberDao.java */
//아이디중복체크
public int idCheck(MemberCommand member);
```

```java
/* MemberDaoImpl.java */
//아이디중복체크
public int idCheck(MemberCommand member) {
	//id값을 체크하여 리턴
	int resultId=getSqlSession().selectOne("idCheck", member);
	return resultId;
}
```

```xml
<!-- MemberMapper.xml -->
<!-- 아이디중복체크 -->
<select id="idCheck" resultType="int">
	select count(*) from user_tb where id=#{id}
</select>
```
<img src="https://user-images.githubusercontent.com/79445646/118355788-02731c00-b5ad-11eb-9b0a-825b7926b6c7.gif" width="900">

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
<img src="https://user-images.githubusercontent.com/79445646/118355828-377f6e80-b5ad-11eb-893b-c97d6d3d1241.gif" width="900">

---

>로그인
- 요청(유효성검사) > Controller > DaoImpl > Mybatis > DB(Oracle) > Controller에서 DB반환
```js
/* login.js */
/* === 로그인 검사 === */
$(document).ready(function(){
	$("#loginCheck").on("click", function(){
		var userId = $("#id").val();
		var userPwd = $("#pwd").val();
		
		//로그인 입력바 공백체크 알림
		if(userId == ""){
			alert("아이디를 입력해 주세요");
			$("#input_id").focus();
			return false;
		}
		//비밀번호 입력바 공백체크 알림
		if(userPwd == ""){
			alert("비밀번호를 입력해 주세요");
			$("#input_pwd").focus();
			return false;
		}
		//폼 내부의 데이터를 전송할 주소
		document.loginCheck.action="loginCheck.do"
		//제출
		document.loginCheck.submit();
	});
});
```

```java
/* MemberController.java */
//로그인 페이지로 이동
@RequestMapping(value="/main/login.do",method=RequestMethod.GET)
public String loginForm() {
	return "login";
}
	
//로그인
@RequestMapping(value="/main/loginCheck.do", method=RequestMethod.POST)
public String loginMember(MemberCommand member, HttpServletRequest req, Model model) {
	if(log.isDebugEnabled()) { //디버그 모드인지 체크(출력상태)
		log.debug("MemberCommand -> "+member);
	}
	HttpSession session=req.getSession();     
	MemberCommand resultLogin=memberDao.loginMember(member);
	if(resultLogin==null) {
		session.setAttribute("resultLogin",null);
		model.addAttribute("message",false);
		return "login";
	} else { 
		session.setAttribute("resultLogin", resultLogin);
				System.out.println("로그인!");   
	}
		return "redirect:/main/list.do";
}
```

```java
/* MemberDao.java */
@Component //관리되는 객체임을 표시하기 위한 가장 기본적인 어노테이션, 자동으로 빈을 등록시켜주는 기능
@Controller //해당 클래스가 컨트롤러임을 나타내기 위한 어노테이션
public interface BoardDao {

	//로그인
	public MemberCommand loginMember(MemberCommand member);

}
```

```java
/* MemberDaoImpl.java */
@Repository
public class BoardDaoImpl extends SqlSessionDaoSupport implements BoardDao {
		
	//로그인
	public MemberCommand loginMember(MemberCommand member) {
		//해당하는 id값의 정보를 선택
		return getSqlSession().selectOne("loginMember", member);
	}

}
```

```xml
<!-- MemberMapper.xml -->
<!-- 로그인 -->
<select id="loginMember" resultType="MemberCommand">
	select id,pwd,nickname from login_tb where id=#{id} and pwd=#{pwd}
</select> 
```
<img src="https://user-images.githubusercontent.com/79445646/118493284-e661ad00-b75b-11eb-97eb-597c847c17e2.gif" width="900">

---

>페이징&검색
- 요청 > Controller > DaoImpl > Mybatis > DB(Oracle) > Controller에서 DB반환
```java
/* PagingUtil.java */
//페이징처림
package com.board.util;

//페이징 처리를 해주는 클래스
public class PagingUtil {
	
	private int startCount;	 // 한 페이지에서 보여줄 게시글의 시작 번호
	private int endCount;	 // 한 페이지에서 보여줄 게시글의 끝 번호
	private StringBuffer pagingHtml;// 페이징 생성자
	/**
	 * currentPage : 현재페이지
	 * totalCount : 전체 게시물 수
	 * blockCount : 한 페이지의  게시물의 수(=numPerPage)
	 * blockPage : 한 화면에 보여줄 페이지 수(=numPerBlock)
	 * pageUrl : 호출 페이지 url
	 * addKey : 부가적인 key 없을 때는 null 처리 (&num=23형식으로 전달할 것)
	 **/
	
	public PagingUtil(int currentPage, int totalCount, int blockCount, int blockPage, String pageUrl) {
		this(null,null,currentPage,totalCount,blockCount,blockPage,pageUrl,null);
	}
	
	public PagingUtil(int currentPage, int totalCount, int blockCount, int blockPage, String pageUrl, String addKey) {
		this(null,null,currentPage,totalCount,blockCount,blockPage,pageUrl,addKey);
	}
	
	public PagingUtil(String keyField, String keyWord, int currentPage, int totalCount, int blockCount, int blockPage,String pageUrl) {
		this(null,null,currentPage,totalCount,blockCount,blockPage,pageUrl,null);
	}
	
	public PagingUtil(String keyField, String keyWord, int currentPage, int totalCount, int blockCount, int blockPage,String pageUrl,String addKey) {
		if(addKey == null) addKey = ""; //부가키가 null 일때 ""처리
		// 전체 페이지 수			ex) 122/10=12.2 -> ceil은 무조건 올려주는 함수 -> 13.2 -> int -> 13
		int totalPage = (int) Math.ceil((double) totalCount / blockCount);
		if (totalPage == 0) {
			totalPage = 1;
		}
		// 현재 페이지가 전체 페이지 수보다 크면 전체 페이지 수로 설정
		if (currentPage > totalPage) {
			currentPage = totalPage;
		}
		// 현재 페이지의 처음과 마지막 글의 번호 가져오기.
		startCount = (currentPage - 1) * blockCount + 1;
		endCount = currentPage * blockCount;
		// 시작 페이지와 마지막 페이지 값 구하기.
		int startPage = (int) ((currentPage - 1) / blockPage) * blockPage + 1;
		int endPage = startPage + blockPage - 1;
		// 마지막 페이지가 전체 페이지 수보다 크면 전체 페이지 수로 설정
		if (endPage > totalPage) {
			endPage = totalPage;
		}
		// 이전 block 페이지
		pagingHtml = new StringBuffer();
		if (currentPage > blockPage) {
			if(keyWord==null){//검색 미사용시
				pagingHtml.append("<li class='page-item'><a class='page-link' href="+pageUrl+"?pageNum="+ (startPage - 1) + addKey +">");
			}else{
				//StringBuffer클래스에서 문자열을 추가할 때 -> "문자열"+"문자열"을 말할때 append
				pagingHtml.append("<li class='page-item'><a class='page-link' href="+pageUrl+"?keyField="+keyField+"&keyWord="+keyWord+"&pageNum="+ (startPage - 1) + addKey +">");
			}
			pagingHtml.append("<");
			pagingHtml.append("</a></li>");
		}
		//페이지 번호.현재 페이지는 빨간색으로 강조하고 링크를 제거.
		for (int i = startPage; i <= endPage; i++) {
			if (i > totalPage) {
				break;
			}
			if (i == currentPage) {
				pagingHtml.append("<li class='page-item active'><a class='page-link'>");
				pagingHtml.append(i);
				pagingHtml.append("</a></li>");
			} else {
				if(keyWord==null){//검색 미사용시
					pagingHtml.append("<li class='page-item'><a class='page-link' href="+pageUrl+"?pageNum=");
				}else{
					pagingHtml.append("<li class='page-item'><a class='page-link' href="+pageUrl+"?keyField="+keyField+"&keyWord="+keyWord+"&pageNum=");
				}
				pagingHtml.append(i);
				pagingHtml.append(addKey+">");
				pagingHtml.append(i);
				pagingHtml.append("</a></li>");
			}
		}
		// 다음 block 페이지
		if (totalPage - startPage >= blockPage) {
			if(keyWord==null){//검색 미사용시
				pagingHtml.append("<li class='page-item'><a class='page-link' href="+pageUrl+"?pageNum="+ (endPage + 1) + addKey +">");
			}else{
				pagingHtml.append("<li class='page-item'><a class='page-link' href="+pageUrl+"?keyField="+keyField+"&keyWord="+keyWord+"&pageNum="+ (endPage + 1) + addKey +">");
			}
			pagingHtml.append(">");
			pagingHtml.append("</a></li>");
		}
	}
	
	public StringBuffer getPagingHtml() {
		return pagingHtml; //링크문자열 가져오는 경우
	}
	
	public int getStartCount() {
		return startCount;
	}
	
	public int getEndCount() {
		return endCount;
	}
	
}
```

```java
package com.board.controller;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.board.command.BoardCommand;
import com.board.dao.BoardDao;
import com.board.util.PagingUtil;

@Component //직접작성한 Class를 Bean으로 등록하기 위한 어노테이션
@Controller
public class ListController {
	
	private Logger log=Logger.getLogger(this.getClass());
	
	@Autowired
	private BoardDao boardtDao;
	
	//게시글 리스트 출력
	@RequestMapping("/main/list.do")
	public ModelAndView listForm(@RequestParam(value="pageNum",defaultValue="1") int currentPage,
															@RequestParam(value="keyField",defaultValue="") String keyField,
															@RequestParam(value="keyWord",defaultValue="") String keyWord) {
		if(log.isDebugEnabled()) { //로그 객체가 디버깅모드상태라면?, 출력할 준비가 되어있다면
			//System.out.println("출력준비 완료!");
			log.debug("currentPage:"+currentPage); //log.debug("출력할 값")
			log.debug("keyField:"+keyField);
			log.debug("keyWord:"+keyWord); 
		}
		//검색분야,검색어를 전달 -> parameterType="map"
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("keyField", keyField);
		map.put("keyWord", keyWord);
		//총레코드 수 또는 검색되 총 레코드 수
		int count=boardtDao.getTotalCount(map);
		//페이징 처리 클래스 생성자
		//1.현재페이지 2.총레코드수 3.페이지당 게시물수 4.블럭당 페이지수 5.요청명령어 
		PagingUtil page=new PagingUtil(currentPage,count,5,3,"list.do");
		//start -> 페이지당 맨 첫번째 나오는 게시물 번호
		map.put("start", page.getStartCount());
		//<-> map.get("start") -> #{start}
		map.put("end", page.getEndCount());		
		List<BoardCommand> list=null;
		if(count > 0) {
			list=boardtDao.list(map); //keyField, keyWord, Start, end값이 각각 분리됨
			//System.out.println("ListController의 list -> "+list);
		} else {
			list=Collections.emptyList(); //0적용
		}
		//System.out.println("ListController의 count -> "+count);
		ModelAndView mav=new ModelAndView("mainpage"); //이동할 페이지명
		mav.addObject("count",count); //총 레코드 수 ${count(키명)}
		mav.addObject("list",list); //레코드 전체
		mav.addObject("pagingHtml",page.getPagingHtml()); //링크 문자열
		return mav; //${pagingHtml}(링크문자열 출력)
	}
	
}
```

```java
/* BoardDao.java */
public interface BoardDao {
	//글목록보기
	public List<BoardCommand> list(Map<String,Object> map);

	//총레코드 수(검색어에 맞는 레코드 수까지 포함)
	public int getTotalCount(Map<String,Object> map);
}
```

```java
/* BoardDaoImpl.java */
@Repository
public class BoardDaoImpl extends SqlSessionDaoSupport implements BoardDao {

	//글목록보기, 검색분야에 따른 검색어까지 조회(페이징 처리)
	public List<BoardCommand> list(Map<String, Object> map) {
		// TODO Auto-generated method stub
		List<BoardCommand> list=getSqlSession().selectList("selectList",map);
		//System.out.println("list()호출됨!!");
		return list;
	}

	//총레코드 수(검색어에 맞는 레코드 수까지 포함)
	public int getTotalCount(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return getSqlSession().selectOne("totalCount",map);
	}

}
```

```xml
<!-- BoardMapper.xml -->
<!--  1.모든 필드를 검색 2.번호 메기기 3.보여줄 필드 -->
<select  id="selectList"  parameterType="map"  resultType="BoardCommand">
	select postnum,id,boardnum,type,nickname,title,content,regdate,readcnt,recommand,best
		from ( select a.*, rownum rnum from (select * from post_tb
			<where>
				<if test="keyWord!=null and keyField=='title'">
					title like '%' || #{keyWord} || '%'
				</if>
				<if test="keyWord!=null and keyField=='nickname'">
					nickname like '%' || #{keyWord} || '%'
				</if>
				<if test="keyWord!=null and keyField=='content'">
					content like '%' || #{keyWord} || '%'
				</if>
				<if test="keyWord!=null and keyField=='all'">
					title like '%' || #{keyWord} || '%'  or
					nickname like '%' || #{keyWord} || '%'  or
					content like '%' || #{keyWord} || '%'
				</if>
			</where> 
	order by postnum desc ) a ) 
	<![CDATA[where rnum >=#{start} AND rnum <=#{end}]]>
</select>
 
<!-- 검색어에 해당하는 총 레코드 수 구하기 -->
<select id="totalCount" parameterType="map" resultType="Integer">
	select count(*) from post_tb
	<where>
		<if test="keyWord!=null and keyField=='title'">
			title like '%' || #{keyWord} || '%'
		</if>
		<if test="keyWord!=null and keyField=='nickname'">
			nickname like '%' || #{keyWord} || '%'
		</if>
		<if test="keyWord!=null and keyField=='content'">
			content like '%' || #{keyWord} || '%'
		</if>
		<if test="keyWord!=null and keyField=='all'">
			title like '%' || #{keyWord} || '%'  or
			nickname like '%' || #{keyWord} || '%'  or
			content like '%' || #{keyWord} || '%'
		</if>
	</where>
</select>
```
<img src="" width="900">

---


<!-- Footer -->
## 보완할점


---


## 오류해결


---


## 추가하지 못한 기능들


---

