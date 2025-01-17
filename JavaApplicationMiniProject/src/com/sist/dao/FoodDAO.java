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
	// 홈 / 맛집 / 맛집 검색 => 상세보기
	// 3. 장르별 출력
	public List<FoodVO> foodGenreData(int page, String genre){
		List<FoodVO> list = new ArrayList<FoodVO>();
		try {
			getConnection();
			String sql = "SELECT fno, name, poster, num "
					   + "FROM (SELECT fno, name, poster, rownum as num "
					         + "FROM (SELECT /*+ INDEX_ASC(food_menupan fm_fno_pk) */ fno, name, poster "
					               + "FROM food_menupan "
					               + "WHERE type LIKE '%'||?||'%')) "
					   + "WHERE num BETWEEN ? AND ?";
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, genre);
			
			int rowSize = 12;
			int start = (rowSize * page) - (rowSize - 1);
			int end = rowSize * page;
			
			ps.setInt(2, start);
			ps.setInt(3, end);
			
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				FoodVO vo = new FoodVO();
				vo.setFno(rs.getInt(1));
				vo.setName(rs.getString(2));
				vo.setPoster("https://www.menupan.com" + rs.getString(3));
				
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
	// 3-1. 장르별 총페이지
	public int foodGenreTotalPage(String genre) {
		int total = 0;
		try {
			getConnection();
			String sql = "SELECT CEIL(COUNT(*)) / 12.0 "
					   + "FROM food_menupan "
					   + "WHERE type "
					   + "LIKE '%'||?||'%'";
			
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, genre);
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
	// 4. 검색
	public List<FoodVO> foodFindData(String address) {
		List<FoodVO> list = new ArrayList<FoodVO>();
		try {
			getConnection();
			String sql = "SELECT fno, poster, name, address, type, score, rownum "
					   + "FROM food_menupan "
					   + "WHERE address LIKE '%'||?||'%' AND rownum <= 10 "
					   + "ORDER BY fno ASC";
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, address);
			
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				FoodVO vo = new FoodVO();
				vo.setFno(rs.getInt(1));
				vo.setPoster("https://www.menupan.com" + rs.getString(2));
				vo.setName(rs.getString(3));
				vo.setAddress(rs.getString(4));
				vo.setType(rs.getString(5));
				vo.setScore(rs.getDouble(6));
				
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
	
	public FoodVO foodDetailData(int fno) {
		FoodVO vo = new FoodVO();
		try {
			getConnection();
			String sql = "SELECT name, type, phone, address, score, "
					          + "theme, poster, images, time, parking, "
					          + "content, price "
					   + "FROM food_menupan "
					   + "WHERE fno = " + fno;
			ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			rs.next();
			
			vo.setName(rs.getString(1));
			vo.setType(rs.getString(2));
			vo.setPhone(rs.getString(3));
			vo.setAddress(rs.getString(4));
			vo.setScore(rs.getDouble(5));
			vo.setTheme(rs.getString(6));
			vo.setPoster("https://www.menupan.com" + rs.getString(7));
			vo.setImages(rs.getString(8));
			vo.setTime(rs.getString(9));
			vo.setParking(rs.getString(10));
			vo.setContent(rs.getString(11));
			vo.setPrice(rs.getString(12));
			
			rs.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			disconnection();
		}
		
		return vo;
	}
	
	public List<FoodVO> foodTop10() {
		List<FoodVO> list = new ArrayList<FoodVO>();
		
		try {
			getConnection();
			String sql = "SELECT name, poster, score, rownum "
				       + "FROM (SELECT name, poster, score "
					         + "FROM food_menupan "
					         + "ORDER BY score DESC) "
					   + "WHERE rownum <= 10";
			
			ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				FoodVO vo = new FoodVO();
				vo.setName(rs.getString(1));
				vo.setPoster(rs.getString(2));
				vo.setScore(rs.getDouble(3));
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
}
















