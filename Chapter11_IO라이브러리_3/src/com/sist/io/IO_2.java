package com.sist.io;
import java.io.*;
// 필터 스트림 => 읽기 성능을 최적화 => 속도가 빠르다
/*
 * 파일의 단점
 * -------- 구분자가 없다
 * 사원 1명
 * 1|홍길동|~~\n
 * 2|~~		\n => 임의로 구분자를 만들어서 처리
 */
public class IO_2 {
	public static void main(String[] args) {
		try {
			FileReader fr = new FileReader("c:\\javaDev\\seoul_location.txt");
			BufferedReader br = new BufferedReader(fr);
			long start = System.currentTimeMillis();
			
			while (true) {
				String msg = br.readLine(); // 한 줄씩 읽어온다
				if (msg == null) {
					break;
				}
				System.out.println(msg);
			}
				
				long end = System.currentTimeMillis();
				
				fr.close();
				br.close();
				System.out.println("걸린시간 : " + (end - start) + "초(MS)");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
