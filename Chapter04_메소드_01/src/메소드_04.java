/*
 * 	사용자로부터 단을 입력 받아서 해당 구구단을 출력
 * 	---------				-----------
 * 		매개변수					리턴형 => 자체 void
 *								리턴형 => String 
 */								
		
import java.util.*;
public class 메소드_04 {
	public static void main(String[] args) {
		process();
	}
	
	
	static String multiTables(int a) {
		String result = "";
		for (int i = 1; i < 10; i++) {
			result = a + " * " + i + " = " + (a * i);
			System.out.println(result);
		}
		
		return result;
		
	}
	
	/*
	static void multiTable(int a) {
		for (int i = 1; i < 10; i++) {
			System.out.print(a + " * " + i + " = " + (a * i));
			System.out.println();
		}
	}
	*/
	
	static void process() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("단 수 입력(2 ~ 9) : ");
		int multi = scanner.nextInt();
		
		// 메소드 호출
		multiTables(multi);
		
	}

}
