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
		
		int i = 1;
		while (i < 101) {
			if (i % 4 == 0 || i % 7 == 0) {
				System.out.print(i + " ");
				i++;
			}
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
