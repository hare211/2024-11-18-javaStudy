/*
 * 	국어, 영어, 수학, => 입력... 총점 / 평균 / 학점
 * 
 * 	1. 변수값 채우기 (초기화)
 * 	2. 처리 => 기능
 * 		=>
 * 	3. 결과값
*/

import java.util.*;
public class 자바제어문_단일조건문5 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("국어 점수 입력 : ");
		int kor = scanner.nextInt();
		
		System.out.print("영어 점수 입력 : ");
		int eng = scanner.nextInt();
		
		System.out.print("수학 점수 입력 : ");
		int math = scanner.nextInt();
		
		int total = kor + eng + math;
		
		double avg = total / 3.0;
		
		System.out.println("===== 결과값 =====");
		System.out.println("국어 점수 : " + kor);
		System.out.println("영어 점수 : " + eng);
		System.out.println("수학 점수 : " + math);
		System.out.println("총점 : " + total);
		System.out.printf("평균 : %.2f\n", avg);
		
		// 학점
		char score = 'A';
		int temp = (total / 3) / 10;
		
		if (temp == 10 || temp == 9) {
			score = 'A';
		} else if (temp == 8) {
			score = 'B';
		} else if (temp == 7) {
			score = 'C';
		} else if (temp == 6) {
			score = 'D';
		} else {
			score = 'F';
		}
		
		/*if (90 <= temp && temp <= 100) {
			score = 'A';
		} else if (80 <= temp && temp < 90) {
			score = 'B';
		} else if (70 <= temp && temp < 80) {
			score = 'C';
		} else if (60 <= temp && temp < 70) {
			score = 'D';
		} else {
			score = 'F';
		}*/
		
		System.out.println("학점 : " + score);
		
		
	}

}
