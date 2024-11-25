import java.util.*;

public class 반복문_3 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("단 입력 : ");
		
		int table = scanner.nextInt();
		
		System.out.println("===== 요청 결과값 ======");
		for (int i = 1; i < 10; i++) {
			System.out.println(table + " * " + i + " = " + table * i);
		}
		
		
		int n = 10; // 출력할 수열의 길이
	    int a = 0, b = 1;

	    System.out.print(a + " " + b + " "); // 첫 두 항 출력
	    for (int i = 2; i < n; i++) {
	    		int next = a + b;
	            System.out.print(next + " ");
	            a = b;
	            b = next;
	        }
	}

}
