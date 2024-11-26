
public class 반복문_1 {
	public static void main(String[] args) {
		// 1 ~ 10
		System.out.println("===== for =====");
		for (int i = 1; i <= 10; i++) {
			System.out.print(i + " ");
		}
		
		System.out.println("\n===== while =====");
		int i = 1;
		while (i <= 10) {
			System.out.print(i + " ");
			i++;
		}
		
		System.out.println("\n===== do ~ while =====");
		i = 1;
		do {
			System.out.println(i + " ");
			i++;
		} while (i <= 10);
	}

}
