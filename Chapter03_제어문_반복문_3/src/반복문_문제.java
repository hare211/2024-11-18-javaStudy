import java.util.Iterator;
import java.util.Scanner;

public class 반복문_문제 {
	public static void main(String[] args) {
		// 1 번
		/*
		int x = 0;
		if (10 < x && x < 20) {
		} */
		
		// 2 번
		/*
		char ch = ' ';
		if (!(ch == ' ' && ch == '\t')) {
		} */
		
		// 3 번
		/*
		char ch = ' ';
		if (ch == 'x' && ch == 'X') {
		} */
		
		// 4 번
		/*
		char ch = ' ';
		if ('0' <= ch && ch < '9') {
		} */
		
		// 5 번
		/*
		for (int i = 1; i < 7; i++) {
			for (int j = 1; j < 7; j++) {
				if (i + j == 6) {
					System.out.printf("[%d, %d]", i, j);
					System.out.println();
				}
			}
			
		} */
		
		// 6 번 (문제 잘못봄)
		Scanner scanner = new Scanner(System.in);
		/*
		System.out.print("첫 번째 정수를 입력해주세요 : ");
		int start = scanner.nextInt();
		
		System.out.print("두 번째 정수를 입력해주세요 : ");
		int end = scanner.nextInt();
		
		if (start > end) {
			int temp = 0;
			temp = start;
			start = end;
			end = temp;
		}
		
		for (int i = start; i <= end; i++) {
			for (int j = start; j <= end; j++) {
				System.out.println(start + " * " + end + " = " + start * end);
				start++;
			}
			
		} */
		
		// 6 번 다른 풀이
		/*
		while (true) {
			System.out.print("첫 번째 정수를 입력해주세요 : ");
			int start = scanner.nextInt();
			System.out.print("두 번째 정수를 입력해주세요 : ");
			int end = scanner.nextInt();
			
			if (start > end) {
				System.out.println("첫 번째 정수는 두 번째 정수보다 값이 작아야 합니다. 다시 입력해주세요.");
				continue;
			}
			for (int i = start; i <= end; i++) {
				for (int j = start; j <= end; j++) {
					System.out.println(start + " * " + end + " = " + start * end);
					start++;
				}
			}
			break;
		}
		*/
		
		
		// 7 번
		/*
		int sum = 0;
		for (int i = 5; i < 17; i++) {
			sum += i;
		} */
		
		// 8 번
		/*
		int sum = 0;
		for (int i = 3; i < 4463; i++) {
			if (i % 2 == 0) {
				sum += i;
			}
			
		} */
		
		// 9 번 (문제 잘못봄)
		/*
		int sum = 0;
		for (int i = 0; i < 13; i++) {
			if (i % 6 == 0) {
				sum += i;
			} else if (i % 2 == 0 && i % 6 != 0) {
				sum += i;
			} else if (i % 3 == 0 && i % 6 != 0) {
				sum += i;
			}
		} System.out.println(sum);
		*/
		
		// 10 번
		/*
		int sum = 0;
		for (int i = 1; i < 101; i++) {
			if (i % 4 == 0) {
				sum += i;
			}
		} System.out.println(sum);
		*/
		
		// 11 번
		
		/*
		int count = 0;
		int evenCount = 0;
		while (count < 11) {
			int a = (int)(Math.random() * 101);
			if (a % 2 == 0) {
				evenCount++;
			}
			count++;
			System.out.print(a + " ");
		}
		System.out.println("\n" + evenCount);
		*/
		
		// 12 번
		/*
		int count = 0;
		int multiThree = 0;
		int multiFive = 0;
		
		while (count < 11) {
			int a = (int)(Math.random() * 101);
			if (a % 3 == 0) {
				multiThree++;
			}
			if (a % 5 == 0) {
				multiFive++;
			}
			count++;
			System.out.print(a + " ");
		}
		System.out.println("\n3 의 배수 : " + multiThree + " 개, 5 의 배수 : " + multiFive + " 개");
		*/
		
		// 13 번
		/*
		for (int i = 1; i <= 5 ; i++) {
			for (int j = 1; j <= 10 ; j++) {
				System.out.print("*");
			}
			System.out.println();
			
		}
		*/
		
		// 14 번
		/*
		for (int i = 1; i < 6; i++) {
			for (int j = 1; j < 6; j++) {
				System.out.print(i);
			}
			System.out.println();
		}
		*/
		
		// 15 번
		
		/*
		for (int i = 1; i < 6; i++) {
			for (int j = 1; j < 6; j++) {
				if (i == j) {
					System.out.print(i);
				} else {
					System.out.print("#");
				}
			}
			System.out.println();
		}
		*/
		
		
		// 16 번
		/*
		char c = 'A';
		for (int i = 1; i <= 5; i++) {
			for (int j = 1; j <= 5; j++) {
				System.out.print(c);
				c++;
			}
			c = 'A';
			System.out.println();
		} 
		*/
		
		// 17 번
		/*
		char c = 'A';
		for (int i = 1; i <= 5; i++) {
			for (int j = 1; j <= 5; j++) {
				System.out.print(c);
			}
			c++;
			System.out.println();
		}
		*/
		
		/*
		 * 1,5
		 * 2,4
		 * 3
		 * 2,4
		 * 1,5
		 * 
		 * 1,5
		 * 5,1
		 * 5,5
		 * 12221
		 * 21212
		 * 22122
		 * 21212
		 * 12221
		 * 
		 * $###$
		 * #$#$#
		 * ##$##
		 * #$#$#
		 * $###$
		*/

		
		
		
		 int n = 5; 

	        for (int i = 0; i < n; i++) { 
	            for (int j = 0; j < n; j++) { 
	                
	                if (i == j || i + j == n - 1) {
	                    System.out.print("*");
	                } else if ((i + j) % 2 == 0) {
	                    System.out.print(" ");
	                } else {
	                    System.out.print(" ");
	                }
	            }
	            System.out.println(); 
	        }
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		}
		
	}


