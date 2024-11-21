/*
 * 
*/

import java.util.Scanner;

public class 연산자_삼항연산자4 {
	public static void main(String[] args) {
		int com = (int)(Math.random() * 3);
		// 0, 1, 2
		Scanner scanner = new Scanner(System.in);
		System.out.print("가위 (0), 바위(1), 보(2) : ");
		int user = scanner.nextInt();
		
		System.out.println("====== 결과값 ======");
		System.out.print("컴퓨터 : ");
		System.out.print(com == 0 ? "가위" : "");
		System.out.print(com == 1 ? "바위" : "");
		System.out.print(com == 2 ? "보" : "");
		
		System.out.println();
		
		System.out.print("사용자 : ");
		System.out.print(user == 0 ? "가위" : "");
		System.out.print(user == 1 ? "바위" : "");
		System.out.print(user == 2 ? "보" : "");
		
		System.out.println();
		System.out.print("결과 : ");
		int result = com - user;
		
		System.out.print(result == 1 || result == -2 ? "컴퓨터 Win" : "");
		System.out.print(result == -1 || result == 2 ? "사용자 Win" : "");
		System.out.print(result == 0 ? "무승부" : "");
		
		/*
		 * 	com (0) => 가위
		 * 		user 가위 (0)
		 * 			 바위 (1)
		 * 			 보  (2)
		 * 	com (1) => 바위
		 * 		user 가위 (0)
		 * 			 바위 (1)
		 * 			 보  (2)
		 * 	com (2) => 보
		 * 		user 가위 (0)
		 * 			 바위 (1)
		 * 			 보  (2)
		*/
	}

}
