package com.sist.win;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.*; // 윈도우 관련
/*
 * 상속 => 기존의 클래스를 재사용 => 추가, 변경해서 사용
 * 		  ----------
 * 			사용자 정의
 * 			라이브러리 => 변경해서 사용하는 상속이 많다
 * 			=> 코드의 재사용이 높다
 * 			   --------- 개발 속도가 빠르다
 * 			=> 코드 관리가 용이하다
 * 			=> 코드가 간결해진다
 * 			=> 가존의 클래스는 이미 검증된 상태 : 신뢰성이 높다
 * 		상속 : is-a => 변경 후 사용
 * 	*** 포함 : has-a => 있는 그대로 사용
 * 
 * 	객체지향 => 권장(캡슐화, 재사용(상속), 변경, 추가가 쉽게)
 * 										--------
 * 										오버라이딩, 오버로딩
 * 		*** 상속의 문제점
 * 			= 결합성이 높다(다른 클래스의 영향이 크다)
 * 			예) 상속 받는 클래스 => 상속을 내리는 클래스(변경)
 * 			= 제약 조건이 많다
 * 			= 메모리 할당량이 많다 => 속도가 느려진다
 * 			= 윈도우 사용하지 않는 이유 => 속도가 느리다
 * 		특징)
 * 			1. 단일 상속만 가능
 * 			2. 상속 기호 : extends : 클래스를 확장해서 사용
 * 						--------
 * 					예) class A extends B
 * 						A 클래스는 B 클래스를 확장해서 새로운 클래스 제작
 * 						=> A 클래스는 B 클래스로부터 상속을 받는다
 * 			3. 상속 => 특별한 경우가 아니면 모든 변수, 메소드 상속
 * 				=> 특별한 경우(예외)
 * 					static : => 공유(여러 개의 객체가 공동 사용)
 * 							 
 * 
 * 
 * 
 * 				상속 내리는 클래스(super, 상위 클래스, 부모 클래스)
 * 					=> 상속을 받을 클래스의 변수, 메소드에 접근이 불가능
 * 						-------------
 * 							자신의 객체 ==> this
 * 							상위 클래스의 객체 ==> super
 * 				class A {
 * 					int a, b;
 * 				}
 * 				class B extends A {
 * 					// a, b
 * 
 * 					public B() {
 * 						this.a = 10; // class B(this) 의 a, b
 * 						this.b = 20;
 * 						super.a = 100; // class A(super) 의 a, b
 * 						super.b = 200;
 * 				}
 *	
 */
class A {
	int a = 10;
	void display() {
		System.out.println("A 클래스가 가지고 있는 display()");
	}
}
class B extends A{
	int b = 100;
	void display() {
		System.out.println("B 클래스가 가지고 있는 display()");
	}
}
public class 윈도우상속 extends JFrame{
	// 윈도우 설정
	JButton b1 = new JButton("North");
	JButton b2 = new JButton("East");
	JButton b3 = new JButton("West");
	JButton b4 = new JButton("Center");
	JButton b5 = new JButton("South");
	public 윈도우상속() {
		//setLayout(new FlowLayout()); // 일자로 배치
		setLayout(new GridLayout(2, 3));
		// BorderLayout => default //  경계
		add(b1); add(b2); add(b3); add(b4); add(b5);
		// 레이아웃
//		add("North", b1);
//		add("South", b5);
//		add("Center", b4);
//		add("East", b2);
//		add("West", b3);
		
		setSize(640, 400);
		// 윈도우 요청
		setVisible(true);
		
	}
	public static void main(String[] args) {
		new 윈도우상속();
//		A aa = new A();
//		System.out.println(aa.a);
//		aa.display();
//		
//		B bb = new B();
//		System.out.println(bb.a);
//		bb.display();
//		
//		// 클래스가 많은 경우 => 모아서 한 개의 이름으로 제어
//		// 상위 클래스를 이용해서 접근이 가능
//		A cc = new B();
//		System.out.println(cc.a);
//		cc.display();
//		
//		// B dd = (B) new A(); 오류
//		A dd = new B();
//		B ee = (B) dd;
		
	}
}
















