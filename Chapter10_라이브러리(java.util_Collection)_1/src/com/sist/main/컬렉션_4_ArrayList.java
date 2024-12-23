package com.sist.main;
import java.util.*;
public class 컬렉션_4_ArrayList {
	public static void main(String[] args) {
		/* 동기, 비동기
		 * List => 인터페이스
		 * ArrayList => 데이터베이스(오라클)
		 * 	=> 단순한 목록
		 * 	=> 크롤링 데이터
		 * Vector => 네트워크
		 * 	=> 채팅 => 사용자 정보 저장
		 * LinkedList
		 * 	=> 게시판 / 덧글
		 * ---------- 동일한 메서드
		 */
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		
		for (int i : list) {
			System.out.println(i);
		}
		
		System.out.println();
		
		LinkedList<Integer> vec = new LinkedList<Integer>();
		vec.add(1);
		vec.add(2);
		vec.add(3);
		vec.add(4);
		vec.add(5);
		
		for (int i : vec) {
			System.out.println(i);
		}
		/*
		 * add() / remove() / set() / get() / size() / isEmpty() / clear()
		 */
	}
}
