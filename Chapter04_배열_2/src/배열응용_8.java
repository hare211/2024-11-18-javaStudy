/*
 * 버블 정렬
 * 	=> 인접한 데이터끼리 비교
 * 	=> 선택 정렬 => 앞에서부터 고정
 * 	=> 버블 정렬 => 뒤에서부터 고정
 * 
 * 
*/

import java.util.Arrays;

public class 배열응용_8 {
	public static void main(String[] args) {
		int[] arr = new int[5];
		
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int) (Math.random() * 100) + 1;
		}
		System.out.println("정렬 전 : ");
		
		for (int i : arr) {
			System.out.print(i + " ");
		}
		System.out.println("\n정렬 후 : ");
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = 0; j < arr.length - 1 -i; j++) {
				if (arr[j] < arr[j + 1]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
			System.out.println((i + 1) + " Round :" + Arrays.toString(arr));
		}
		System.out.println("최종 결과값");
		for (int i : arr) {
			System.out.print(i + " ");
		}
	}
}
