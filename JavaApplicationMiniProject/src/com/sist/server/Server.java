package com.sist.server;
import java.util.*;
import java.net.*;
import java.io.*;
/*
 * 서버
 * 	=> 접속 담당
 * 		=> 접속한 클라이언트의 정보 저장
 * 	=> 통신 담당 : 각 클라이언트 당 따로 통신
 * 	   ------ 쓰레드 이용
 * 	   => 저장된 클라이언트의 정보 이용
 * 	   => 내부 클래스
 * 
 * class Server {
 * 		Vector waitVc;
 * 		
 * 		class Client extends Thread {
 * 				// 클래스 간 공유가 많다(변수, 메서드)
 * 				// 내부 클래스를 이용한다
 * 		}
 */
public class Server {
	class Client extends Thread {
		// Client 의 모든 정보
		String id, name, sex;
		// Client 와의 연결
		Socket s;
		
		// 송수신
		// 송신
		OutputStream out;
		// 수신
		BufferedReader in;
		
		public Client (Socket s) {
			try {
				// 클라이언트 컴퓨터 메모리
				this.s = s;
				// 서버 -> 클라이언트
				out = s.getOutputStream();
				// 클라이언트 -> 서버
				in = new BufferedReader(new InputStreamReader(s.getInputStream()));
				
				// Encoding : 보낼 때, Decoding : 받을 때(UTF - 8)
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		// 통신
		// 개인별 전송
		// 접속자 전체 전송
	}
	public static void main(String[] args) {
		
	}
}












