package com.sist.main;

import java.util.ArrayList;

/*
 * 상속 : 이미 만들어진 클래스를 재사용
 * 		---------------- 기존의 클래스(사용자 정의, 라이브러리)
 * 포함 : 재사용
 * 		상속 / 포함
 * 		--	  --
 * 			  | 있는 그대로 사용
 * 		| 변경해서 사용
 * 		| 상속이 안되는 클래스 : final class
 * 							-----------
 * 							String, System, Scanner...
 * 	상속 : 상속을 내리는 클래스 : 공통으로 적용 되는 내용
 * 		  상속을 받는 클래스
 * 			=> 유지보수 용이
 * 			=> 반복 제거
 * 			=> 관리 용이
 * 			=> 속도가 느리다
 * 			=> 변경이 어렵다
 * 			=> 소스를 볼 수 없기 때문에 가독성이 낮다
 * 			=> 1) 가독성 2) 최적화
 * 			=> 가급적이면 상속을 하지 않는다
 * 				=> 웹, 모바일
 * 	=> 클래스를 상속 받아서 => 새로운 클래스(기존의 클래스 + 새로운 추가)
 * 		예)
 * 			묻고 답하기
 * 				글쓰기
 * 				상세보기
 * 			답변 게시판
 * 			자유게시판
 * 			자료실
 */
import java.util.*;
public class 재사용_3 {
	public static void main(String[] args) {
		//ArrayList list = new ArrayList();
		ArrayList<String> list = new ArrayList<String>();
		list.add("홍길동");
		
		//String name = (String)list.get(0);
		
		Object name = list.get(0);
	}
}
