import java.util.Arrays;
import java.util.Iterator;

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
			System.out.println("사원(" + (i + 1) + ")" + arr[i]);
			sum += arr[i];
		}
		System.out.println("총점 : " + sum + "\n평균 : " + (sum / (double) arr.length));
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
		
		int num = 0;
		int[] count = new int[10];
		for (int i = 0; i < 100; i++) {
			num = (int) (Math.random() * 10);
			if (num == 0) {
				count[0]++;
			} else if (num == 1) {
				count[1]++;
			} else if (num == 2) {
				count[2]++;
			} else if (num == 3) {
				count[3]++;
			} else if (num == 4) {
				count[4]++;
			} else if (num == 5) {
				count[5]++;
			} else if (num == 6) {
				count[6]++;
			} else if (num == 7) {
				count[7]++;
			} else if (num == 8) {
				count[8]++;
			} else if (num == 9) {
				count[9]++;
			}
		}
		
		for (int i = 0; i < count.length; i++) {
			System.out.println(i + "의 개수 : " + count[i]);
		}
		System.out.println(Arrays.toString(count));
		
		
		// 7 번
		
		char[] arr = new char[5];
		
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (char) ((char)(Math.random() * 26) + 65);
		}
		Arrays.sort(arr);
		System.out.println(Arrays.toString(arr));
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
