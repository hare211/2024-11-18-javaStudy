/*
 * 	=> 다중 조건문 ==> 58 page => 해당 조건에 맞는 내용 한 개 실행 (else if 문)
 * 
 * 	
*/

public class 제어문_선택조건문4 {
	public static void main(String[] args) {
		int a = 15; // 단일, 다중 / 조건이 여러 개 수행하는 지
		if (a % 3 == 0) {
			System.out.println(a + "은(는) 3의 배수입니다");
		} if (a % 5 == 0) {
			System.out.println(a + "은(는) 5의 배수입니다");
		} if (a % 7 == 0) {
			System.out.println(a + "은(는) 7의 배수입니다");
		} /*else {
			System.out.println(a + "은(는) 3, 5, 7 의 배수가 아닙니다");
		}*/
	}
}
