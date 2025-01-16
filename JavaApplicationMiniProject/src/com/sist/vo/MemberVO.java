package com.sist.vo;
/*
ID        NOT NULL VARCHAR2(20)  
PWD       NOT NULL VARCHAR2(10)  
NAME      NOT NULL VARCHAR2(50)  
SEX                CHAR(6)       
EMAIL              VARCHAR2(100) 
BIRTHDATE NOT NULL DATE          
ADDRESS   NOT NULL VARCHAR2(100) 
REGDATE            DATE         

jdbc : 자바 데이터베이스 연결
	java.sql
	1. ojdbc8.jar
	2. lombok.jar
	--------------
	a. 오라클에 있는 데이터를 모아서 윈도우 / 웹에 전송
		VO : Value Object (Spring)
		DTO : Data Transfer Object (MyBatis)
		Bean : (JSP)
	b. DAO : Data Access Object, 데이터베이스 연결
		Connection : 데이터베이스 연결
		Statement : SQL 문장 전송 / 결과값 읽기
			Statement : SQL + 데이터를 동시에 전송
			"WHERE no = " + no; => SQL 완성 후 전송
			PreparedStatement : SQL 문장을 전송, 나중에 데이터 값을 채운다
			"WHERE name = ?"
			ex)
				String name, sex, address, phone;
				int age, no;
				"INSERT INTO tableName VALUES(' "+ name + "','" + sex + "','" + address + "','" + phone + "'," + age + "," + no + ")"
				"INSERT INTO tableName VALUES(?, ?, ?, ?)"
		CallableStatement : PROCEDURE 호출
							------------ 오라클 함수
							PL / SQL => 중복 SQL
		ResultSet : 결과값 저장하는 메모리 공간
		SELECT id, sex, age, name, regdate
	---------------------------------------------------
		id		sex		age		name		regdate
		hong1	남자		25		홍길동		25/01/16 | => next
		hong2	남자		25		홍길동		25/01/16
		hong3	남자		25		홍길동		25/01/16 | => previous
	---------------------------------------------------
	| 커서
	
	1. 드라이버 등록 : 한 번 사용(생성자)
		Class.forName("oracle.jdbc.driver.OracleDriver")
				MySql = "com.mysql.cj.jdbc.Driver"
				----- MARIADB
				----- driver 는 각 데이터베이스 업체에서 다운 받는다
	2. 오라클 연결 / 해제
		conn = DriverManager.getConnection(URL, "username", "password")
		ps.close() / conn.close()
	3. Connection 객체 관리 (GC 가 바로 회수 하지 못함)
		반드시 한 개만 생성 : 싱글톤
	4. 코딩 순서
		try {
			1. 오라클 연결
			2. SQL 문장
			3. 오라클로 SQL 문장 전송
			4. 실행 후 결과값 읽기
			5. List / VO 에 값 채우기
		} catch(Exception ex) {
			ex.printStackTrace();
			예외 위치 확인 / 예외 메세지 확인
		} finally {
			오라클 해제
		}
 */

import java.util.Date;

import lombok.Data;
@Data
public class MemberVO {
	private String id, pwd, name, sex, email, address;
	private Date birthdate, regdate;
}
