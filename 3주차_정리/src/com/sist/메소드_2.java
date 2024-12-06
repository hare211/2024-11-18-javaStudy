package com.sist;
import java.util.*;
import java.io.*; // 파일, 네트워크 전송 : 읽기 / 쓰기
import java.nio.file.spi.FileSystemProvider;
/*
 * Input / Output => io => 반드시 예외처리
 * 	마지막장 12장
 * 	------
 * 	| 자바 관련 모든 문법 => 응용
 * 		= 데이터 베이스 (o) => 웹
 * 		= 네트워크 => 온라인 게임
 * 		웹 => 스레드, 네트워크 => 호출
 * 			 | 면접
*/

public class 메소드_2 {
	static String seoulData; // 자동 초기화 => null
	// 초기화 (자동)
	static {
		try {
			FileReader fr = new FileReader("c:\\javaDev\\seoul_location.txt");
			StringBuffer sb = new StringBuffer();
			
			int i = 0;
			
			while ((i = fr.read()) != -1) { // EOF => -1
				sb.append((char) i);
			}
			
			seoulData = sb.toString();
			fr.close();
			
		} catch (Exception ex) {
			
		}
	}
	static void menu() {
		System.out.println("==== 메뉴 ====");
		System.out.println("1. 명소 목록"); // 페이징 고민
		System.out.println("2. 명소 상세 보기");
		System.out.println("3. 명소 검색(명소명)");
		System.out.println("4. 명소 검색(주소)");
		System.out.println("5. 종료");
		System.out.println("=============");
	}
	
	static String[] find(int type, String findData) {
		// 확인 => 검색된 개수
		String[] data = seoulData.split("\n");
		
		int count = 0;
		
		for (String seoul : data) {
			String[] sd = seoul.split("\\|");
			String ss = "";
			if (type == 1) {
				ss = sd[1]; // 1 번 => 명소명
			}else {
				ss = sd[3]; // 3 번 => 주소명
			}
			if (ss.contains(findData)) {
				count++;
				//System.out.println("명소 : " + sd[1] + " 주소 : " + sd[3]);
			}
		}
		// | 배열 크기 확인
		String[] datum = new String[count];
		
		int i = 0;
		
		for (String seoul : data) {
			String[] sd = seoul.split("\\|");
			String ss = "";
			if (type == 1) {
				ss = sd[1]; // 1 번 => 명소명
			}else {
				ss = sd[3]; // 3 번 => 주소명
			}
			if (ss.contains(findData)) {
				datum[i] = sd[1] + " -- " + sd[3];
				i++;
			}
		}
		
		return datum;
	}
	// 조립 => 사용자 정의 메소드 반드시 호출
	static void process() {
		Scanner scanner = new Scanner(System.in);
		
		while (true) {
			menu();
			System.out.print("메뉴 선택 : ");
			int m = scanner.nextInt();
			
			switch (m) {
			case 5:
				System.out.println("프로그램 종료");
				return;
			case 1:
				// 고민 => 데이터를 받아서 출력, 메소드 안에서 출력
			case 3, 4:
				System.out.print("1. 명소 | 2. 주소 : ");
				int type = scanner.nextInt();
				
				System.out.print("검색어 입력 : ");
				String fd = scanner.next();
				
				String[] ss = find(type, fd);
				for (String s : ss) {
					System.out.println(s);
				}
			default:
				break;
			}
		}
	}
	// 시작 => 자동 호출 메소드 => 전체 프로젝트에 한 개 이상의 main 존재
	public static void main(String[] args) {
		process();
	}

}
