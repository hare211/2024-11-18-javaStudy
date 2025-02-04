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
					   + "FROM (SELECT no, subject, name, regdate, hit, rownum as num "
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
			rs.close(); // 작성 안 했었음
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
			String sql = "SELECT CEIL (COUNT(*) / 10.0) FROM free_board";
			ps = conn.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			rs.next();
			
			total = rs.getInt(1);
			rs.close();
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
			// 기존에 있던 데이터를 수정
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			// 해제
			disconnection();
		}
	}
	// 4. 수정 UPDATE (비밀번호 검사)
	// 4-1. 수정하려던 글의 기존 정보 읽기
	public FreeBoardVO boardUpdateData(int no) {
		// 한 개의 게시글 읽기 => PRIMARY KEY
		FreeBoardVO vo = new FreeBoardVO();
		// 한 row 의 데이터 찾기 => VO => 중복 없는 데이터, PK
		// 여러 row 의 데이터 찾기 List<VO> 로 저장 => 검색어(LIKE)
		try {
			getConnection();
			String sql = "SELECT no, name, subject, content "
					   + "FROM free_board "
					   + "WHERE no = " + no;
			
			ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			rs.next();
			
			vo.setNo(rs.getInt(1));
			vo.setName(rs.getString(2));
			vo.setSubject(rs.getString(3));
			vo.setContent(rs.getString(4));
			
			rs.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			disconnection();
		}
		return vo;
	}
	// 4-2. 실제 수정
	public boolean boardUpdate(FreeBoardVO vo) {
		boolean bCheck = false;
		try {
			getConnection();
			String sql = "SELECT pwd "
					   + "FROM free_board "
					   + "WHERE no = " + vo.getNo();
			
			ps = conn.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			
			rs.next();
			
			String db_pwd = rs.getString(1);
			
			rs.close();
			
			if (db_pwd.equals(vo.getPwd())) {
				bCheck = true;
				sql = "UPDATE free_board "
			     	+ "SET name = ?, subject = ?, content = ? " // ? => 문자열을 넣을 땐 ? 선언 후 나중에 값을 넣는게 더 편하다
					+ "WHERE no = ?";
				
				// "UPDATE free_board SET name = " + vo.getname() + ", subject = " + vo.getSubject() + ", content = " + " WHERE no = " + vo.getNo()
				
				ps = conn.prepareStatement(sql); 
				ps.setString(1, vo.getName()); // SQL 문장  1번 ? 에 name 넣기 
				ps.setString(2, vo.getSubject()); // SQL 문장 2번 ? 에 subject 넣기
				ps.setString(3, vo.getContent()); // SQL 문장 3번 ? 에 content 넣기
				ps.setInt(4, vo.getNo());
				
				// 실행
				ps.executeUpdate(); // 기존에 있던 데이터를 수정
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			disconnection();
		}
		
		return bCheck;
	}
	// 5. 삭제 DELETE (비밀번호 검사)
	public boolean boardDelete(int no, String pwd) {
		boolean bCheck = false;
		try {
			// 연결
			getConnection();
			// SQL 문장
			String sql = "SELECT pwd "
					   + "FROM free_board "
					   + "WHERE no = " + no;
			
			// SQL 문장 전송
			ps = conn.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			
			rs.next();
			
			String db_pwd = rs.getString(1);
			rs.close();
			
			if (db_pwd.equals(pwd)) {
				bCheck = true;
				sql = "DELETE FROM free_board "
					+ "WHERE no = " + no;
				
				ps = conn.prepareStatement(sql);
				ps.executeUpdate();
			}
			
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			disconnection();
		}
		return bCheck;
	}
	// 6. 찾기 LIKE
	public List<FreeBoardVO> boardFindData(String col, String fd) {
		// 이름, 제목, 내용으로 찾을 수 있도록
		List<FreeBoardVO> list = new ArrayList<FreeBoardVO>();
		try {
			// 연결
			getConnection(); 
			String sql = "SELECT no, subject, name, regdate, hit "
					   + "FROM free_board "
					   + "WHERE " + col + " LIKE '%'||?||'%'";
			// ? => setString(1, '홍길동')
			ps = conn.prepareStatement(sql);
			ps.setString(1, fd);
			
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
			rs.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			// 해제
			disconnection();
		}
		return list;
	}
	// 6-1. LIKE 로 찾은 COUNT 읽기
	public int boardFindCount(String col, String fd) {
		int count = 0;
		try {
			// 연결
			getConnection();
			String sql = "SELECT COUNT(*) "
					   + "FROM free_board "
					   + "WHERE " + col + " LIKE '%'||?||'%'";
			// ? => setString(1, '홍길동')
			ps = conn.prepareStatement(sql);
			ps.setString(1, fd);
			
			ResultSet rs = ps.executeQuery();

			rs.next();
			count = rs.getInt(1);
			
			rs.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			// 해제
			disconnection();
		}
		return count;
	}
	// ------------------------------ CRUD
}







