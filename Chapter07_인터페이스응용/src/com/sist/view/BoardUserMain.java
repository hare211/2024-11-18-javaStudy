package com.sist.view;
import com.sist.controller.*;
import java.util.*;
public class BoardUserMain {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Controller c = new Controller();
		System.out.print("list, write, update, detail, delete : ");
		// list.jsp, write.jsp...
		String cmd = scanner.next();
		
		c.service(cmd);
		
	}
}
