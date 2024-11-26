// 10개의 정수를 추출해서 최소값,최대값을 구하는 프로그램 
// 1~100사이 
// 50 56 57 90 87  67 56 34 23 78 
public class 반복문_8 {
	public static void main(String[] args) {
		
		int max = 1, min = 100;
		int count = 0;
		for (int i = 1; i <= 10; i++) {
			int num = (int)(Math.random() * 100) + 1;
			
			System.out.print(num + " ");
			
			if (max < num) {
				max = num;
			} if (min > num) {
				min = num;
			} if (num % 3 == 0) {
				count++;
			}
		}
		System.out.println();
		System.out.println("최대값 : " + max);
		System.out.println("최소값 : " + min);
		System.out.println("3의 배수 개수 : " + count);
	}

}
