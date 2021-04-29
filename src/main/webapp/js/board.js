/**
 * 게시판 js 
 */
/* 게시글 리스트=================================================== */
$("#write_btn").on("click",function(){
	if(sessionScope.resultLogin == ""){
		alert("로그인을 해주세요.");
		location.href="login.do";
	}
});


/* 게시글 검색 ====================================================*/
function searchCheck(){
	if(document.search_free_board.keyWord.value=='' && !document.search_free_board.keyField.value=='all'){
		alert('검색어를 입력하세요');
		document.search_free_board.keyWord.focus();
		return false;
	}
}

