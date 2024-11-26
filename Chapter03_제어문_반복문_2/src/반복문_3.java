/*
 * 	ABCD
 * 	EFGH
 * 	IJKL
 * 	MNOP
 * 
 * 	ABCD
 * 	ABCD
 * 	ABCD
 * 	ABCD
 * 
 * 	
*/
public class 반복문_3 {
	public static void main(String[] args) {
		char c = 'A';
		
		for (int i = 1; i <= 4; i++) {
			for (int j = 1; j <= 4; j++) {
				System.out.print(c++);
			}
			System.out.println();
		}
		
		for (int i = 1; i <= 4; i++) {
			for (int j = 1; j <= 4; j++) {
				System.out.print(c++);
			}
			System.out.println();
			c = 'A';
		}
		
		for (int i = 1; i <= 4; i++) {
			for (int j = 1; j <= 4; j++) {
				System.out.print(c);
			}
			System.out.println();
			c++;
		}
		
		for (int i = 1; i <= 4; i++) {
			for (int j = 1; j <=4; j++) {
				if (i == j) {
					System.out.print("#");
				} else {
					System.out.print(j);
				}
			}
			System.out.println();
		}
		
		for (int i = 1; i <= 4; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		System.out.println();
		
		for (int i = 1; i <= 4; i++) {
			for (int j = 1; j <= 5 - i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		
		for (int i = 1; i <= 6; i++) {
			for (int j = 1; j <= 6; j++) {
				if (i + j == 6) {
					//System.out.println("[" + i  + ", " + j + "]");
					System.out.printf("[%d, %d]\n", i, j);
				}
			}
		}
		
		for (int i = 1; i <= 4; i++) {
			
			for (int j = 1; j <= 4 - i; j++) {
				System.out.print(" ");
			}
			for (int k = 1; k <= i; k++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		for (int i = 1; i <= 4; i++) {
			for (int j = 1; j <= i - 1; j++) {
				System.out.print(" ");
			}
			for (int k = 0; k < 5 - i; k++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

}
