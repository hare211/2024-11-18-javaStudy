/*
 * 	3 개의 정수를 받아서 평균 / 총점을 전송하는 메소드
 * 	1. 입력
 * 	2. 처리 => 평균 / 총점
 * 		=> 세분화
 * 	3. 출력
 * 
*/

import java.util.Scanner;

public class 메소드_05 {
	static int userInput(int a) {
		Scanner scanner = new Scanner(System.in);
		System.out.print(a + "' 정수 입력 : ");
		int c = scanner.nextInt();
		return c;
	}
	
	static int total(int a, int b, int c) {
		return a + b + c;
	}
	
	static double div(int total) {
		return total / 3.0;
	}
	static void print (int total, double div) {
		System.out.println("총점 : " + total);
		System.out.println("평균 : " + div);
	}
	public static void main(String[] args) {
		/*Scanner scanner = new Scanner(System.in);
		System.out.print("1' 정수 입력 : ");
		int a = scanner.nextInt();
		
		System.out.print("2' 정수 입력 : ");
		int b = scanner.nextInt();
		
		System.out.print("3' 정수 입력 : ");
		int c = scanner.nextInt();
		
		int total = a + b + c;
		double avg = total / 3.0;
		
		System.out.println("총점 : " + total + " 평균 : " + avg);
		*/
		
		userInput(3);
		userInput(3);
		userInput(3);
		
		int total = total(0, 0, 0);
	}

}
