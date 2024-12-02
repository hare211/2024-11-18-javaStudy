/*
 * 6 개의 난수 발생 => 중복이 없는 데이터 출력 (1 ~ 45 사이의 난수)
*/
public class 배열_5 {
	public static void main(String[] args) {
		/*
		// 선언
		int[] lotto = new int[6];
		// 초기값
		for (int i = 0; i < lotto.length; i++) {
			lotto[i] = (int) (Math.random() * 45) + 1;
			for (int j = 0; j < lotto.length; j++) {
				if (lotto[i] == lotto[j]) {
					i--;
					break;
				}
			}
		}
		// 처리
		for (int i : lotto) {
			System.out.print(i + " ");
		}
		*/
		
		String str1 = "Hello, ";
		String str2 = "World";
		
		String result = new StringBuilder().append(str1).append(str2).toString();
		System.out.println(result);
	}

}
