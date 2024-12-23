package com.sist.emp;
import java.util.*;
public class EmpUserMain {
	public static void main(String[] args) {
		EmpDAO dao = EmpDAO.newInstance();
		
//		HashSet<String> set = dao.empGetJobs();
//		
//		System.out.println("저장 개수 : " + set.size());
//		
//		for (String job : set) {
//			System.out.println(job);
//		}
//		TreeSet<String> set = dao.empGetNames();
//		System.out.println("사원 인원 : " + set.size());
//		for (String name : set) {
//			System.out.println(name);
//		}
//		System.out.println("==== 한명 퇴사 ====");
//		set.remove("SCOTT");
//		System.out.println("사원 인원 : " + set.size());
//		for (String name : set) {
//			System.out.println(name);
//		}
//		
//		System.out.println(set.subSet("K", "WORD"));
//		// 순위 검색
//		set.add("d");
		List<Integer> list = dao.empGetDeptno();
		
		System.out.println("부서 번호 : " + list.size());
		
		for (Integer i : list) {
			System.out.println(i);
		}
		
		System.out.println();
		
		Collections.sort(list);
		
		for (Integer i : list) {
			System.out.println(i);
		}
		
		System.out.println();
		
		Collections.reverse(list);
		
		for (Integer i : list) {
			System.out.println(i);
		}
		
		list.forEach(i -> System.out.println(list));
		
		
	}
}

