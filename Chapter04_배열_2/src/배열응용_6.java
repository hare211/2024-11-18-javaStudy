import java.util.Arrays;

public class 배열응용_6 {
	static void sort(int[] arr) {
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] < arr[j]) {
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
	}
	public static void main(String[] args) {
		int[] arr = new int [5];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int) (Math.random() * 100) + 1;
		}
		System.out.println("정렬 전 :");
	
		
		for (int i : arr) {
			System.out.print(i + " ");
		}
		System.out.println();
		System.out.println("정렬 후 : ");
		sort(arr);
		
		
		System.out.print(Arrays.toString(arr));
		
		
	}
	
	
	
	
	
	
	
	
	


}
