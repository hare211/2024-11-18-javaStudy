package com.sist.dao;
import java.util.*;
import java.sql.*;
import com.sist.vo.*;

public class FoodDAO {
	private Connection conn;
	private PreparedStatement ps;
	private Database db = new Database();
	private static FoodDAO dao;
	
	// 싱글톤
	public static FoodDAO newInstance() {
		if (dao == null) {
			dao = new FoodDAO();
		}
		return dao;
	}
	
	// 전체 목록 출력
	public List<FoodVO> foodListData(int page) {
		List<FoodVO> list = new ArrayList<FoodVO>();
		try {
			// 오라클 연결
			conn = db.getConnection();
			// 페이지 나누기
			int rowSize = 20;
			int start = (rowSize * page) - (rowSize - 1);
			int end = rowSize * page;
			/*
			 * WHERE num BETWEEN start AND end
			 * 1page			1 ~ 20
			 * 2page			21 ~ 40
			 * => rownum 은 1번부터 시작
			 * => *** 인라인 뷰 => 페이지
			 */
			String sql = "SELECT "
							+ "fno, "
							+ "name, "
							+ "num "
						+ "FROM (SELECT "
									+ "fno, "
									+ "name, "
									+ "rownum as num "
							  + "FROM ("
							  		+ "SELECT "
							  			+ "fno, "
							  			+ "name "
							  		+ "FROM "
							  			+ "food_house "
							  		+ "ORDER BY "
							  			+ "fno"
				  		   	+ ")"
			  		   	+ ") "
						+ "WHERE num "
						+ "BETWEEN " + start + " AND " + end;
			
			ps = conn.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				FoodVO vo = new FoodVO();
				
				vo.setFno(rs.getInt(1));
				vo.setName(rs.getString(2));
				list.add(vo);
			}
			rs.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			db.disconnection(conn, ps);
		}
		return list;
	}
}
