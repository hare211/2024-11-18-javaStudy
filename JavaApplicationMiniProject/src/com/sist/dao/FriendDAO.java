package com.sist.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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
	/*
	 * INSERT INTO friend (requester_id, receiver_id, status) VALUES (?, ?, 'P')
	 */
	public void addFriend(String requesterId, String receiverId) {
		try {
			getConnection();
	        // 이미 친구 요청이 존재하는지 확인
	        String checkSql = "SELECT COUNT(*) "
	        		        + "FROM friend "
	        		        + "WHERE (requester_id = ? AND receiver_id = ?) OR (requester_id = ? AND receiver_id = ?)";
	        ps = conn.prepareStatement(checkSql);
	        ps.setString(1, requesterId);
	        ps.setString(2, receiverId);
	        ps.setString(3, receiverId); // 역방향 관계 확인
	        ps.setString(4, requesterId);

	        ResultSet rs = ps.executeQuery();
	        if (rs.next() && rs.getInt(1) > 0) {
	            System.out.println("이미 친구 요청이 존재하거나 친구로 등록된 상태입니다.");
	            return;
	        }
	        
			String sql = "INSERT INTO friend(requester_id, receiver_id, status) VALUES(?, ?, 'P')";
			
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, requesterId);
			ps.setString(2, receiverId);
			
			ps.executeUpdate();
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			disconnection();
		}
	}
}
