/*
 * 	1. 형식 / 문법
 * 	2. 간단한 예제 => 흐름 (동작 => 호출)
 * 	3. 약간 응용 => 확장
 * 	4. 기간이 지나면 감 => 2 ~ 3 월
 * 				 ---
 * 		=> 누적
 * 	-------------------------------------
 * 	데이터 저장
 * 		= 변수 : 한 개 데이터 저장
 * 		= 배열 : 여러 개를 연속적으로 저장 => 인덱스 : 고정적 / 같은 데이터형
 * 		= 클래스 : 여러 개 데이터 저장 => 다른 데이터형 => 동적 (new)
 * 		------------------------ 메모리에 저장
 * 		= 파일 => 종속 (파일과 파일의 연결이 어렵다)
 * 		= RDBMS(오라클)
 * 		사용자가 요청하면 => 처리
 * 		= 연산자
 * 		= 제어문
 * 		-------- 관련된 명령문 (기능을 모아서 처리) => 메소드
 * 		사용자가 요청한 위치에 처리 결과 출력
 * 		= 브라우저 출력 (웹)
 * 
 * 		-------------------------------
 * 		일반 자바 => 오라클 연결 자바 => 웹 연결 자바
 * 		-------------------------------
 * 		| 통합 : 스프링
 * 
 * 				method(int a, int b, int c...)
 * 				method(int[] arr)
 * 				method(int a, String s, double d...)
 * 				method(Class c)
 * 		메소드 : 결과값(리턴형), 사용자 요청값 (매개변수)
 * 				---------	-----------------
 * 				1 개만 가능	제한이 없다
 * 							=> 매개변수를 많이 사용하면
 * 								=> 묶어서 설정 (매개변수 3 개 이상)
 * 				=> 자바 / C => 1 개만 사용
 * 				return 값
 * 					여러 개 값이 있는 경우 : 배열 / 클래스
 * 				=> 파이썬 => 여러 개 가능
 * 				return 값, 값, 값... (데이터형 복합적 반환 가능)
 * 				변수, 변수, 변수 = 메소드
 * 
 * 				=> 프로그램
 * 					기본
 * 					= 입력 기능
 * 					= 요청 처리 기능 => 세분화
 * 					= 출력 기능
 * 					= 모든 메소드는 한 개의 기능만 수행 => 유지보수
 * 						=> 결제창 => 등록
 * 					= 교통 시스템
 * 						사고 / 공사 => 출력
 * 						CCTV => 위도 / 경도 opencv
 * 							--- 최적화 (속도, 사용자 편리성)
 * 					=> 프로그램 => 개발보다 유지보수에 초점
 * 										----- 가독성, 재사용
 * 									메소드 변경 / 메소드 추가
 * 		형식)
 * 			[접근지정어]	[옵션]	리턴형	메소드명	(매개변수) => 선언부, {구현부}
 * 										------	------- 사용자가 요청한 값 => 0 이상 사용 가능
 * 										기능별 구분자
 * 										=> 문법은 변수 식별자와 동일
 * 										=> 약속 => 메소드는 소문자
 * 										=> 메소드명이 동일하면 안된다
 * 										=> 기능 => 처리가 다른 경우
 * 											-----------------
 * 											같은 메소드 명으로 사용 (오버로딩)
 * 			--------- 	---		---- 처리 결과값
 * 								기본형, 배열, 클래스
 * 								=> 1 개만 설정 가능
 * 						변경이 없는 final
 * 						선언만 abstract
 * 						자동 저장 => 공유
 * 						------ static
 * 			default
 * 			=> 같은 풀더에 존재
 * 				----- 패키지
 *  ------------------------------------------
 * 			리턴형			매개변수
 * 	------------------------------------------
 * 			O				O
 * 			String substring(int begin)
 * 				|				|
 * 				리턴형			매개변수
 * 	------------------------------------------
 * 			O				X
 * 			String trim() => 좌우 공백 제거
 * 			double random() => 0.0 ~ 0.99
 * 			-----		----
 * 	------------------------------------------
 * 			X				O
 * 			void System.out.println(String s)
 * 			--- 결과값 없다 => 메소드 자체 처리
 * 			| 오라클 연결 시 insert / update / delete
 * 	------------------------------------------
 * 			X				X => 사용빈도 거의 없음
 * 			void System.out.print() => 다음 줄에 출력 => <br>
 * 	------------------------------------------
 * 
 * 	메소드 호출
 * 	--------
 * 	메소드명(전송하는 값) => void
 * 	데이터형 변수 => 메소드명(전송하는 값)
 * 			|		|
 * 			---------
 * 	=> 왼쪽에 있는 데이터형이 크거나 같다 => 권장(같은 데이터형)
 * 	=> 통계 / 회계
 * 
 * 	메소드 제작
 * 	1) 반복이 많은 경우
 * 	2) 기능별로 나눠서 처리 => 단락
 * 	3) 다른 클래스와 연결
 * 	-------------------------
 * 	메소드 사용 목적
 * 	1) 반복 제거
 * 	2) 코드 관리를 쉽게 (소스를 간결)
 * 	3) 재사용
 * 
 *	void display() {
 *		1문장 -- 2
 *		2문장	 -- 3
 *		3문장 -- 4
 *		4문장 -- 5
 *		5문장 -- 6
 *	}
 *	메소드 => 시작 (JVM => 가장 먼저 호출)
 *	main() {
 *		1문장 -- 1
 *		display(); => 복귀
 *		2문장 -- 7
 *		3문장 -- 8
*/

import java.util.Arrays;
import java.util.stream.Stream;

public class 메소드_01 {
	static void display() {
		int i = 0; // display{} 안에서만 사용이 가능
		System.out.println("i = " + i);
		i++;
		// {}이 종료가 되면 자동으로 메모리에서 사라진다 => 지역변수
	}
	public static void main(String[] args) {
		System.out.println("main start");
		display();
		display();
		display();
		display();
		display();
		System.out.println("main end");
		
		String phoneNum = 메소드_01.formatPhoneNumner("01028185376");
		System.out.println(phoneNum);
		Integer[] arr = {2,1,2,1};
		int[] aR = Arrays.stream(arr)
						 .mapToInt(Integer::intValue)
						 .toArray();
		
		System.out.println(arr);
		System.out.println(aR);
		System.out.println(Arrays.toString(arr));
		System.out.println(Arrays.toString(aR));
		

	
		
	}
	public static String formatPhoneNumner(String phoneNumner) {
		String regEx = "(\\d{3})(\\d{3,4})(\\d{4})";
		return phoneNumner.replaceAll(regEx, "$1-$2-$3");
		
	}
}
