package com.sist.dao;

import java.nio.charset.Charset;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.sist.vo.MessageVO;

public class MessageDAO {
	private Connection conn;
	private PreparedStatement ps;
	private static MessageDAO dao;
	private final String URL = "jdbc:oracle:thin:@localhost:1521:XE";
	
	public MessageDAO() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public static MessageDAO newInstance() {
		if (dao == null) {
			dao = new MessageDAO();
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
			if (conn != null) {
				conn.close();
			}
			if (ps != null) {
				ps.close();
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public void sendMessage(String subject, String content) {
		try {
			getConnection();
			String sql = "INSERT INTO message VALUES(message_mno_seq.nextval, ?, ?)";
					
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, subject);
			ps.setString(2, content);
			
			ps.executeUpdate();
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			disconnection();
		}
	}
	
	public List<MessageVO> listMessage(String receiverID) {
		List<MessageVO> list = new ArrayList<MessageVO>();
		
		try {
			getConnection();
			String sql = "SELECT subject, content FROM message WHERE receiverID = ?";
			
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, receiverID);
			
			ResultSet rs = ps.executeQuery();
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			disconnection();
		}
		
		return list;
	}
}
