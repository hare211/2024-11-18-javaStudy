package com.sist.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;


public class CardDAO {
	private Connection conn;
	private PreparedStatement ps;
	private static CardDAO dao;
	private final String URL = "jdbc:oracle:thin:@localhost:1521:XE";
	
	
	
	public CardDAO() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public static CardDAO newInstance() {
		if (dao == null) {
			dao = new CardDAO();
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
	public void cardInsert(String id, int price) {
		try {
			getConnection();
			conn.setAutoCommit(false); // auto commit 해제
			String sql = "INSERT INTO myCard VALUES(?, ?)";
			
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, id);
			ps.setInt(2, price);
			
			ps.executeUpdate();
			
			sql = "INSERT INTO myPoint VALUES((SELECT NVL(MAX(no) + 1, 1) FROM myPoint), ?, ?)";
			
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, id);
			ps.setInt(2, price);
			ps.executeUpdate();
			
			conn.commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			try {
				conn.rollback();
			} catch (Exception e) {
				e.printStackTrace();
			}
		} finally {
			try {
				conn.setAutoCommit(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
			disconnection();
		}
	}
	public static void main(String[] args) {
		CardDAO dao = CardDAO.newInstance();
		dao.cardInsert("hong", 3000);
	}
}
