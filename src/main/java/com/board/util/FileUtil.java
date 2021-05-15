package com.board.util;

import java.io.File;

//파일업로드시 업로드할 경로지정 및 파일의 새 이름으르 부여(공통모듈)

public class FileUtil {
	
	//업로드 및 다운로드 경로
	public static final String UPLOAD_PATH="C:/webtest/8.spring/sou/CRUD/src/main/webapp/upload";
	
	//1.탐색기의 원본파일명만 받아서 처리해주는 정적메서드(ex test.txt)
	public static String rename(String filename) throws Exception {
		if(filename==null) return null;
		//새이름 규칙 -> 시스템날짜+랜덤숫자(0~49) -> 조합  //컴퓨터의 시간을 문자로 만들어 달라는 구문 + Math.random()에 50을 곱하여 반올립하면 0~50사이의 값을 얻을 수 있다.
		String newName=Long.toString(System.currentTimeMillis())+(int)(Math.random()*50);
		System.out.println("newName(난수) -> "+newName);
		return rename(filename,newName);
	}
	
	//2.실제로 새로운 파일명을 변경하는 역할 -> 확장자 구분 -> 변경된 이름만 구하기
	//ex) testkimaaa.txt(뒤에서 검색) -> 123aaa.TXT
	public static String rename(String filename,String newName) throws Exception {
		if(filename==null) return null;
		//확장자를 구하기(뒤에서부터 찾기 -> 앞에서 부터 찾기엔 파일명이 길이가 제각각이라서)
		//indexOf(앞에서 찾는 메서드), lastIndexOf(뒤에서 찾는 메서드)
		int idx=filename.lastIndexOf("."); //못찾으면 -1을 리턴
		String extention=""; //확장자 저장
		String newFileName=""; //새 파일명을 저장할 변수
		if(idx!=-1) { //확장자를 찾았다면
			extention=filename.substring(idx); //idx부터 문자열 끝까지(확장자)
			System.out.println("extention -> "+extention);
		}
		//새파일명
		int newIdx=newName.lastIndexOf(".");
		if(newIdx!=-1) {
			//0은 포함 newIdx 바로 앞의 문자열까지가 실제로 변경된 파일명
			newName=newName.substring(0,newIdx);
			System.out.println("newName(변경된 파일명) -> "+newName);
		}
		//확장자가 대문자라면 소문자로 바꿔서
		//newName(변경된 이름만)+extention(탐색기의 원래파일의 확장자만)
		newFileName=newName+extention.toLowerCase(); 
		System.out.println("newFileName -> "+newFileName);
		return newFileName;	
	}
	//글수정 -> 업로드된 파일도 수정 -> 기존 업로드된 파일 삭제 -> 새로 업로드됨
	//파일삭제 -> 수정할 목적
	public static void removeFile(String filename) {
		File file=new File(UPLOAD_PATH, filename); //1.경로(업로드할 위치), 2.파일명
		if(file.exists()) file.delete(); //이 경로에 파일이 존재한다면 삭제하라
	}
	
}
