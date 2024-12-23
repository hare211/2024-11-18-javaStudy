package com.sist.main;
/*
 * JOIN => 교집합
 * UNION => 합집합
 * MINUS => 차집합
 * 
 * Collection : 배열의 단점을 보완
 * 				고정 -> 가변
 * 				=> 모든 개발자가 동일한 메서드를 이용 => 표준화
 * 				=> 가독성 / 처리 기능이 편리하다
 * List : ArrayList / Vector / LinkedList
 * 	=> 순서가 있다(인덱스)
 * 	=> 데이터의 중복 허용
 * Set : HashSet / TreeSet
 * 	=> 순서가 없다
 * 	=> 데이터 중복 허용X
 * 	=> 중복 제거 
 * Map : HashMap / Hashtable
 * 	=> 두 개 동시에 저장
 * 		(키, 값)
 * 	=> 키는 중복 X, 값은 중복 O
 * 	=> 웹 => 클래스 관리자
 * 	=>	 HttpsServletRequest
 * 		 HttpsServletResponse
 * 		 HttpSession
 * 		 Cookie
 * 		---------------------- Map
 * 		=> 스프링 / MyBatis
 * 
 * ArrayList
 * 	=> 복사
 * 		addAll()
 * 	=> 순차적으로 출력하는 방법
 * 		iterator()
 * 		listIterator
 * 		=> 출력이 어려운 경우
 * 	=> Set <=> 복사가 가능
 * 
 * 	=> ArrayList
 * 		단순한 목록형 데이터를 관리하기 용이
 * 		---------------- 데이터베이스(오라클)
 * 		| 추가 / 삭제 / 용이
 * 		  ---------------
 * 		  => LinkedList
 */
import java.util.*;
public class ArrayList_정리 {
	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<String>();
		list.add("홍씨");
		list.add("박씨");
		list.add("청이");
		list.add("강씨");
		list.add("청이");
		list.add("홍씨");
		list.add("박씨");
		// 중복된 데이터 첨부 가능
		
		for (String s : list) {
			System.out.println(s);
		}
		System.out.println("===== 복사 =====");
//		ArrayList<String> list2 = new ArrayList<String>();
//		
//		list2.addAll(list);
//		
//		for (String s : list2) {
//			System.out.println(s);
//		}
		// => 코테
		Set set = new HashSet();
		set.addAll(list);
		
		ArrayList<String> list2 = new ArrayList<String>();
		list2.addAll(set);
		// 중복을 허용하지 않는다 => 순차적(X) 관리하기 어렵다
		// Set (중복 제거) => ArrayList 를 이동 => 중복이 제거된 ArrayList
		for (String s : list2) {
			System.out.println(s);
		}
	}
}

















