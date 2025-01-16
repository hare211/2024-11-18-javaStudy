package com.sist.dao;
import java.sql.*;
import com.sist.vo.*;

public class MemberDAO {
	private Connection conn;
	private PreparedStatement ps;
	private static MemberDAO dao;
	private final String URL = "jdbc:oracle:thin:@localhost:1521:XE";
	
	// 1. 드라이버 등록
	public MemberDAO() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	// 2. Connection 객체 한 개만 생성(싱글톤)
	public static MemberDAO newInstance() {
		if (dao == null) {
			dao = new MemberDAO();
		}
		return dao;
	}
	// 3. 연결
	public void getConnection() {
		try {
			conn = DriverManager.getConnection(URL, "hr", "happy");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	// 4. 해제
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
	
	// 기능
	// 1. 로그인
	public MemberVO isLogin(String id, String pwd) {
		MemberVO vo = new MemberVO();
		try {
			getConnection();
			String sql = "SELECT COUNT(*) "
					+ "FROM member "
					+ "WHERE id = ?";
			
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, id);
			
			// 실행 요청
			ResultSet rs = ps.executeQuery();
			rs.next();
			int count = rs.getInt(1);
			rs.close();
			
			if (count == 0) { // ID 가 검색되지 않은 경우 => ID 가 없는 경우
				vo.setMsg("NOID");
			} else { // ID 가 하나라도 검색 된 경우 => ID 가 있는 경우
				// 비밀번호 확인
				sql = "SELECT id, pwd, name, sex FROM member WHERE id = ?";
				
				ps = conn.prepareStatement(sql);
				// 실행 전에 ? 에 값 채운다
				ps.setString(1, id);
				// SQL 문장 실행
				rs = ps.executeQuery();
				
				rs.next();
				
				vo.setId(rs.getString(1));
				vo.setName(rs.getString(3));
				vo.setSex(rs.getString(4));
				String db_pwd = rs.getString(2);
				
				// 비밀번호 검사
				if (db_pwd.equals(pwd)) { // 로그인 성공
					vo.setMsg("OK");
				} else { // 비밀번호 틀림
					vo.setMsg("NOPWD");
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			disconnection();
		}
		return vo;
	}
	// 2. 회원가입
	// 3. 회원수정
	// 4. 회원탈퇴
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
