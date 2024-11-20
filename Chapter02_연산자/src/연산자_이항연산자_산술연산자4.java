/*
 * 	키보드 입력
 * 	1) BufferedReader => java.io
 * 		=> 예외처리
 * 	2) Scanner => java.util
 * 
 * 	// 다른 풀더에 있는 경우에 클래스를 읽어온다
 * 		import 를 이용한다
 * 		include / using / from
*/
import java.util.Scanner;

public class 연산자_이항연산자_산술연산자4 {
	public static void main(String[] args) {
		// 클래스를 메모리에 저장 => new
		Scanner scanner = new Scanner(System.in);
		// System.in => 키보드 입력값을 받는다
		
		System.out.print("국어 점수를 입력하세요 : ");
		int kor = scanner.nextInt(); // 입력한 정수값 읽기
		System.out.print("수학 점수를 입력하세요 : ");
		int math = scanner.nextInt();
		System.out.print("영어 점수를 입력하세요 : ");
		int eng = scanner.nextInt();
		
		System.out.println("국어 점수 : " + kor);
		System.out.println("수학 점수 : " + math);
		System.out.println("영어 점수 : " + eng);
	}

}
