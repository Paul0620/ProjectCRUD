<!-- Header -->
# CRUD 게시판 - 개인 프로젝트

<!-- Body -->
## 프로젝트 목적
- 첫 프로젝트 임으로 제일 많이 사용하는 게시판 공부
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

## CRUDFest 패키지 구조


---

## CRUDFest DB 모델링


---

## Front-End 주요기능


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

