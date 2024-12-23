package com.sist.movie;

import java.util.ArrayList;
import java.util.Scanner;
/*
 * 데이터를 여러 개 가져온다 => ArrayList
 * 목록 / 검색
 * 데이터 상세보기 => Movie
 * => Movie : 영화 한 개에 대한 정보 => 사용자 정의 데이터형 클래스
 * => 데이터 출력 : 웹, 모바일, 애플리케이션 => for-each
 * Collection => 반드시 제네릭을 이용해서 저장을 한다
 * 
 */
public class MovieUserMain {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		MovieSystem ms = new MovieSystem();
		
		while (true) {
			System.out.println("===== Menu =====");
			System.out.println("1. 전체 목로");
			System.out.println("2. 상세보기");
			System.out.println("3. 영화명 검색");
			System.out.println("4. 출연진 검색");
			System.out.println("5. 장르 검색");
			System.out.println("6. 프로그램 종료");
			System.out.println("=================");
			System.out.print("메뉴 선택 : ");
			
			int menu = scanner.nextInt();
			
			if (menu == 6) {
				System.out.println("프로그램 종료");
				System.exit(0);
				
			} else if (menu == 1) {
				ArrayList<Movie> list = ms.movieListDate();
				for (Movie m : list) {
					System.out.println(m.getMno() + ". "
							+ m.getTitle());
				}
			} else if (menu == 2) {
				System.out.print("영화 번호 1 ~ 1938 입력 : ");
				int mno = scanner.nextInt();
				Movie m  = ms.movieDetailData(mno);
				System.out.println("=== " + m.getTitle() + m.getTitle() + " 상세보기 ===");
				System.out.println("영화명 : " + m.getTitle());
				System.out.println("출연 : " + m.getActor());
				System.out.println("감독 : " + m.getDirector());
				System.out.println("장르 : " + m.getGenre());
				System.out.println("개봉일 : " + m.getRegdate());
				System.out.println("관람 등급 : " + m.getGrade());
			} else if (menu == 3) {
				System.out.print("검색어 입력 : ");
				String title = scanner.next();
				
				ArrayList<Movie> list = ms.movieFindTitle(title);
				System.out.println("검색 결과값 " + list.size() + "건");
				for (Movie m : list) {
					System.out.println(m.getMno() + ". " + m.getTitle());
				}
			} else if (menu == 4) {
				System.out.print("검색어 입력 : ");
				String actor = scanner.next();
				
				ArrayList<Movie> list = ms.movieFindActor(actor);
				System.out.println("검색 결과값 " + list.size() + "건");
				for (Movie m : list) {
					System.out.println(m.getMno() + ". " + m.getTitle() + " " + m.getActor());
				}
			}  else if (menu == 5) {
				System.out.print("검색어 입력 : ");
				String genre = scanner.next();
				
				ArrayList<Movie> list = ms.movieFindGenre(genre);
				System.out.println("검색 결과값 " + list.size() + "건");
				for (Movie m : list) {
					System.out.println(m.getMno() + ". " + m.getTitle() + " " + m.getGenre());
				}
			}
		}
	}
}
