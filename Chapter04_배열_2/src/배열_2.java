/*
 * char 배열 사용법 / double / String
 * => 응용 => 정령 / 달력... / 중복없는 난수
 * => 지니뮤직, 서울 여행, 맛집...
*/
public class 배열_2 {
	public static void main(String[] args) {
		char[] alpha = new char[26];
		// 초기화
		char c = 'A';
		// 인덱스 번호
		for (int i = 0; i < alpha.length; i++) {
			alpha[i] = c++; // A ~ Z 까지 입력
		}
		// 처리 => (X)
		// 출력
		for (char cc : alpha) {
			System.out.print(cc + " ");
		}
		System.out.println();
		
		// => 'K' 가 있는 인데스 번호를 출력
		int index = 0;
		for (int i = 0; i < alpha.length; i++) {
			if (alpha[i] == 'K') {
				index = i;
				break;
			}
		}
		System.out.println("K의 위치는 : " + index);
	}

}
