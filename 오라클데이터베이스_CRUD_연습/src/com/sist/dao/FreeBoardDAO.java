package com.sist.dao;
import java.util.*;
import java.sql.*;
import com.sist.vo.*;

public class FreeBoardDAO {
	// 오라클 연결 객체
	private Connection conn;
	// 오라클 송수신 담당 (송신 : SQL 문장 / 수신 : 실행 결과값)
	private PreparedStatement ps;
	// 오라클 주소 : 고정 (상수)
	private final String URL = "jdbc:oracle:thin:@localhost:1521:XE";
	// 객체를 한 번만 생성해서 재사용(메모리 절약)
	// Connection 객체 수를 조절
	// 싱글톤
	private static FreeBoardDAO dao;
// --------------------------------------------------------------------------------------------------------------------
	// 1. 드라이버 등록
	public FreeBoardDAO() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	// 연결 - 해제 : 윈도우, 명령프롬프트, 웹, react, vue... 상관 없이 모두 필요
	// 2. 오라클 연결
	public void getConnection() {
		try {
			conn = DriverManager.getConnection(URL, "hr", "happy");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	// 3. 오라클 해제
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
	// 4. 싱글톤
	public static FreeBoardDAO newInsatance() {
		if (dao == null) {
			dao = new FreeBoardDAO();
		}
		return dao;
	}
// --------------------------------------------------------------------------------------------------------------------	
}
