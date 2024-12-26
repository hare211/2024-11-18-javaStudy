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
 * 
 * 		입출력
 * 				입력 스트림				출력 스트림
 * 		키보드 		=>		자바 프로그램		=>		모니터
 * 					|						|
 * 				~InputStream			~OutputStream
 * 				~Reader					~Writer
 * 		~InputSTream / ~OutputStream
 * 		=> 이미지나 동영상 같은 바이트 형태의 데이터 입출력
 * 		=> 업로드 / 다운로드
 * 		~Reader / ~Writer
 * 		=> 16bit(2byte) 문자 데이터를 입출력
 * 		=> 파일에 글쓰기 / 파일 읽어오기
 * 
 * 		메모리에 모아서 한 번에 처리 => Buffered~
 * 
 * 		=> 객체 단위로 저장 -> 과거
 * 		   ------------ 파일 프로그램
 * 		=> 데이터베이스로 변경
 * 		=> 파일에 저장하는 경우
 * 		   -------------- Open API => 파싱(파일에 저장했다가 필요한 것만 파싱하여 가져옴)
 * 		   -------------- 크롤링 => 임시 저장 장소
 * 
 * 			1. 데이터 종류 
 * 				1) 정형화 데이터 : 데이터베이스 안 저장 => 공유
 * 					=> 웹 / 윈도우에 출력할 데이터
 * 				2) 반정형화 데이터 : 구분만 된 데이터
 * 					=> HTML / XML / JSON / CSV
 * 					=> API / 공공포탈 
 * 				3) 비정형화 데이터 : 구분이 없는 데이터
 * 					=> 뉴스 / 줄거리 / 덧글
 * 					=> 분석하여 필요한 데이터를 읽어 와 정형화 된 데이터로 저장 -> 빅 데이터 => AI
 * 		FileInputStream / FileOutputStream => 이미지 / ZIP
 * 		=> CheckException => 예외 처리 필요
 */
import java.io.*;
public class IO_1 {
	public static void main(String[] args) {
		//FileInputStream fis = null;
		FileReader fis = null;
		try {
			// 파일 읽기
			fis = new FileReader("C:\\Users\\sist-117\\git\\java-study\\Chapter11_IO라이브러리_2\\src\\com\\sist\\io\\IO_1.java");
			int i = 0; // int read() => char 로 변환, 'A' -> 65 로 반환됨
			while ((i = fis.read()) != -1) { // -1 EOF 파일이 끝나기 전
				System.out.print((char) i);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			try {
				fis.close();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}
}













