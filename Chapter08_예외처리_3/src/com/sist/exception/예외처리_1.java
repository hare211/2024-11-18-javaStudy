package com.sist.exception;

import java.util.Objects;

/*
 * 예외처리 방법
 * ---------
 * 	1. 직접처리 (예외복구)
 * 		try {
 * 			정상 수행 문장
 * 		} catch (예상되는 예외클래스) {
 * 			오류 발생 시 복구
 * 			오류 내용 확인
 * 		} finally {
 * 			닫기(서버, 오라클, 파일) => 자원(resource) 반환
 * 			=> 반드시 한 번은 수행
 * 		}
 * 	2. 간접처리 : throws
 * 		=> 예외회피
 * 		=> 예상되는 예외를 선언 -> 컴파일러에 알려준다
 * 		=> 이 메서드를 사용 시에는 반드시 예외처리 후 사용 가능
 * 			=> throws / try ~ catch 
 * 		=> 사용자 정의는 사용빈도 적다 / 라이브러리가 많이 존재
 * 
 * 	CheckException
 * 
 * 
 * 	UnCheckException - 필요 시에만 처리
 * 	RuntimeException
 * 	ArithmeticException
 * 	ArrayIndexOutOfBoundsException
 * 	NullPointerException
 * 	ClassCastException
 * 
 * 소스가 없는 경우 => 새로운 메서드를 만드는 경우
 * 		try ~ catch => 개발
 * 이미 소스가 있는 경우 => 새로운 기능 추가
 * 		throws => 유지보수
 * 
 * 1. 예상되는 예외를 메서드 뒤에 선언
 * 2. 메서드 호출에 반드시 예외처리후 호출
 */

public class 예외처리_1 {
	/*
	public int div(int a, int b) throws ArithmeticException { // UnCheckException
		return a / b;
	}
	public void print() {
		int c = div(10, 0);
	}
	*/
	public void display() throws Exception, ClassNotFoundException {
		System.out.println("display call...");
	}
	// CheckException 호출 시 반드시 예외처리
	// UnCheckException throws 문장을 사용하지 않는다
	
	// 1. try ~ catch
	public void print() {
		try {
			display();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	// 2. try ~ catch
	public void print2() {
		try {
			display();
		} catch (Throwable e) {
			
		}/* catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	}
	// 3. throws
	public void print3() throws Exception, ClassNotFoundException {
		display();
	}
	// 4. throws
	public void print4() throws Exception {
		display();
	}
	
	public static void main(String[] args) {
		
	}
}
