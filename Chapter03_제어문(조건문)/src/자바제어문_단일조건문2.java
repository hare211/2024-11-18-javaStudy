// => 정수 2 개 => 사용자 요청 => 계산
//					+, -, *, /
// 간단한 계산기 (사칙연산 사용)

import java.util.Scanner;

import javax.swing.JOptionPane;

public class 자바제어문_단일조건문2 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("첫 번째 정수 입력 : ");
		int num1 = scanner.nextInt();
		
		System.out.print("두 번째 정수 입력 : ");
		int num2 = scanner.nextInt();
		
		System.out.print("연산자 입력(+(43), -(45), *(42), /(47)) : ");
		char op = (char) scanner.nextInt();
		
		System.out.println(num1);
		System.out.println(num2);
		System.out.println(op);
		
		if (op == '+') {
			System.out.printf("%d + %d = %d\n", num1, num2, num1 + num2);
		}
		if (op == '-') {
			/*JOptionPane.showMessageDialog(null,
					num1 + "-" + num2 + "=" + (num1 - num2));*/
			System.out.printf("%d - %d = %d\n", num1, num2, num1 - num2);
		}
		if (op == '*') {
			System.out.printf("%d * %d = %d\n", num1, num2, num1 * num2);
		}
		if (op == '/') {
			if (num2 == 0) {
				System.out.println("0 으로 나눌 수 없습니다");
			}
			if (num2 != 0) {
				System.out.printf("%d / %d = %d\n", num1, num2, num1 / num2);
			}		
		}
	}

}
