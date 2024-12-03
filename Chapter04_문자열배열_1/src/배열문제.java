import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class 배열문제 {
	public static void main(String[] args) {
		// 1 번
		/*
		int[] arr = {100, 90, 85};
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			System.out.println((i + 1) + " 번 학생 : " + arr[i] + " 점");
			sum += arr[i];
		}
		System.out.println("총점 : " + sum);
		*/
		
		// 2 번
		/*
		int[] arr = {50, 45, 35, 12, 70};
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			System.out.println("사원(" + (i + 1) + ") 점수 : " + arr[i]);
			sum += arr[i];
		}
		System.out.println("총점 : " + sum + "\n평균 : " + (sum / (double) arr.length));
		
		int max = arr[0];
		int min = arr[0];
		int maxI = 0;
		int minI = 0;
		for (int i = 0; i < arr.length; i++) {
			if (max < arr[i]) {
				max = arr[i];
				maxI = i + 1;
			}
			if (min > arr[i]) {
				min = arr[i];
				minI = i + 1;
			}
		}
		
		System.out.println("실적이 제일 큰 사원 : " + maxI + " 번 사원 | 점수 : " + max + "\n실적이 제일 작은 사원 : " + minI + " 번 사원 | 점수 : " + min);
		*/
		
		
		// 3 번
		/*
		int[] arr = new int[10];
		
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int) (Math.random() * 10);
		}
		
		System.out.println(Arrays.toString(arr));
		*/
		
		// 4 번
		/*
		int[] arr = {10, 20, 30, 40, 50};
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
		}
		System.out.println("sum = " + sum); 
		*/
		
		// 5 번
		/*
		int[] arr = new int[10];
		
		int evenTotal = 0;
		int oddTotal = 0;
		
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int) (Math.random() * 100) + 1;
			if (arr[i] % 2 == 0) {
				evenTotal += arr[i];
			} else {
				oddTotal += arr[i];
			}
		}
		System.out.println(Arrays.toString(arr));
		
		System.out.println("짝수 합 : " + evenTotal + "\n홀수 합 : " + oddTotal);
		*/
		
		// 6 번
		/*
        int[] arr = new int[10];
        for (int i = 0; i < 100; i++) {
            int num = (int)(Math.random() * 10);
            arr[num]++;
        }
        System.out.println(Arrays.toString(arr));
        
        for (int i = 0; i < arr.length; i++) {
			System.out.println(i + "의 개수 : " + arr[i]);
		}
		*/
		
		// 7 번
		/*
		char[] arr = new char[5];
		
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (char) ((int)(Math.random() * 26) + 65);
		}
		Arrays.sort(arr);
		System.out.println(Arrays.toString(arr));
		
		System.out.println(arr.toString());
		
		char[] arrReverse = new char[5];
		int j = 0;
		for (int i = arr.length - 1; i >= 0; i--) {
			arrReverse[j] = arr[i];
			j++;
		}
		System.out.println(Arrays.toString(arrReverse));
		arr = arrReverse;
		System.out.println(Arrays.toString(arr));
		
		System.out.println(arr.toString());
		System.out.println(arrReverse.toString());
		*/
	
		
		// AES 정렬 / DESC 정렬
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
