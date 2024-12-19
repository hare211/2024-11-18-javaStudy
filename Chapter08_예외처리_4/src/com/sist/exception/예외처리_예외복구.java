package com.sist.exception;
/*
 * CheckException => 컴파일 시
 * 	=> java.io / java.net / java.sql
 * 	=> 반드시 예외처리를 사용
 * 	=> 컴파일 시 예외처리를 작성했는 지 확인
 * UnCheckException => 런타임(실행 시)
 * 	=> java.lang / java.util
 * 		=> Object => clone() => 예외처리가 필요
 * 					-------- 메모리 복제(prototype)
 * 		=> 예외처리를 필요 시에만 작성
 * 
 * 	예외종류 / 형식
 * 	1) 직접처리(예외복구)
 * 		try {
 * 			정상 수행
 * 		} catch (예외 클래스) {
 * 
 * 		} finally { => 생략 가능
 * 
 * 		}
 * 
 * throws : 예상되는 에러를 선언만 한다
 * throw : 고의로 예외를 발생 -> 테스트
 */

public class 예외처리_예외복구 {
	public void display() throws Exception {
		System.out.println(10 / 0);
	}
	static void hello() {
		System.out.println("Good");
	}
	public static void main(String[] args) {
		hello();
		예외처리_예외복구 a = new 예외처리_예외복구();
		try {
			a.display();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		String str = String.join("|", "A", "B", "C", "D");
		System.out.println(str);
		
		String s = "A, B, C, D, E, F";
		String[] st = s.split(", ");
		for (String string : st) {
			System.out.println(string);
		}
		
		String result = String.join("-", st);
		System.out.println(result);
		String[] oo = result.split("-");
		for (String string : oo) {
			System.out.println(string);
		}
		
	}
}
