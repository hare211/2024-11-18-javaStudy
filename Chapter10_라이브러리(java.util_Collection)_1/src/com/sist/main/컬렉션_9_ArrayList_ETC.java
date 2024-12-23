package com.sist.main;
import java.util.*;
public class 컬렉션_9_ArrayList_ETC {
	public static void main(String[] args) {
		String[] names = {"홍", "박", "이", "강", "김", "홍"};
		
		List<String> list = Arrays.asList(names);
		// 배열 => List 로 변경
		
		for (String name : list) {
			System.out.println(name);
		}
		
		System.out.println();
		
		Set<String> set = new HashSet<String>(); // 순서가 없기 때문에 Set 으로 변경했을 때는 순차적으로 가져오지 못할 수 있다.
		set.addAll(list);
		
		for (String name : set) {
			System.out.println(name);
		}
	}
}
