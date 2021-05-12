package com.board.command;

import org.springframework.web.multipart.MultipartFile;

public class FileCommand {

	private int filenum; //파일번호
	private int postnum; //게시글번호
	private String originalname; //원본파일명
	private String savename; //저장파일명
	private int filesize; //파일크기
	private MultipartFile upload; //업로드할때 필요로 하는 객체명
	
	public int getFilenum() {
		return filenum;
	}
	public void setFilenum(int filenum) {
		this.filenum = filenum;
	}
	public int getPostnum() {
		return postnum;
	}
	public void setPostnum(int postnum) {
		this.postnum = postnum;
	}
	public String getOriginalname() {
		return originalname;
	}
	public void setOriginalname(String originalname) {
		this.originalname = convert(originalname);
	}
	public String getSavename() {
		return savename;
	}
	public void setSavename(String savename) {
		this.savename = convert(savename);
	}
	public int getFilesize() {
		return filesize;
	}
	public void setFilesize(int filesize) {
		this.filesize = filesize;
	}
	public MultipartFile getUpload() {
		return upload;
	}
	public void setUpload(MultipartFile upload) {
		this.upload = upload;
	}
	
	//모든 DTO에 static정적메서드를 작성 -> 적용( (, ), <, > 을 입력받지 못하게 코딩)
	//이 메서드는 현재 있는 클래스에서만 사용이 가능하도록 성정  -> private
	private static String convert(String name) {
		if(name!=null){
		//System.out.println("name->"+name);
		//입력받은 문자열중에서 자바스크립트 구문을 실행시킬 수 있는 특수기호를 입력x(<,>)
		// -> replaceAll(1.변경전 문자열, 2.변경후 문자열)
			name=name.replaceAll("<", "&lt"); //< 가 입력되면 바꿔준다
			name=name.replaceAll(">", "&gt"); //>가 입력되면 바꿔준다
			//추가 eval( 을 입력받지 못하게 해줘야함  " " or ' ')
			name=name.replaceAll("\\(","&#40"); //괄호 (가 입력되면 바꿔준다
			name=name.replaceAll("\\)","&#41"); //괄호 )가 입력되면 바꿔준다
			//"test" 'test'
			name=name.replaceAll("\"","&quot"); //큰따옴표 " 가 입력되면 바꿔준다
			name=name.replaceAll("\'","&apos"); //작은따옴표 ' 가 입력되면 바꿔준다
			//System.out.println("name->"+name);
		} else {
			return null; //입력을 하지 않았다면 더 이상 실행x
		}
		return name;
	}	
}
