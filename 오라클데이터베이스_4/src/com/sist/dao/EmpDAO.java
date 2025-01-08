package com.sist.dao;
import java.util.*;
import com.sist.vo.*;
import java.sql.*;

public class EmpDAO {
	private Connection conn; 
	private PreparedStatement ps;
	private Database db = new Database(); // getConnection() / disconnection() 재사용
	private static EmpDAO dao;
	
	// 싱글톤
	public static EmpDAO newInstance() {
		if (dao == null) {
			dao = new EmpDAO();
		}
		return dao;
	}
	
	// 기능 => 전체 목록 출력
	public List<EmpVO> empListData() {
		List<EmpVO> list = new ArrayList<EmpVO>();
		try {
			conn = db.getConnection();
			String sql = "SELECT "
							+ "empno, "
							+ "ename, "
							+ "job, "
							+ "hiredate, "
							+ "dname, "
							+ "loc "
						+ "FROM "
							+ "emp "
						+ "JOIN "
							+ "dept "
						+ "ON "
							+ "emp.deptno = dept.deptno";
			
			
			ps = conn.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				EmpVO vo = new EmpVO();
				
				vo.setEmpno(rs.getInt(1));
				vo.setEname(rs.getString(2));
				vo.setJob(rs.getString(3));
				vo.setHiredate(rs.getDate(4));
				vo.getDvo().setDname(rs.getString(5));
				vo.getDvo().setLoc(rs.getNString(6));
				
				list.add(vo);
			}
			rs.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			db.disconnection(conn, ps);
		}
		return list;
	}
	// 상세보기 => EmpVO (사원 한 명에 대한 모든 정보 저장)
	// 무조건 중복이 없는 데이터 전송
	public EmpVO empDetailData(int empno) {
		EmpVO vo = new EmpVO();
		try {
			conn = db.getConnection(); // conn = 작성하지 않아 오류 발생하였음
			
			String sql = "SELECT "
							+ "e1.empno, "
							+ "e1.ename, "
							+ "e1.job, "
							+ "e2.ename, "
							+ "e1.hiredate, "
							+ "e1.sal, "
							+ "e1.comm, "
							+ "dname, "
							+ "loc, "
							+ "grade "
						+ "FROM "
							+ "emp e1, "
							+ "emp e2, "
							+ "dept d, "
							+ "salgrade " // dept d => 별칭 d 쓰지 작성하지 않아 오류 발생하였음
						+ "WHERE "
							+ "e1.mgr = e2.empno "
						+ "AND "
							+ "e1.deptno = d.deptno "
						+ "AND "
							+ "e1.sal "
						+ "BETWEEN "
							+ "losal "
						+ "AND "
							+ "hisal "
						+ "AND "
							+ "e1.empno = " + empno;
			   
			ps = conn.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			
			rs.next();
			
			vo.setEmpno(rs.getInt(1));
			vo.setEname(rs.getString(2));
			vo.setJob(rs.getString(3));
			vo.setMname(rs.getString(4));
			vo.setHiredate(rs.getDate(5));
			vo.setSal(rs.getInt(6));
			vo.setComm(rs.getInt(7));
			vo.getDvo().setDname(rs.getString(8));
			vo.getDvo().setLoc(rs.getNString(9));
			vo.getSvo().setGrade(rs.getInt(10));
			
			rs.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			db.disconnection(conn, ps);
		}
		return vo; 
	}
	// 검색
	public List<EmpVO> empFindData(String col, String fd) {
		// 이름, 입사일, 직위, 부서명, 근무지
		List<EmpVO> list = new ArrayList<EmpVO>();
		try {
			// 1. 연결
			conn = db.getConnection();
			// 2. SQL 문장
			String sql = "SELECT "
							+ "empno, "
							+ "ename, "
							+ "job, "
							+ "hiredate, "
							+ "dname, "
							+ "loc "
						+ "FROM "
							+ "emp, "
							+ "dept "
						+ "WHERE "
							+ "emp.deptno = dept.deptno "
						+ "AND " + col + " " 
						+ "LIKE "
							+ "'%'||?||'%'";
			// 조건이 있는 경우 반드시 AND
			// ? => setString(1, fd) => ' '
			ps = conn.prepareStatement(sql);
			// 실행 요청 전에 ? 에 값을 채운다
			ps.setString(1, fd);
			
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				EmpVO vo = new EmpVO();
				vo.setEmpno(rs.getInt(1));
				vo.setEname(rs.getString(2));
				vo.setJob(rs.getString(3));
				vo.setHiredate(rs.getDate(4));
				vo.getDvo().setDname(rs.getString(5));
				vo.getDvo().setLoc(rs.getNString(6));
				
				list.add(vo);
			}
			
			rs.close();
			
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			db.disconnection(conn, ps);
		}
		return list;
	}
}
