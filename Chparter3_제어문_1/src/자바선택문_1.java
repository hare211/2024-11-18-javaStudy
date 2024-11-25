/*
 * 	선택문 : 다중조건문을 단순화 시킨 프로그램
*/
// 다중조건문 동일 => 한 개의 case 에 있는 문장만 수행
public class 자바선택문_1 {
	public static void main(String[] args) {
		int score = (int)(Math.random() * 101);
		int avg = score / 10; // 0 ~ 10
		
		
		// 다중조건문보다 가독성이 좋다
		// ========= 범위를 지정하기 때문에 => 페이징
		// 선택문은 범위 지정이 불가능
		// => 데이터베이스는 10000 단위 가능
		switch (avg) {
		case 10:
		case 9:
			System.out.println(score + "점은 A 등급입니다");
			break;
		case 8:
			System.out.println(score + "점은 B 등급입니다");
			break;
		case 7:
			System.out.println(score + "점은 C 등급입니다");
			break;
		case 6:
			System.out.println(score + "점은 D 등급입니다");
			break;
		default:
			System.out.println(score + "점은 F 등급입니다");
			break;
		}
	}

}
