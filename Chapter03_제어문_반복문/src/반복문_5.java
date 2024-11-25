// 1 ~ 100 사이의 3의 배수 합, 5의 배수 합, 7의 배수 합
public class 반복문_5 {
	public static void main(String[] args) {
		int sum3 = 0;
		int sum5 = 0;
		int sum7 = 0;
		
		for (int i = 0; i <= 100; i += 3) {
			sum3 += i;
		}
		for (int i = 0; i <= 100; i += 5) {
			sum5 += i;
		}
		for (int i = 0; i <= 100; i += 7) {
			sum7 += i;
		}
		
		System.out.println(sum3);
		System.out.println(sum5);
		System.out.println(sum7);
		
		/*for (int i = 1; i <= 100; i++) {
			if (i % 3 == 0) {
				sum3 += i;
			}
			if (i % 5 == 0) {
				sum5 += i;
			}
			if (i % 7 == 0) {
				sum7 += i;
			}
		}*/
		
		System.out.println(sum3);
		System.out.println(sum5);
		System.out.println(sum7);
	}

}
