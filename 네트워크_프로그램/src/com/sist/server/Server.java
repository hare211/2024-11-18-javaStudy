package com.sist.server;
import java.util.*; // 데이터가 여러 개 => StringTokenizer
// => 사용자 정보 저장 => Vector(동기화)
import com.sist.commons.*;
import java.io.*; // 송수신
// 전송 => byte 단위 전송, 수신 시 => 2 byte
// 전송 -> OutputStream / 수신 -> BufferedReader
import java.net.*; // 다른 컴퓨터와 연동
// ServerSocker : 접속 담당 / Socket : 클라이언트와 통신
public class Server implements Runnable{
	private ServerSocket ss;
	private final int PORT = 3050; // 조별포트
	// => 1024 ~ 65535
	private Vector<Client> waitVc = new Vector<Client>(); // vector 에 저장해주는 역할 -> ServerSocket
	
	public Server() {
		try {
			ss = new ServerSocket(PORT);
			// bind => IP / PORT 연결 => 유심(핸드폰 개통)
			// listen() => 대기상태
			/*
			 * new ServerSocket(int count, int port);
			 * new ServerSocket(int port);
			 * 접속 인원이 50 명
			 * 
			 * 웹 : 톰캣(50명) XE(50명)
			 *
			 */
			System.out.println("Server Start...");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		// 접속 시 처리 => 접속자 정보를 저장(ip, port -> 접속자 정보)
		// ----- 발신자 IP(전화번호)
	
	}
	public void run() {
		try {
			while (true) {
				Socket s = ss.accept();
				// 접속 시에만 호출 => 발신자의 정보(ip / port) => accept 메서드
				// => Socket(ip / port)
				// => 사용자는 port => 자동으로 설정
				// => 어떤 위치든 상관없다
				Client client = new Client(s); // s -> 한 명하고만 연결이 된다
				// s => port(윈도우마다 다르다)
				// => 통신을 시작하라 명령
				client.start(); // run() 호출
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	public static void main(String[] args) {
		Server server = new Server();
		new Thread(server).start();
	}
	// 클라이언트 정보 => 통신(송수신) => 클라이언트마다 따로 작성
	// 내부 클래스 => 다른 캘래스의 데이터를 공유
	class Client extends Thread {
		// => 한 명만 연결
		Socket s; // ip / port
		OutputStream out; // 송신
		BufferedReader in; // 수신
		
		// 초기화
		public Client(Socket s) {
			try {
				this.s = s;
				out = s.getOutputStream();
				in = new BufferedReader(new InputStreamReader(s.getInputStream()));
				
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		// 통신하는 위치
		public void run() {
			try {
				while (true) {
					//  사용자가 보내준 데이터를 받는다
					String msg = in.readLine();
					// => 보낼 때 \n 으로 종료
					/*
					 * 요청
					 *  1. 접속자 전체
					 *  2. 한 명에게 전송
					 */
					messageAll(msg);
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		// 전체적으로 전송 => 동기화 => 안정성
		public synchronized void messageAll(String msg) {
			try {
				for (Client c : waitVc) {
					c.messageTo(msg); // 한 명에게 보내는 메서드를 for 문을 통해 호출하여 모두에게 보낸다
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		// 한 명에게 전송 => 동기화
		public synchronized void messageTo(String msg) {
			try {
				out.write((msg + "\n").getBytes()); // readLine() 에 \n 가 없음 => "\n" 
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}
}












