import java.util.Scanner;

public class 반복문_5 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int com = (int)(Math.random() * 100) + 1;
		// 1 ~ 100 사이의 정수 추출
		
		while (true) { // 무한루프 => 항상 종료시점 지정(break;)
			System.out.print("1 ~ 100 사이의 정수 입력 : ");
			int user = scanner.nextInt();
			
			if (1 > user || user > 100) {
				System.out.println("잘못된 입력입니다");
				continue; // 처음으로 이동
			}
			
			if (com > user) {
				System.out.println("Up");
			} else if (com < user) {
				System.out.println("Down");
			} else {
				System.out.println("정답");
				break;
			}
		}
	}

}
