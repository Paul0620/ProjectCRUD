/* === 댓글 설정 === */
/* 댓글쓰기 */
function fn_comment(postnum){  
	var content=$("#content").val();
	if(content==""){
        		alert("내용을 입력해주세요.");
        		$("#content").focus();
        		return false;
    } 	
    $.ajax({
        type:"POST",
        url : "cWrite.do",
        data:$("#commentForm").serialize(),
        success : function(data){
	        if(data=="success"){
	        	alert("등록이 완료되었습니다.");
	            location.reload();
	            $("#content").val("");
	        }        
        },
        error:function(request,status,error){
            alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
		}  
	});
} 

/* 댓글수정 */
function commentUpdateCheck(commentnum,id){
	var updateContent=$("#updateContent").val();
	var paramData=JSON.Stringify({"content":commentContent,"commentnum":commentnum});
	var headers={"Content-Type":"application/json","X-HTTP-Method_Override":"POST"};
	$.ajax({
		type:"POST",
		url:"cUpdate.do",
		data:paramData,
		headers:headers,
		dataType:'text',
		success:function(result){
			console.log(result);
			cancel();	
		}
		,error:function(error){
			console.log("에러:"+error);
		}
	});
}

/* 댓글삭제(미구현) 

function fn_deleteComment(commentnum){
	var paramData = {"commentnum": commentnum};

	$.ajax({
		type : 'POST',
		url: "cDelete.do",
		data : paramData,
		dataType : 'text',
		success: function(result){
			console.log(result);
			//location.reload();
		}
		, error: function(error){
			console.log("에러 : " + error);
		}
	});
}
"fn_deleteComment(${commeneList.commentnum})"
*/

/* 댓글삭제(미구현) 
function del(commentnum) {
	var chk = confirm("정말 삭제하시겠습니까?");
	if (chk) {
		location.href='cDelete.do?commentnum='+commentnum;
	}
}*/












