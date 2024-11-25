/*
 * 3 - 5 -> 봄
 * 6 - 8 -> 여름
 * 9 - 11 -> 가을
 * 12 - 2 -> 겨울
*/
public class 자바선택문_2 {
	public static void main(String[] args) {
		int month = (int)(Math.random() * 12) + 1; // 1 ~ 12
		
		switch (month) {
		case 3, 4, 5:
			System.out.println(month + "월은 봄입니다.");
			break;
		case 6, 7, 8:
			System.out.println(month + "월은 여름입니다.");
			break;
		case 9, 10, 11:
			System.out.println(month + "월은 가을입니다.");
			break;
		case 1, 2, 12:
			System.out.println(month + "월은 겨울입니다.");
		}
	}

}
