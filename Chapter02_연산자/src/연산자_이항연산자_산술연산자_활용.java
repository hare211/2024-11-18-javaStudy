// 국어, 영어, 수학 점수 입력 => 평균, 총점

import java.util.Scanner; // 간단한 입력 처리

public class 연산자_이항연산자_산술연산자_활용 {
	/*
	 * 	변수 => 반드시 초기화(값을 저장) => 사용
	 * 			=========================
	 * 			1. 임의로 설정
	 * 				int a = 100;
	 * 			2. 사용자로부터 입력 값을 받아서 처리
	 * 				Scanner
	 * 			3. 컴퓨터가 임의로 설정 => 난수(random)
	*/
	public static void main(String[] args) {
		// Scanner 클래스를 메모리에 저장
		
		Scanner scanner = new Scanner(System.in);
		// 입력 값을 받아서 => 변수에 저장
		// 사용자 입력을 받는다
		System.out.print("국어 영어 수학 점수 입력 : ");
		
		int korScore = scanner.nextInt();
		int engScore = scanner.nextInt();
		int mathScore = scanner.nextInt();
		
		// 처리 ==> 결과값 출력
		System.out.println("==== 결과값 ====");
		System.out.println("국어 점수 : " + korScore);
		System.out.println("영어 점수 : " + engScore);
		System.out.println("수학 점수 : " + mathScore);
		
		// + : 문자열 결합
		
		System.out.println("총점 : " + (korScore + engScore + mathScore));
		// 연산자의 우선 순위 변경 => korScore + engScore + mathScore => 문자열에 결합
		System.out.printf("평균 : %.2f", (korScore + engScore + mathScore) / 3.0);
		// () => 우선 순위 결정
		
		
	}

}
