import java.util.*;
public class 배열응용_5 {
	public static void main(String[] args) {
		// 배열 선언
		int[] arr = new int[5];
		// 초기화
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int) (Math.random() * 100) + 1;
		}
		System.out.println("정렬 전 :");
	
		
		for (int i : arr) {
			System.out.print(i + " ");
		}
		System.out.println();
		System.out.println("정렬 후 : ");
		Arrays.sort(arr);
		for (int i : arr) {
			System.out.print(i + " ");
		}
		System.out.println();
		for (int i = arr.length - 1; i >= 0; i--) {
			System.out.print(arr[i] + " ");
		}
		// 자바 => 조립식 / 라이브러리 중심 / 오버라이딩 프로그램
	}
	

	
	
	
	
	
	
	
	
	
	
	
	
}
