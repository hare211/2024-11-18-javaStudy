package com.sist.main;

import java.util.HashSet;
import java.util.Iterator;

public class 컬렉션_7_Set_2 {
	public static void main(String[] args) {
		HashSet set = new HashSet(); // => 일반 클래스
		// Set set = new HashSet() => 인터페이스
		// 1. 저장 => add()
		// => 콤보박스 => 부서명 / 장르 / 검색...
		set.add("red");
		set.add("blue");
		set.add("green");
		set.add("yellow");
		set.add("pink");
		set.add("red");
		set.add("blue");
		set.add("green");
		set.add("yellow");
		set.add("pink");
		set.add("red");
		set.add("blue");
		set.add("green");
		set.add("yellow");
		set.add("pink");
		// 실제 저장은 5 개만 저장됨
		System.out.println("저장 개수 : " + set.size());
		
		// 저장된 데이터 출력
		Iterator<String> iter = set.iterator();
//		while (iter.hasNext()) {
//			System.out.println(iter.next());
//		}
		// 람다식
		set.forEach(color -> System.out.println(color));
//		for (Object color : set) {
//			System.out.println(color);
//		}
		
		System.out.println("==== 삭제 ====");
		
		set.remove("yellow");
		System.out.println("저장 개수 : " + set.size());
		for (Object color : set) {
			System.out.println(color);
		}
		
		System.out.println("==== 전체 삭제 ====");
		set.clear();
		System.out.println("저장 개수 : " + set.size());
		for (Object color : set) {
			System.out.println(color);
		}
		
		if (set.isEmpty()) {
			System.out.println("장바구니가 비어있습니다.");
		} else {
			System.out.println("장바구니에 상품이 있습니다."
					+ "");
		}
		
		
		
	}
}
