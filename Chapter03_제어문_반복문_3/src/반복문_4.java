/*
 * 3 명의 학생 점수 (국어, 영어, 수학) => 평균, 총점, 학점
*/

import java.util.Scanner;

public class 반복문_4 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int i = 1;
		
		while (i <= 3) {
			System.out.print(i + " 번째 국어 점수 입력 : ");
			int kor = scanner.nextInt(); 
			
			System.out.print(i + " 번째 영어 점수 입력 : ");
			int eng = scanner.nextInt();
			
			System.out.print(i + " 번째 수학 점수 입력 : ");
			int math = scanner.nextInt();
			
			int total = kor + eng + math;
			double avg = total / 3.0;
			
			char score = 'A';
			
			switch (total / 30) {
			case 10, 9:
				score = 'A';
				break;
			case 8:
				score = 'B';
				break;
			case 7:
				score = 'C';
				break;
			case 6:
				score = 'D';
				break;
			default:
				score = 'F';
				break;
			}
			System.out.println("국어 점수 : " + kor);
			System.out.println("영어 점수 : " + eng);
			System.out.println("수학 점수 : " + math);
			System.out.println("총점 : " + total);
			System.out.printf("평균 : %.2f\n", avg);
			System.out.println("학점 : " + score);
			i++;
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
