package com.sist.exception;

import java.time.DayOfWeek;
import java.time.LocalDate;

/*
 * 263 page
 * 예외 : 수정이 가능한 에러(가벼운 에러)
 * 	= 사전적 의미 : 일반적이지 않은 상황
 * 		=> 프로그램에서 문제 발생
 * 		=> 사용자의 입력이나 제어 => 유효성 검사
 * 								-------
 * 								자바 스크립트
 * 								=> 자바 : if
 * 								=> 스프링 : validation
 * 		=> 개발자의 실수
 * 		   ---------
 * 			본인이 에러 => 찾기가 어렵다
 * 			----------------------
 * 			=> 소스를 비교(X)
 * 			=> Output 창 => 디버깅
 * 			=> 실무
 * 			---------------------- 비정상 종료 : 방지하는 프로그램
 * 									----------------------
 * 									예외처리 => 정상 종료를 할 수 있게 만든다
 * 		
 * 에러 : 수정이 불가능(치명적인 에러) => 메모리 부족, 인터넷 문제
 * ------------------------------------------------------------------
 * 자바 :
 * 		javac : 컴파일, java : 인터프리터(런타임)
 * 		컴파일 에러 : 컴파일 시 에러 => 문법 에러
 * 		런타임 에러 : 실행 시 에러 => 사용자 입력 / 출력 => 배열 범위 초과
 * 		논리적 에러 : 웹에서 발생
 * 					------ 실행은 되지만 기존 의도와는 다르게 동작
 * 		-------------------------------------------------------
 * 		중요점 
 * 		=> 다른 개발자가 분석 => 가독성(개발 / 유지보수)
 * 		=> 속도, 최적화
 * 		=> 견고성 -> 에러 발생 시 종료하지 않고 정상 수행 가능
 * 		   ----
 * 			1) 에러를 사전에 방지하는 법
 * 				=> 우선 if 문으로 방지
 * 			2) 예외처리
 * 				*** 변수 초기값
 * 				우선 명시적 초기화
 * 				=> 명시적 초기화가 안되는 경우 => 외부에서 읽어서 데이터 대입
 * 				=> 생성자 / 초기화 블럭
 * 			=> 가벼운 에러 -> 수정이 가능한 에러
 * 			예) FileReader fr = new FileReader("경로명/파일명")
 * 				Document doc = Jsoup.connect("URL주소").get()
 * 				Socket socket = new Socket("서버주소", port)
 * 
 * 				웹에서 번호로 표시(브라우저)
 * 				웹 => URL 주소 => 마지막에 파일명 지정
 * 				404 : 요청한 파일이 없는 경우
 * 				500 : 자바 소스의 오류
 * 				400 : Bad Request
 * 				415 : GET / POST / PUT / DELETE
 * 		=> 0 으로 나눈 경우 / 정수 변환 / 배열 범위 초과
 * 		NumberFormateException
 * 		ArrayIndexOfBoundsException
 * 		=> 메모리 할당 => 주소가 없는 경우
 * 		NullPointerException
 * 		=> 매개 변수에 값 전송(다른 값을 전송)
 * 		=> 클래스 형변환...
 * 		ClassCastException
 * 
 * 	예외처리의 종류
 * 	예외처리 크기(계층 => catch => 순서지정)
 * 	예외복구 : try ~ catch ~ finally => 가급적이면 예외처리로 주로 사용
 * 			예외가 발생하면 복구해서 다시 수행 가능
 * 		*** 예외나 에러가 없게 프로그램을 제작
 * 
 *   		try {
 * 			정상 수행 문장
 * 			(오라클 연결
 * 			SQL 문장 전송 => SQL
 * 			결과값 받기)
 * 			=> 예외 발생 가능
 * 			=> main -> 평상 시 코딩
 * 			예외 발생 -> catch로 이동
 * 		} catch(예상되는 예외 클래스) { -> 여러 개 사용 가능, 클래스의 크기, 순서 중요
 * 			예외가 발생 시 처리
 * 			getMessage() -> 에러 내용 출력, printStatckTrace() -> 에러 라인 출력
 * 		} finally {
 * 			try / catch 상관없이 무조건 수행하는 문장
 * 			(오라클 닫기)                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                 
 * 		}
 * 

 * 	------------------------------------------------
 * CheckException : 컴파일 시에 예외처리 여부 확인
 * 	=> 반드시 예외처리를 해야 사용이 가능
 * 	=> java.io / java.sql / java.net
 * 		: IOException
 * 		: SQLException
 * 		: MalformedURLException
 * 	=> java.lang => 리플렉션
 * 		: ClassNotFoundException
 * 	=> javax.http.* => JSP => X
 * 	=> jakarata.http
 * 	   -------------
 * 		이클립스 => 톰캣 => 최신 -> 10 버전 => 스프링(스프링부트)
 * 		=> 스프링 편집기 버전 다운 => JDK, 톰캣 마찬가지
 * 
 * UnCheckException : 예외처리 여부 확인 X
 * 	=> 필요 시에만 예외처리
 * 	=> NullPoniterException : 메모리 할당 X
 * 		선언만 한 경우 => 윈도우
 * 	=> NumberFormatException : 문자열 => 정수 변환
 * 	=> ArrayIndexOutOfBoundsException : 배열 범위 초과
 * 	=> ClassCastException : 클래스 형변환
 * 	=> ArithemticException : 0 으로 나눈 경우
 * 
 * 	=> 한 번에 처리가 가능 : RunimeException
 * -------------------------------------- Exception
 * 
 *    			    Object	
 * 					  |
 * 			      Throwable
 * 					  |
 * 		-----------------------------
 * 		|							|
 * 	  Error						Exception
 * 	  ----- 처리가 불가능
 * 			메모리 부족
 * 			
 * 
 * 				Exception
 * 		   			|
 * Check ------------------------- UnCheck
 * => 빈드시 예외처리				=> 필요 시에만 예외처리
 * => 컴파일러가 감시
 * 	----------------------------------------------------
 * 	정의 : 사전에 에러를 방지하는 프로그램
 * 	목적 : 프로그램의 비정상 종료를 방지하고 정상 상태를 유지
 * 
 * 	try {
 * 		1
 * 		2
 * 		3
 * 	} catch (예외처리 클래스) {
 * 		4
 * 	}
 * 	
 * 
 * 	예외회피 : trhows => 메서드 선언 뒤에 서술
 * 				=> 예약, 떠맡기기 => 다음에 사용 시에 예외처리를 해서 사용
 * 				=> 라이브러리
 * 	임의로 발생 : 테스트, 배포 전에 확인 => throw
 * 				정상 상태 유지
 * 				throw new Exception(); -> Exception 을 찾아간다
 * 	사용자 정의 예외 : 자바에서 지원하지 않는 예외처리가 있는 경우
 * 		class MyException extends Exception {
 * 		}
 * 		=> if 문으로 사용 가능
 * 		=> 비밀번호 => 대소문자 + 특수문자 + 8자 이상
 * 				  => length() + 정규식
 */

public class 예외처리_1 {
	public static void main(String[] args) {
		
		String str = "hello";
		String str1 = "hello java java java";
		
		System.out.println(str);
		System.out.println(str1);
		
		str = "hi";
		
		System.out.println(str);
		System.out.println(str1);
		
		System.out.println(str1.replace("java", "ehit"));
		
		
		int year = 2024;
		int month = 12;
		LocalDate firstDayOfMonth = LocalDate.of(year, month, 1);
		LocalDate firstDayOfNextMonth = firstDayOfMonth.plusMonths(1);
		
		System.out.println("Su Mo Tu We Th Fr Sa");
		int offset = firstDayOfMonth.getDayOfWeek().getValue() % 7;
		for (int i = 0; i < offset; i++) {
			System.out.print("   ");
		}

		LocalDate ldt = firstDayOfMonth;
		while (ldt.isBefore(firstDayOfNextMonth)) {
			System.out.printf("%2d ", ldt.getDayOfMonth());
			if (ldt.getDayOfWeek() == DayOfWeek.SATURDAY) {
				System.out.println();
			}
			ldt = ldt.plusDays(1);
		}
	}
}

















