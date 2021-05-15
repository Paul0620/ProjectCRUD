/* === 게시판 리스트 === */
/* 게시글 검색 */
function searchCheck(){
	if(document.search.keyWord.value=='' && !document.search.keyField.value=='all'){
		alert('검색어를 입력하세요');
		document.search.keyWord.focus();
		return false;
	}
}

/* === 게시글 작성/수정 설정 === */
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

/* 파일업로드(미구현) */
(function($){
	var $fileBox = null;
		$(function() {
		init();
	});
	function init() {
		$fileBox = $('.input-file');
		fileLoad();
	}
	function fileLoad() {
		$.each($fileBox, function(idx){
			var $this = $fileBox.eq(idx),$btnUpload = $this.find('[type="file"]'),$label = $this.find('.file-label');
			$btnUpload.on('change', function() {
				var $target = $(this),fileName = $target.val(),$fileText = $target.siblings('.file-name');
				$fileText.val(fileName);
			});
			$btnUpload.on('focusin focusout', function(e) {
				e.type == 'focusin' ? $label.addClass('file-focus') : $label.removeClass('file-focus');
			});
		});
	}
})(jQuery);

/* === 게시글삭제 설정 === */
function del(postnum) {
	var chk = confirm("정말 삭제하시겠습니까?");
	if (chk) {
		location.href='delete.do?postnum='+postnum;
	}
}

