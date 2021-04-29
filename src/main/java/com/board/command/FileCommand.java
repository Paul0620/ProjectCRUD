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
		this.originalname = originalname;
	}
	public String getSavename() {
		return savename;
	}
	public void setSavename(String savename) {
		this.savename = savename;
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
	
}
