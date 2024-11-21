import java.util.Scanner;

public class Prac {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("정수를 입력해주세요 : ");
		int num = scanner.nextInt();
		
		if (num < 0) {
			System.out.println(num + "는(은) 음수입니다");
		} else {
			System.out.println(num + "는(은) 양수입니다");
		}
		
		System.out.println("===================================");
		
		System.out.print("정수를 입력해주세요 : ");
		int n = scanner.nextInt();
		
		if (n % 3 == 0) {
			System.out.println(n + "은(는) 3의 배수입니다");
		} else {
			System.out.println(n + "은(는) 3의 배수가 아닙니다");
		}
		
		System.out.println("===================================");
		System.out.print("10 ~ 99 사이의 정수를 입력해주세요 : ");
		int integer = scanner.nextInt();
		if (10 > integer || 100 <= integer) {
			System.out.println("정수가 범위 내에 있지 않습니다.");
			
		}
		if (10 <= integer && integer <= 99) {
			int ten = integer / 10;
			int one = integer % 10;
			
			System.out.println(ten == one ? "10의 자리와 1의 자리가 같습니다" : "10의 자리와 1의 자리가 같지 않습니다");
		}
		
		
		System.out.println("===================================");
		System.out.println("달(month)을 입력해주세요 : ");
		int month = scanner.nextInt();
		
		if (3 <= month && month <= 5) {
			System.out.println("봄");
		} else if (6 <= month && month <= 8) {
			System.out.println("여름");
		} else if (9 <= month && month <= 11) {
			System.out.println("가을");
		} else if (month == 1 || month == 2 || month == 12) {
			System.out.println("겨울");
		} else {
			System.out.println("잘못된 입력입니다");
		}
		
		scanner.close();
	}

}
