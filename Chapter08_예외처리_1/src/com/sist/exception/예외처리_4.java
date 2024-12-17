package com.sist.exception;

import java.util.Scanner;
/*
 * UnCheck
 * -------
 * 		Exception => 모든 예외처리
 * 			|
 * 		RuntimeException => 아래 범위 모두 포함
 * 			|
 * 	-----------------------
 *  |
 *  ArrayIndexOutOfBoundsException => 배열 범위
 *  ArithmeticException => 0 으로 나누는 경우
 *  NumberFormatException => 정수 변환 X
 *  ClassCastException => 형변환 X
 *  
 *  유의점
 *  try {
 *  	int a = 10;
 *  } catch (Exception ex) {
 *  	int b = 10;
 *  }
 *  a, b => 지역 변수 -> 블록 내에서만 생존
 *  
 */

public class 예외처리_4 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int[] arr = new int[2]; // 배열 범위 초과, a / 0
		
		try {
			
			System.out.print("첫 번째 정수 : ");
			String s1 = scanner.next();
			
			System.out.print("두 번째 정수 : ");
			String s2 = scanner.next();
			
			arr[0] = Integer.parseInt(s1);
			arr[1] = Integer.parseInt(s2);
			
			int result = arr[0] / arr[1];
			System.out.println("result = " + result);
			
		} catch (ArrayIndexOutOfBoundsException ex) { // 변수명.getMessage() -> 에러 내용 출력, 변수명.printStackTrace() -> 에러 라인 출력
			System.out.println("배열 범위 초과");
		} catch (ArithmeticException ex) {
			System.out.println("0 으로 나눌 수 없다.");
		} catch (NumberFormatException ex) {
			System.out.println("정수 변환 에러");
		} catch (RuntimeException ex) { // 제일 큰 예외를 맨 아래로 / 상위 클래스일수록 맨 아래로
			System.out.println("Runtime Error");
		} catch (Exception ex) {
			System.out.println("Exception Error");
		} catch (Throwable ex) {
			System.out.println("Throwable Error");
		}
		System.out.println("정상 수행");
	}
}
