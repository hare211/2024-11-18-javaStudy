/*
 * 3 명의 학생
 * 	=> 국어 / 영어 / 수학 점수를 입력을 받아 => 총점 / 평균 / 학점 / 등수를 출력한다
*/

import java.util.Iterator;
import java.util.Scanner;

public class 배열응용_1 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		// int[][] arr = new int [3][7]; => 2 차원 배열
		int[] kor = new int[3];
		int[] eng = new int[3]; // 1 번 / 2 번 / 3 번 => 인덱스 일치
		int[] math = new int[3];
		
		int[] total = new int[3];
		double[] avg = new double[3];
		char[] score = new char[3];
		int[] rank = new int[3];
		
		
		for (int i = 0; i < kor.length; i++) {
			System.out.print((i + 1) + " 번 국어 점수 입력 : ");
			kor[i] = scanner.nextInt();
			System.out.print((i + 1) + " 번 영어 점수 입력 : ");
			eng[i] = scanner.nextInt();
			System.out.print((i + 1) + " 번 수학 점수 입력 : ");
			math[i] = scanner.nextInt();
			
			total[i] = kor[i] + eng[i] + math[i];
			
			avg[i] = total[i] / 3.0;
		}
		// 학점 계산
		for (int i = 0; i < kor.length; i++) {
			switch ((int) (avg[i] / 10)) {
			case 10, 9:
				score[i] = 'A';
				break;
			case 8:
				score[i] = 'B';
				break;
			case 7:
				score[i] = 'C';
				break;
			case 6:
				score[i] = 'D';
			break;
			default:
				score[i] = 'F';
				break;
			}
		}
		// 등수 계산
		for (int i = 0; i < kor.length; i++) {
			rank[i] = 1;
			for (int j = 0; j < kor.length; j++) {
				if (total[i] < total[j]) {
					rank[i]++;
				}
			}
		}
		// 출력
		for (int i = 0; i < kor.length; i++) {
			// 출력 서식을 만드는 메소드 => 원하는 스타일로 출력 %5d or %-5d 
			// %-5d 왼쪽 정렬 => 공백을 출력 => 3 자리 // %5d 오른쪽 정렬
			System.out.printf("%-5d%-5d%-5d%-7d%-7.2f%-3c%-5d\n", kor[i], eng[i], math[i], total[i], avg[i], score[i],rank[i]);
		}
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
