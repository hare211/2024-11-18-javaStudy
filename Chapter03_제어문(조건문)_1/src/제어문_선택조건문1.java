/*
 * 	선택조건문
 * 		= 조건 true 일 때 처리
 * 		= 조건 false 일 때 처리
 * 		-------------------- 나눠서 작업
 * 		예) 로그인 (O), 로그인 (X)
 * 
 * 		형식) ==> 56 page
 * 		==> 무조건 수행
 * 		if (조건문) {
 * 			조건문 true 일 때 처리하는 문장 ==> 종료
 * 		} else {
 * 			조건문 false 일 때 처리하는 문장 ==> 종료
 * 		}
 * 
 * 		점수 입력 ==> 
 * 		60 이상 합격 ==> 불합격
 * 		if (60 <= score) 
 * 		if (60 > score) ==> else
*/
public class 제어문_선택조건문1 {
	public static void main(String[] args) {
		char c = 'A';
		int type = (int)(Math.random() * 2); // 0, 1
		
		if (type == 0) {
			c = (char)((Math.random() * 26) + 65);
		}
		if (type == 1) {
			c = (char)((Math.random() * 26) + 97);
		}
		System.out.println("c = " + c);
		
		System.out.println("==== 결과값 ====");
		if ('A' <= c && c <= 'Z') {
			System.out.println(c + "는(은) 대문자입니다");
		}
		/*if ('a' <= c && c <= 'z') */
		else{
			System.out.println(c + "는(은) 소문자입니다");
		}
	}

}
