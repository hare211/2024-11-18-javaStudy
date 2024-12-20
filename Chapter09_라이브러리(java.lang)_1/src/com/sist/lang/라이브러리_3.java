package com.sist.lang;
/*
 *	Wrapper
 * 		: 기본형 데이터를 클래스화 -> 사용 용이
 * 		byte => Byte
 * 		short => Short
 * 		int => Integer
 * 		long => Long
 * 		float => Float
 * 		double => Double
 * 		char => Character
 * 		boolean => Boolean
 * 
 * 	=> 변환(문자열)
 * 	=> 데이터형의 통일화 : 제네릭스
 * 		<Class 형>
 * 		=> <int> (X) => <Integer> -> 모든 데이터형을 정수형으로
 * 	=> 기능 많음
 * 	=> 일반 기본형과 호환
 * 		Integer i = 10 / int i = 10
 * 
 * 		Integer i = (int) 10.5;
 */

import java.util.Scanner;

public class 라이브러리_3 {
	public static void main(String[] args) {
		// 1. 진법 변환 2, 8, 16
		Scanner scanner = new Scanner(System.in);
		System.out.print("정수 입력 : ");
		Integer i = scanner.nextInt();
		
		System.out.println(Integer.toOctalString(i)); // 8 진법 변환
		System.out.println(Integer.toHexString(i)); // 16 진법 변환
		System.out.println(Integer.toBinaryString(i)); // 2 진법 변환
		
		// 2. 범위 : 데이터형 범위
		System.out.println(Integer.MIN_VALUE);
		System.out.println(Integer.MAX_VALUE);
		
		// 3. 변환 : 문자열 => 정수형
		System.out.print("첫 번째 문자열 입력 : ");
		String s1 = scanner.next();
		System.out.print("두 번째 문자열 입력 : ");
		String s2 = scanner.next();
		
		System.out.println(s1 + s2); // 문자열로 결합 됨
		System.out.println(Integer.parseInt(s1) + Integer.parseInt(s2)); // 정수형으로 결합
	}
}
