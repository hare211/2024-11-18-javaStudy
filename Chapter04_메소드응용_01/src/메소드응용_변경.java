// 메소드형 숫자 야구 게임
import java.util.*;


public class 메소드응용_변경 {
	// 중복 없는 난수 (3 개의 정수)
	static int[] random() {
		int[] com = new int[3];
		
		for (int i = 0; i < com.length; i++) {
			com[i] = (int) (Math.random() * 9) + 1;
			for (int j = 0; j < i; j++) {
				if (com[i] == com[j]) {
					i--; // 같은 정수가 있는 경우
					break;
				}
			}
		}
		System.out.println(Arrays.toString(com));
		
		return com;
	}
	// 사용자 입력 => 유효성 검사
	static int[] userInput() {
		Scanner scanner = new Scanner(System.in);
		
		int[] user = new int[3];
		
		while (true) {
			System.out.print("세자리 정수 입력 : ");
			int input = scanner.nextInt();
			
			// 오류 처리
			if (100 > input || input > 1000) {
				System.out.println("세자리 정수가 아닙니다.");
				continue;
				/*
				 * continue 사용 시
				 * for = 증가식으로 이동
				 * while = 조건식으로 이동
				 * => 특정 부분을 제외
				 * => 웹에서는 사용빈도가 적다
				*/
			}
			user[0] = input / 100; // 369 / 100 => 3
			user[1] = (input % 100) / 10;
			user[2] = input % 10;
			// => 코딩테스트 => 화폐 매수 구하기
			
			// 오류 처리 => 중복된 수가 없어야 된다, 0을 입력하면 안된다
			if (user[0] == user[1] || user[1] == user[2] || user[0] == user[2]) {
				System.out.println("중복된 숫자는 사용할 수 없습니다");
				continue;
			}
			if (user[0] == 0 || user[1] == 0 || user[2] == 0) {
				System.out.println("0은 사용할 수 없습니다.");
				continue;
			}
			break;
		}
		return user;
		
	}
	// 비교
	static int compare(int[] com, int[] user) {
		int s = 0, b = 0;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (com[i] == user[j]) {
					if (i == j) { // 자릿수 동일
						s++;
					} else {
						b++;
					}
				}
			}
		}
		
		hint(s, b, user);
		
		return s;
	}
	// 힌트 제공
	static void hint(int s, int b, int[] user) {
		
		System.out.println("Input Number : " + Arrays.toString(user));
		System.out.println("=======================================================");
		System.out.print("S : ");
		for (int j = 0; j < s; j++) {
			System.out.print("●");
		}
		System.out.println();
		System.out.print("B : ");
		for (int j = 0; j < b; j++) {
			System.out.print("○");
		}
		System.out.println("\n=======================================================");
		System.out.println("Input Number : " + Arrays.toString(user) + ", Result : " + s + " S - " + b + "B");
	}
	// 종료 여부
	static boolean isEnd(int s) {
		boolean bCheck = false;
		if (s == 3) {
			bCheck = true;
		}
		return bCheck;
	}
	// 전체 조합 => 새로운 게임 여부 확인
	static void process() {
		Scanner scanner = new Scanner(System.in);
		
		int[] com = random();
		//System.out.println(Arrays.toString(com));
		int[] user = new int[3];
		
		while (true) {
			user = userInput();
			int s = compare(com, user);
			if (isEnd(s)) {
				System.out.print("New Game | Y/N");
				char c = scanner.next().charAt(0);
				if (c == 'Y' || c == 'y') {
					System.out.println("New Game Start");
					process(); // 재귀 호출
				} else {
					System.out.println("== End ==");
					System.exit(0);
				}
			}
		}
		//System.out.println(Arrays.toString(user));
	}
	public static void main(String[] args) {
		process();
	}

}
