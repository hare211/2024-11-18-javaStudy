package com.sist.io;

import java.io.File;

// listFiles => 현재 풀더에 존재하는 파일의 확장자
public class IO_3 {
	public static void main(String[] args) {
		File dir = new File("c:\\javaDev");
		File[] list = dir.listFiles();
		
		for (File f : list) {
			if (f.isFile()) {
				String name = f.getName();
				String ext = name.substring(name.lastIndexOf(".") + 1);
				System.out.println(name + " " + ext);
			}
		}
	}
}
