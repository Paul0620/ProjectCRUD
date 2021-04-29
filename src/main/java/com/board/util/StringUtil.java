package com.board.util;

//형식 유지 태그 때문에 요즘에는 잘 사용하지 않음.
//글내용 보기 <textarea><pre><%=content%></pre></textarea> 
//<pre>(있는 그대로 저장) 태그 때문에 아래 메서드를 사용할 일이 거의 없음 
public class StringUtil {
	public static String parseBr(String msg){ //정적 메서드
		
		if(msg == null) return null;
		// \r\n (enter) -> <br>로 변경해서 다시 반환
		//줄바꿈 기능을 위해서 쓰던 메서드
		return msg.replace("\r\n", "<br>")
                  .replace("\n", "<br>");
	}
}
