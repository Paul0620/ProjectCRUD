package com.board.util;

//페이징 처리를 해주는 클래스
public class PagingUtil {
	
	private int startCount;	 // 한 페이지에서 보여줄 게시글의 시작 번호
	private int endCount;	 // 한 페이지에서 보여줄 게시글의 끝 번호
	private StringBuffer pagingHtml;// 페이징 생성자

	/**
	 * currentPage : 현재페이지
	 * totalCount : 전체 게시물 수
	 * blockCount : 한 페이지의  게시물의 수(=numPerPage)
	 * blockPage : 한 화면에 보여줄 페이지 수(=numPerBlock)
	 * pageUrl : 호출 페이지 url
	 * addKey : 부가적인 key 없을 때는 null 처리 (&num=23형식으로 전달할 것)
	 **/
	
	public PagingUtil(int currentPage, int totalCount, int blockCount, int blockPage, String pageUrl) {
		this(null,null,currentPage,totalCount,blockCount,blockPage,pageUrl,null);
	}
	
	public PagingUtil(int currentPage, int totalCount, int blockCount, int blockPage, String pageUrl, String addKey) {
		this(null,null,currentPage,totalCount,blockCount,blockPage,pageUrl,addKey);
	}
	
	public PagingUtil(String keyField, String keyWord, int currentPage, int totalCount, int blockCount, int blockPage,String pageUrl) {
		this(null,null,currentPage,totalCount,blockCount,blockPage,pageUrl,null);
	}
	
	public PagingUtil(String keyField, String keyWord, int currentPage, int totalCount, int blockCount, int blockPage,String pageUrl,String addKey) {
		if(addKey == null) addKey = ""; //부가키가 null 일때 ""처리
		// 전체 페이지 수			ex) 122/10=12.2 -> ceil은 무조건 올려주는 함수 -> 13.2 -> int -> 13
		int totalPage = (int) Math.ceil((double) totalCount / blockCount);
		if (totalPage == 0) {
			totalPage = 1;
		}
		// 현재 페이지가 전체 페이지 수보다 크면 전체 페이지 수로 설정
		if (currentPage > totalPage) {
			currentPage = totalPage;
		}
		// 현재 페이지의 처음과 마지막 글의 번호 가져오기.
		startCount = (currentPage - 1) * blockCount + 1;
		endCount = currentPage * blockCount;
		// 시작 페이지와 마지막 페이지 값 구하기.
		int startPage = (int) ((currentPage - 1) / blockPage) * blockPage + 1;
		int endPage = startPage + blockPage - 1;
		// 마지막 페이지가 전체 페이지 수보다 크면 전체 페이지 수로 설정
		if (endPage > totalPage) {
			endPage = totalPage;
		}
		// 이전 block 페이지
		pagingHtml = new StringBuffer();
		if (currentPage > blockPage) {
			if(keyWord==null){//검색 미사용시
				pagingHtml.append("<li class='page-item'><a class='page-link' href="+pageUrl+"?pageNum="+ (startPage - 1) + addKey +">");
			}else{
				//StringBuffer클래스에서 문자열을 추가할 때 -> "문자열"+"문자열"을 말할때 append
				pagingHtml.append("<li class='page-item'><a class='page-link' href="+pageUrl+"?keyField="+keyField+"&keyWord="+keyWord+"&pageNum="+ (startPage - 1) + addKey +">");
			}
			pagingHtml.append("<");
			pagingHtml.append("</a></li>");
		}
		//페이지 번호.현재 페이지는 빨간색으로 강조하고 링크를 제거.
		for (int i = startPage; i <= endPage; i++) {
			if (i > totalPage) {
				break;
			}
			if (i == currentPage) {
				pagingHtml.append("<li class='page-item active'><a class='page-link'>");
				pagingHtml.append(i);
				pagingHtml.append("</a></li>");
			} else {
				if(keyWord==null){//검색 미사용시
					pagingHtml.append("<li class='page-item'><a class='page-link' href="+pageUrl+"?pageNum=");
				}else{
					pagingHtml.append("<li class='page-item'><a class='page-link' href="+pageUrl+"?keyField="+keyField+"&keyWord="+keyWord+"&pageNum=");
				}
				pagingHtml.append(i);
				pagingHtml.append(addKey+">");
				pagingHtml.append(i);
				pagingHtml.append("</a></li>");
			}
		}
		// 다음 block 페이지
		if (totalPage - startPage >= blockPage) {
			if(keyWord==null){//검색 미사용시
				pagingHtml.append("<li class='page-item'><a class='page-link' href="+pageUrl+"?pageNum="+ (endPage + 1) + addKey +">");
			}else{
				pagingHtml.append("<li class='page-item'><a class='page-link' href="+pageUrl+"?keyField="+keyField+"&keyWord="+keyWord+"&pageNum="+ (endPage + 1) + addKey +">");
			}
			pagingHtml.append(">");
			pagingHtml.append("</a></li>");
		}
	}
	
	public StringBuffer getPagingHtml() {
		return pagingHtml; //링크문자열 가져오는 경우
	}
	
	public int getStartCount() {
		return startCount;
	}
	
	public int getEndCount() {
		return endCount;
	}
	
}
