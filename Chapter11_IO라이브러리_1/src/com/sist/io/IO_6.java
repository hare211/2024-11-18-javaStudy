package com.sist.io;
// 삭제 => delete()
import java.io.*;

public class IO_6 {
	public static void main(String[] args) {
		File dir = new File("c:\\java_data");
		// Linux - rm 파일명 => rm -rf 풀더명
		//dir.delete(); // 풀더 안에 파일 또는 풀더가 있으면 삭제가 수행되지 않음
		File[] files = dir.listFiles();
		for (File f : files) {
			f.delete(); // 파일 모두 삭제
		}
		dir.delete(); // 정상 삭제
		
		System.out.println("삭제 완료");
	}
}
