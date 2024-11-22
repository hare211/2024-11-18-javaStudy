/*
 * 	자바에서 지원하는 제어문
 * 		= 조건문 : 요청에 맞는 문장만 실행 => 건너뛰는 경우
 * 				=> 오류 방지
 * 					====== if 로 처리가 어려운 과정 : 예외처리 (8장)
 * 				=> 사전에 방지 => if => 이런 경우
 * 			단일 조건문
 * 				형식)		| 연산자 => 부정연산자(!), 비교연산자, 논리연산자
 * 					if (조건문 => true / false) {
 * 							조건문이 true 일 경우에만 처리하는 문장
 * 						}
 * 						false => 건너뛴다
 * 						=> 독립적으로 실행 => if 문을 여러 개 사용하면 속도가 저하
 * 						=> if 문장마다 다른 문장으로 되어 있다 => 모든 if 의 조건을 검색
 * 						=> 사용처 : 아이디 중복 체크, 검색, 상세보기
 * 			선택 조건문
 * 			다중 조건문
 * 		= 선택문 => 게임 => 네트워크
 * 		= 반복문
 * 			do ~ while : 무조건 1 번 이상 수행
 * 			while : 반복 횟수가 없는 경우
 * 			for : 횟수 지정 => 코테 / 정처 실기
 * 		= 반복제어문
 * 			break = 반복을 종료
 * 			continue = 특정부분을 제외하고 다시 반복 시작
*/

import java.util.Scanner;

public class 제어문_조건문1 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int com = (int)(Math.random() * 3); 
		int player = scanner.nextInt();
		
		System.out.print("Computer : ");
		if (com == 0) {
			System.out.println("가위");
		}
		if (com == 1) {
			System.out.println("바위");
		}
		if (com == 2) {
			System.out.println("보");
		}
		
		
		System.out.print("Player : ");
		if (player == 0) {
			System.out.println("가위");
		}
		if (player == 1) {
			System.out.println("바위");
		}
		if (player == 2) {
			System.out.println("보");
		}
		
		System.out.println("==== 결과 ====");
		
		if (com == 0) {
			if (player == 0) {
				System.out.println("비겼다");
			}
			if (player == 1) {
				System.out.println("Player Win");
			}
			if (player == 2) {
				System.out.println("컴퓨터 Win");
			}
			
		}
		if (com == 1) {
			if (player == 0) {
				System.out.println("컴퓨터 Win");
			}
			if (player == 1) {
				System.out.println("비겼다");
			}
			if (player == 2) {
				System.out.println("Player Win");
			}
			
		}
		if (com == 2) {
			if (player == 0) {
				System.out.println("Player Win");
			}
			if (player == 1) {
				System.out.println("컴퓨터 Win");
			}
			if (player == 2) {
				System.out.println("비겼다");
			}
			
		}
		
	}

}
