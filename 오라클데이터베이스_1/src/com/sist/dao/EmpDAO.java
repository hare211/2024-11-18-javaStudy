package com.sist.dao;
/*
 * 오라클 연동 클래스
 * 
 * 오라클 연동
 * --------
 * 1. 드라이버 설정
 * 	=> 한 번만 설정
 * 	=> 생성자 이용
 * 	=> Class.forName("드라이버 명")
 * 					------------ oracle.jdbc.driver.OracleDriver
 * 					------------ com.mysql.cj.jdbc.Driver -> MySql
 * 2. 오라클 연결
 * 	Connection conn = DriverManager.getConnection(URL, "username", "password");
 * 3. 오라클로 SQL 문장 전송
 * 			 ----------
 * 	PreparedStatement ps = conn.preparedStatement(sql);
 * 4. 오라클에서 SQL 실행 후 결과값 요청
 * 	ResultSet rs = ps.executeQuery();
 * 
 * 	rs
 * 	---------------------------
 * 		id		pwd		name
 * 	---------------------------
 * 		aaa		1234	홍씨		| => next() 위에서부터 아래로 => 가장 많이 사용
 * 	---------------------------
 * 		bbb		1234	이씨
 * 	---------------------------
 * 		ccc		1234	박씨		| => previous() 아래서부터 위로
 * 	---------------------------
 *	| cursor 위치 
 *
 *	=> rs.close()
 *	=> ps.close()
 *	=> conn.close()
 *	=> 생성되는 순서 반대로 닫는다
 *
 *	*** rs.next() => record 단위 => 한 줄에 있는 모든 데이터를 읽는다
 */
import java.util.*;
import java.sql.*;
import com.sist.vo.*;
/*
 * => SQL 문장에 ; 작성 X
 * => 변경사항 -> LIKE
 * => LIKE '%'||문자열||'%' => 문자열 결합
 * 	  LIKE CONCAT('%', 문자열, '%') => MySql
 * => JOIN => Oracle JOIN / ANSI JOIN
 * 							--------- 표준화 (Oracle, MySql 에서 모두 사용 가능)
 */
public class EmpDAO {
	// 1. 오라클 연결
	private Connection conn;
	// 2. 오라클 SQL 송수신
	private PreparedStatement ps;
	/*
	 * SQL 문장 전송
	 * 오라클 실행 결과 읽기
	 * ----------------
	 * Statement : 데이터와 동시에 SQL 문장 전송
	 * PreparedStatement : SQL 먼저 전송
	 * 					   나중에 데이터 전송 ***
	 * CallableStatement : Procedure(함수) 호출
	 * 					   | SQL 문장 노출 X
	 * 					   | 보안 뛰어남
	 * 					   | ERP => 관리 프로그램
	 * 
	 * EmpVO
	 * String sql = "INSERT INTO emp VALUES('' => Statement
	 * 				+ vo.getEmpno() +'', ' " + vo.getEname()
	 * 				+ " ', ' " + vo.getJob() + " ' , ' "
	 * 				+ vo.getHiredate() + " ', "
	 * 				+ vo.getSale()...
	 * String sql = "INSERT INTO emp VALUES(?, ?, ?...) => PreparedStatemenut 
	 * 		=> MyBatis / JPA
	 */
	// => 필드 선언 => 클래스 모든 곳에서 사용
	// 3. DAO => 오라클 연동 =>  사용자 한 명당 한 개만 사용 (싱글톤)
	private static EmpDAO dao;
	// 3-1. URL
	private final String URL = "jdbc:oracle:thin:@localhost:1521:XE";
	// => TCP => Socket 을 이용해서 오라클로 SQL 문장 전송
	// => 오라클 서버 => 자바 응용프로그램 : Client
	public EmpDAO() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// ojdbc8.jar
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	// 4. 기능
	// 모든 메서드에서 공통으로 사용되는 기능
	// 4-1. 오라클 연결 / 오라클 연결 해제 => 공통
	public void getConnection() {
		try {
			conn = DriverManager.getConnection(URL, "hr", "happy");
			// conn hr/happy 와 같다
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public void disConnection() {
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
	// 4-2. 싱글톤 => 메모리 공간을 한 개만 생성
	public static EmpDAO newInstance() {
		if (dao == null) {
			dao = new EmpDAO();
		}
		return dao;
	}
	// ------------------------------------ | 중복 부분 => jar
	// 2차 => JSP : MyBatis (XML) => Jquery, Ajax
	// 3차 => Spring : MyBatis (Annotation) => VueJS
	// 4-3. 목록 => SELECT column_list
	public List<EmpVO> empListData(int type) {
		List<EmpVO> list = new ArrayList<EmpVO>();
		String order = "";
		if (type == 1) {
			order = "ORDER BY empno ASC";
		} else if (type == 2) {
			order = "ORDER BY hiredate DESC";
		} else if (type == 3) {
			order = "ORDER BY ename ASC";
		}
		try {
			// 1. 오라클 연결
			getConnection();
			// 2. SQL 문장 작성
			String sql = "SELECT empno, ename, job, hiredate FROM emp " + order;
			// 3. 오라클로 전송
			ps = conn.prepareStatement(sql);
			// 4. SQL 실행 후 결과값 읽기
			ResultSet rs = ps.executeQuery(); // rs 에 요청한 emp 데이터 전송
			// 정수 => getInt(), 실수 => getDouble(), 문자열 => getString(), 날짜 => getDate()
			// => 커서의 위치 변경
			// 7839 KING PRESIDENT 81/11/17 // 1 2 3 4
			while (rs.next()) { // 처음부터 마지막까지 데이터를 읽어온다
				EmpVO vo = new EmpVO();
				vo.setEmpno(rs.getInt(1));
				vo.setEname(rs.getString(2));
				vo.setJob(rs.getString(3));
				vo.setHiredate(rs.getDate(4));
				list.add(vo);
			}
			rs.close();
		} catch (Exception ex) {
			// 오류 확인
			ex.printStackTrace();
		} finally {
			// 오라클 해제
			disConnection();
		}
		return list;
	}
	// 4-4. 상세보기 => WHERE
}












