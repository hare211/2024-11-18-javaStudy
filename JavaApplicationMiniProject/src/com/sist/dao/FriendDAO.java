package com.sist.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class FriendDAO {
	private Connection conn;
	private PreparedStatement ps;
	private static FriendDAO dao;
	private final String URL = "jdbc:oracle:thin:@localhost:1521:XE";
	
	public FriendDAO() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public static FriendDAO newInstance() {
		if (dao == null) {
			dao = new FriendDAO();
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
	
	public void addFriend
}
