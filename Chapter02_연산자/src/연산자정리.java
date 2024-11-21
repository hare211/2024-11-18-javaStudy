/*
 * 	데이터 저장 (변수) =====> 요청 처리
 * 							연산자 / 제어문
 * 	
 * 	단항연산자
 * 		증감연산자 / 형변환연산자 / 부정연산자
 * 								=> 조건문 / 반복문 조건 => 제어문
 * 									! (boolean 으로 사용이 가능)
 * 										!true => false
 * 										!false => true
 * 					=> 실수 => 정수
 * 						(데이터 형)변수 | 값
 * 					=> 크기 순서
 * 							DownCasting			UpCasting
 * 							<====				====>
 * 						byte < short < int < long < float < double
 * 							   char
 * 						변수 => 작은 데이터는 저장이 가능
 * 						long a = 10;
 * 								 -- int 데이터 => 자동으로 long 으로 변경
 * 								 -- 10 => 10L
 * 						int a = 'A'
 * 								 -- int 데이터
 * 						** 주의점 : 큰 데이터는 첨부가 불가능
 * 						int a = 10.0 => 오류 발생
 * 								=== 큰 데이터
 * 						** float / double => f / F
 * 						** int / long => l / L
 * 						** 형변환 => 클래스 형변환
 * 		++, --, : 1씩 증가, 1씩 감소 => for 문
 * 	이항연산자
 * 		산술연산자 (+, -, *, /, %)
 * 			** 산술규칙
 * 			1) 같은 데이터 형만 연산이 가능
 * 				long + int 
 * 						===
 * 						long 변경 => 자동으로 큰 데이터 형으로 변경 후에 연산
 * 				=> long + long
 * 				예) 10.5 + 10
 * 							===
 * 							10.0 => 10.5 + 10.0 ==> 20.5
 * 					'A' + 10
 * 					===
 * 					65 ========> 65 + 10 = 75
 * 			2) int 이하 데이터 형을 연산 => 결과값이 int
 * 				===== byte / short / char
 * 				byte + byte = int
 * 				char + char = int
 * 				short + char + byte = int
 * 			3) char 는 연산 시에 자동으로 정수 형으로 변경 후에 처리
 * 			** 연산처리
 * 				+ : 더하기, 문자열 결합
 * 							=======
 * 							5 + "5" => "55"
 * 							"5" + 5 => "55"
 * 				/ : 0 으로 나눌 수 없다 => 오류 발생
 * 					정수 / 정수 = 정수
 * 					==============	5 / 2 = 2
 * 				% : 나머지
 * 					부호 (+, -,)
 * 					5 % 2 = 1
 * 					-5 % 2 = -1
 * 					-5 % -2 = -1
 * 					------
 * 					5 % -2 = 1
 * 					=> 나눠지는 수의 부호를 따라감
 * 			*** 가장 많이 사용되는 연산
 * 				=> 합 / 평균
 * 				=> 웹프로그램 : 로직이 없다, 흐름 
 * 
 * 				===================== 조건문 / 반복문 => 결과값 : true / false
 * 		비교연산자
 * 			문자열은 비교할 수 없다 / 문자, 숫자, 논리
 * 			=> == 같다
 * 			   != 같지 않다
 * 			   <, > <=, >=
 *			=> if (부정연산자 / 비교연산자 / 논리연산자) => 조건
 *			=> 평문
 *			===================================
 *			=> 조건문 : 필요 시 사용, 불필요 시 건너뛴다
 *			=> 반복문 : 게임 
 *			================ 흐름 제어
 * 		논리연산자
 * 			&& => 범위 포함 (기간)
 * 			char a = 'B'
 * 			'A' <= a && a <= 'Z'
 * 			|| => 범위 밖에 있는 경우
 * 			'A' > a || a > 'Z'
 * 
 * 			int score;
 * 			0 > score || score > 100 => 다시 입력하시오
 * 			(조건) && (조건)  
 *    	    -----    -----      
 *   	      |        |
 *            ----------
 *     		       |
 *     		     결과값 => true/false 
 *     		&& 조건 두 개가 true 일 때만 true => 나머지는 false
 *     		*** && 앞에 있는 조건이 false => 뒤에 있는 조건 처리하지 않는다
 *     			=> 효율적인 연산
 *      	(조건) || (조건)  
 *    	    -----    -----      
 *   	      |        |
 *            ----------
 *     		       |
 *     		     결과값 => true/false 
 *     		|| 조건 중에 한 개 이상의 true 있으면 true
 *     		*** || 앞에 있는 조건이 true => 뒤에 있는 조건 처리하지 않는다
 *     ==============================
 * 		대입연산자
 * 
 * 	삼항연산자
 * 		=> 조건문
 * 		=> 변수 / 연산자 / 제어문 => 문법, 형식, 동작 순서
 * 			=> 1. 배열 2. 메소드 3. 객체지향 4. JDBC
*/
// 점수 => random => 60 이상 짝수
public class 연산자정리 {
	public static void main(String[] args) {
		// 점수
		int score = (int)(Math.random() * 101);
		// 0 ~ 100
		System.out.println("score : " + score);
		
		boolean bCheck = 60 <= score && score % 2 == 0;
		System.out.println("bCheck = " + bCheck);
		/*
		 * 	90 <= score && score < 95
		*/
		
	}
	
	
	
	
	
	
	

}
