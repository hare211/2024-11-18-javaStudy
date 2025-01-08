package com.sist.main;
import java.util.*;
import com.sist.dao.*;
import com.sist.vo.*;

public class EmpMain {
	public static void main(String[] args) {
		System.out.println("==== 사원 목록 ====");
		
		// 오라클 연결
		EmpDAO dao = EmpDAO.newInstance(); // 객체 생성
		
		// dao 객체의 empJoinAllData 메서드를 통해 데이터를 가져온다
		List<EmpVO> list = dao.empJoinAllData();
		
		for (EmpVO vo : list) {
			System.out.println(vo.getEmpno() + " "
					+ vo.getEname() + " "
					+ vo.getJob() + " "
					+ vo.getHiredate() + " "
					+ vo.getStrSal() + " "
					+ vo.getDvo().getDname() + " "
					+ vo.getDvo().getLoc() + " "
					+ vo.getSvo().getGrade());
		}
		
		Scanner scanner = new Scanner(System.in);
		int empno = scanner.nextInt();
		
		
		EmpVO vo = dao.empFindData(empno);
		System.out.println("==== 사원 정보 ====");
		
		System.out.println("사번 : " + vo.getEmpno());
		System.out.println("이름 : " + vo.getEname());
		System.out.println("직위 : " + vo.getJob());
		System.out.println("입사일 : " + vo.getHiredate());
		System.out.println("급여 : " + vo.getStrSal());
		System.out.println("부서명 : " + vo.getDvo().getDname());
		System.out.println("근무지 : " + vo.getDvo().getLoc());
		System.out.println("급여 등급 : " + vo.getSvo().getGrade());
		
	}
}
