package com.sist.temp;
class Super {
	int a = 10;
	int b = 20;
	public Super() {
		System.out.println("Super() call...");
	}
}
class Sub extends Super {
	int a, b; // 변수 오버라이딩 => 하지 않으면 display 주석 / Sub 객체 생성 시 Super 의 a, b 의 값이 Sub 인스턴스 안에 생성. 
			  // 따라서 int a, b 의 값을 오버라이딩 하여 따로 값을 지정해야함.
	public Sub() {
		System.out.println("Sub() call...");
	}
	public void display() { // Sub 의 a, b 를 변경하면 Super 의 a, b 의 값도 변경된다.
		super.a = 100;
		super.b = 200;
		this.a = 1000;
		this.b = 2000;
		System.out.println("super.a = "	+ super.a);
		System.out.println("super.b = "	+ super.b);
		System.out.println("this.a = "	+ this.a);
		System.out.println("this.a = "	+ this.b);
	}
}
public class MainClass {
	public static void main(String[] args) {
		//Super super = new Super();
		
		Sub sub = new Sub();
		sub.display();
	}
}
