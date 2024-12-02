import java.util.Arrays;
import java.util.Iterator;

public class 배열문제 {
	public static void main(String[] args) {
		// 2 번
		/*
		char[] c = new char[5];
		int[] arr = {0, 1, 2, 3, 4, 5};
		char[] c1 = {'일', '월', '화', '수', '목', '금', '토'};
		boolean[] b = {true, false, false, true};
		*/
		
		// 3 번
		/*
		char[] alpha = {'a', 'b', 'c', 'd'};
		for (int i = 0; i < alpha.length; i++) {
			System.out.print(alpha[i]);
		}
		*/
		
		// 4 번
		/*
		int[] arr = new int[10];
		for (int i = 0; i < args.length; i++) {
			arr[i] = (int) (Math.random() * 100) + 1;
			if (arr[i] % 3 == 0) {
				System.out.print(arr[i] + " ");
			}
		}
		*/
		
		// 5 번
		
		/*
		int[] arr = new int[10];
		double avg = 0.0;
		int total = 0;
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int) (Math.random() * 10) + 1;
			System.out.print(arr[i] + " \n");
			total += arr[i];
		}
		
		avg = total / (double) arr.length;
		System.out.println("평균 : " + avg);
		*/
		
		// 6 번
		/*
		int[] num = {94, 85, 95, 88, 90};
		int max = 0;
		int min = 100;
		
		
		for (int i : num) {
			if (max < i) {
				max = i;
			}
			if (min > i) {
				min = i;
			}
		}
		*/
		/*
		for (int i = 0; i < num.length; i++) {
			if (num[i] > max) {
				max = num[i];
			}
			if (num[i] < min) {
				min = num[i];
			}
		}
		System.out.println("최대값 = " + max + " 최소값 = " + min);
		*/
		
		// 7 번
		
		int[] arr = new int[10];
		
		int total = 0;
		double avg = 0.0;
		
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int) (Math.random() * 10) + 1;
			total += arr[i];
		}
		avg = total / (double) arr.length;
		System.out.println(Arrays.toString(arr) + "\n평균 : " + avg);
		
		// 8 번
		/*
		int[] arr = {10, 20, 30, 50, 3, 60, -3};
		
		System.out.println(arr[1]);
		
		// 9 번
		int index = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == 60) {
				index = i;
			}
		}
		System.out.println("index = " + index)
		*/
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
