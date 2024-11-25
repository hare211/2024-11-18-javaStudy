// 정수를 입력을 받아서 짝수/홀수
// random() => 1~100
// random() => 두개 발생(1~100) 
// => 최대값 / 최소값을 출력하는 프로그램을 만든다



public class 제어문_선택조건문2 {
	public static void main(String[] args) {
		// 임의의 정수
		/*int num = (int)(Math.random() * 100) + 1;
		
		if (num % 2 == 0) {
			System.out.println(num + "는(은) 짝수입니다");
		} else {
			System.out.println(num + "는(은) 홀수입니다");
		}*/
		
		int num1 = (int)(Math.random() * 100) + 1;
		int num2 = (int)(Math.random() * 100) + 1;
		
		if (num1 < num2) {
			System.out.println("최소값은 " + num1 + " 이고, " + "최대값은 " + num2 + " 입니다");
		} else if (num1 == num2) {
			System.out.println(num1 + ", " + num2 + "으로 값이 동일합니다");
		} else {
			System.out.println("최소값은 " + num2 + " 이고, " + "최대값은 " + num1 + " 입니다");
		}
		
		System.out.print(Math.min(num1, num2) + ", ");
		System.out.println(Math.max(num1, num2));
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
