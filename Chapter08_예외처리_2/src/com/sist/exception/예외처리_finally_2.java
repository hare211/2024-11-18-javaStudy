package com.sist.exception;
import java.sql.*;
/*
 * 
 */
public class 예외처리_finally_2 {
	public static void main(String[] args) {
		/*
		 * 1. 오라클 연결이 가능하게 드라이버 설정
		 * 		Class.forName("드라이버")
		 * 		=> ClassNotFoundException -> CheckException
		 * 2. 오라클 연동
		 * 		Connection : SQLException : CheckException
		 * 3. 오라클로 명령어를 전송
		 * 			------- SQL
		 * 	  PreparedStatement : SQLException
		 * 4. 결과값을 받는다
		 * 		ResuletSet -> 결과값을 메모리에 저장
		 * -------------------------- finally
		 * 5. ResultSet 닫기
		 * 	  PreparedStatement 닫기
		 * 	  Connection 닫기
		 */
		Connection conn = null;
		// 오라클 송수신 담당
		PreparedStatement ps = null;
		// 결과값 저장
		ResultSet rs = null;
		
		try {
			String url = "jdbc:oracle:thin:@localhost:1521:XE";
			
			// 1. 연결 드라이버 설정
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// 2. 연결
			conn = DriverManager.getConnection(url, "hr", "happy");
			// 3. 오라클 요청
			String sql = "SELECT empno,ename,job FROM emp";
			//					  int String String
			ps = conn.prepareStatement(sql);
			// 실행 후에 결과값을 가지고 온다(메모리에 저장)
			rs = ps.executeQuery();
			// 결과 출력
			while (rs.next()) { // next 다음이 없으면 false // rs.previous() 아래서부터 위로 올라가면서
				System.out.println(rs.getInt(1) + " "
						+ rs.getString(2) + " "
						+ rs.getString(3));
			}
		} catch (SQLException e) { // -> 오라클 연결
			System.out.println(e.getMessage());
			e.printStackTrace();
		} catch (ClassNotFoundException e) { // -> Class.forName
			System.out.println(e.getMessage());
			e.printStackTrace();
		} finally {
			// 오라클 연결 해제
			try {
				if (rs != null) {
					rs.close();
				}
				if (ps != null) {
					ps.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e2) {
				
			}
		}
	
	}

}
