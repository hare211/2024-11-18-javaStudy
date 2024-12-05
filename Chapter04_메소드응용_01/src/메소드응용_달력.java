import java.util.Scanner;

public class 메소드응용_달력 {
	// 1. 입력
	static int input(String str) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print(str + " 입력 : ");
		int a = scanner.nextInt();
		
		return a;
	}
	// 2. 요일 구하기
	static int dayOfWeek(int year, int month) {
		int total = (year - 1) * 365
				+ (year - 1) / 4
				- (year - 1) / 100
				+ (year - 1) / 400;
		
		// 2. 전달까지 총 날 수
		int[] lastDay = {
				31, 28, 31, 30, 31 ,30,
				31, 31, 30, 31, 30, 31};
		
		if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
			lastDay[1] = 29;
		} else {
			lastDay[1] = 28;
		}
		for (int i = 0; i < month - 1; i++) {
			total += lastDay[i];
		}
		// 3. +1
		total++;
		
		// 요일 구하기
		int week = total % 7; // 0 ~ 6
		
		return week;
	}
	static int[] getLastDay() {
		int[] lastDay = {
				31, 28, 31, 30, 31 ,30,
				31, 31, 30, 31, 30, 31};
		return lastDay;
	}
	// 3. 달력 출력
	static void print(int year, int month, int week) {
		
		String[] strWeek = {"일", "월", "화", "수", "목", "금", "토"};
		
		int[] lastDay = getLastDay();
		
		System.out.println(year + "년도 " + month + "월");
		
		for (int i = 0; i < strWeek.length; i++) {
			if (i == 0) {
				System.err.print(strWeek[i] + "\t");
			} else {
				System.out.print(strWeek[i] + "\t");
			}
		}
		System.out.println();
		for (int i = 1; i < lastDay[month - 1]; i++) {
			if (i == 1) {
				// 해당 요일까지 공백
				for (int j = 0; j < week; j++) {
					System.out.print("\t");
				}
			}
			System.out.printf("%2d\t", i);
			week++;
			if (week > 6) {
				week = 0;
				System.out.println();
			}
		}
	}
	
	// 4. 조립
	static void process() {
		int year = input("년도");
		int month = input("월");
		
		
		print(year, month, dayOfWeek(year, month));
		
	}
	public static void main(String[] args) {
		process();
	}

}
