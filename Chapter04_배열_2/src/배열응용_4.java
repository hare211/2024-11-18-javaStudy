/*
 * 정렬
 * 	= 선택정렬 / 버블정렬
 * 	= ASC / DESC ====> Oracle : Order by
 * 	  ---	----
 * 			| 내림차순 (******) => 최신순
 * 	   | 올림차순
 * 	86 ~ 96 page => 1 차원 배열
 * 	알고리즘 => 정렬 알고리즘 => 108 page
 * 	
 * 	선택정렬 : 한 개의 데이터를 선택한 후에 기준점으로 변경
 * 	올림차순, 내림차순
*/

import java.util.Arrays;

public class 배열응용_4 {
	public static void main(String[] args) {
		int[] arr = new int[5];
		//초기화
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int) (Math.random() * 100) +1;
		}
		System.out.println("정렬 전 : ");
		
		for (int i : arr) {
			System.out.print(i + " ");
		}
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] < arr[j]) {
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
		System.out.println();
		System.out.println("정렬 후 : ");
		for (int i : arr) {
			System.out.print(i + " ");
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

}
