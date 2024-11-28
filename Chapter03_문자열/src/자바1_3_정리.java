/*
 * 	1. 변수 = 한 개만 저장하는 공간, 변경이 가능
 * 			=> 1. 메모리 저장, 2. 값 읽기, 3. 수정이 가능
 * 	   ---
 * 		1) 지역변수 : 메소드 안에서 선언되는 변수
 * 		2) 멤버변수
 * 		3) 공유변수
 * 		------------------------------------------------
 * 		=> 변수를 저장하기 위해서는 반드시 필요한 내용
 * 			-------------------------------
 * 			메모리 크기 결정 / 클래스 (JVM 에서 크기를 모른다)
 * 								 ------------------
 * 								 | new => 새로운 메모리(객체) 생성
 * 			기본형 
 * 			----
 * 			정수 : byte(1 byte), int(4 byte), long(8 byte)
 * 					-128 ~ 127	-21억 ~ 21억
 * 			실수 : double(8 byte) => 소수점 15 자리 이상
 * 			논리 : boolean(1 byte) => true / false
 * 			문자 : char(2 byte)	=> 0 ~ 65535
 * 			-------------
 * 			참조형 : 배열 / 클래스 (String, Integer, ArrayList)
 * 				오라클 : Connection / Statement / ResultSet
 * 			*** 변경이 되는 값
 * 				누적 / 루프
 * 				*** 가독성
 * 					i / j => a / b, m / n
 * 				입력값
 * 				난수값
 * 		메모리 저장
 * 		------------------------------------------------
 * 		 MethodArea : Method / static (공유변수)
 * 		------------------------------------------------
 * 		 Stack : 메모리 자체에서 관리 => 지역변수
 * 					{}이 종료가 된 경우 사라진다
 * 		------------------------------------------------
 * 		 Heap : 실제 데이터 공간 : 클래스 / 배열
 * 				자동으로 해제되지 않는다 => 개발자가 처리
 * 				new / delete => 가비지 컬렉션
 * 								자동 메모리 회수
 * 				 => 메모리 저장
 * 					-------- 확인 int malloc() => new
 * 							 해제 free() => delete
 * 		------------------------------------------------
 * 
 * 		=> 사용자 요청에 따른 데이터 처리
 * 		1) 연산자
 * 			단항연산자 (++, --, !, (type))
 * 			이항연산자 (+, -, *, /, %, => ==, !=, <, >, <=, >=, &&, ||, =, +=, -=)
 * 			삼항연산자 ( ? : )
 * 		2) 제어문
 * 			if, if ~ else
 * 			for, while
 * 			break               
 * 		------- 묶어서 처리 => 메소드 => 중복 제거
 * 		1. 입력
 * 		2. 처리 => 세분화
 * 		3. 출력
 * 		------------------------------------------------
*/

import java.util.Scanner;



public class 자바1_3_정리 {
	// 멤버 변수 => 자동 초기화 / int a; => a = 0
	public static int userInput(String s) {
		Scanner scanner = new Scanner(System.in);
		System.out.print(s + "입력 : ");
		return scanner.nextInt();
	}
	public static void main(String[] args) {
		// 지역 변수 => 자동 초기화가 안됨 => int a; => error
/*		String s1 = "Hello";
		String s2 = "Hello"; // 문자열 자체가 메모리 주소
		String s3 = new String("Hello");
		if (s1 == s2) {
			System.out.println("동일"); */

		/* Scanner scanner = new Scanner(System.in);
		System.out.print("년도 입력 : ");
		int year = scanner.nextInt();
		
		System.out.print("월 입력 : ");
		int month = scanner.nextInt();
		
		System.out.print("일 입력 : ");
		int day = scanner.nextInt();
		*/
		/*
		int year = userInput("년도");
		int month = userInput("월");
		int day = userInput("일");
		
		System.out.println(year + "년 " + month + "월 " + day + "일");
		*/
		
		String s = "";
		
		System.out.println(s.compareTo("dwq"));
				
		System.out.println(s.equals("d"));
		
		
		


	}

}
































































