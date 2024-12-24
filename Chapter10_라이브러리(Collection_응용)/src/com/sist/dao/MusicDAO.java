package com.sist.dao;
/*
 * Collection
 * ----------
 * 	=> 단순 목록 : ArrayList
 * 				=> 수정 / 삭제 => 속도 느리다(인덱스가 모두 밀려지기 때문)
 * 				=> 가변형
 * 1. 목록 => 페이지 나누기 => ArrayList
 * 2. 상세보기 => MusicVO
 * 				=> 버튼 클릭 시 => 동영상 실행
 * 3. 검색 => ArrayList
 * 4. 게시판 => LinkedList
 * 				=> 수정 / 삭제 => 속도 빠르다(다음 주소를 참조하기 때문)
 * 5. 구매 => Map
 * 			=> 두 개 저장
 * 6. 찜하기 => Set
 * 			=> 한 사람당 1 개만
 * => 프로젝트 : 크롤링 => 오라클
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;
import com.sist.vo.*;

public class MusicDAO {
	// 연결 객체
	private Connection conn;
	// SQL 문장 전송 객체
	private PreparedStatement ps;
	// URL 등록
	private final String URL = "jdbc:oracle:thin:@211.238.142.124:1521:XE";
	
	// 싱글톤 + 연결 / 해제
	private static MusicDAO dao; // 한 개만 사용
	
	// => ArrayList 
	// 1. 드라이버 등록 => 한 번만 등록 -> 생성자
	public MusicDAO() {
		try {
			// ojdbc8.jar => 자바에서 지원 X => 오라클에서 지원
			// mvnrepository.com => jar 라이브러리 드라이버
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException ex) {
			// TODO: handle exception
		}
	}
	// 2. 오라클 연결
	public void getConnection() {
		try {
			conn = DriverManager.getConnection(URL, "hr", "happy");
			// 오라클 => conn hr/happy
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	// 3. 오라클 해제
	public void disConnection() {
		try {
			if (ps != null) {
				ps.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (Exception ex) {
			// TODO: handle exception
		}
	} // 데이터베이스 사용 시 공통 기반
	/*
	 * DAO 는 사용자당 1 개만 사용이 가능하게 만든다
	 * -----------------------------------
	 * => 싱글톤
	 */
	/*
	 * 디자인 패턴 -> (싱글톤, 팩토리, MV, MVC) => 웹
	 *  => 싱글톤 => static
	 *  => 팩토리 패턴 => Map
	 *  => MV 패턴 => JSP(Java + HTML) / 자바와 HTML 이 섞여있어 보기 어렵다 -> 나눈다
	 *  				  |		  |
	 *  				Model	View
	 *  => MVC 패턴
	 *  => Observer
	 *  => prototype => 복제
	 *  
	 *  문법 => 형식			| 순차적으로
	 *  응용					| 알고리즘까지
	 *  디자인 패턴 / 알고리즘	| 공부 
	 */
	public static MusicDAO newInstance() {
		if (dao == null) {
			dao = new MusicDAO();
		}
		return dao;
	}
	// 5. 뮤직 상세보기
	// 6. 뮤직 검색
	// DAO => 공용(웹, 윈도우, 애플리케이션) -> 하나를 만들면 다 사용할 수 있다
	public List<MusicVO> musicFindData(String fd) {
		List<MusicVO> list = new ArrayList<MusicVO>();
		try {
			// 1. 오라클 연결
			getConnection();
			// 2. 오라클로 전송할 문장
			String sql = "SELECT mno, title, singer, album, poster " + "FROM genie_music " + "WHERE title LIKE '%'||?||'%'"; // 
			//		 //오라클 -> kv			// contains() => LIKE => REGEXP_LIKE
			// 3. SQL 을 전송
			ps = conn.prepareStatement(sql);
			// 4. ? 에 값을 채운다
			ps.setString(1, fd);
			// 5. 실행 후 결과값을 가지고 온다
			ResultSet rs = ps.executeQuery();
			// 6. List 에 값을 채운다
			while (rs.next()) { // 처음부터 마지막까지 읽어온다
				// 한 줄씩 읽어온다
				MusicVO vo = new MusicVO();
				
				vo.setMno(rs.getInt(1));
				vo.setTitle(rs.getString(2));
				vo.setSinger(rs.getString(3));
				vo.setAlbum(rs.getString(4));
				vo.setPoster(rs.getString(5));
				
				list.add(vo);
			}
			rs.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			// 오라클 연결 해제
			disConnection();
		}
		return list;
	}
	// 동영상 키
	public String getkey(int mno) {
		String key = "";
		try {
			getConnection();
			
			String sql = "SELECT DISTINCT key FROM genie_music" + "WHERE mno = " + mno;
			
			ps = conn.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			
			rs.next();
			key = rs.getString(1);
			rs.close();
			
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			disConnection();
		}
		return key;
	}
}













