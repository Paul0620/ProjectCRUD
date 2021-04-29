<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<!DOCTYPE html>
 
<html>
<head>
  <title>현재 유저정보 출력화면</title>
     
</head>
<body>
        <br><br>
        <b><font size="6" color="gray">내 정보</font></b>
        <br><br><br>
        
        <!-- 회원정보를 가져와 member 변수에 담는다. -->
        <c:set var="member" value="${requestScope.memberInfo}"/>
        
        <!-- 가져온 회원정보를 출력한다. -->
        <table>
            <tr>
                <td id="title">아이디</td>
                <td>${member.id}</td>
            </tr>
                        
            <tr>
                <td id="title">닉네임</td>
                <td>${member.nickname}</td>
            </tr>
                    
            <tr>
                <td id="title">이름</td>
                <td>${member.name}</td>
            </tr>
            
            <tr>
                <td id="title">이메일</td>
                <td>
                    ${member.email}
                </td>
            </tr>
            
            <tr>
                <td id="title">연락처</td>
                <td>${member.phone}</td>
            </tr>
            
            <tr>
                <td id="title">성별</td>
                <td>${member.gender}</td>
            </tr>
                    
            <tr>
                <td id="title">직업</td>
                <td>
                    ${member.job}
                </td>
            </tr>
                    
            <tr>
                <td id="title">주소</td>
                <td>
                    ${member.zipNo}&nbsp;
                    ${member.roadAddrPart1}&nbsp;
                    ${member.roadAddrPart1}&nbsp;
                    ${member.addrDetail}
                </td>
            </tr>
        </table>
        
        <br>
        <input type="button" class="btn" value="뒤로" onclick="changeForm(-1)">
        <input type="button" class="btn" value="회원정보 변경" onclick="changeForm(0)">
        <input type="button" class="btn" value="회원탈퇴" onclick="changeForm(1)">
</body>
</html>

