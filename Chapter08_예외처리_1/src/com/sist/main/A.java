package com.sist.main;

public class A {
	public static void main(String[] args) {
//		String s = "123";
//		
//		try {
//			int a = Integer.parseInt(s);
//			System.out.println(a);
//			
//		} catch (NumberFormatException e) {
//			System.out.println(e.getMessage());
//		}
		
		StringBuffer sb = new StringBuffer();
		sb.append("1");
		sb.append("2");
		sb.append("3");
		sb.append(2);
		sb.append(2.2);
		Object obj = new Object();
		sb.append(obj.getClass());
		
		String sd = new String(sb);
		
		System.out.println(sb.toString());
		System.out.println(sd);
	}
}
