package com.sist.movie;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class MovieUserMain {
	public static void main(String[] args) {
		MovieSystem ms = new MovieSystem();
		try {
			// 키보드 입력
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			
			while (true) {
				System.out.println("==== Menu ====");
				System.out.println("1. 영화 목록");
				System.out.println("2. 영화 상세");
				System.out.println("3. 영화 검색");
				System.out.println("9. 종료");
				System.out.println("==============");
				
				System.out.print("메뉴 선택 : ");
				String sm = in.readLine();
				int menu = 0;
				try {
					int m = Integer.parseInt(sm);
					menu = m;
				} catch (NumberFormatException ex) {
					ex.printStackTrace();
				}
				
				// BufferedReader => 값을 읽을 때 문자열로 가지고 온다
				// 필요한 데이터형으로 변환해야 함
				switch (menu) {
				case 1:
					List<Movie> movieList = ms.movieListData();
					for (Movie mo : movieList) {
						System.out.println(mo.getMno() + "."
								+ mo.getTitle());
					}
					break;
				case 2:
					System.out.print("영화 번호 입력 : ");
					String mno = in.readLine();
					int mn = Integer.parseInt(mno);
					
					Movie movie = ms.movieDetailData(mn);
					System.out.println("영화번호 : " + movie.getMno());
					System.out.println("영화명 : " + movie.getTitle());
					System.out.println("출연 : " + movie.getActor());
					System.out.println("감독 : " + movie.getDirector());
					System.out.println("등급 : " + movie.getGrade());
					System.out.println("장르 : " + movie.getGenre());
							
					break;
				case 3:
					System.out.print("검색어 입력 : ");
					String fd = in.readLine();
					List<Movie> findList = ms.movieFindData(fd);
					System.out.println("검색 결과 : " + findList.size() + " 건");
					for (Movie find : findList) {
						System.out.println(find.getTitle());
					}
					
					break;
				case 9:
					System.out.println("프로그램 종료");
					return;
				default:
					System.out.println("잘못된 메뉴입니다.");
					break;
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
