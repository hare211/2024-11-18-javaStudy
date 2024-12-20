package com.sist.math;
import java.sql.*;
/*
 * 데이터형
 * 	=> 기본형 
 * 	=> 참조형
 * 	   ---- 클래스 / 배열
 * 			----
 * 			| 라이브러리
 * 			| 사용자 정의
 * 	멤버 변수 => 기본형 / 클래스 / 배열
 */
public class GoodsDAO {
	// 클래스 전체 영역에서 사용하는 변수 / 클래스 / 배열 => 멤버 변수
	
	private Connection conn; // 오라클 연결해주는 컬렉션
	private PreparedStatement ps; // 오라클 명령문
	// 변경이 되면 안되는 값 : 상수 => 오라클 주소
	// hr1 hr2 hr3 hr4
	private final String URL = "jdbc:oracle:thin:@211.238.142.124:1521:XE"; // 192 -> private, 211 -> public 
	/*
	 * 오라클 실행 명령어
	 * -------------- SQL
	 * 
	 * 	DQL : 데이터 검색 => 데이터 읽기
	 * 			=> SELECT
	 * 	DML : 데이터 조작
	 * 			=> INSERT : 데이터를 오라클에 추가
	 * 			=> UPDATE : 데이터 수정
	 * 			=> DELETE : 데이터 삭제
	 * 	DCL : 데이터 제어
	 * 			=> GRANT : 권한 부여
	 * 			=> REVOKE : 권한 해제
	 * 	DDL : 저장 장소, 함수...
	 * 			=> CREATE : 생성
	 * 			=> ALTER : 수정
	 * 			=> DROP : 삭제
	 * 			=> RENAME
	 * 			=> TRANCATE
	 *	TCL  : 트랙잭션 제어
	 *		=> COMMIT : 정상 저장
	 *		=> ROLLBACK : 모든 명령 취소
	 *
	 *	=> JOIN / Subquery
	 */
	// 오라클 연결 => 드라이버 설치(시작과 동시에) => 생성자 => 한 번만 수행
	// 디자인 패턴 -> 싱글톤
	private static GoodsDAO dao;
	
	public GoodsDAO() {
		try {
			Class.forName("oracle.jdbc.diver.OracleDriver");
		} catch (Exception ex) {
			
		}
	}
	// GoodsDAO dao = GoodsDao.newInstance()
	// 싱글톤 패턴
	// 메모리 공간을 하나만 쓰겠다 -> 싱글톤
	public static GoodsDAO newInstance() { // -> 싱글톤 패턴 -> 메모리 없으면 생성 / 있으면 기존에 있는 것을 반환
		if (dao == null) {
			dao = new GoodsDAO();
		}
		return dao;
	}
	// => 자바 / 오라클 / 스프링 => 단순화 라이브러리(MyBatis, JPA)
	// 공통 모듈 => 메서드마다 공통으로 사용
	// => 오라클 연결
	public void getConnection() {
		try {
			conn = DriverManager.getConnection(URL, "hr", "happy");
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}
	// => 오라클 닫기 => 반복 코딩 => 메서드화
	public void disConnection() {
		try {
			if (ps != null) {
				ps.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (Exception ex) {
			
		}
	}
	// => 자동화(스프링 => AOP) => 실시간 처리 Task
	// 기능
	// 총 페이지
	public int goodsTotalPage() {
		int count = 0;
		// selectList(String sql)
		try {
			// 1. 연결
			getConnection();
			// 2. 전송할 오라클 명령문 
			String sql = "SELECT COUNT(*) FROM goods_all"; // SQL 문장 
			// 3. 오라클로 전송
			ps = conn.prepareStatement(sql);
			// 4. 실행 결과값 읽기
			ResultSet rs = ps.executeQuery();
			// 5. 데이터가 있는 메모리 위치에 커서를 이동
			rs.next();
			// 6. 읽어온 값을 저장
			count = rs.getInt(1);
			// 7. ResultSet 닫기
			rs.close();
		} catch (Exception ex) {
			// 에러 확인
			ex.printStackTrace();
		} finally {
			disConnection(); // 반드시 연결 해제
		}
		return count;
	}
	// 목록
	// 추가
	
}



















