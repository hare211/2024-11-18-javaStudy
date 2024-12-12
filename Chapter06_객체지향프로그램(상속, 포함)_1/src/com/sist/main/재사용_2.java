package com.sist.main;

/*
 * 
*/

class 사람 {
	String name, sex, address, phone;
	int age;
	public 사람() {
		System.out.println("사람 class 메모리 할당");
	}
	
}

class 회사원 extends 사람{
	/*
	 * String name, sex, address, phone;
	   int age;
	*/
	String dept, job, loc;
	int sabun, pay;
	
	public 회사원() {
		System.out.println("회사원 메모리 할당");
	}
	
}
public class 재사용_2 {
	public static void main(String[] args) {
		//회사원 회사원 = new 회사원();
		// 메모리 할당 => 상속 받은 클래스만 이용하는 방법
		// 상속을 내리는 클래스 => 메모리 할당
		
		사람 사람 = new 회사원();
		// 묵시적 형변환
		// double d = 10;
		// 클래스형 => 변수, 메소드만 사용이 가능
		
		회사원 회사원 = (회사원)사람;
		
		
	}

}
