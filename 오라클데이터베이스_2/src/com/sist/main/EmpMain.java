package com.sist.main;
import java.util.*;
import java.sql.*;

public class EmpMain {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("이름 입력 : ");
		String ename = scanner.next();
		
		// 오라클 연결 후 데이터 읽기 => 출력
		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:XE";
			Connection conn = DriverManager.getConnection(url, "hr", "happy");
			
			// SQL 문장 전송
//			String sql = "SELECT ename, job, sal, hiredate FROM emp WHERE ename = UPPER('" + ename + "')";
//			String sql = "SELECT ename, job, sal, hiredate FROM emp WHERE LOWER (ename) = '" + ename + "'";
			String sql = "SELECT ename, job, sal, hiredate FROM emp WHERE ename = '" + ename.toUpperCase() + "'";
			// 문자열은 반드시 ' ' 안에 처리
			// 저장된 데이터는 반드시 대소문자를 구분한다
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			rs.next();
			
			System.out.println("이름 : " + rs.getString(1));
			System.out.println("직위 : " + rs.getString(2));
			System.out.println("급여 : " + rs.getInt(3));
			System.out.println("입사일 : " + rs.getDate(4));
			
			rs.close();
			ps.close();
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
