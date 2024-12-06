package com.sist;
import java.lang.reflect.Method;
import java.util.*;

class MyBoard {
	@RequestMapping("write")
	public void write() {
		System.out.println("글쓰기 처리");
	}
	@RequestMapping("lsit")
	public void list() {
		System.out.println("목 록");
	}
	@RequestMapping("update")
	public void update() {
		System.out.println("수정 처리");
	}
	@RequestMapping("delete")
	public void delete() {
		System.out.println("삭제 처리");
	}
}

public class Board {
	public static void main(String[] args) throws Exception{
		Scanner scanner = new Scanner(System.in);
		System.out.print("글쓰기(write), 수정(update), 목록(list) : ");
		String cmd = scanner.next();

		Class clsName = Class.forName("com.sist.MyBoard");
		Object obj = clsName.getDeclaredConstructor().newInstance();
		Method[] methods = clsName.getDeclaredMethods();
		for (Method m : methods) {
			RequestMapping rm = m.getAnnotation(RequestMapping.class);
			if (rm.value().equals(cmd)) {
				m.invoke(obj, null);
			}
		}
		/*
		MyBoard m = new MyBoard(); // 클래스
		
		if (cmd.equals("write")) {
			m.write();
		} else if (cmd.equals("update")) {
			m.update();
		} else if (cmd.equals("list")) {
			m.update();
		}
		*/
	}

}
