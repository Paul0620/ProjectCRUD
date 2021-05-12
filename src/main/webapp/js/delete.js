/* 게시글 삭제 js  */
function del(postnum) {
	var chk = confirm("정말 삭제하시겠습니까?");
	if (chk) {
		location.href='delete.do?postnum='+postnum;
	}
}

