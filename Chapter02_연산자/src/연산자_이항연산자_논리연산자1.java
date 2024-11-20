/*
 * 		&&	||
 * 		(조건) && (조건)	==> 범위, 기간 안에 있는 경우
 * 		-----	-----			1 <= a && a <= 100 ===> 직렬연산자
 * 		  |		  |
 * 		 -----------
 * 			  |
 * 			결과값 => true / false
 * 
 * 		(조건)  ||  (조건)		==> 범위 밖에 있는 경우 ===> 병렬연산자
 * 		-----	   -----		
 * 		  |			 |
 * 		----------------
 * 			   |
 * 			결과값 => true / false	
 * 
 * 		
 * 
 * 
 * 
*/
public class 연산자_이항연산자_논리연산자1 {

	public static void main(String[] args) {
		
		int x = 10;
		int y = 9;
		
		// boolean bCheck = x < y && x == ++y;
		// true ==> true 확인
		// false ==>
		
		boolean bCheck = x < y || x == ++y;
		System.out.println(bCheck);
		System.out.println(x);
		System.out.println(y);
		
		// && => 예약일, 체크인
		// || => 유효성 검사
		/*
		 * 	국어, 영어, 수학 입력 => 총점. 평균
		 * 	=> int kor = 입력
		 * 	=> int eng = 입력
		 * 	=> int math = 입력
		 * 
		 *		int total = kor + eng + math
		 *		double avg = total / 3.0
		 *	// 코테, 점수x, 제한
		 *
		 *	문자열 입력
		 *	=> ABBA
		*/
	}
}
