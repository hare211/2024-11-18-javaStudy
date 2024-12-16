package com.sist.main;

import java.util.Scanner;

/*
 * 추상 클래스
 * 	= 주목먹
 * 		관련된 클래스를 모아서 한 개의 객체명으로 관리
 * 		(서로 다른 클래스를 연결해서 사용)
 * 	예)
 * 		게시판
 * 			글쓰기, 목록, 수정, 상세보기, 삭제, 검색
 * 		| 묻고답하기 : 답하기
 * 		| 자료실 : 다운로드 / 업로드
 * 		| 댓글형 게시판 : 댓글
 * 		| 갤러리 게시판 : 이미지
 * 		=> 요구사항 분석 / 설계
 * 		=> 단점
 * 			= 단일 상속만 가능
 * 			= 미완성(메소드 구현이 안된 경우)
 * 				new 를 이용해서 객체를 생성할 수 없다
 * 			= 상속을 받아서 메소드를 구현 후에 사용
 * 				new 구현된 클래스의 생성자
 */
abstract class 도형 {
	public abstract void draw(); // 추상 메소드
	// 상속 받는 클래스는 무조건 구현해서 사용
	public void colorSelect() {
		System.out.println("검정색 사용");
	}
}
class 사각형 extends 도형 {
	@Override
	public void draw() {
		System.out.println("사각형을 그린다");
	}
}
class 삼각형 extends 도형 { // abstract 메소드가 있는 경우 상속 시에 무조건 구현 후에 사용
	@Override
	public void draw() {
		System.out.println("삼각형을 그린다");
	}
}
class 원 extends 도형 {
	@Override // 선언된 메서드는 필수
	public void draw() {
		System.out.println("원을 그린다");
	}
	public void colorSelect() { // 선택 사항
		System.out.println("파랑색 사용");
	}
}
public class 추상클래스 {
	public static void main(String[] args) {
		// 관련된 클래스를 모아서 한 개 객체명으로 제어
		도형 a = new 사각형();
		// 상속 받아서 메소드를 구현한 클래스 
		// 오버라이딩 : 기능을 변경해서 사용
		/*
		 * 오버라이딩
		 * 	1) 상속(익명 클래스는 상속 없이 사용)
		 * 	2) 메소드명, 매개 변수, 리턴형이 동일
		 * 	3) 접근지정어는 확대만 가능...
		 * 	4) 유지보수에서 주로 사용
		 * 	5) 웹 => 유사한 기능이 많다
		 * 		회원가입 / 로그인 / 로그아웃
		 * 		게시판 / 공지사항 / 목록
		 */
		a.draw();
		a.colorSelect();
		
		a = new 삼각형();
		a.draw();
		a.colorSelect();
		
		a = new 원();
		a.draw();
		a.colorSelect();
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("도형 선택 : 1. 네모 | 2. 삼각형 | 3. 원 : ");
		
		int mode = scanner.nextInt();

//		도형 aa = null;
//		if (mode == 1) {
//			aa = new 삼각형();
//		} else if (mode == 2) {
//			aa = new 삼각형();
//		} else if (mode == 3) {
//			aa = new 원();
//		}
//		
//		aa.colorSelect();
//		aa.draw();
		
		도형[] aa = {null, new 사각형(), new 삼각형(), new 원()};
		aa[mode].colorSelect();
		aa[mode].draw();
	}
}
