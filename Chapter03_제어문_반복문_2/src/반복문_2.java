
public class 반복문_2 {
	public static void main(String[] args) {
		for (int i = 1; i <= 9; i++) {
			for (int j = 2; j <= 9; j++) {
				System.out.printf("| %2d * %2d = %2d |", j, i, j * i);
			}
			System.out.println();
		}
	}
}
