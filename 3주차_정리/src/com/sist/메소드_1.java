package com.sist;

import java.util.Scanner;
import java.io.*;

/*
 * 	메소드 형식
 * 	
 * 	static 리턴형 메소드명(매개변수...) { => 선언부
 * 		=> 구현부 => 메모리에 저장
 * 	}
 * 
*/
public class 메소드_1 {
	
	static String movieData = ""; // 전역변수
	/*
	 * 예외처리
	 * 	=> 예외 복구 try ~ catch(복구)
	 * 	=> 예외 회피 => 컴파일러에 예외 => 알려주는 역할
	 * ==> 프로그램 유지
	*/
	static { // 실행 시 자동 인식
		try {
			// 정상 수행
			FileReader fr = new FileReader("c:\\javaDev\\movie.txt");
			int i = 0; // 단점 => char (X), int (O)
			
			StringBuffer sb = new StringBuffer();
			while ((i = fr.read()) != -1 ) { // -1 EOF
				sb.append((char) i);
			}
			
			movieData = sb.toString();
			fr.close();
		} catch (Exception ex) { // 예외처리
			// 에러 발생 => 복구
		}
	}
	
	static void menu() {
		System.out.println("==== Menu ====");
		System.out.println("1. 영화 목록");
		System.out.println("2. 영화 상세");
		System.out.println("3. 영화 검색(영화명)");
		System.out.println("4. 영화 검색(출연진)");
		System.out.println("5. 종료");
		System.out.println("==============");
	}

	/*
	 * movieData 배열 info 
	*/
	static void movieList(int page) {
		String[] movie = movieData.split("\n");
		
		final int ROWSIZE = 20; // 시작점
		
		int i = 0; // for 횟수
		int j = 0; // 20 개씩
		
		int pageCount = (page * ROWSIZE) - ROWSIZE; // 1page => 0, 2page => 20, 3page => 40
		
		for (String s : movie) {
			//System.out.println(s);
			if (j < 20 && i >= pageCount) {
				String [] md = s.split("\\|");
				System.out.println(md[0] + "." + md[1]);
				j++;
			}
			i++;
		}
	}
	// 상세보기 => 데이터
	static void movieDetail(int movieNo) {
		String[] movie = movieData.split("\n");
		// 영화 정보 전체 => \n
		for (String s : movie) {
			// 영화 한 개 => 정보 => |
			String[] info = s.split("\\|");
			if (info[0].equals(String.valueOf(movieNo))) { // int movieNo 를 String 으로 (int 형을 String 형으로) // parseInt => 문자열을 정수로
				System.out.println("영화명 : " + info[1]);
				System.out.println("장르 : " + info[2]);
				System.out.println("출연 : " + info[4]);
				System.out.println("개봉일 : " + info[5]);
				System.out.println("관람등급 : " + info[6]);
				System.out.println("감독 : " + info[7]); 
			}
		}
	}
	// 영화명으로 찾기
	static void titleFind(String mn)	{
		String[] movie = movieData.split("\n");
		// 영화 정보 전체 => \n
		for (String s : movie) {
			// 영화 한 개 => 정보 => |
			String[] info = s.split("\\|");
			if (info[1].contains(mn)) {
				System.out.println(info[1] + "[" + info[4] + "]");
			}
		}
		
	}
	// 출연진으로 찾기
	static void actorFind(String actor) {
		String[] movie = movieData.split("\n");
		// 영화 정보 전체 => \n
		for (String s : movie) {
			// 영화 한 개 => 정보 => |
			String[] info = s.split("\\|");
			if (info[4].contains(actor)) {
				System.out.println(info[1] + " [" + info[4] + "]");
			}
		}
		
	}
	public static void process() {
		Scanner scanner = new Scanner(System.in);
		
		while (true) {
			menu();
			System.out.print("메뉴 선택 : ");
			int m = scanner.nextInt();
			
			if (m == 5) {
				System.out.println("프로그램 종료");
				break;
			} else if (m == 1) {
				System.out.print("페이지 입력 : ");
				int page = scanner.nextInt();
				movieList(page);
			} else if (m == 2) {
				System.out.print("영화 선택 1 ~ 1938 : ");
				int no = scanner.nextInt();
				movieDetail(no);
			} else if (m == 3) {
				System.out.print("영화명 입력 : ");
				String mn = scanner.next();
				titleFind(mn);
			} else if (m == 4) {
				System.out.print("출연진 입력 : ");
				String actor = scanner.next();
				actorFind(actor);
			}
		}
	}
	public static void main(String[] args) {
		process();
	}

}
