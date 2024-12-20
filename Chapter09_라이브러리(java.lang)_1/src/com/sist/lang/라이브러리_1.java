package com.sist.lang;

import java.util.Random;

/*
 * java.lang
 * 	=> Object / String / StringBuffer / Math / Wrapper
 * java.util
 * 	=> Random / StringTokenizer / Date / Calendar
 * 	=> Collection(List, Map, Set)
 * java.io
 * 	=> File / FileInputStream / FileOutputStream / FileReader / FileWriter / BufferReader / BufferedInputStream
 * 	   BufferedOutputStream / ObjectOutputStream / ObjectInputStream
 * java.sql
 * 	=> Connection / statement / ResultSet
 * 외부 라이브러리(웹)
 * 	=> 파싱(XML, HTML, JSON, CSV)
 * 
 * StringBuffer : 임시로 문자열을 저장해서 => 한 번에 출력
 * 	=> append() => 문자열 결합
 * Math
 * 	=> random() : 난수 발생 -> 0.0 ~ 0.99
 * 	=> ceil() : 올림 함수 => 총 페이지
 * Wrapper
 * 	=> 데이터를 쉽게 다루기 위해서 기본형 데이터들을 클래스화한 클래스
 * 	=> 제네릭스<> : 데이터형의 통일화 => 형변환 없이 사용
 * 		=> Collection
 * 	=> int -> Integer : 문자열을 정수형 변환
 * 				Integer.parseInt("10")
 * 	   long -> Long : 문자열을 long 으로 변경
 * 				Long.parseLong("")
 * 	   double -> Double : 문자열을 실수로 변경
 * 				Double.parseDouble()
 * 	   boolean -> Boolean : 문자열을 논리형으로 변경
 * 				Boolean.parseBoolean()
 * -----------------------------------------------
 * 		혼합이 가능
 * 		Interger i = 100; => 오토 박싱
 * 		int ii = i => 언박싱
 */
public class 라이브러리_1 {
	
	public static void main(String[] args) {
		int count = 135; // 
		// SELECT CIL(COUNT(*)/10.0) FROM emp; => 보통 오라클에서 코딩
		int totalPage = (int) (Math.ceil(count / 10.0)); // 빈도 수 낮음
		/*
		 * 게시판
		 * 10
		 * 9
		 * 8
		 * ...
		 * => 자바에서 할 수도 있음
		 */
		System.out.println(totalPage);
		// Random => nextInt(100) + 1
		Random r = new Random();
		
		System.out.println(r.nextInt(100));
	}

}
























