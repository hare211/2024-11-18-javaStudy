// 사칙연산자 => 4 개의 메소두
import java.util.*;
public class 메소드_02 {
	// 1) 리턴형 / 매개변수 => O
	public static void main(String[] args) {
		process();
	}
	
	static int plus(int a, int b) {
		int c = a + b;
		return c;
	}
	
	static int minus(int a, int b) {
		int c = a - b;
		return c;
	}
	
	static int multi(int a, int b) {
		int c = a * b;
		return c;
	}
	
	static String divide(int a, int b) {
		String result = "";
		if (b == 0) {
			result = "0 으로 나눌 수 없습니다.";
		} else {
			result = String.valueOf(a / (double) b);
		}
		return result; // 리턴형에 선언된 데이터형과 일치
	}
	// 조립 => 다른 클래스에서 사용이 가능
	static void process() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("첫 번째 정수 입력 : ");
		int num1 = scanner.nextInt();
		
		System.out.print("두 번째 정수 입력 : ");
		int num2 = scanner.nextInt();
		
		System.out.print("연산자 입력(+ - * /) : ");
		String option = scanner.next();
		
		// switch, 다중 조건문
		if (option.equals("+")) {
			int c = plus(num1, num2);
			System.out.println(num1 + " + " + num2 + " = " + c);
		} else if (option.equals("-")) {
			int c = minus(num1, num2);
			System.out.println(num1 + " - " + num2 + " = " + c);
		} else if (option.equals("*")) {
			int c = multi(num1, num2);
			System.out.println(num1 + " * " + num2 + " = " + c);
		} else if (option.equals("/")) {
			String c = divide(num1, num2);
			if (c.contains("0으로")) {
				System.out.println(c);
			} else {
				System.out.println(num1 + " / " + num2 + " = " + c);
			}
		} else {
			System.out.println("사용할 수 없는 연산자");
		}
	}

}
