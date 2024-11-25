/*
 * 	자바에서 지원하는 제어문 => 54 page ~ 83 page
 * 	** 변수 / 연산자 / 제어문 => 기본
 * 	** 메소드 / 객체지향 프로그램
 * 	** 라이브러리 => 조립
 * 
 * 	제어문 => 연산자가 응용
 * 	---- 배열
 * 		 --- 메소드
 * 			 ---- 클래스 
 * 	1.	제어문
 * 		조건문 : 사용자 요청에 맞게 처리 => 필요하면 수행 => 건너 뛴다
 * 				================
 * 				검색, 상세보기, 로그인, ID 중복체크...
 * 			= 단일 조건문 : 독립적으로 실행
 * 			  형식)
 * 					if (조건문) { => 조건문에 사용되는 연산자
 * 									=================
 * 									부정연산자(!), 비교연산자(==, !=, <, >, <=, >=)
 * 									논리연산자(&&, ||) => 반드시 true / false
 * 							조건문이 true 일 때 실행하는 문장
 * 						}
 * 						=> 조건이 true 면 문장 실행, false 가 되면 건너 뛴다
 * 						=> 54 page
 * 
 * 						55 page 중첩 if 문
 * 						if (조건문) { ==> 조건이 모두 true 일 때만 수행
 * 							if (조건문) {
 * 								조건 true 일 때 수행
 * 							}
 * 						}
 * 							중첩 조건문 대신 사용 ==> && (소스를 줄일 수 있다)
 * 							=> 특별한 경우에만 사용
 * 								=> 메뉴 조절
 * 									if (로그인이 되어 있다면) {
 * 										if (user) {
 * 											마이 페이지
 * 										}
 * 										if (admin) {
 * 											관리자 메뉴
 * 										}
 * 									}
 * 							==> if (조건 && 조건) {
 * 				
 * 								}
 * 
 * 			= 선택조건문 : true / false 를 나눠서 따로 처리 => 56 page
 * 					=> 가장 많이 사용되는 조건문
 * 					=> 웹 : 모든 내용이 브라우저로 전송
 * 							======= true / false
 * 							아이디 중복체크 / 검색 / 에러발생 ~ 에러미발생
 * 				형식)
 * 					if (조건) {
 * 						조건이 true 일 때 처리
 * 					} else {
 * 							조건이 false 일 때 처리
 * 			    	}
 * 					
 * 			= 다중 조건문 : 메뉴처리, 키보드 처리, 별점
 * 				여러 개의 조건문을 사용하지만 한 개의 조건만 수행
 * 				형식)
 * 					if (조건) {
 * 						조건 true 일 때 수행 ==> 종료
 * 						조건 false
 * 							  | 아래로 이동
 * 					} else if (조건) {
 * 						조건 true 일 때 수행 ==> 종료
 * 						조건 false 
 * 							  | 아래로 이동
 * 					} else if (조건) {
 * 						조건 true 일 때 수행 ==> 종료
 * 						조건 false
 * 							  | 아래로 이동
 * 					} else {
 * 						생략이 가능
 * 						위 모든 조건이 false 일 때 무조건 수행되는 문장
 * 					}
 * 

 * 
 * 
 * 		선택문
 * 		반복문
 * 		반복제어문
*/
// 다중 조건문 예제
// => 사용자로부터 정수 2 개 연산자 (+, -, *, /)
//										-- 중첩 조건문 => 나누기 값이 0 이 
// 프로그램은 비정상 종료가 없는 프로그램, 사전에 오류를 방지
// 웹 => 비정상 종료를 방지 => 에러가 발생 => 건너 뛴다 (다음 문장으로)
// => 8장 예외처리
import java.util.Scanner;
// 자바에서 지원하는 라이브러리 클래스를 가지고 올 때 import
public class 자바제어문 {
	public static void main(String[] args) {
		// 키보드 입력을 받아서 변수에 저장 => Scanner
		Scanner scanner = new Scanner(System.in);
		// 자바에서 클래스를 저장할 때 => 반드시 new 를 동적 메모리 할당
		// malloc(클래스의 크기) => 메모리를 만들어 준다
		// -----------------  => 승격 : new
		// free() => delete : 자바 => 자동 메모리 회수 : '가비지 컬렉션'
		System.out.print("첫 번째 정수 입력 : ");
		int num1 = scanner.nextInt();
		
		System.out.print("두 번째 정수 입력 : ");
		int num2 = scanner.nextInt();
		
		System.out.print("연산자 입력(+,-, *, /) : ");
		char op = scanner.next().charAt(0);
		// 맨 처음 문자를 읽는 경우에 사용 = charAt()
		// 문자열은 0 번 부터 시작
		System.out.println("num1 = " + num1);
		System.out.println("num2 = " + num2);
		System.out.println("op = " + op);
		
		// 연산처리 => 4 개 경우의 수 => 한 번만 실행 => 다중 조건문
		if (op == '+') {
			System.out.println(num1 + " + " + num2 + " = " + (num1 + num2));
		} else if (op == '-') {
			System.out.println(num1 + " - " + num2 + " = " + (num1 - num2));
		} else if (op == '*') {
			System.out.println(num1 + " * " + num2 + " = " + (num1 * num2));
		} else if (op == '/') {
			System.out.println(num1 + " / " + num2 + " = " + (num1 / num2));
		}
		
		
		
		
		
		
		
		
		
		
	}

}
