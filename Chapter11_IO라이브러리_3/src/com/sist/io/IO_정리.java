package com.sist.io;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class IO_정리 {
	public static void main(String[] args) {
		try {
			// 사용처 => 웹 -> 데이터 / HTML
//			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//			// Scanner 대체
//			System.out.print("문자열 입력 : ");
//			String msg = in.readLine(); // enter => 메모리에 저장
//			System.out.println(msg);
//			// 명령 프롬프트(X) => 입력창 / 출력창
//			//					브라우저(왼도우)
//			
//			Scanner scanner = new Scanner(System.in);
//			String s = scanner.nextLine();
//			System.out.println(s);
			System.out.print("입력 : ");
			int data = System.in.read(); // read() -> 한 글자만 읽어온다
			System.out.println(data); // int 형
			System.out.println((char) data); // 형변환 통해서 문자로 출력
		} catch (Exception ex) {
			// TODO: handle exception
		}
	}
}
