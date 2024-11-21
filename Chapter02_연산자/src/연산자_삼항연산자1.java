/*
 * 	삼항연산자 => 웹 / 게임 ==> 소스를 간결하게 만드는 경우
 * 	------- if ~ else
 * 
 * 		(a == 1)? 
 * 
 * 	웹
 * 
 * 	
 * 			
*/
public class 연산자_삼항연산자1 {

	public static void main(String[] args) {
		char c = 'A';
		System.out.println('A' <= c && c <= 'Z' ? "대문자" : "소문자");
		
		int a = (int)(Math.random() * 100) + 1;
		System.out.println("a = " + a);
		System.out.println(a % 2 == 0 ? "짝수" : "홀수");
		
		c = 'A';
		System.out.println('a' <= c && c <= 'z' ? "소문자" : "대문자");
		
		/*
		 * 		
		*/
	}
}
