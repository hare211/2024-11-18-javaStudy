/*
 * 	비교연산자 => 숫자나 논리만 비교
 * 			=> "" == "" => equals()
 * 		|
 * 
 * 		== : 같다
 * 		!= : 같지 않다
 * 		================ 오라클 : =, <> => JavaScript : ===
 * 		<, > : 보다 작거나, 크다
 * 		<=, >= : 보다 작거나, 크거나 같다
 * 
 * 		===> 결과값은 true / false ===> 조건문
*/
public class 연산자_이항연산자_비교연산자1 {
	public static void main(String[] args) {
		System.out.println(6 == 7);
		System.out.println(6 != 7);
		System.out.println(6 < 7);
		System.out.println(6 > 7);
		System.out.println(6 <= 6);
		System.out.println(6 >= 6);
		
		System.out.println("============");
		
		char c = 'A';
		int a = 65;
		// char는 연산처리되면 점수 변경
		System.out.println(c == a);
		
	}

}
