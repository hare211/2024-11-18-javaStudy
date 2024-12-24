package com.sist.main;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
/*
 * DAO => 오라클, Manager => 파일
 * ---------------------------
 * => 예외처리
 * => 사용자 정의 데이터형 => VO => 캡슐화
 * => 멤버 변수 / 상수 / static
 * => 메서드
 * 	  ---- 리턴형 / 매개 변수
 * 		   ----	  ------- 사용자가 보내준 값
 * 		   결과값 =>
 * 					1. 목록 => List
 * 					2. 상세보기 => VO
 * 					3. 총 페이지 => int
 * 
 * 컬렉션
 * ---- IO => 2차(문법 => 형식) => DAO(웹)
 * 								------- JSP / Spring
 * @Transactional
 * public void insert() {
 * 		SQL
 * 		SQL
 * }
 * 
 * 
 * 	public void insert() {
 * 		try {
 * 			getConnection()
 * 			conn.setAutoCommit(false)
 * 			SQL
 * 			SQL
 * 			conn.commit()
 * 		} catch (Exception ex) {
 * 
 * 			try {
 * 				conn.rollback()
 * 			} catch (Exception ex {
 * 
 * 			} finally {
 * 				try {
 *				conn.setAutoCommit(false) 				
 * 				disConnection()
 * 				} catch (Exception ex) {
 * 
 * 				}
 * 			}
 * 		}
 * 	}
 * 
 * => 이력서 : 개인 프로젝트
 * 
 * 컬렉션 (Collection)
 * 	=> 배열(고정적) => 데이터 추가 => 새로운 배열
 * 		=> 동적 배열 => 저장 개수 확인
 * 		------------------------ 가변
 * 	=> 많은 데이터를 저장 할 수 있다
 * 	=> 표준화 => 개발자 모두가 같은 코딩을 한다
 * 	=> 단점 : 모든 데이터를 저장 할 수 있다
 * 			 --------- 데이터형이 틀린 경우도 있다
 * 				=> 형변환 / 제어문 사용에 어려움이 있다
 * 				=> 제네릭을 사용하여 제어한다
 * 				=> 같은 데이터만 첨부 => 배열
 * 				   -------------
 * 					명시적 => 어떤 데이터가 들어가는 지 알려준다 -> 제네릭 -> List<String> => 데이터 통일, 가독성 좋다
 * 
 * 				Collection(CRUD) => 자료구조
 * 					 |
 * 	------------------------------------------
 * 	|				 |						|
 * List				Set					   Map
 * =ArrayList	  = HashSet				 = HashMap
 * | 단순한 목록		| 장바구니				   | 관리(클래스 관리, 회원 관리)
 * 					  중복이 없는 데이터
 * 
 * List
 * 	add() : 추가
 * 	remove() : 삭제
 * 	set() : 수정
 * 	get() : 데이터 가져오기 <- 빈도 높음
 * 	isEmpty() : 값 존재 여부
 * 	clear() : 전체 삭제 <- 빈도 높음
 * 	size() : 저장 개수 <- 빈도 높음
 * 
 * Set
 * 	add() : 추가 <- 빈도 높음
 * 	remove() : 삭제
 * 	isEmpty() <- 빈도 높음
 * 	clear() <- 빈도 높음
 * 	size() <- 빈도 높음
 * 
 * Map
 * 	put("key", "value") : 추가
 * 	get("key") : 데이터 가져오기
 * 	isEmpty()
 * 	clear()
 * 	size()
 * 	keySet() : 저장된 키 전체
 * 	values() : 저장된 값
 * 
 * ----------------------------------------------
 * 	복사 => addAll() : Set / List (Map 은 호환 X) -> key
 * 	교집합 => retainAll() => 같은 것들
 * 	차집합 => removeAll() => 
 * 	=> Chapter10 라이브러리 map_2 music, MusicMain 예제
 * ----------------------------------------------
 * 
 * java.lang
 * 	Object / String / StringBuffer
 * 	Wrapper / System / Math
 * java.util
 * 	Date / Calendar / StringTokenizer
 * 	ArrayList / hashSet / HashMap
 * java.text
 * 	SimpleDateFormat -> 날짜변환 -> yyyy - M - d
 * 	DecimalFormat -> 숫자변환 -> 1,000
 * ------------
 * java.io : 파일 입출력 => 웹에서 나오면 -> 다운로드 / 업로드
 * java.sql : 데이터베이스 입출력(오라클, MySql) / <- 모든 데이터
 * java.net : 네트워크 입출력
 * 				=> 웹(네트워크) => 한글 변환
 */
import java.util.*;
public class 컬렉션정리 {
	public static void main(String[] args) {
		try {
			String encoded = "https://www.google.com/search?q=%EC%9E%90%EB%B0%94&oq=%EC%9E%90%EB%B0%94&gs_lcrp=EgZjaHJvbWUyBggAEEUYOTIGCAEQRRg7Mg0IAhAAGIMBGLEDGIAEMg0IAxAuGMcBGNEDGIAEMg0IBBAAGIMBGLEDGIAEMgYIBRBFGEEyBggGEEUYPDIGCAcQRRhB0gEIMTEyMWowajeoAgCwAgA&sourceid=chrome&ie=UTF-8";
			String decoded = URLDecoder.decode(encoded, "UTF-8");
			
			System.out.println(encoded);
			System.out.println(decoded);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
	}
}

















