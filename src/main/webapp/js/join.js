/* 회원가입 버튼 클릭 후 체크 */
$(document).ready(function(){		
	$("#check-btn").on("click", function(){	
		/*아이디
		if($("#id").val()==""){
			alert("아이디를 입력해주세요.");
			$("#id").focus();
			return false;
		}
		//아이디 중복버튼
		var idChkVal = $("#idCheck").val();
		if(idChkVal == "N"){
			alert("중복확인 버튼을 눌러주세요.");
		}*/
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
			alert("이름을 입력해주세요.");
			$("#email").focus();
			return false;
		}
		//전화번호
		if($("#phone").val()==""){
			alert("이름을 입력해주세요.");
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

/* 아이디 중복버튼 클릭 후 체크 */
function fn_idCheck(){
	//아이디 공백체크 알림
	if($("#id").val()==""){
		alert("아이디를 입력해주세요.")
		$("#id").focus();
		return false;
	}
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

/* 닉네임 중복버튼 클릭 후 체크 */
function fn_nicknameCheck(){
	//닉네임 공백체크 알림
	if($("#nickname").val()==""){
		alert("닉네임을 입력해주세요.")
		$("#nickname").focus();
		return false;
	}
	$.ajax({
		url : "nicknameCheck.do",
		type : "post",
		dataType : "json",
		data : {"nickname" : $("#nickname").val()},
		success : function(data){
			if(data == 1){
				alert("중복된 닉네임입니다.");
				$("#nicknameCheck").val("Y");
				return false;
			}else if(data == 0){
				$("#nicknameCheck").val("Y");
				alert("사용가능한 닉네임입니다.");
			}
		}
	});
}

/* 주소창 팝업 */
function goPopup(){
	// 주소검색을 수행할 팝업 페이지를 호출합니다.
	// 호출된 페이지(jusopopup.jsp)에서 실제 주소검색URL(https://www.juso.go.kr/addrlink/addrLinkUrl.do)를 호출하게 됩니다.
	var pop = window.open("jusoPopup.do","pop","width=570,height=420, scrollbars=yes, resizable=yes"); 	
}

/* 주소값 내보내기 */
function jusoCallBack(zipNo, roadAddrPart1, roadAddrPart2, addrDetail){
	// 팝업페이지에서 주소입력한 정보를 받아서, 현 페이지에 정보를 등록합니다.
	/*
	document.form.zipNo.value = zipNo;
	document.form.roadAddrPart1.value = roadAddrPart1;
	document.form.roadAddrPart2.value = roadAddrPart2;
	document.form.addrDetail.value = addrDetail;
	*/
	$("#zipNo").val(zipNo);
	$("#roadAddrPart1").val(roadAddrPart1);
	$("#roadAddrPart2").val(roadAddrPart2);
	$("#addrDetail").val(addrDetail);
}




