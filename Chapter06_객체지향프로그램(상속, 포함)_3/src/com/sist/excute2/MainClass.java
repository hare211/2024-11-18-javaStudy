package com.sist.excute2;

class Sub {
	int a = 10;

	@Override
	public String toString() {
		System.out.println("Sub...");
		return " ";
	}
}

public class MainClass {
	public static void main(String[] args) {
		Object obj = new Sub();
		// 묶어서 한 개로 관리
		obj.toString();
		/*
		 * 상위 클래스는 하위 클래스의 추가된 메소드를 
		 */
	}
}
