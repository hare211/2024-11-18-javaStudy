package com.sist.util;
/*
 * java.lang : 자바의 기본 라이브러리
 * 				=> import 생략
 * 		1) Object
 * 			clone() : 복제
 * 			equals() : 객체 비교
 * 			toString() : 객체 주소 문자열 변환
 * 		2) StringBuffer : 문자열 결합 => 제어
 * 						  -------- 
 * 							append()
 * 		3) Math : 수학 관련 메서드
 * 			ceil() : 올림 함수
 * 			random() : 난수 발생
 * 		4) System
 * 			println() : 화면 출력
 * 			gc() : 가비지 컬렉션 -> 메모리 즉시 회수
 * 			exit() : 프로그램 종료
 * 		5) Wrapper : 기본 데이터형을 클래스화 / 제네릭
 * 			Integer / Double / Boolean => parseInt, Double, Boolean()
 * 			=> 윈도우 / 웹 / 크롤링 => 모두 문자열로 들어온다 -> 문자열을 각 적합한 데이터형으로 변환할 필요가 있음
 * 		6) String : 이전 예제 참조
 * java.util : 프로그램 개발에 유용하게 사용되는 라이브러리
 * 		1) Random : 난수 발생
 * 			=> nextInt(100) -> 0 ~ 99
 * 		2) StringTokenizer : 구분자 별로 문자를 토큰으로 저장 -> 메모리 점진적으로 생성, 한 번 생성하여 불러낸 토큰은 다시 호출할 수 없음
 * 			=> countTokens() : 처음부터 끝까지 스캔하여 int 형으로 길이 반환
 * 			=> hasMoreTokens() : 다음 토큰이 존재하는 지 boolean 형으로 반환 -> 루프 돌릴 때 사용
 * 			=> nextToken() : 자른 토큰 호출
 * 		3) Date : 시스템의 시간 / 날짜
 * 					기능은 거의 없음 => 오라클 날짜 데이터 호환
 * 		4) Calendar : Date 보완
 * 			=> 날짜 관련 기능
 * 			=> 오늘 날짜 / 오늘 시간 / 오늘 요일 / 마지막 날짜
 * 	------------------------------------------------------
 * 		Collection : util 의 핵심
 * 					=> 표준화 / 가변형 / 항상 0 번부터 순서를 유지
 * 		ArrayList : 비동기적 => 데이터베이스 연결 시 용이
 * 		Vector : 동기적 => 네트워크 상에서 접속자 정보 저장 시 용이
 * 		Map : 웹 상에서 클래스 관리 => MyBatis / Spring -> 클래스 저장, SQL 문장 저장
 * 		Set : 중복 제거
 * 
 * 		=> LinkedList -> C 언어와의 호환
 * 			=> Queue
 * 		=> 배열 대신 사용 : 고정
 * 
 *		=> 데이터형(Object) => 프로그램에 맞게 데이터형 변경
 *			=> 제네릭 <String> <Sawon>
 *			=> 정수형 <int>(X) -> <Integer> 
 * 		---------------------------------------------------
 * 		*** SQL -> 웹의 핵심
 * 		
 */
public class 라이브러리_정리 {

}
