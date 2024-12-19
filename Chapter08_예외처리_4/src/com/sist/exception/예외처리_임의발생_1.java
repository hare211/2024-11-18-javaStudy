package com.sist.exception;
// 임의 발생은 한 개만 사용 => if 문

import java.util.Scanner;
/*
 * 웹, 윈도우 -> 무조건 String
 * a.jsp?no=1
 * 
 * public void display(String no) {
 * 		정수형 변환 Integer.parseInt(no);
 * }
 */
public class 예외처리_임의발생_1 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		try {
			System.out.print("국어 점수 입력 : ");
			int kor = scanner.nextInt();
			
			if (0 > kor || kor > 100) {
				// 잘못된 입력 => 직접 처리
				// catch 를 불러올 수 있다
				throw new IllegalArgumentException("0 이상 100 이하만 입력하세요.");
				// throw => 필요 시 catch 를 호출할 수 있다
				// throw 아래는 코딩 불가
			}
			
		} catch (IllegalArgumentException e) {
			// 매개 변수에 전송값이 다른 경우
			//e.printStackTrace();
			System.out.println(e.getMessage());
			
		}
	}
}
