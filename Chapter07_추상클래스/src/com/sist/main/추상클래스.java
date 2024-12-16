package com.sist.main;
/*
 * 목적
 * => 여러 개 클래스를 하나로 제어
 * 	  ---------------------
 * 		데이터베이스
 * 		기능
 * 		=> 공통으로 설정 => 모든 클래스가 공동 사용
 * 		=> 공통 기능 : 클래스마다 다른 내용 출력
 * 			---------------------------
 * 			=> 미구현
 * 				1. 목록
 * 				2. 검색
 * 				3. 추가
 * 				4. 삭제
 * 				5. 상세보기
 * 			=> emp(사원정보), dept(부서정보), book(교재)
 * 		1. 상속을 받는다
 * 		2. 미구현된 메서드를 구현해서 사용
 * 		3. 추상클래스를 이용해서 모든 클래스를 연결하여 사용
 * 		4. 공통기능? / 미구현 => 처리하는 내용이 틀린 경우
 * 		5. 형식)
 * 			public abstract class ClassName { 구성요소, 필수 아님
 * 				변수 : 멤버 변수
 * 				생성자
 * 				메소드 => 구현 메소드
 * 						= 상속 받은 모든 클래스가 동일한 기능
 * 				메소드 => 미구현 메소드 
 * 						= 기능은 동일 => 처리하는 내용이 다른 경우
 * 						= 버튼 클릭...
 * 				--------------------
 * 			}
 * 		6. 반드시 오버라이딩
 * 		7. 반드시 상속 받아서 처리 : extends
 * 			---------------- 단일 상속만 지원
 * 		abstract
 * 		|		|
 * 		class A  class B
 * 		*** 설계단
 * 		*** 클래스 객체 생성 : new 를 사용하지 않는다 -> 추상클래스 / 인터페이스
 * 		Class cls = Class.forName() -> 추상 or 인터페이스
 * 		Calendar cal = Calendar.newInstance()
 */
abstract class Button {
	public abstract void click(); // 선언
}
class Login extends Button {

	@Override
	public void click() {
		System.out.println("클릭 후 로그인 요청");
	}
	
}
class Join extends Button {

	@Override
	public void click() {
		System.out.println("클릭 후 회원 가입 요청");
	}
	
}
class Calc extends Button {

	@Override
	public void click() {
		System.out.println("클릭 후 계산기 요청");
	}
	
}
public class 추상클래스 {
	public static void main(String[] args) {
		
		Button btn = new Login();
		// 상위				하위
		// 변수 => 상위 클래스 => 주소값이 없다 => 선언된 클래스
		// 메소드 => 하위 클래스 => 주소를 가지고 있다 => 생성자 
		btn.click();
		
		btn = new Join();
		btn.click();
		
		btn = new Calc();
		btn.click();
		
		// 관련된 클래스를 여러 개 모아서 => 한 개의 객체명으로 처리
		// 가급적이면 배열 처리를 하지 않는다
	}
}




















