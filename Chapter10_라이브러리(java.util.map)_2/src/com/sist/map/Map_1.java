package com.sist.map;
/*
 * => 중복 데이터 => 목록 => ArrayList
 * 	  웹에서 검색 데이터 / 전체 목록
 * 	  ----------------------------> 데이터를 모아서 브라우저
 * => 중복 데이터를 만든다 => HashSet
 * 	  ----------------------------> 웹 채팅
 * => 두 개를 동시에 저장(key, value) => HashMap
 * 	  ----------------------------> 방문한 맛집 / 장바구니 / 아이디 저장...
 * 
 * Map (인터페이스)
 * ---
 * 			Map
 * 			 |
 * 	----------------------
 * 	|					 |
 * HashMap => 비동기	  Hashtable => 동기 => 쓰레드 기반
 * 	=> 웹 : AJAX / VUE / React
 * 동기 => 한 개가 완전히 저장 후에 다른 데이터를 저장 -> 순차적으로(속도가 늦다, 안전성 높다)
 * 비동기 => 동시에 저장(속도가 빠르다)
 * 
 * 특징)
 * 		두 개를 동시에 저장
 * 		key / value
 * 		=> key 중복 X
 * 		=> value 중복 O
 * 		=> 예) ("id", "admin")
 * 		=> 주요사용처
 * 			웹 => 90% Map 형식 사용
 * 			--
 * 			사용자가 보내준 데이터 정보
 * 			HttpServletRequest
 * 				=> request.setAttribute("key", "Object")
 * 					=> ?id=admin
 * 			브라우저로 보내는 정보
 * 			HttpServletResponse
 * 				=> reponse.setAttribute("key", "Object")
 * 			브라우저에 저장하는 정보
 * 			Cookie
 * 				new Cookie(key, value)
 * 			서버에 저장하는 정보
 * 			HttpSession
 * 				session.setAttibute("if", "hong")
 * 		=> 스프링
 * 			key, 객체 => Factory 패턴
 * 			=> 클래스 관리자(생명주기)
 * 		=> MyBatis
 * 			key, SQL
 * 	=> 주요 메서드
 * 		clear() : 전체 삭제
 * 		get() : 데이터 읽기 => get(key)
 * 		put() : 데이터 지정
 * 		isEmpty : 데이터 존재 여부 확인
 * 		size() : 저장 개수 확인
 * 		keySet() : 키 값 전체를 가져온다
 *  	valueSet() : 값 전체를 가져온다
 * 
 */
// 간단한 장바구니
import java.util.*;
public class Map_1 {
	public static void main(String[] args) {
		String[] data = {"사과", "배", "수박", "귤", "참외", "메론", "바나나"};
		
		Map<String, Integer> cart = new HashMap<String, Integer>();
		
		Scanner scanner = new Scanner(System.in);
		
		while (true) {
			System.out.println("==== 과일 목록 ====");
			System.out.println("1. 사과");
			System.out.println("2. 배");
			System.out.println("3. 수박");
			System.out.println("4. 귤");
			System.out.println("5. 참외");
			System.out.println("6. 메론");
			System.out.println("7. 바나나");
			System.out.println("9. 종료");
			System.out.println("===============");
			
			System.out.print("과일 선택 : ");
			int f = scanner.nextInt();
			if (f == 9) {
				break;
			}
			cart.put("f_" + f, f);
			//		  ------- 중복이 안되게 만든다
		}
		// 장바구니 종료
		if (cart.isEmpty()) {
			System.out.println("장바구니가 비어있습니다.");
		} else {
			System.out.println("과일 구매 총 " + cart.size() + "건");
			for (String key : cart.keySet()) { // cart.keySet() 리턴형 Set, 등록된 모든 key 를 읽어온다
				// keySet => 등록된 모든 키를 읽어 온다
				int value = cart.get(key);
				System.out.println(data[value - 1]);
			}
		}
		
	}
}















