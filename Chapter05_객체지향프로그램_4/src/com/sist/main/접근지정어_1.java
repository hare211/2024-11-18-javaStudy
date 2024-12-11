package com.sist.main;

/*
 * 	패키지 : 관련된 클래스를 모아둔 관리 영역
 * 	---- 풀더
 * 		com.회사명.클래스종류
 * 					=> vo : 사용자 정의 데이터형
 * 					=> dao : 오라클 연동
 * 						==> 테이블 당 1 개
 * 					=> manager : Open API, 크롤링
 * 					=> model : 브라우저 연결 => 데이터 전송
 * 				*** => commons : 공통으로 사용되는 기능
 * 						=> 중복 제거 => static => 공통 모듈
 * 				*** => service : dao + model
 * 				*** => controller : 사용자 요청 => model
 * 		=> view : 화면 UI
 * 		=> dao / vo / controller
 * 	=> 자바 소스
 * 
 * 	private : 메소드, 클래스
 * 	protected :
 * 	default : 메소드, 필드, 생성자, 클래스
 * 				=> 같은 패지키에서만 사용이 가능
 * 				=> 윈도우 : Button, Menu...
 * 	public : 클래스, 메소드, 필드, 생성자
 * 				=> 다른 클래스와 연결
 * 					------------ 다른 패키지 연결
 * 					=> 클래스, 메소드, 생성자
 * 				=> 모든 클래스에서 사용이 가능
*/

import java.util.*;
class Util {
	// 중복 없는 난수
	/*
	 * 값 읽기 getXxx()
	 * 값 설정 setXxx()
	 * 존재 여부 isXxx() => boolean
	 * 삭제 remove(), delete()
	 * 	   text
	*/
	public int [] getRand(int count) {
		int[] com = new int[count];
		
		for (int i = 0; i < com.length; i++) {
			com[i] = (int) (Math.random() * 31) + 1;
			
			for (int j = 0; j < i; j++) { // j => 저장된 데이터
				if (com[i] == com[j]) {
					i--;
					break;
				}
			}
		}
		return com;
	}
	public void display() {
		System.out.println("display() 진입");
		System.out.println("display 기능처리");
		System.out.println("display() 종료");
	}
	// Call By Reference
	public void getRand(int[] com) {
		for (int i = 0; i < com.length; i++) {
			com[i] = (int) (Math.random() * 31) + 1;
			
			for (int j = 0; j < i; j++) { // j => 저장된 데이터
				if (com[i] == com[j]) {
					i--;
					break;
				}
			}
		}
	}
	// 정렬 => ASC / DSC
	// 패키지가 없는 경우 => JSP 사용이 안됨, jar 파일을 못 만든다.
}
public class 접근지정어_1 {
	public static void main(String[] args) {
		Util util = new Util();
		
		int day = (int) (Math.random() * 16) + 5;
		int[] arr = new int[day];
		
		util.getRand(arr);
		Arrays.sort(arr);
		
		for (int i : arr) {
			System.out.print(i + " ");
		}
		
//		int day = (int) (Math.random() * 16) + 5;
//		int[] arr = util.getRand(day);
//		//			객체명.메소드(값)
//		Arrays.sort(arr);
//		
//		for (int i : arr) {
//			System.out.print(i + " ");
//		}
//		System.out.println("main 에서 display 호출 전");
//		util.display();
//		System.out.println("main 에서 display 호출 완료");
	}
}

















