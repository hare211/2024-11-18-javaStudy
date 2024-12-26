package com.sist.io;
/*
 * 
 */
import java.util.*;
import java.io.*;
import java.net.*;
public class IO_7 {
	public static void main(String[] args) {
		/*
		 * 일일 박스오피스
		 * 실시간 예매율
		 */
		String[] strURL = {
				"",
				"searchMainDailyBoxOffice.do", 
				"searchMainRealTicket.do",
				"searchMainDailySeatTicket.do"
		};
		try (Scanner scanner = new Scanner(System.in);
			 
		) {
			System.out.println("==== Menu ====");
			System.out.println("1. 일일 박스 오피스");
			System.out.println("2. 실시간 예매율");
			System.out.println("3. 좌석 점유율");
			System.out.println("==============");
			System.out.print("메뉴 선택 : ");
			int menu = scanner.nextInt();
			
			String path = "https://www.kobis.or.kr/kobis/business/main/";
			// .do => MVC 구조 -> URL 주소를 임의로 변경 가능
			
			path = path + strURL[menu];
			
			URL url = new URL(path);
			HttpURLConnection conn = (HttpURLConnection)url.openConnection(); // 웹에 접속
			
			if (conn != null) { // 접속이 된 경우
				BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
				// 전송 => 1byte, 받은 경우 => 2byte 로 변환 후 출력
				// 한글이 깨진다 -> UTF-8
				// 네트워크의 단점 : 전송 시 1byte
				// => 오라클, 웹
				// => 주소 / PORT
				//	  URL => 8080 => 0 ~ 65535
				while (true) {
					String msg = br.readLine();
					if (msg == null) {
						break;
					}
					System.out.println(msg);
				}
			}
			conn.disconnect();
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
