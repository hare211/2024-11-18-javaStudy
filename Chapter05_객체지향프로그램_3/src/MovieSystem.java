import java.util.*;
import java.io.*;

public class MovieSystem {
	// 영화 전체 정보 => 모든 사용자가 공유
	static Movie[] movies = new Movie[1938];
	
	// 초기화
	
	static {
		try {
			// 파일 전체 읽기
			FileReader fr = new FileReader("c:\\javaDev\\movie.txt");
			int i = 0; // 한글자씩 읽어 온다 => 정수, i > 글자 하나 읽을 때마다 증가하는 변수
			StringBuffer sb = new StringBuffer();
			// 문자열 결합의 최적화 => 데이터가 많은 경우
			//String data = "";
			
			while ((i = fr.read()) != -1) {
				sb.append((char) i);
				//data += (char) i;
			}
			
			fr.close();
			//System.out.println(sb.toString());
			String data = sb.toString();
			/*
			 * 1|
			 * 쇼생크 탈출
			 * |드라마
			 * |https://movie-phinf.pstatic.net/20160119_278/14531650465287bcuk_JPEG/movie_image.jpg?type=m77_110_2
			 * |팀 로빈스(앤디 듀프레인), 모건 프리먼(엘리스 보이드 레드 레딩)
			 * |2016 .02.24 재개봉, 1995 .01.28 개봉
			 * |15세 관람가
			 * |프랭크 다라본트
			 */
			// 분리
			String[] temp = data.split("\n");
			// 영화 한 개에 대한 정보
			int j = 0;
			for (String s : temp) {
				movies[j] = new Movie();
				// movies[0] => no, title, actor...
				String[] ss = s.split("\\|");
				movies[j].no = ss[0];
				movies[j].title = ss[1];
				movies[j].genre = ss[2];
				movies[j].poster = ss[3];
				movies[j].actor = ss[4];
				movies[j].regdate = ss[5];
				movies[j].grade = ss[6];
				movies[j].director = ss[7];
				j++;
			}
		} catch (Exception ex) {} // io => 파일 입력 / 출력 => 반드시 예외 처리
	}
	// 목록 => 페이지를 나눠서 처리
	Movie[] movieListData (int page) {
		final int ROWSIZE = 20;
		//int pageCount = (ROWSIZE * page) - ROWSIZE;
		// (page - 1) * ROWSIZE => 시작 위치
		int start = (page - 1) * ROWSIZE;
		int end = page * ROWSIZE;
		int totalPage = (int)(Math.ceil(movies.length / 20.0));
		int ARRSIZE = 20;
		
		if (page == totalPage) {
			end = page * ROWSIZE - 2;
			ARRSIZE = 18;
		}
		
		Movie[] movieData = new Movie[ARRSIZE];
		int j = 0;
		for (int i = start; i < end; i++) {
			movieData[j] = movies[i];
			j++;
		}
		return movieData;
		//							올림함수
		//	17 => 10 => 2		17 / 10.0 => 1.7 => 2
		/*
		 * 	1 page => 0 ~ 19
		 * 	2 page => 20 ~ 39 => while, for 문은 처음부터
		 * 
		 * 	마지막 => 1938 => 18
		*/
	}
	// 상세보기
	// 검색
}
