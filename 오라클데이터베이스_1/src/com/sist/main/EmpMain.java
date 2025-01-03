package com.sist.main;
import java.util.*;
import com.sist.dao.*;
import com.sist.vo.*;

public class EmpMain {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("사번순 1, 입사순 2, 이름순 3 : ");
		int type = scanner.nextInt();
		
		// 오라클 연결
		EmpDAO dao = EmpDAO.newInstance();
		List<EmpVO> list = dao.empListData(type);
		for (EmpVO vo : list) {
			System.out.println(vo.getEmpno() + " " + vo.getEname() + " " + vo.getJob() + " " + vo.getHiredate());
		}
				
	}
}
