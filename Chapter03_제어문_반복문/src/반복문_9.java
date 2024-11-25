
public class 반복문_9 {
	public static void main(String[] args) {
		int dcnt= 0, scnt = 0;
		
		for (int i = 1; i < 11; i++) {
			char c = 'A';
			int no = (int)(Math.random() * 2);
			// 0, 1
			
			if (no == 0) {
				c = (char)((Math.random() * 26) + 65);
			} else {
				c = (char)((Math.random() * 26) + 97);
			}
			
			System.out.print(c + " ");
			
			if ('A' <= c && c <= 'Z') { // 대문자라면
				dcnt++;
			} else {
				scnt++;
			}
		}
		System.out.println();
		System.out.println("대문자 개수 :" +scnt);
		System.out.println("소문자 개수 :" +dcnt);
		
	}

}
