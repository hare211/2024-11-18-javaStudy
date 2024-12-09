// 3 명의 학생 국어 / 영어 / 수학 => 총점, 평균, 학점
// new 3 번 => 메모리 공간이 다르다
import java.util.*;
/*
 * int[] kor = new int[3]...
*/
class Student { // Student 데이터형 => 배열이 가능 => 10장 Collection
	String name;
	int kor, eng, math;
	int total;
	double avg;
	char score;
	String school_name; // 범위
}
public class 클래스_5 {
	public static void main(String[] args) {
		// 배열 선언
		Student[] std = new Student[3];
		// 초기화
		Scanner scanner = new Scanner(System.in);
		
		for (int i = 0; i < std.length; i++) {
			std[i] = new Student(); // 메모리 공간 할당
			//System.out.println(std[i]);
			System.out.print((i + 1) + "번째 국어 입력 : ");
			std[i].kor = scanner.nextInt();
			
			System.out.print((i + 1) + "번째 영어 입력 : ");
			std[i].eng = scanner.nextInt();
			
			System.out.print((i + 1) + "번째 수학 입력 : ");
			std[i].math = scanner.nextInt();
			
			std[i].total = std[i].kor + std[i].eng + std[i].math;
			
			std[i].avg = std[i].total / 3.0;
			
			switch (std[i].total / 30) {
			case 10, 9:
				std[i].score = 'A';
				break;
			case 8:
				std[i].score = 'B';
				break;
			case 7:
				std[i].score = 'C';
				break;
			case 6:
				std[i].score = 'D';
				break;
			default:
				std[i].score = 'F';
			}
		}
		// 출력
		
		for (int i = 0; i < std.length; i++) {
			System.out.printf("%-5d%-5d%-5d%-7d%-7.2f\n",
					std[i].kor,
					std[i].eng,
					std[i].math,
					std[i].total,
					std[i].avg,
					std[i].score);
			
		}
	}
}
















