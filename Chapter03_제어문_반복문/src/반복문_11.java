
public class 반복문_11 {
	public static void main(String[] args) {
		/*for (char c = 'A';  c <= 'Z'; c += 2) {
			System.out.print(c + " "); 	
		} */
		// 증가식은 한 개만 증가하는 것이 아니라 경우에 따라 여러 개 증가도 가능
		for (int i = 1; i <= 10; i++) {
			if (i % 2 == 1) {
				System.out.print(i + " ");
			}
		} System.out.println();
		for (int i = 1; i <= 10; i += 2) {
			System.out.print(i + " ");
		}
		
		System.out.println();
		// 1 ~ 100 => 5의 배수를 다 출력하시오
		
		for (int i = 5; i <= 100; i += 5) {
			System.out.print(i + " ");

		
			
		}
	}

}
