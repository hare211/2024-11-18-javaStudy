package com.sist.dao;
import java.util.*;
import java.sql.*;
import com.sist.vo.*;

public class FoodDAO {
	private Connection conn;
	private PreparedStatement ps;
	private static FoodDAO dao;
	private final String URL = "jdbc:oracle:thin:@localhost:1521:XE";
	
	// 1. 드라이버 등록
	public FoodDAO() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	// 2. Connection 객체 한 개만 생성(싱글톤)
	public static FoodDAO newInstance() {
		if (dao == null) {
			dao = new FoodDAO();
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
	// 1. 전체 목록 => 인라인 뷰
	public List<FoodVO> foodListData(int page) {
		List<FoodVO> list = new ArrayList<FoodVO>();
		try {
			getConnection();
			String sql = "SELECT fno, name, poster, num "
					   + "FROM (SELECT fno, name, poster, rownum as num "
					         + "FROM (SELECT /*+ INDEX_ASC(food_menupan fm_fno_pk) */ fno, name, poster "
					               + "FROM food_menupan)) "
					   + "WHERE num BETWEEN ? AND ?";
			
			ps = conn.prepareStatement(sql);
			
			int rowSize = 12;
			int start = (rowSize * page) - (rowSize - 1);
			int end = rowSize * page;
			
			ps.setInt(1, start);
			ps.setInt(2, end);
			
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				FoodVO vo = new FoodVO();
				vo.setFno(rs.getInt(1));
				vo.setName(rs.getString(2));
				vo.setPoster("http://menupan.com" + rs.getString(3));
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
	public int foodTotalPage() {
		int total = 0;
		try {
			getConnection();
			String sql = "SELECT CEIL(COUNT(*) / 12.0) "
					   + "FROM food_menupan";
			
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
	// 2. 상세보기 => 조회수 증가
}
















