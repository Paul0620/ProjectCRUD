/* 게시판 리스트 */
/* 게시글 검색 */
function searchCheck(){
	if(document.search.keyWord.value=='' && !document.search.keyField.value=='all'){
		alert('검색어를 입력하세요');
		document.search.keyWord.focus();
		return false;
	}
}

/* 게시글 작성,수정(미구현) */
/* 파일업로드 */
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
