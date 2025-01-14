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
			Class.forName("oracle.jdbc.driver.OracleDriver");
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
	// 일반 SQL 사용
	public void sqlExecute() {
		try {
			getConnection();
			String sql = "SELECT empno, ename, job, hiredate, sal, rank, dname, loc, grade "
					   + "FROM (SELECT empno, ename, job, hiredate, sal, "
					                + "RANK() OVER(ORDER BY sal DESC) rank, dname, loc, grade "
					         + "FROM emp e, dept d, salgrade s "
					         + "WHERE e.deptno = d.deptno "
					         + "AND e.sal "
					         + "BETWEEN s.losal AND s.hisal)";
			
			ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				System.out.println(
						rs.getInt(1) + " "
						+ rs.getString(2) + " "
						+ rs.getString(3) + " "
						+ rs.getDate(4).toString() + " "
						+ rs.getInt(5) + " "
						+ rs.getInt(6) + " "
						+ rs.getString(7) + " "
						+ rs.getString(8) + " "
						+ rs.getInt(9));
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			disconnection();
		}
	}
	// View 사용
	public void viewExecute() {
		try {
			getConnection();
			// 소스 간결화, 데이터 보안
			String sql = "SELECT * FROM empAllData";
			
			ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				System.out.println(
						rs.getInt(1) + " "
						+ rs.getString(2) + " "
						+ rs.getString(3) + " "
						+ rs.getDate(4).toString() + " "
						+ rs.getInt(5) + " "
						+ rs.getInt(6) + " "
						+ rs.getString(7) + " "
						+ rs.getString(8) + " "
						+ rs.getInt(9));
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			disconnection();
		}
	}
}
