/*
 * 	중첩 조건문
 * 		3개의 점수를 받아서 총점, 평균, 학점
 * 			=> 97 이상 A+ / 94 이상 A0 / 90 A-
*/
import java.util.*;
public class 제어문_조건문3 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("국어 점수 입력 :");
		int kor = scanner.nextInt();
		
		System.out.print("영어 점수 입력 :");
		int eng = scanner.nextInt();
		
		System.out.print("수학 점수 입력 :");
		int math = scanner.nextInt();
		
		// 총점 구하기
		int total = kor + eng + math;
		// 평균
		double avg = total / 3.0;
		// 학점
		char score = 'A', opt = '+'; // 초기화
		//	 --> A ~ F	  --> +, 0, -
		
		int avg2 = (int)avg; // avg2 => 0 ~ 100
		
		if (90 <= avg2 && avg2 <= 100) {
			score = 'A';
			if (97 <= avg2 && avg2 <= 100) {
				opt = '+';
			}
			if (94 <= avg2 && avg2 < 97) {
				opt = '0';
			}
			if (94 > avg2) {
				opt = '-';
			}
		}
		
		if (80 <= avg2 && avg2 < 90) {
			score = 'B';
			if (87 <= avg2 && avg2 < 90) {
				opt = '+';
			}
			if (84 <= avg2 && avg2 < 87) {
				opt = '0';
			}
			if (84 > avg2) {
				opt = '-';
			}
		}
		
		if (70 <= avg2 && avg2 < 80) {
			score = 'C';
			if (77 <= avg2 && avg2 < 80) {
				opt = '+';
			}
			if (74 <= avg2 && avg2 < 77) {
				opt = '0';
			}
			if (74 > avg2) {
				opt = '-';
			}
		}
		
		if (60 <= avg2 && avg2 < 70) {
			score = 'D';
			if (67 <= avg2 && avg2 < 70) {
				opt = '+';
			}
			if (64 <= avg2 && avg2 < 67) {
				opt = '0';
			}
			if (64 > avg2) {
				opt = '-';
			}
		}
		
		System.out.println("==== 결과값 =====");
		
		System.out.println("국어 점수 : " + kor);
		System.out.println("영어 점수 : " + eng);
		System.out.println("수학 점수 : " + math);
		System.out.println("총점 : " + total);
		System.out.printf("평균 : %.2f\n", avg);
		System.out.println("학점 : " + score + "" + opt);
	}

}
