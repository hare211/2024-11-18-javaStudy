/*
 * 	break ==> 사용하는 위치 반복문, 선택문에서만 사용이 가능
 * 				조건문에서는 사용이 불가능
 * gitHub
*/
public class 반복제어문_1 {
	public static void main(String[] args) {
		for (int i = 1; i <= 10; i++) {
			if (i == 5) {
				continue; // i++ 로 이동 => 6 부터 출력된다
			}
			System.out.print(i + " ");
			
		}
	}

}
