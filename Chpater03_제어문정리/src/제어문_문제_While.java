import java.util.Scanner;

public class 제어문_문제_While {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		// 1 번
		/*
		System.out.print("구구단 2 ~ 9 입력 : ");
		
		int num = scanner.nextInt();
		if (9 < num || num < 2) {
			System.out.println("2 ~ 9 사이 입력:");
		}
		
		int i = 1;
		while (i < 10) {
			System.out.printf("[%d * %d = %d]\n", num, i, num * i);
			i++;
		}
		*/
		
		// 2 번
		/*
		int i = 1;
		while (i < 101) {
			if (i % 8 == 0) {
				System.out.print(i + " ");
			}
			i++;
		}
		*/
		
		// 3 번
		/*
		int i = 1;
		while (i < 101) {
			if (i % 4 == 0 || i % 7 == 0) {
				System.out.print(i + " ");
				i++;
			}
		}
		*/
		
		// 4 번
		/*
		int i = 1;
		while (i < 101) {
			if (i % 10 == 3 || i % 10 == 6 || i % 10 == 9) {
				System.out.print(i + " ");
				i++;
			}
		}
		*/
		
		// 5 번
		/*
		System.out.print("문자열 입력 : ");
		String str = scanner.nextLine();
		int count = 0;
		int i = 0;
		while (i < str.length()) {
			char c = str.charAt(i);
			if (c == 'a') {
				count++;
			} else if (c == 'e') {
				count++;
			} else if (c == 'i') {
				count++;
			} else if (c == 'u') {
				count++;
			} else if (c == 'o') {
				count++;
			}
			i++;
		}
		System.out.println(count);
		*/
		
		// 6 번
		/*
		while (true) {
			if (9 < num || num < 1) {
				System.out.println("1 ~ 9 사이 정수 다시 입력");
			}
			if (0 < num && num < 10 ) {
				break;
			}
		}*/
		
		int i = 1;
		int n = 1;
		int n1 = 0;
		System.out.print("정수 입력 1 ~ 9 : ");
		int num = scanner.nextInt();
		while (i < 101) {
			
			if (n1 > 11) {
				n1 = 0;
				n++;
			}
		
			if (n + n1 == num) {
				System.out.printf("[%d%d]", n, n1);
			}
			
			n1++;
			i++;
		}
		
		
		// 7 번
		/*
		int i = 10;
		while (i < 21) { 
			System.out.print(i + " ");
			i++;
		}
		*/
		// 8 번 
		/*
		int i = 20;
		while (i > 9) {
			System.out.print(i + " ");
			i--;
		}
		*/
		
		
		// 문자열 입력을 받아 거꾸로 출력
		// 이미지를 거꾸로 출력하는 프로그램 작성
		
		
		// 9 번
		
		/*
		int i = 0;
		int max = 0;
		while (i < 5) {
			System.out.print("정수 입력 : ");
			int num = scanner.nextInt();
			if (num > max) {
				max = num;
			}
			++i;
		}
		System.out.println("가장 큰 정수 : " + max);
		*/
		
		// 10 번
		/*
		int i = 0;
		int maxLength = 0;
		String maxLengthString = "";
		int sumLength = 0;
		
		while (i < 3) {
			System.out.print("문자열 입력 : ");
			String str = scanner.nextLine();
			if (str.length() > maxLength) {
<<<<<<< HEAD
				maxLength = str.length;
=======
   				maxLength = str.length();
>>>>>>> a3aae43e06b4d35f91cf2d47fcb9a7255cbda271
				maxLengthString = str;
			}
			sumLength += str.length();
			i++;
		}
		System.out.println("가장 긴 문자열 : " + maxLengthString);
		
		System.out.println("문자열 길이 합 : " + sumLength);
		*/
	
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
