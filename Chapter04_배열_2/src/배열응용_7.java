/*
 * char
 * 버블 정렬
 * 
 * 	char => 문자열은 불가능
 * 			====	compare() / equals()
 * 						> <
 * 	=> char => 정수형 취급한다
 * 				연산자를 사용하면 정수로 변경
 * 				'A' < 'B'
 * 				65 < 66
 * 
 * 				B C A E D
 * 
 * 				i = 0
 * 				i = 1
 * 				i = 2
 * 				i = 3
 * 				i = 4
*/

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

public class 배열응용_7 {
	public static void main(String[] args) {
		// 선언
		char[] arr = new char[5];
		// 초기화
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (char) ((Math.random() * 26) + 65);
		}
		System.out.println("정렬 전 : ");
		for (char c : arr) {
			System.out.print(c + " ");
		}
		
		System.out.println("\n정렬 후 : ");
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] < arr[j]) {
					char temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
			System.out.println((i + 1) + " Round : " + Arrays.toString(arr));
		}
		for (char c : arr) {
			System.out.print(c + " ");
		}
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
