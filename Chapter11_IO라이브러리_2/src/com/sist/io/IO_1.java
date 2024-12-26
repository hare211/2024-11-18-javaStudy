package com.sist.io;
/*
 * 라이브러리 => 9 ~ 12장
 * -------
 * 1. 클래스명 : 사용처
 * 2. 주요 메서드 => 역할 / 리턴형 / 매개 변수
 * 3. 자바에서 지원 => 오버라이딩은 거의 없다
 * 	  ---------> 실무에서 동일하게 사용(표준화)
 * 
 * 1. 입출력
 * 		=> 메모리 입출력(Scanner)
 * 			=> System.out.println() 표준 입출력
 * 			=> System.in.read() => int / 반드시 예외 처리
 * 			   -------------------- Scanner
 * 		=> 파일 입출력
 * 			InputStream		OutputStream => 인터페이스, 1byte
 * 			읽기				쓰기
 * 		특징	1) 단방향 통신(읽기 / 쓰기를 동시에 처리 X)
 * 			2) Stream : 데이터 이동 통로
 * 			3) 1byte 입출력
 * 				=> 브라우저 / 한글이 없는 파일
 * 			4) 주요 메서드
 * 			read() : 한 글자씩 읽음
 * 			write() : 한 글자씩 저장
 * 			close() : 닫기
 * 
 * 			Reader		Writer => 2byte -> 한글 읽기에 적합
 * 			읽기			쓰기
 * 			read()		Write()		close()
 * 
 * 			=> 바이트스트림
 * 				: 1byte 송신 / 수신 => 다운로드, 업로드
 * 			*** FileInputStream / FileOutputStream
 * 			=> 문자스트림
 * 				: 2byte 송신 / 수신 => 한글 파일 제어
 * 			*** FileReader / FileWriter
 * 			=> 필터스트림
 * 			=> 데이터를 메모리에 모아서 한 번에 처리 : 속도 빠름
 * 			*** BufferedInputStream / BufferedOutputStream
 * 			*** BufferedReader / BufferedWriter
 * 
 * 				ObjectInputStream / ObjectOutputStream
 * 		=> 네트워크 입출력
 */
public class IO_1 {

}
