package com.sist.io;
/*
 * FileInputStream => Reader 형식으로 변경
 * seoul_nature
 */
import java.io.*; // 웹에서 가장 많이 사용되는 방식

public class IO_6 {
	public static void main(String[] args) {
		try (FileInputStream fis = new FileInputStream("c:\\javaDev\\seoul_nature.txt");
			 BufferedReader br = new BufferedReader(new InputStreamReader(fis)); // Input 을 Reader 로 => 1byte 를 2byte 로 변환(InputStreamReader)
		) {
			// 웹을 읽는 경우
//			int i = 0;
//			while ((i = br.read()) != -1) {
//				System.out.print((char) i);
//			}
			while (true) {
				String msg = br.readLine();
				// 한 줄씩 읽기
				if (msg == null) {
					break;
				}
				System.out.println(msg);
			}
		} catch (Exception ex) {
			// TODO: handle exception
		}
	}
}
