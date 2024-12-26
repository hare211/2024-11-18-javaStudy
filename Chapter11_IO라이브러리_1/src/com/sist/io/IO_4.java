package com.sist.io;
import java.io.*;
import com.sist.model.*;
import java.util.*;

public class IO_4 {
	public static void main(String[] args) {
		Container c = new Container();
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("클래스 호출 : ");
		String cmd = scanner.next();
		
		I i = (I) c.getBean(cmd); // 클래스를 모아서 관리 => Map
		i.execute();
		// 한 개의 클래스로 통일 => 인터페이스
	}
}
