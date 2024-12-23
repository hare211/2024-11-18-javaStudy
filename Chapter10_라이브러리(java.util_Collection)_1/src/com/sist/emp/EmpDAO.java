package com.sist.emp;
import java.sql.*;
import java.util.*;

public class EmpDAO {
	private Connection conn; // 연결 객체(오라클)
	private PreparedStatement ps; // SQL 전송 객체
	// => 오라클에서 데이터를 가져올 때 => 오라클에서 실행이 가능한 문장을 전송해야 함 
	//								=> SQL -> SELECT => 데이터 검색
	private final String URL = "jdbc:oracle:thin:@localhost:1521:XE";
	// jdbc:업체명:드라이버명:@IP:PORT:데이터베이스명
	// 자바 지원이 아니라 해당 데이터베이스 업체 지원
	
	// 1. 싱글톤 => 객체를 한 번만 생성
	private static EmpDAO dao;
	
	// 2. 드라이버 등록 => 1 번만 등록 => 생성자
	public EmpDAO() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver"); // "oracle...Driver" -> 로드할 클래스의 완전한 이름
			// 클래스 정보를 읽어서 메모리 할당 => 리플렉션
			// 클래스가 가지고 있는 변수 / 메서드 / 생성자 제어
			// -------------------------- 스프링
			// 스프링 : 객체의 생명주기 담당(컨테이너)
			// => JSP(MVC => 구조 : 스프링 형식)
			// 2차 => 1차 프로젝트가 어렵다
		} catch (Exception ex) {
			
		}
	}
	
	public static EmpDAO newInstance() {
		if (dao == null) {
			dao = new EmpDAO();
		}
		return dao;
	}
	
	// => JDBC(ojdbc8.jar) => DBCP(웹) => ORM => DataSet(JPA)
	//									=> JPA, MyBatis, Hibernate
	// 1. 반복 제거
	// => 연결 / 닫기 => MyBatis
	public void getConnection() {
		try {
			conn = DriverManager.getConnection(URL, "hr", "happy");
			// SQL Plus => conn hr/happy
		} catch (Exception ex) {
			// TODO: handle exception
		}
	}
	
	public void disConnection() {
		try {
			if (ps != null) {
				ps.close(); // => SQL Plus -> exit
			}
			if (conn != null) {
				conn.close(); // => SQL Plus -> exit
			}
		} catch (Exception ex) {
			// TODO: handle exception
		}
	}
	
	public ArrayList<Integer> empGetDeptno() {
		ArrayList<Integer> list = new ArrayList<Integer>();
		try {
			getConnection();
			String sql = "SELECT deptno FROM emp";
			ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				list.add(rs.getInt(1));
				
			}
			rs.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			disConnection();
		}
		return list;
	}
	
	public TreeSet<String> empGetNames() { // 중복된 이름을 제거와 검색이 목적
		TreeSet<String> set = new TreeSet<String>();
		try {
			getConnection();
			String sql = "SELECT ename FROM emp";
			ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				set.add(rs.getString("ename"));
				// 자바는 모든 내용이 0 번부터 시작
				// 오라클은 1 번부터
			}
			rs.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			disConnection();
		}
		return set;
	}
	
	public HashSet<String> empGetJobs() { //  직위를 가져오려 함 -> 중복된 직위 제거 // 일반 전체 목록을 가져온다 -> ArrayList
		HashSet<String> set = new HashSet<String>();
		try {
			// 1. 오라클 연결
			getConnection(); // 연결
			// 2. 오라클(SQL 만 실행 가능) => SQL 문장(자바에서 SQL 문장을 SQL 로 전송한다)
			String sql = "SELECT job FROM emp"; // -> 오라클 SQL Developer 로 전송
			// 3. 오라클 전송
			ps = conn.prepareStatement(sql);
			// 4. 실행 후 데이터 읽기
			ResultSet rs = ps.executeQuery(); // -> 실행 후 나온 데이터를 rs 에 저장
			
			while (rs.next()) { // next -> 위에서부터 읽기 // previous -> 아래서부터 읽기 ==> 다음 데이터가 없으면 false 값 반환 -> 루프 종료
				set.add(rs.getString(1));
			}
			rs.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			disConnection(); // 오라클 연결 해제
		}
		return set;
	}
	// 사원의 모든 정보 => 전체 목록과 관련 => return 을 ArrayList 로
	// 목적과 용도, 의도에 맞게 TreeSet, HashSet, ArrayList 를 알맞게 사용해야 함.
}























