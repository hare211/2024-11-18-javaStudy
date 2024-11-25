import java.util.Iterator;
import java.util.Scanner;

public class 반복문_문제 {
	public static void main(String[] args) {
		
		// 1번
		/* int score = (int)(Math.random() * 101);
		int grade = score / 10;
		System.out.println("귀하의 점수는 " + score + "점 입니다.");
		
		switch (grade) {
		case 10, 9:
			System.out.println("A 학점입니다.");
			break;
		case 8:
			System.out.println("B 학점입니다.");
			break;
		case 7:
			System.out.println("C 학점입니다.");
			break;
		case 6:
			System.out.println("D 학점입니다.");
			break;
		default:
			System.out.println("F 학점입니다.");
		} */
		
		// 2번
		Scanner scanner = new Scanner(System.in);
		
		/*System.out.print("첫 번째 정수를 입력해주세요 : ");
		int num1 = scanner.nextInt();
		
		System.out.print("두 번째 정수를 입력해주세요 : ");
		int num2 = scanner.nextInt();
		
		System.out.print("연산자 입력(+, -, *, /) : ");
		
		switch (scanner.next()) {
		case "+":
			System.out.println(num1 + " + " + num2 + " = " + (num1 + num2));
			break;
		case "-":
			System.out.println(num1 + " - " + num2 + " = " + (num1 - num2));
			break;
		case "*":
			System.out.println(num1 + " * " + num2 + " = " + (num1 * num2));
			break;
		case "/":
			if (num2 == 0) {
				System.out.println("0 으로 나눌 수 없습니다.");
			} else {
				System.out.println(num1 + " / " + num2 + " = " + (num1 / num2));
				break;
			}
		} */
		
		// 3번
		/* int sum = 0;
		for (int i = 2; i <= 100; i += 2) {
			sum += i;
		}
		System.out.println("2 + 4 +...+ 100 의 합 : " + sum);
		
		// 4번
		for (int i = 5; i < 101; i += 5) {
			System.out.print(i + " ");
		}
		
		// 5번
		for (char c = 'B'; c <= 'N'; c += 2) {
			System.out.println(c + " ");
		} */
		
		// 6번
		/*System.out.print("정수를 입력해주세요 : ");
		int num = scanner.nextInt();
		int sum = 0;
		
		for (int i = num; i > 0 ; i--) {
			sum += i;
		}
		System.out.println("1 ~ " + num + "까지의 합 : " + sum);*/
		
		// 7번
		/*int count = 0;
		for (int i = 2; i < 31; i += 2) {
			
			System.out.print(i + " ");
			count++;
			if (count % 3 == 0) {
				System.out.println();
			}
		}*/
		
		// 8번
		/* int sum = 0;
		
		for (int i = -2; i > -11; i -= 2) {
			sum += i;
		}
		for (int i = 1; i < 11; i += 2) {
			sum += i;
		}
		System.out.println(sum); */
		
		// 9번
		/*for (int i = 1; i < 11; i++) {
			if (i % 3 == 0) {
				continue;
			} else {
				System.out.print(i + " ");
			}
		}*/
	}

}
