/*	=> 달력
 * 		1. 사용자 정의
 * 			=> 달력 : 1 일차의 요일 확인
 * 							-------
 * 			=> 1년도 1월 1일 => 월요일
 * 			1) 1/1/1 ~ 2013/12/31 => 총 날 수 계산
 * 			2) 2023/11/30 => 총 날 수 계산
 * 			3) ----------------------------------- + 1
 * 			1) + 2) + 3) / 7 => 요일을 구한다
 * 			0 ~ 6 => 0 일 => 6 => 토
 * 			=> 예약 / 일정 관리
 * 		2. 라이브러리 Calendar
 * 
*/
import java.util.Iterator;
import java.util.Scanner;
public class 배열응용_2 {
	public static void main(String[] args) {
		// 입력 받기 => year / month / day => 요일
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("년도 입력 : ");
		int year = scanner.nextInt();
		
		System.out.print("월 입력 : ");
		int month = scanner.nextInt();
		
		//System.out.println("일 입력 : ");
		//int day = scanner.nextInt();
		
		// 전 년도까지 날 수
		int total = (year - 1) * 365
				+ (year - 1) / 4
				- (year - 1) / 100
				+ (year - 1) / 400; // 윤년 처리
		// 전 달까지 날 수
		int[] lastDay = {
				31, 28, 31, 30, 31, 30,
				31, 31, 30, 31, 30, 31 };
		// 모든 언어에서 사용되는 윤년 계산
		if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
			// 윤년 조건
			lastDay[1] = 29;
		} else {
			lastDay[1] = 28;
		}
		for (int i = 0; i < month - 1; i++) {
			total += lastDay[i];
		}
		
		// 입력 날 +
		//total += day;
		total++;
		
		
		// 요일 구하기
		// => switch 대신
		char[] strWeek = {'일', '월', '화', '수', '목', '금', '토'};
		int week = total % 7;
		
		System.out.println(year + "년도 " + month + "월 " + strWeek[week] + "요일입니다");
		
		System.out.println();
		
		for (char c : strWeek) {
			System.out.print(c + "\t");
		}
		
		System.out.println();
		for (int i = 1; i <= lastDay[month - 1]; i++) {
			if (i == 1) { // for 시작
				for (int j = 0; j < week; j++) {
					System.out.println("\t");
				}
			}
			System.out.printf("%2d\t", i);
			week++; // 요일 변경
			if (week > 6) { // 일요일이라면
				week = 0;
				System.out.println(); // 다음줄에 출력
			}
		}
		
		
		
		
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

