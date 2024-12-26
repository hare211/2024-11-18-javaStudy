package com.sist.io;
// 파일 제어 => 파일에 읽기 / 쓰기
//			  --------------> Reader / Writer
import java.io.*;
import java.util.*;
public class IO_3 {
	public static void main(String[] args) {
		// FileWriter : 파일에 입력
		FileWriter fw = null; // 2byte 단위 : 한글은 한 글자당 2byte
		try {
			fw = new FileWriter("c:\\java_data\\sawon.txt", true); // true -> append 덮어쓰지 않고 추가함
			// sawon.txt 파일이 없는 경우 자동으로 생성
			fw.write("3|박씨|영업부|부산|3000\r\n");
			System.out.println("등록 완료");
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			try {
				fw.close();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}
}
