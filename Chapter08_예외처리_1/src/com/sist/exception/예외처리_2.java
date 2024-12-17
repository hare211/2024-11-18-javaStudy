package com.sist.exception;
/*
 * 예외처리
 * 	=> 전체
 * 	=> 예상되는 부분에서만 처리
 * 
 * 	1. 예외처리 시 흐름
 * 	---------------
 */
public class 예외처리_2 {
	public static void main(String[] args) {
//		try {
//			for (int i = 1; i < 11; i++) {
//				int r = (int) (Math.random() * 3);
//				// 0, 1, 2
//				int a = i / r; // 오류 발생 => catch
//				System.out.println("i = " + i + ", a = " + a);
//			}
//		} catch (Exception e) {
//			
//		}
		// 크롤링 for 문 안 try 
		for (int i = 1; i < 11; i++) {
			try {
				int r = (int) (Math.random() * 3);
				// 0, 1, 2
				int a = i / r; // 오류 발생 => catch
				System.out.println("i = " + i + ", a = " + a);
			} catch (Exception e) {
				
			}
		}
	}
}
