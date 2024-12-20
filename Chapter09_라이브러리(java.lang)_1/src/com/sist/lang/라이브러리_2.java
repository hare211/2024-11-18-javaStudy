package com.sist.lang;
/*
 * java.lang
 * 	1. Object
 * 	=> 최상위 클래스 -> 모든 클래스의 상위 클래스
 * 	   ----------
 * 		관리하는 기능 : 객체와 관련
 * 		객체 소멸 / 겍체 복제 / 객체 비교 / 객체 생성
 * 		-----	  ------	------	 -------
 * 									 getClass()
 * 							equals()
 * 				  clone()
 * 		finalize()
 * 	2. String : 문자열 관리 클래스
 * 		=> 웹 3대 클래스
 * 			String / ArrayList /  Integer
 * 		=> 오라클 연동 3대 클래스
 * 			Connection / ResultSet / Statement
 * 		기능
 * 		1) trim() : 공백 제거(좌우)
 * 		2) length() : 문자 개수
 * 		3) substring() : 문자를 자르는 경우
 * 		4) indexOf() / lastIndexOf() : 문자 위치 찾기
 * 		5) equals() : 문자 비교
 * 		   -------- 로그인
 * 		6) contains() : 포함 문자열
 * 		7) statsWith() : 시작 문자열 => 방문한 맛집
 * 			food_1 food_2
 * 		8) valueOf() => 다른 데이터형 문자열 변환
 * 			Cookie -> 저장 값이 String
 * 		9) replace() / replaceAll()
 * 		10) split()
 * 	3. StringBuffer : 문자열 결합 => append()
 * 	4. Math : random() / ceil()
 * 		=> 모든 메서드가 static 으로 만들어짐
 * 	5. System : println() / print() / printf()
 * 				gc() / exit(0) => 윈도우                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            
 * 	6. Wrapper
 * 		: 기본형 데이터를 클래스화 -> 사용 용이
 * 		byte => Byte
 * 		short => Short
 * 		int => Integer
 * 		long => Long
 * 		float => Float
 * 		double => Double
 * 		char => Character
 * 		boolean => Boolean
 * 		------------------- 기능(메서드)
 */
import java.io.*;
public class 라이브러리_2 {
	public static void main(String[] args) {
		try {
			// 시간 측정
			// log 파일 작성 시 사용
			long start = System.currentTimeMillis(); // 현재 시간
			
			FileReader fr = new FileReader("c:\\javaDev\\movie.txt");
			
			int i = 0; // <- 문자를 받는 경우
			//String data = ""; // 문자열 결합
			
			// StringBuffer -> 문자열 결합 최적화
			StringBuffer sb = new StringBuffer();
			// 파일 읽기 => 웹 사이트 => HTML
			
			while ((i = fr.read()) != -1) {
				sb.append((char) i);
			}
			fr.close();
			
			String data = sb.toString();
			System.out.println(data);
			// 문자열 제어는 String
			// 문자열 결합 StringBuffer(비동기적) 데이터 크롤링 => 쓰레드 / -> 빈도수 더 많음 / 이틀을 2틀로 써버리네...
			//						 비동기 -> 속도 빠름, 동시성
			// 			StringBuilder(동기적)
			//System.out.println(sb.toString());
			
			long end = System.currentTimeMillis();
			System.out.println("걸린시간 : " + (end - start));
		} catch (Exception ex) {
			// TODO: handle exception
		}
	}
}













