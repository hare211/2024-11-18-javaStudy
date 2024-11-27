/*
 * 	문자열 정보
 * 		=> length() : 문자의 개수
 * 		=> 비밀번호는 8자리 이상...
 */

import java.util.Scanner;
// 사용자가 입력한 문자의 개수 확인 => 공백 포함
// Hello Java
public class 문자열_3 {
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		
		// BufferedReader => 예외처리
		System.out.print("문자 입력 : ");
		String str1 = scanner.next(); // Enter
		String str2 = scanner.next();
		String str3 = scanner.next();
		// next() => 공백 /enter
		// abc def ddd
		
		System.out.println("===== 결과값 =====");
		System.out.println("문자 개수 : " + str1.length());
		System.out.println("문자 개수 : " + str1.length());
		System.out.println("문자 개수 : " + str2.length());
		System.out.println("문자 개수 : " + str3.length());
		
	}

}
