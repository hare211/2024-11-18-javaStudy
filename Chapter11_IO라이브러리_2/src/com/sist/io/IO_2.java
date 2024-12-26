package com.sist.io;
import java.io.*;

public class IO_2 {
	public static void main(String[] args) {
		FileInputStream fis = null;
		FileOutputStream fos = null; // fis 에서 읽어와 fos 에 저장
		
		try {
			// 파일 자체 제어 => Reader / Writer 
			// 파일 복사 -> 파일 전송 => FileIn-OutputStream 
			fis = new FileInputStream("c:\\javaDev\\movie.txt");
			fos = new FileOutputStream("c:\\java_data\\movie.txt");
			//							=> 파일이 없는 경우 자동으로 파일 생성, 있는 경우 덮어씀
			/*
			 * mode
			 * 	r => read
			 * 	w => write => create
			 * 	a => append
			 * 	fos = new FileOutputStream("c:\\java_data\\movie.txt", true); => a mode(append) -> 기존의 내용에서 추가
			 */
			int i = 0; // IO_1 에선 i => 한 글자
			// 읽은 바이트 수
			byte[] buffer = new byte[1024]; // TCP(1024byte) / UDP(512byte)
			// read() : 글자 번호 / read(byte[], start, end) : 읽은 바이트 수
			while ((i = fis.read(buffer, 0, 1024)) != -1) {
				fos.write(buffer, 0, i); // i 읽은 바이트 수
			}
			System.out.println("복사 완료");
			
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			try {
				fis.close();
				fos.close();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}
}
