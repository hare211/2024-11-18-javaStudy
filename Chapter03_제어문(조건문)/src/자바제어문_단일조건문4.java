/*
 * 	윤년
 * 	----
 * 	1. 4년마다
 * 	2. 400년 마다 
 *  3. 100년 마다 제외
 *  
 *  year % 4 == 0	year % 100 != 0
*/

import java.util.Scanner;

public class 자바제어문_단일조건문4 {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("년도 입력 : ");
		int year = scanner.nextInt();
		
		// 결과 출력
		if ((year % 4 == 0 && year % 100 !=0) || (year % 400 == 0)) {
			System.out.println(year + "는(은) 윤년입니다");
		}
		if (!((year % 4 == 0 && year % 100 !=0) || (year % 400 == 0))) {
			System.out.println(year + "는(은) 윤년이 아닙니다");
		}
	}

}
