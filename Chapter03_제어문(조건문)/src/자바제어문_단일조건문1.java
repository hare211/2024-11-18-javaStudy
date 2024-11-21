/*
 * 	단일 조건문
 * 	1) 형식)
 * 		if(조건문) {
 * 			실행문장 : 조건문이 true 일 때만 실행
 * 					 false 면 실행이 안 되는 문장
 * 		}
 * 
*/
// 정수 입력 => 짝수 / 홀수
import java.lang.reflect.Array;
import java.util.*;

public class 자바제어문_단일조건문1 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		/*
		 * System.out.print("정수 입력 : "); int num = scanner.nextInt();
		 * 
		 * if (num % 2 == 0) { // 짝수면 System.out.println(num + "는(은) 짝수입니다"); } if (num
		 * % 2 == 1) { // num % 2 != 0 홀수면 System.out.println(num + "는(은) 홀수입니다"); }
		 */
		
		System.out.print("정수 입력 : ");
		int num = scanner.nextInt();
		
		if (num % 3 == 0) {
			System.out.println(num + "은(는) 3의 배수입니다");
			
		}
		if (num % 3 != 0) {
			System.out.println(num + "은(는) 3의 배수가 아닙니다");
			
		}
		
	}

}
