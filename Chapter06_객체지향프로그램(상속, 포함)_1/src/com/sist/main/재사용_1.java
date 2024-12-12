package com.sist.main;

/*
 * 자바의 기본 형식
 * package => 한 번만 사용이 가능
 * import
 * public class ClassName {
 * 		멤버 변수 / 정적 변수 => X, 여러 개...
 * 		생성자 => 필요 시에 사용
 * 		메소드 => 필요 시에 사용
 * 		main() {} => 반드시 한 개가 필요
 * }
 * 
 * => 제어어
 * 		static : 공통적인
 * 		synchronized : 동기적인 => 쓰레드
 * 		------
 * 		async 비동기
 * 		sync 동기
 * 		------ 자바 스크립트 => Ajax => web 2.0 => web 3.0
 * 		
 * 		상속 (웹, 스프링 => 사용빈도 거의 없다)
 * 		-------------------------------
 * 		상속 : 목적 / 형식 / 메모리 구조
 * 		=> 목적
 * 		기존의 클래스(이미 만들어져 있는 클래스)
 * 			= 라이브러리 클래스
 * 			= 사용자 정의 클래스
 * 		재사용 할 때 / 변경 사용, 추가 사용
 * 		=> 반복 제거 / 소스를 줄이는 경우
 * 		=> 상속에서는 예외조건
 * 			1. 생성자 2. static 3. 초기화 블록
 * 			** 상속은 된다 사용을 못하는 것 => private(protected)
 * 		=> 형식
 * 			class A
 * 			class B extends A
 * 					--------- A 클래스를 확장해서 사용
 * 			=> 상속을 내리는
 * 		Object
 * 		↑
 * 		A => super
 * 		↑
 * 		B => sub => this, super
 * 		
 * 		*** 상속을 내리는 클래스 => 상속 받은 클래스의 변수, 메소드 제어 불가능
 * 			super => 자바의 모든 클래스는 Object 상속을 받는다
 * 		*** 상속을 받은 클래스는 상속 내린 클래스 제어가 가능
 * 		
 * 		자동 추가
 * 		import java.lang.* => String, System
 * 
 * 		1) 단일 상속 => 수정가능(변수 오버라이딩, 메소드 오버라이딩)
 * 		2) 상속 : extends : 한 개만 사용이 가능
 * 		3) 상속을 두 개 이상 받는 경우
 * 			class A
 * 			class B
 * 			class C extends A, B => 오류
 * 
 * 			class A
 * 			class B extends A => A, B
 * 			class C extends B => C, A, B
 * 
 * 			=> 여러 개를 받는 방법 => 클래스는 기존
 * 				--------------- 인터페이스
 * 
 * 		상속을 받아서 메모리 할당
 * 		1) 상위 클래스 (상속 내린 클래스)
 * 		2) 하위 클래스 (상속을 받은 클래스)
 * 		=> 속도가 느려진다
 * 		=> 영향력이 많이 존재
 * 		=> 공통점을 추출
 *  
*/
class Sawon {
	public Sawon() {
		System.out.println("Sawon 객체 생성");
	}
	public void display() {
		System.out.println("사원 기능");
	}
	@Override
	protected void finalize() throws Throwable {
		// 소멸자 함수
		System.out.println("객체 소멸");
	}
	
}
public class 재사용_1 {
	public static void main(String[] args) {
		Sawon sa = new Sawon();
		sa.display();
		sa = null;
		System.gc(); // 메모리 회수
		
		B b = new B();
		
		A a = new B();
		
		b.a = 2;
		
		
	}
}












