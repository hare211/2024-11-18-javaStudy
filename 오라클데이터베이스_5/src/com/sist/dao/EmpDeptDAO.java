package com.sist.dao;
import java.util.*;
import java.sql.*;

public class EmpDeptDAO {
	Connection conn;
	PreparedStatement ps;
	private final String URL = "jdbc:oracle:thin:@localhost:1521:XE";
	private static EmpDeptDAO dao;
	
	// 드라이버
	public EmpDeptDAO() {
		try {
			Class.forName("oracle.driver.OracleDriver");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	// 싱글톤
	public static EmpDeptDAO newInstance() {
		if (dao == null) {
			dao = new EmpDeptDAO();
		}
		return dao;
	}
	// 연결
	public void getConnection() {
		try {
			conn = DriverManager.getConnection(URL, "hr", "happy");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	// 해제
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
}
