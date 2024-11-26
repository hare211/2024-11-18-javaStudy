// 1 ~ 10 까지 난수 => 10 을 발생 => 평균
public class 반복문_2 {
	public static void main(String[] args) {
		double avg = 0.0;
		int sum = 0;
		
		int i = 1;
		
		while (i <= 10) {
			int num = (int)(Math.random() * 10) + 1;
			System.out.print(num + " ");
			sum += num;
			i++;
		}
		System.out.println("\n난수의 평균 : " + (sum / 10.0));
	}

}
