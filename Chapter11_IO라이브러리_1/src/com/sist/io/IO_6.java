package com.sist.io;
// 삭제 => delete()
import java.io.*;
/*
 * 1. 파일 읽기
 * 		new File("경로명\\파일명")
 * 2. 풀더 읽기
 * 		new File("경로명\\풀더명")
 * 
 * 		웹에서 계속 필요 => 이미지 올리기 / 업로드 / 다운로드
 * 						--------------------------
 * 						=> 자료실
 * 						=> 댓글 - 이미지(이모티콘)
 * 3. 주요 메서드
 * 		getName() : 파일명
 * 		getPath() : 경로명 ~ 파일명
 * 		length() : 파일 크기
 * 
 * 		listFiles() : 풀더의 파일 목록
 * 		mkdir() : 풀더 생성
 * 		createNewFile() : 파일 생성
 * 		delete() : 삭제
 * 		exits() : 존재 여부 확인
 */
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
