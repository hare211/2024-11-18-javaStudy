package com.sist.exception;
/*
 * 예외처리가 필요한 클래스
 * ------------------
 * => 라이브러리에서 제공
 * 	  ------- 입출력 / 네트워크 / 오라클 / URL / 쓰레드
 * 			  ----------------------------------
 * 			  | CheckException
 * 				=> 컴파일 시 확인(예외처리 설정)
 * 			=> 에외처리 방법
 * 			1. 직접처리(예외복구)
 * 				try ~ catch ~ finally
 * 
 * 			try {
 * 				정상 수행 문장 => 일부러 에러가 있는 문장을 사용하는 것이 아니다
 * 					=> 개발자 실수, 사용자 입력 문제 -> 에러발생 가능성
 * 			} catch (예외 클래스) {
 * 				1. 에러 내용 출력(어디서 에러 발생 됐는 지 확인)
 * 					=> getMessage() : 에러 내용만 출력
 * 					=> printStackTrace() : 에러 라인 출력
 * 				2. 예외 복구  
 * 					=> 다시 입력을 유도하는 경우
 * 					=> 웹 / 윈도우에서만 가능 
 * 					=> 데이터 수집(JSoup - 정적, 셀레니움 - 동적)
 * 				3. 에러 확인 => 소스 코딩 수정
 * 			} catch 문은 필요 시 여러 문 작성 가능
 * 			finally {
 * 				생략 가능 
 * 				=> 닫기(파일, 서버, 오라클)
 * 				=> try / catch 상관 없이 무조건 수행
 * 			}
 * 			catch => 통합해서 한 번에 처리
 * 			Exception / Throwable
 * 
 * 			=> try => finally 수행
 * 				: 에러가 없는 경우
 * 			=> try => catch => finally 수행
 * 				: try 수행 과정 중 에러 발생 => catch 에서 수행
 * 					=> finally 수행
 * 			=> 사전에 에러 처리
 * 			=> 에러 시 문제점
 * 				| 에러 위치부터 try 끝까지 => 스킵
 * 			2. 간접처리(예외회피) => 선언만 한다
 * 				메소드 뒤에 throws
 * 				=> 직접 처리하는 부분이 아니고 이런 에러가 예상이 된다
 * 					(컴파일러에게 알려준다)
 * 					=> 컴파일러가 예외처리 여부를 확인하지 않는다.
 * 				=> 복구할 수 없다 / 정상 수행 / 시스템 자체 처리
 */				
public class 예외처리_1차정리 {
	public void display() throws Exception {
		System.out.println("display call");
	}
	public static void main(String[] args) throws Exception {
		
		예외처리_1차정리 c = new 예외처리_1차정리();
		c.display();
		 
		for (int i = 0; i < 10; i++) { 
			double a = (Math.random() * 10) + 1;
			int b = (int) (Math.random() * 3); 
			
			System.out.printf("%.4f\n", a / b);
		}
//		for (int i = 0; i < 5; i++) {
//			try {
//				double a = (Math.random() * 3) + 1;
//				int b = (int) (Math.random() * 5); 
//				
//				System.out.printf("%.5f\n", a / b); 
//			} catch (Exception e) {
//				System.out.println("/ by zero");
//				
//			}
//			
		
//		}
		
	}
}
