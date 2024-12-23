package com.sist.main;
import java.util.*;

public class 컬렉션_5_List {
	public static void main(String[] args) {
		List<String> names = new ArrayList<String>();
		
		names = new LinkedList<String>();
		
		names = new Vector<String>();
		
		// 하나의 객체로 ArrayList, LinkedList, Vector 모두 사용하는 법
		// 인터페이스 => MyBatis / JPA => 리턴형 => List
		// 데이터를 모아서 순차적으로 접근 => 크롤링
		
		List<String> list = new ArrayList<String>();
		list.add("Java");
		list.add("Oracle");
		list.add("HTML / CSS");
		list.add("JavaScript");
		list.add("JSP"); // Jquery / Ajax
		list.add("Spring"); // VueJS
		list.add("Python"); // Numpy / Pands / MatplotLib
		list.add("ElasticSearch");
		list.add("AWS"); // Linux
		
		for (String subject : list) {
			System.out.println(subject);
		}
		for (String subject : list) {
			System.out.println(subject);
		}
		System.out.println("================");
		// 데이터를 모아서 순차적으로 출력
//		Iterator<String> iter = list.iterator();
//		
//		while (iter.hasNext()) { // 데이터를 가지고 있는 동안
//			System.out.println(iter.next()); // next() 데이터를 읽어온다
//		}
//		while (iter.hasNext()) { // StringTokenizer 와 똑같은 구조? 토큰
//			System.out.println(iter.next()); 
//		}
		
		ListIterator<String> iter = list.listIterator();
		while (iter.hasNext()) {
			System.out.println(iter.next());
		}
		System.out.println("==================");
		
		while (iter.hasPrevious()) {
			System.out.println(iter.previous());
		}
		System.out.println("==================");
		
		while (iter.hasNext()) {
			System.out.println(iter.next());
		}

	}
}































