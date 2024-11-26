
public class 반복제어문_2 {
	public static void main(String[] args) {
		/*for (int i = 1; i < 4; i++) {
			for (int j = 1; j < 4; j++) {
				if (j == 2) {
					break;
				}
				System.out.println("i = " + i + ", j = " + j);
			}
			break; // 1 차 for 
		} */
		// 이름이 있는 break => 많이 사용하지 않는다
		outer : for (int i = 1; i < 4; i++) {
			for (int j = 1; j < 4; j++) {
				if (j == 2) {
					break outer;
					
				} System.out.println("i = " + i + ", j = " + j);
				
			}
			
		}
	}

}
