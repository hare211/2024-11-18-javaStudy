// => 점수 입력 => 학점
/*
 *	A => 90 <= score && score <= 100
 *		 80 <= score && score < 90
 *		 70 <= score && score < 80
 *		 60 <= score && score < 70
 *		 
*/

import java.util.Scanner;

public class 연산자_삼항연산자3 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("점수 입력 : ");
		int score = scanner.nextInt();
		/*
		 * 	알파벳 => 대문자 조건
		 * 		'A' <= c && c <= 'Z' => A ~ Z 사이에 존재
		 * 			소문자 조건
		 * 		'a' <= c && c <= 'z' => a ~ z 사이에 존재
		 * 		=> 알파벳
		 * 		('A' <= c && c <= 'Z') || ('a' <= c && c <= 'z')
		*/
		System.out.println(0 > score || score > 100 ? "비정상입력" : "정상입력");
		// nextDouble() : 실수, nextBoolean() : true / false, next() : 문자열
		
		System.out.println("===== 결과값 =====");
		System.out.print(90 <= score && score <= 100 ? "A학점" : "");
		System.out.print(80 <= score && score < 90 ? "B학점" : "");
		System.out.print(70 <= score && score < 80 ? "C학점" : "");
		System.out.print(60 <= score && score < 70 ? "D학점" : "");
		System.out.print(60 > score ? "F학점" : "");
		
		
		
	}

}
