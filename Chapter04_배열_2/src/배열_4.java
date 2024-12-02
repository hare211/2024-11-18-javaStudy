/*
 * 6 개의 난수 발생 => 중복이 없는 데이터 출력 (1 ~ 45 사이의 난수)
 * => 피망 => 로직
*/

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class 배열_4 {
	public static void main(String[] args) {
		// 6 개를 저장하는 메모리 공간
		int[] lotto = new int[6];
		int su = 0; // 난수 발생 시 저장하는 변수
		boolean bCheck = false; // 중복 여부 확인
		
		for (int i = 0; i < lotto.length; i++) {
			bCheck = true;
			while (bCheck) { // 중복 여부 확인
				// 난수 발생
				su = (int) (Math.random() * 45) + 1;
				bCheck = false; // while 문만 종료
				// 같은 정수가 있는 지 확인
				for (int j = 0; j < i; j++) {
					if (lotto[j] == su) { // 저장 된 데이터 중에 난수와 같은 값이 있는 지
						bCheck = true; // while 문을 다시 수행
						break;
					}
				}
			}
			lotto[i] = su;
		}
		Arrays.sort(lotto);
		System.out.println(Arrays.toString(lotto));
		
		
		// 6 개의 난수 발생 => 중복이 없는 데이터 출력 (1 ~ 45 사이의 난수)
		
		int[] arr = new int[6];
		
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int) (Math.random() * 45) + 1;
			for (int j = 0; j < i; j++) {
				if (arr[i] == arr[j]) {
					i--;
					break;
				}
			}
		}
		Arrays.sort(arr);
		System.out.print(Arrays.toString(arr));
		System.out.println();
		
		// 6 개의 난수 발생 => 중복이 없는 데이터 출력 (1 ~ 45 사이의 난수)
        int[] arr1 = new int[6];
        Set<Integer> uniqueNumbers = new HashSet<>();

        int index = 0;
        while (index < arr1.length) {
            int rand = (int) (Math.random() * 45) + 1;
            if (!uniqueNumbers.contains(rand)) {
                uniqueNumbers.add(rand);
                arr1[index++] = rand;
            }
        }
        Arrays.sort(arr1);
        System.out.println(Arrays.toString(arr1));
	}

	
	
	
	
	
	
	
	
	
}
