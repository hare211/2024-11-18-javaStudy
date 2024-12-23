package com.sist.main;

import java.util.Comparator;
import java.util.Map;
import java.util.Random;
import java.util.TreeSet;

// 제네릭 => Collection 전체에서 사용이 가능
// List / Set / Map 모두 사용 가능
/*
 * List<String> => ArrayList(Vector, LinkedList)
 * Set<String> => HashSet(중복 제거) / TreeSet(검색)
 * 	=> add()
 * 	=> addAll() => 다른 Collection 데이터를 첨부
 * 	=> clear()
 * 	=> isEmpty()
 * 	=> size()
 * 	=> iterator()
 * Map<String, String> => Key, Value 
 * 	=> HashMap / Hashtable
 * 	   -------	 --------
 * 		비동기		동기 		=> 동기 -> 순차적, 비동기 -> 병렬적
 * 		  |			 |
 * 		 속도			안전성 => 데드락
 */

public class 컬렉션_8_Set_3 {
	public static void main(String[] args) {
		TreeSet<Integer> set = new TreeSet<Integer>(); // -> 기본적으로 오름차순으로 정렬 / (Comparator.reverseOrder()) -> 내림차순
		Random r = new Random();
		
		for (int i = 0; i < 10; i++) {
			set.add(r.nextInt(101)); // 0 ~ 100 정수
		}
		
		
		// 출력
		set.forEach(score -> System.out.print(score + " "));
		
		System.out.println();
		System.out.println("==== 60점 이하 ====");
		System.out.println(set.headSet(60)); // 지정된 요소보다 작은 값들로 이루어진 부분 집합을 반환
		/*
		 * 60 -> 반한될 집합의 상한(기준) 값.
		 * inclusive : true 일 경우, 상한 값을 포함. false 일 경우 포함 X
		 * 반환된 집합은 오름차순 정렬 상태를 유지
		 * 반환된 부분 집합은 원래 TreeSet 과 연동되어 동기화
		 */
		
		
		System.out.println("==== 60점 이상 ====");
		System.out.println(set.tailSet(60)); 
		
		
		
	}
}
































