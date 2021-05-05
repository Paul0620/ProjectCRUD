/* 댓글 js */

/* 댓글작성 */
function fn_comment(postnum){
    
    $.ajax({
        type:'POST',
        url : "<c:url value='/main/cWrite.do'/>",
        data:$("#commentForm").serialize(),
        success : function(data){
            if(data=="success")
            {
                getCommentList();
                $("#content").val("");
            }
        },
        error:function(request,status,error){
            //alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
       }
        
    });
}

