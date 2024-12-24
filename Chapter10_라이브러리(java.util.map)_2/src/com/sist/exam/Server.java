package com.sist.exam;
import java.util.*;
import java.net.*;

public class Server implements Runnable{
	private Vector<Client> waitVc = new Vector<Client>(); // 서버 -> 동기화 -> ArrayList 는 비동기 -> Vector 필요 
	private ServerSocket ss;
	// 예전 프로그램 => 유지보수(Vector)
	public Server() {
		try {
			ss = new ServerSocket(3355);
			System.out.println("Server Start");
			// bind(ip, port) => listen() => 대기 상태
			// | 개통 -> 전화 대기
		} catch (Exception ex) {
			
		}
	}
	@Override
	public void run() {
		while (true) {
			try {
				Socket s = ss.accept(); // 접속 시
				Client client = new Client(s);
				waitVc.add(client); // 동기화로 되어있어야 함
			} catch (Exception ex) {
				
			}
		}
	}
	
	// 내부 클래스
	class Client extends Thread { // Thread -> 따로 동작 가능
		private Socket s;
		
		public Client(Socket s) {
			this.s = s;
			System.out.println(s.getInetAddress().getAddress()); // ip 호출
			System.out.println(s.getPort()); // 포트 출력
		}
	}
	public static void main(String[] args) {
		Server server = new Server();
		new Thread(server).start();
	}

}
