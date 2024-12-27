package com.sist.main;

import java.util.List;
import java.util.Properties;

public class Properties_1 {
	public static void main(String[] args) {
//		Properties props = System.getProperties();
//		System.out.println(props.getProperty("java.version"));
//		System.out.println(props.getProperty("user.language"));
		EmpDAO dao = new EmpDAO();
		List<Emp> list =  dao.empListData();
		for (Emp e : list) {
			System.out.println(e.getEmpno() + " " + e.getEname() + " " + e.getJob());
		}
	}
}
