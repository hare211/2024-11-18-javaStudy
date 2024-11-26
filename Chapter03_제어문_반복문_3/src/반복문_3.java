/*
 * 	가위바위보 게임을 10 번 수행 => 5승 1무 4패
*/

import java.util.Scanner;

public class 반복문_3 {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		int win = 0, same = 0, lose = 0;
		
		int i = 1;
		
		while (i <= 10) {
			System.out.println("===== " + i + " 번째 게임 =====");
			// com 은 가위바위보
			int com = (int)(Math.random() * 3);
			// 사용자 가위바위보
			System.out.print("가위(0), 바위(1), 보(2) : ");
			int user = scanner.nextInt();
			
			if (0 > user || user > 2 ) {
				System.out.println("잘못된 입력입니다");
				continue; // 조건식으로 이동
				// break; 면 종료 => 단 for 이면 => 증가식으로 이동
			}
			System.out.print("컴퓨터 : " );
			if (com == 0) {
				System.out.println("가위");
			} else if (com == 1) {
				System.out.println("바위");
			} else if (com == 2) {
				System.out.println("보");
			}
			
			// 사용자 확인
			System.out.print("사용자 : ");
			switch (user) {
			case 0:
				System.out.println("가위");
				break;
			case 1:
				System.out.println("바위");
				break;
			case 2:
				System.out.println("보");
				break;
			}
			// 누가 이겼는 지 확인
			int result = com - user;
			// 사용자가 이기는 경우 => -1, 2
			// 컴퓨터가 이기는 경우 => 1, -2
			// 비기는 경우 => 0
			if (result == -1 || result ==2) {
				System.out.println("사용자 Win");
				win++;
			} else if (result == 1 || result == 2) {
				System.out.println("컴퓨터 Win");
				lose++;
			} else if (result == 0) {
				System.out.println("무승부");
				same++;
			}
			System.out.println("게임을 종료할까요?(Y/N) : ");
			char c = scanner.next().charAt(0);
			if (c == 'y') {
				System.out.println("게임을 종료합니다");
				break;
			}
			i++;
			
		}
		System.out.println("======== 최종 결과 ========");
		System.out.printf("%d승 %d무 %d패\n", win, same, lose);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
