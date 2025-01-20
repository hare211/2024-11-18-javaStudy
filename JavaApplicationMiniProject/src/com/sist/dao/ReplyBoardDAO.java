package com.sist.dao;
import java.util.*;
import java.sql.*;
import com.sist.vo.*;

public class ReplyBoardDAO {
	private Connection conn;
	private PreparedStatement ps;
	private static ReplyBoardDAO dao;
	private final String URL = "jdbc:oracle:thin:@localhost:1521:XE";
	
	
	
	public ReplyBoardDAO() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public static ReplyBoardDAO newInstance() {
		if (dao == null) {
			dao = new ReplyBoardDAO();
		}
		return dao;
	}
	
	public void getConnection() {
		try {
			conn = DriverManager.getConnection(URL, "hr", "happy");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
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
	// 1. 목록 출력(인라인 뷰)
	// 1 page 에 10 개, 최신순
	// 추가, 수정, 삭제가 많은 경우 INDEX 사용 X => ORDER BY 사용
	public List<ReplyBoardVO> boardListData(int page) {
		List<ReplyBoardVO> list = new ArrayList<ReplyBoardVO>();
		try {
			getConnection();
			String sql = "SELECT no, subject, name, TO_CHAR(regdate, 'YYYY-MM-DD'), hit, group_tab, num "
				       + "FROM (SELECT no, subject, name, regdate, hit, group_tab, rownum as num "
					         + "FROM (SELECT no, subject, name, regdate, hit, group_tab "
					               + "FROM replyBoard ORDER BY group_id DESC, group_step ASC)) "
					+ "WHERE num BETWEEN ? AND ?";
			
			ps = conn.prepareStatement(sql);
			
			int rowSize = 10;
			int start = (rowSize * page) - (rowSize - 1);
			int end = rowSize * page;
			
			ps.setInt(1, start);
			ps.setInt(2, end);
			
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				ReplyBoardVO vo = new ReplyBoardVO();
				
				vo.setNo(rs.getInt(1));
				vo.setSubject(rs.getString(2));
				vo.setName(rs.getString(3));
				vo.setDbDay(rs.getString(4));
				vo.setHit(rs.getInt(5));
				vo.setGroup_tab(rs.getInt(6));
				
				list.add(vo);
			}
			rs.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			disconnection();
		}
		
		return list;
	}
	// 1-1. 총페이지
	public int boardTotalPage() {
		int total = 0;
		try {
			getConnection();
			String sql = "SELECT CEIL(COUNT(*) / 10.0) FROM replyBoard";
			
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
	// 2. 글쓰기(INSERT)
	public void boardInsert(ReplyBoardVO vo) {
		try {
			getConnection();
			
			String sql = "INSERT INTO replyBoard(no, name, subject, content, pwd, group_id) "
					   + "VALUES (rb_no_seq.nextval, ?, ?, ?, ?, (SELECT NVL(MAX(group_id) + 1, 1) "
					                                           + "FROM replyBoard))";
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, vo.getName());
			ps.setString(2, vo.getSubject());
			ps.setString(3, vo.getContent());
			ps.setString(4, vo.getPwd());
			
			ps.executeUpdate(); // commit 수행
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			disconnection();
		}
	}
	// 3. 상세보기(WHERE)
	public ReplyBoardVO boardDetailData(int type, int no) {
		ReplyBoardVO vo = new ReplyBoardVO();
		
		try {
			// 상세보기 : 선택된 데이터로부터 Primary Key 매개변수로 받아야 함
			getConnection();
			// 조회수 증가
			if (type == 1) {
				
			String sql = "UPDATE replyBoard "
					   + "SET hit = hit + 1 "
					   + "WHERE no = " + no;
			ps = conn.prepareStatement(sql);
			ps.executeUpdate();
			}
			// 상세보기
			String sql = "SELECT no, name, subject, content, TO_CHAR(regdate, 'YYYY-MM-DD HH24:MI:SS'), hit "
				+ "FROM replyBoard "
				+ "WHERE no = " + no;
			
			ps = conn.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			
			rs.next();
			
			vo.setNo(rs.getInt(1));
			vo.setName(rs.getString(2));
			vo.setSubject(rs.getString(3));
			vo.setContent(rs.getString(4));
			vo.setDbDay(rs.getString(5));
			vo.setHit(rs.getInt(6));
			
			rs.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			disconnection();
		}
		
		return vo;
	}
	// 4. 수정(UPDATE)
	// 4-1. 수정할 글의 데이터 가져오기
	public ReplyBoardVO boardUpdateData(int no) {
		ReplyBoardVO vo = new ReplyBoardVO();
		
		try {
			getConnection();
			String sql = "SELECT no, name, subject, content "
					   + "FROM replyBoard "
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
	public boolean boardUpdate(ReplyBoardVO vo) {
		boolean bCheck = false;
		
		try {
			getConnection();
			String sql = "SELECT pwd FROM replyBoard WHERE no = " + vo.getNo();
			
			ps = conn.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			
			rs.next();
			
			String db_pwd = rs.getString(1);
			
			rs.close();
			
			if (db_pwd.equals(vo.getPwd())) {
				bCheck = true;
				
				sql = "UPDATE replyBoard "
					+ "SET name = ?, subject = ?, content = ? "
					+ "WHERE no = ?";
				
				ps = conn.prepareStatement(sql);
				
				ps.setString(1, vo.getName());
				ps.setString(2, vo.getSubject());
				ps.setString(3, vo.getContent());
				ps.setInt(4, vo.getNo());
				
				ps.executeUpdate();
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			disconnection();
		}
		return bCheck;
	}
	// 5. 답변(TRANSACTION)
	// 6. 삭제(TRANSACTION)
}
