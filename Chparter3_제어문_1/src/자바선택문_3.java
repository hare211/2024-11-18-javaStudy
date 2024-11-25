import java.util.*;
public class 자바선택문_3 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("첫 번째 정수 입력 : ");
		int num1 = scanner.nextInt();
		
		System.out.print("첫 번째 정수 입력 : ");
		int num2 = scanner.nextInt();
		
		System.out.print("연산자 입력(+, -, *, /) : ");
		
		switch (scanner.next()) {
		case "+":
			System.out.println(num1 + "+" + num2 + "=" + (num1 + num2));
			break;
		case "-":
			System.out.println(num1 + "-" + num2 + "=" + (num1 - num2));
			break;
		case "*":
			System.out.println(num1 + "*" + num2 + "=" + (num1 * num2));
			break;
		case "/":
			if (num2 == 0) {
				System.out.println("0 으로 나눌 수 없습니다");
			} else {
				System.out.println(num1 + "/" + num2 + "=" + (num1 / num2));
			}
			break;
		default:
			System.out.println("잘못된 입력입니다.");
			break;
		}
	}

}
