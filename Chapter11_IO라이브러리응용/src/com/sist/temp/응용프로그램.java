package com.sist.temp;
/*
 * 구상 => 요구사항 분석
 * 	벤치마킹 => 모방
 * 	| 기능 추출
 * 	| 메소드 => 리턴형 / 매개 변수
 * 		=> 반복하는 소스 : 공통 모듈
 * 		=> ------------------- 다른 프로그램에서 사용
 * 		   ------------------- .jar 로 묶어서 사용
 * => 사용자 정의 + 라이브러리 = 조립
 * 	  ------------------
 * => 1. 필요한 변수 : VO
 * => 2. 기능 설정 : Manager / DAO
 * 							 ----
 * 							 | 오라클 연동
 * 							 | 언어 => SQL
 * 							   ----------
 * 								SELECT * FROM emp
 * => 3. 화면 UI
 * => 4. 화면에 값을 채운다
 * 
 * => 5. 한 개의 기능을 처리 => 메서드 => 응집성
 * 		 => 유지보수 용이 -> 수정, 삭제 편리
 * 		 기능 모아서 관리 => 클래스
 * 
 * 클래스
 * 	= 데이터형(프로그램에 필요한 데이터를 모아서 저장)
 * 		BoardVO / MovieVO...
 * 		=> 캡슐화 => 변수 : private / 메서드를 이용해서 접근
 * 									=> 변수의 기능
 * 									=> 읽기 / 쓰기
 * 									   getter setter
 * 	= Action : 기능만 모아서 관리
 * 			   ----(메서드) 
 * 				~Manager / ~DAO / ~Service / ~Model
 * 	= 혼합 => 게임
 * 	= 상속 => 포함
 * -------------------- 라이브러리
 * 	java.lang : String / Wrapper(Integer)
 * 	java.util : ArrayList / Date
 * 	java.io : FileReader / FileInputStream
 * 			  FileWriter / FileOutputStream
 * 			  -----------------------------
 * 			  BufferedReader
 */
public class 응용프로그램 {

}
