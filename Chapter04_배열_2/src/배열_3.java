/*
 * 10 개의 정수를 임의로 추출 (1 ~ 100) => max, min
 * => max 의 위치 / min 의 위치
*/

import java.util.Arrays;

public class 배열_3 {
	public static void main(String[] args) {
		int[] arr = new int[10];
		
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int) (Math.random() * 100) + 1; 
		}
		// 1. 초기화 된 데이터 10 개를 출력
		System.out.println(Arrays.toString(arr));
		
		// 2. 요청 => 최대값, 최소값 찾기
		int max = arr[0];
		int min = arr[0];
		// => 저장 된 데이터 중에 한 개를 대입
		for (int i : arr) { // 실제 저장 된 데이터를 가지고 온다
			if (max < i) {
				max = i;
			}
			if (min > i) {
				min = i;
			}
		}
		System.out.println("최대값 : " + max);
		System.out.println("최소값 : " + min);
		
		// => 최대값 / 최소값의 인덱스는 몇 번인지 확인
		int maxIndex = 0;
		int minIndex = 0;
		
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == max) {
				maxIndex = i;
			}
			if (arr[i] == min) {
				minIndex = i;
			}
		}
		System.out.println("max 값의 인덱스 : " + maxIndex);
		System.out.println("min 값의 인덱스 : " + minIndex);
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
}
