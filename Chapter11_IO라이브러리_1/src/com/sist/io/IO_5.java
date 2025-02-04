package com.sist.io;
import java.io.*;
// 풀더 / 파일 / (풀더 / 파일 존재 여부 확인) => 삭제(자료실에서 업로더가 삭제 등)
public class IO_5 {
	public static void main(String[] args) {
		File file = new File("c:\\java_data\\sawon"); // sawon 파일 생성하기
		
		if (!file.exists()) {
			try {
				file.createNewFile(); // 파일 생성
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("이미 파일이 존재합니다.");
		}
//		if (!dir.exists()) { // 풀더 생성 => 존재하지 않는 경우
//			dir.mkdir();
//		} else {
//			System.out.println("이미 존재하는 풀더입니다.");
//		}
		System.out.println("프로그램 종료");
	}
}
