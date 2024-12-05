/*
 * 	숫자 야구게임 => 절차적 언어 (main)
 * 				=> 메소드 형식 변환
 * 				=> 객체 지향 프로그램 변환
 * 	|
 * 	1. 3 개 정수 추출 => 1 ~ 9 => 중복 없는 정수
 * 	2. 사용자 입력
 * 	3. 난수와 입력값 비교
 * 	4. 힌트 => 문자열 1S - 2B...
 * 		S : ○
 * 		B : ○○
 * 	5. 종료 여부 확인
*/

import java.util.Arrays;
import java.util.Scanner;

public class 메소드응용_01 {
	public static void main(String[] args) {
		
		// 1. 중복 없는 난수 발생 => 3 개 정수 (1 ~ 9)
		int[] com = new int[3]; // 3 개의 정수를 저장하는 공간
		
		for (int i = 0; i < com.length; i++) {
			com[i] = (int) (Math.random() * 9) + 1;
			for (int j = 0; j < i; j++) {
				if (com[i] == com[j]) {
					i--; // 같은 정수가 있는 경우
					break;
				}
			}
		}
		//System.out.println(Arrays.toString(com));
		
		int[] user = new int[3];
		Scanner scanner = new Scanner(System.in);
		
		while (true) {
			System.out.print("세자리 정수 입력 : ");
			int input = scanner.nextInt();
			
			// 오류 처리
			if (100 > input || input > 1000) {
				System.out.println("세자리 정수가 아닙니다.");
				continue;
				/*
				 * continue 사용 시
				 * for = 증가식으로 이동
				 * while = 조건식으로 이동
				 * => 특정 부분을 제외
				 * => 웹에서는 사용빈도가 적다
				*/
				
			}
			user[0] = input / 100; // 369 / 100 => 3
			user[1] = (input % 100) / 10;
			user[2] = input % 10;
			// => 코딩테스트 => 화폐 매수 구하기
			
			// 오류 처리 => 중복된 수가 없어야 된다, 0을 입력하면 안된다
			if (user[0] == user[1] || user[1] == user[2] || user[0] == user[2]) {
				System.out.println("중복된 숫자는 사용할 수 없습니다");
				continue;
			}
			if (user[0] == 0 || user[1] == 0 || user[2] == 0) {
				System.out.println("0은 사용할 수 없습니다.");
				continue;
			}
			
			// 비교
			int s = 0, b = 0;
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					if (com[i] == user[j]) {
						if (i == j) { // 자릿수 동일
							s++;
						} else {
							b++;
						}
					}
				}
			}
			// 힌트 제공
			System.out.println("Input Number : " + input);
			System.out.println("=======================================================");
			System.out.print("S : ");
			for (int j = 0; j < s; j++) {
				System.out.print("●");
			}
			System.out.println();
			System.out.print("B : ");
			for (int j = 0; j < b; j++) {
				System.out.print("○");
			}
			System.out.println("\n=======================================================");
			System.out.println("Input Number : " + input + ", Result : " + s + " S - " + b + "B");
			//System.out.printlf("Input Number : %d, Result : %dS - ^dB", input, input,  );
			
			// 종류 여부
			if (s == 3) {
				System.out.println("Game Over");
				break;
				}
			}
	}
	

}
