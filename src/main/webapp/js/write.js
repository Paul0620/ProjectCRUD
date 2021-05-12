/* 게시글 작성/수정 js */
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
 
 /* 다중업로드를 위한 설정(미구현) */ 
/*function uploadSummernoteImageFile(file, el) {
	data = new FormData();
	data.append("file", file);
	$.ajax({
		data : data,
		type : "POST",
		url : "uploadSummernoteImageFile",
		contentType : false,
		enctype : 'multipart/form-data',
		processData : false,
		success : function(data) {
			$(el).summernote('editor.insertImage', data.url);
		}
	});
}*/

