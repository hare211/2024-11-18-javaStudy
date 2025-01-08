package com.sist.dao;
// DAO : 데이터베이스와 연결하는 클래스
import java.util.*;
import java.sql.*;
import com.sist.vo.*;
/*
 	오라클 => SQL
 			---- 자바에서도 실행 여부를 확인
	
 */
public class EmpDAO {
	// 오라클 연결
	private Connection conn; // Socket 이 속해있다
	
	// 오라클 SQL로 전송 후 결과값 수신
	private PreparedStatement ps;
	
	// DAO 는 사용자당 한 개만 생성하도록 하여 메모리 최소화 (Connection 조절)
	private static EmpDAO dao;
	
	// 고정 데이터 : URL (오라클 주소)
	private final String URL = "jdbc:oracle:thin:@localhost:1521:XE";
	// XE : 데이터베이스명 => 모든 테이블이 들어가 있다
	// => 폴더 (파일 여러 개)
	
	// 1. 드라이버 등록 : 한 번만 사용 (생성자)
	public EmpDAO() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			/*
			 	클래스명으로 메모리 할당
			 	1. 생성자
			 	2. 멤버 변수
			 	3. 메서드 => 매개 변수도 처리 해줌
			 	----------- 제어할 수 있다
			 	=> 리플렉션 => 스프링 / 메서드의 자동 호출이 가능
			 */
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	// 싱글톤 => 효율적인 메모리 공간 활용 / 재사용 가능
	// newInstance() / getInstance() => 싱글톤 패턴 
	// Calendar.getInstance()
	// 파싱 : XML / HTML / JSON
	//			   ---- JSoup
	public static EmpDAO newInstance() {
		if (dao == null) {
			dao = new EmpDAO();
		}
		return dao;
	}
	
	// 오라클 연결
	public void getConnection() {
		try {
			// SQL Plus 를 사용하는 것과 같다
			conn = DriverManager.getConnection(URL, "hr", "happy");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	// 오라클 연결 해제
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
	
	// ------------------------- 공통 사항
	/*
	 	DAO => 테이블 한 개에 대한 제어
	 	=> BoardDAO
	 	=> ReplyDAO
	 	
	 	Service => 관련된 테이블 여러 개 제어
	 	=> BoardService : Board / Reply
	 */
	// 1. 기능
	
	
	
}















