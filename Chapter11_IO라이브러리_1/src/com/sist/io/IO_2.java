package com.sist.io;
import java.io.File;
// 파일 제어
import java.util.*;

public class IO_2 {
	public static void main(String[] args) {
		// 풀더 생성
		File dir = new File("c:\\javaDev");
		// 어떤 파일 있는 지 확인
		// => listFiles
		File[] list = dir.listFiles();
		//			  --------------- => 파일만 읽기 -> isFile()
		for (File f : list) {
			if (f.isFile()) {
				System.out.println(f.getName() + " " + f.length() + "bytes");
			} else if (f.isDirectory()) {
				System.out.println(f.getName() + " <DIR>");
			}
		}
	}
}
