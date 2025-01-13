package com.sist.dao;
import java.util.*;
import java.sql.*;
import com.sist.vo.*;

public class FreeBoardDAO {
	// 오라클 연결 객체
	private Connection conn;
	// 오라클 송수신 담당 (송신 : SQL 문장 / 수신 : 실행 결과값)
	private PreparedStatement ps;
	// 오라클 주소 : 고정 (상수)
	private final String URL = "jdbc:oracle:thin:@localhost:1521:XE";
	// 객체를 한 번만 생성해서 재사용(메모리 절약)
	// Connection 객체 수를 조절
	// 싱글톤
	private static FreeBoardDAO dao;
// --------------------------------------------------------------------------------------------------------------------
	// 1. 드라이버 등록
	public FreeBoardDAO() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	// 연결 - 해제 : 윈도우, 명령프롬프트, 웹, react, vue... 상관 없이 모두 필요
	// 2. 오라클 연결
	public void getConnection() {
		try {
			conn = DriverManager.getConnection(URL, "hr", "happy");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	// 3. 오라클 해제
	public void disconnection() {
		try {
			if (ps != null) {
				ps.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	// 4. 싱글톤
	public static FreeBoardDAO newInsatance() {
		if (dao == null) {
			dao = new FreeBoardDAO();
		}
		return dao;
	}
// --------------------------------------------------------------------------------------------------------------------	
	// 1. 목록 출력(페이징 기법, 인라인 뷰)
	public List<FreeBoardVO> boardListData(int page) {
		List<FreeBoardVO> list = new ArrayList<FreeBoardVO>();
		try {
			// 1. 오라클 연결
			getConnection();
			// 2. SQL 문장 작성
			String sql = "SELECT no, subject, name, regdate, hit, num "
					   + "From (SELECT no, subject, name, regdate, hit, rownum as num "
					   		 + "FROM (SELECT no, subject, name, regdate, hit "
					   		 	   + "FROM free_board ORDER BY no DESC)) "
					   + "WHERE num BETWEEN ? AND ?";
			ps = conn.prepareStatement(sql);
			// 실행 전 ? 에 값을 채워야 함
			int rowSize = 10;
			int start = (rowSize * page) - (rowSize - 1);
			// 1 page => 1, 2 page => 2
			// rownum 은 1 부터 시작한다
			int end = rowSize * page;
			// 1 page => 10, 2 page => 20
			ps.setInt(1, start);
			ps.setInt(2, end);
			
			// 실행 후 결과값 읽기
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				FreeBoardVO vo = new FreeBoardVO();
				vo.setNo(rs.getInt(1));
				vo.setSubject(rs.getString(2));
				vo.setName(rs.getString(3));
				vo.setRegdate(rs.getDate(4));
				vo.setHit(rs.getInt(5));
				
				list.add(vo);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			disconnection();
		}
		return list;
	}
	// 1-1. 총 페이지 구하기
	public int boardTotalPage() {
		int total = 0;
		try {
			getConnection();
			String sql = "SELECT CEIL (COUNT(*) / 10.0) FROM free_board;";
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			disconnection();
		}
		return total;
	}
	// 2. 상세보기 WHERE (글 클릭)
	public FreeBoardVO boardDetailData(int no) {
		FreeBoardVO vo = new FreeBoardVO();
		try {
			// 연결
			getConnection();
			// 조회수 증가 SQL 문장
			String sql = "UPDATE free_board "
					   + "SET hit = hit + 1 "
					   + "WHERE no = " + no;
			
			ps = conn.prepareStatement(sql);
			
			// 실행 명령
			ps.executeUpdate();
			/*
			 	executeQuery() : 데이터 검색(SELECT)
			 	esecuteUpdate() : 데이터 변경(INSERT / UPDATE / DELETE) => COMMIT 자동 호출
			 */
			sql = "SELECT no, name, subject, content, regdate, hit "
				+ "FROM free_board "
				+ "WHERE no = " + no;
			
			ps = conn.prepareStatement(sql);
			
			// 실행 명령
			ResultSet rs = ps.executeQuery();
			rs.next(); // 한 번만 수행
			
			// 값을 읽어와 채운다
			vo.setNo(rs.getInt(1));
			vo.setName(rs.getString(2));
			vo.setSubject(rs.getString(3));
			vo.setContent(rs.getString(4));
			vo.setRegdate(rs.getDate(5));
			vo.setHit(rs.getInt(6));
			
			rs.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			// 해제
			disconnection();
		}
		return vo;
	}
	// 3. 글쓰기 INSERT
	public void boardInsert(FreeBoardVO vo) { // vo : 게시글 하나가 가지고 있는 모든 정보 => 매개 변수로 받아서 오라클로 전부 전송
		// 리턴형, 매개 변수 생각
		try {
			// 연결
			getConnection();
			String sql = "INSERT INTO free_board(no, name, subject, content, pwd) "
					   + "VALUES(fb_no_seq.nextval, ?, ?, ?, ?)";
			
			ps = conn.prepareStatement(sql);
			ps.setString(1, vo.getName());
			ps.setString(2, vo.getSubject());
			ps.setString(3, vo.getContent());
			ps.setString(4, vo.getPwd());
			
			// 실행
			ps.executeUpdate(); // INSERT 이기 때문에 결과값을 불러올 필요 X
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			// 해제
			disconnection();
		}
	}
	// 4. 수정 UPDATE (비밀번호 검사)
	// 5. 삭제 DELETE (비밀번호 검사)
	// 6. 찾기 LIKE
	// ------------------------------ CRUD
}
