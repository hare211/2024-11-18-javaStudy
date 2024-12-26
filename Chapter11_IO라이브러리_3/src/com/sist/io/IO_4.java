package com.sist.io;

import java.io.FileOutputStream;

/*
 * 파일 출력 => FileOutputStream / FileWriter
 * 필터		BufferedOutputStream / BufferedWriter
 * 			=> Byte 단위(한 글자 저장), char 단위(여러 문자열 저장 가능)
 */
public class IO_4 {
	public static void main(String[] args) {
		try (
			FileOutputStream fos = new FileOutputStream("c:\\java_data\\student.txt");
			// 파일이 없는 경우 자동으로 생성
			// 파일이 있는 경우 글쓰기
		) {
//			fos.write('A');
//			fos.write('B');
//			fos.write('C');
//			fos.write('D');
//			fos.write('E');
			
			String msg = "ABCEFGHIJKLMNOPQRSTUVWXYZ";
			fos.write(msg.getBytes()); // msg 를 byte 배열로 변환
			// 단위 byte => byte[] => getBytes()
			
			System.out.println("저장 완료");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
	}
}
