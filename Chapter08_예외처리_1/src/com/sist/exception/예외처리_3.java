package com.sist.exception;

public class 예외처리_3 {
	public static void main(String[] args) {
		System.out.println("문장 1");
		System.out.println("문장 2");
		System.out.println("문장 3");
		try {
			System.out.println("문장 4");
			System.out.println(10 / 0); // catch 로 이동
			System.out.println("문장 6");
			// catch 로 이동하면 밑에 있는 문장은 수행 X
		} catch (Exception e) {
			System.out.println("문장 7");
		}
		System.out.println("문장 8");
		System.out.println("문장 9");
	}
}
