package com.sist.main;
/*
 * 인터페이스
 * -------
 * 1) 추상 클래스의 일종이다(클래스와 동일하게 취급)
 * 2) 추상 클래스 : 단일 상속
 * 	  인터페이스 : 다중 상속
 * 3) 인터페이스
 * 		=>	변수(X) => 상수
 * 			메소드(구현X) => 구현 되지 않은 메서드만 가지고 있다
 * 			=> 생략이 가능 => 모든 메서드는 public 이다
 * 4) 서로 다른 클래스를 모아서 한 개의 이름으로 연결
 * 5) 결합성이 낮은 프로그램 구현
 * 		=> 유지 보수가 뛰어나다
 * 	*** 인터페이스를 수정하면 관련된 모든 클래스에 오류가 발생
 * 		인터페이스는 고정해야 한다
 * 		-------------------
 * 		=> 구현된 메서드 가능 default / static 를 써야한다
 * 6) 인터페이스는 변수나 메서드의 접근제어자는 모두 public
 * 
 * 예) public interface interface 명 {
 * 		(public static final -> 생략) int a = 10; => 값을 지정하지 않는 경우 오류 발생
 * 		------------------------ 상수형
 * 		(public abstract -> 생략) void display();
 * 		------------------------ 구현 되지 않은 메서드
 * 		(public -> 생략) default void aaa() {
 * 		}
 * 		(public -> 생략) static void bbb() {
 * 		}
 *    }
 * 
 * 오버라이딩
 * 	= 메서드명 동일
 * 	= 매개 변수 동일
 * 	= 리턴형 동일
 * 	= 접근제어자는 확대할 수 있지만 축소할 수 없다
 * 		private < default < protected < public
 * 
 * 		interface A {
 * 			void display();
 * 		}
 * 
 * 		class B implements A {
 * 			void display(){} => 오류 -> public -> default 축소되어 오류
 * 		}
 * 		상속				extends
 * 			interface ====> interface
 * 						implements
 * 			interface ====> class
 * 
 * 				| 아이템 => 기획
 * 		= 설계(요구사항) : 아키텍처 => 사이버다임
 * 		= 데이터베이스 설계 : DBA
 * 		= 화면 UI : HTML / CSS / JavaScript => 퍼블리셔
 * 		= 구현 : 웹 개발자
 * 		= 테스트 : 테스터
 * 		= 배포 : 웹 개발자
 * 		----------------------------------------------
 */
interface A {
//	int a;
//	private int b = 10;
//	protected int c = 100;
	int d = 100; // public static final -> 생략
	void aaa (); // public abstract -> 생략 / 선언만 하는 메서드
	default void bbb() { // public -> 생략
		
	}
	static void ccc() { // public -> 생략
		
	}
}
class B implements A {

	@Override
	public void aaa() {
		
	}
	
}
public class 인터페이스_1 {

}





