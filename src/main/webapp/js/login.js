 /* 로그인 검사 */
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


	/*$.ajax({
			url : "loginCheck.do",
			type : "post",
			dataType : "json",
			data : {userId, userPwd},
			success : function(data){
				if(data != null){
					alert("로그인에 실패하였습니다.")
					return false;
				}
			}
		})*/
