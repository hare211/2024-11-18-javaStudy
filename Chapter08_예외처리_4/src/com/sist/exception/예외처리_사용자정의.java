package com.sist.exception;

import java.util.Scanner;

// 사용자 정의 예외처리 => 호출 => throw 
/*
 * 1. 기존에 만들어져 있는 예외처리, 사용자 정의는 찾지 못한다
 * 
 * 데이터형 => 클래스 => new
 * 	int / double / long => 메모리 크기 확인
 * 	class A {
 * 		int a, b;
 * 		double d;
 * 	}
 * 	=> new -> byte 크기 계산
 * 2. 사용자 정의 예외처리 : 기존의 예외처리 클래스 상속
 * 		Exception / Throwable
 * 
 * try ~ catch => 에러 처리 => 정상 수행
 * throws : 선언 => 어떤 에러가 발생하는 지 알려주는 경우 
 * 	=> 라이브러리에서 주로 나온다
 * throw : 직접 예외발생
 * 	=> 사용자 정의 예외처리
 */
class MyException extends Exception {
	public MyException(String msg) {
		super(msg);
	}
}
public class 예외처리_사용자정의 {
	public static void main(String[] args) {
		try {
			Scanner scanner = new Scanner(System.in);
			
			System.out.print("정수 입력 : ");
			int score = scanner.nextInt();
			if (0 > score || score > 100) {
				throw new MyException("잘못된 입력");
			}
		} catch (MyException e) {
			System.out.println(e.getMessage());
		}
	}
}
