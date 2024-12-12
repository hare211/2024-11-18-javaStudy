package com.sist.main;
/*
 * 변경(수정)
 * ----------- 오버라이딩
 * => 변수 오버라이딩
 * => 메소드 오버라이딩
 * 
 */
class Super { // 상속을 내리는 클래스
	String name = "홍길동";
	int age = 32;
	
}
class Sub extends Super{ // 상속 받는 클래스
	// 변수 오버라이딩 << 하지 않으면 super.name, age 의 값이 마지막으로 변경한 값으로 변경 됨.
	String name;
	int age;
	public Sub() {
		name = "심청이";
		age = 27;
	}
	void display() {
		System.out.println("Super : name = " + super.name);
		// super => 상속 내린 클래스의 변수, 메소드
		System.out.println("Super : age = " + super.age);
		
		System.out.println("Sub : name = " + this.name);
		System.out.println("Sub : age = " + this.age);
	}
}
public class 상속_1 {
	public static void main(String[] args) {
		Sub sub = new Sub();
		sub.display();
		
	}
}
