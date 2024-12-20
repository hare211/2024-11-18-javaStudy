package com.sist.util;
/*
 * java.lang : 자바 기본이 되는 클래스의 집합
 * --------- Object / String / StringBuffer
 * 			 Math / Wrapper(Integer / Double / Boolean)
 * java.util : 프로그램에서 많이 사용되는 유용한 클래스의 집합
 * 	=> 반드시 import 사용
 * 	1) 날짜
 * 		Date => Calendar
 * 	2) 문자열 분리
 * 		StringTokenizer : split 은 정규식 사용해야 함
 * 	3) 랜덤
 * 		Random
 * 	4) Collection => 자료 구조 => 배열(X)
 * 		Collection
 * 			|
 * 	---------------------------------------------- 동기와 비동기의 차이
 * 	|						|					|
 * 	List					Set					Map
 * 	|						|					|
 * 	ArrayList				HashSet / TreeSet	HashMap / HashTable
 * 	LinkedList - Queue
 * 	Vector
 * java.io : 입출력(메모리 / 네트워크 / 파일)
 * java.net : 네트워크(Socket, URL)
 * java.text : 변환(문자열, 날짜, 숫자)
 * java.lang.reflext : 정규식
 * -----------------------------------------------------
 * 웹 / 오픈 소스(외부 라이브러리)
 * 		org / com
 */
import java.util.*;
// Scanner(X)
public class 라이브러리_1 {
	public static void main(String[] args) {
		Random r = new Random();
		/*
		 * r.nextInt() => int 전 범위
		 * r.nextInt(100) => 0 ~ 99
		 * Math.random() (X)
		 */
		//int i = r.nextInt(100) + 1; // 1 ~ 100
		//System.out.println(i);
		// 게임, 예약일
		int[] com = new int[6];
		for (int i = 0; i < com.length; i++) {
			com[i] = r.nextInt(45) + 1;
			for (int j = 0; j < i; j++) {
				if (com[i] == com[j]) {
					i--;
					break;
				}
			}
		}
		// 정렬
		Arrays.sort(com);
		// SQL 명령어
		// ORDER BY no DESC(ASC), DESC -> 내림차순 / ASC -> 오름차순 (기본값 오름차순)
		// 출력
		for (int i : com) { // 오름차순
			System.out.print(i + " ");
		}
		System.out.println();
		
		for (int i = com.length - 1; i >= 0; i--) { // 내림차순
			System.out.print(com[i] + " ");
		}
	}
}

// 
