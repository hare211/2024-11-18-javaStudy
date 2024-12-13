package com.sist.excute;

import java.util.*;
public class MainClass {
	public MainClass() {
		
	}
	public static void main(String[] args) {
		// A = 1, B = 2, C = 3, D = 4
		Scanner scanner = new Scanner(System.in);
		System.out.print("A-1, B-2, C-3, D-4 : ");
		
		I[] i = {null, new A(), new B(), new C(), new D()};
		
		int select = scanner.nextInt();
		i[select].excute();
//		int select = scanner.nextInt();
//		if (select == 1) {
//			A a = new A();
//			a.excute();
//		} else if (select == 2) {
//			B b = new B();
//			b.excute();
//		} else if (select == 3) {
//			C c = new C();
//			c.excute();
//		} else if (select == 4) {
//			D d = new D();
//			d.excute();
//		}
	}
}
