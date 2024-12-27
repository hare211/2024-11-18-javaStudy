package com.sist.movie;
import java.io.*;
import java.util.*;
// ObjectInputStream
public class MovieSystem {
	// 영화 정보를 가지고 있다 => 요청 기능
	// 값 읽기
	private static List<Movie> movieList = new ArrayList<Movie>();
	
	static {
		ObjectInputStream ois = null;
		try {
			FileInputStream fis = new FileInputStream("c:\\java_data\\movie_info.txt");
			ois = new ObjectInputStream(fis);
			movieList = (List<Movie>) ois.readObject();
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			try {
				ois.close();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}
	// 목록 출력
	// SELECT * FROM movie
	public List<Movie> movieListData() {
		return movieList;
	}
	
	// mno 에 해당하는 영화상세보기
	/*
	 * SELECT * FROM movie
	 * WHERE mno = 1
	 */
	public Movie movieDetailData(int mno) {
		Movie movie = new Movie();
		for (Movie m : movieList) {
			if (m.getMno() == mno) {
				movie = m;
				break;
			}
		}
		return movie;
	}
	// 검색
	// WHERE title LIKE '%fd%'
	/*
	 * 웹(네트워크 통신)
	 * writeObject(Object), Object readObject()
	 * 						형변환 후 사용
	 * 직렬화					역직렬화
	 * 저장되는 데이터는 반드시 implements Serializable 사용
	 * 객체 생성 시 FileInputStream / FileOutputStream
	 */
	public List<Movie> movieFindData(String title) {
		List<Movie> list = new ArrayList<Movie>();
		for (Movie m : movieList) {
			if (m.getTitle().contains(title)) {
				list.add(m);
			}
		}
		return list;
	}
	
}
