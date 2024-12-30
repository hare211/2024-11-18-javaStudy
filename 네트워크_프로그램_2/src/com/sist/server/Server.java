package com.sist.server;
import java.io.*;
import java.net.*;
import java.util.*;
import com.sist.commons.*;
/*
 * class Server {
 * 	Vector waitVc = new Vector()
 * 	=> 접속자 저장 공간(IP)
 * 	class Client extends Thread {
 * 		접속자마다 따로 통신만 담당
 * 				-------- Thread
 * 						 ------
 * 						 | 접속된 사람들과 통신
 * 		멤버 클래스를 이용한다
 * 	}
 * }
 * 서버 안에 내부 클래스, Client 를 선언하는 이유
 * class Server {
 * 		Vector w = new Vector()
 * 
 * 		=> new Server()
 * }
 * class Client {
 * 		Server server = new Server() 
 * 		server.w
 * 
 * }
 * => port 가 같아서 사용할 수 없다(server 두 번 실행)
 * Vector 를 static 으로 선언하거나 Client 를 내부 클래스로 선언한다 
 */
// 접속 시에 처리 => 교환 소켓 / 대기 소켓
public class Server {
	private Vector<Client> waitVc = new Vector<Client>(); // Server.Client 외부에서 가져올 때는 Server.Client 로 써야한다
	// 1. 저장 공간(접속자) => 동기화
	/*
	 * Vector => 네트워크(요즘엔 자바로 구축하지 않아 사라지고 있다)
	 * ArrayList => 데이터베이스
	 * LinkedList => 추가 / 수정 / 삭제 가 많은 곳
	 */
	// 2. 서버 가동
	private ServerSocket ss;
	// 3. 접속 시 => 연결 라인 => PORT
	private final int PORT = 3050;
	// 4. 서버 가동 => ServerSocket 초기화
	public Server() {
		try {
			ss = new ServerSocket(PORT);
			// bind => 개통(유심)
			// listen() => 대기
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	// 5. 접속 시 처리 = 사용자 정보를 받아서 Client 클래스로 전송
	// 통신이 가능하게 만든다
	public static void main(String[] args) {
		
	}
	// 클라이언트마다 통신을 담당
	// Server 가 가지고 있는 모든 자원(변수, 메서드)을 사용할 수 있다
	// => 쓰레드는 데이터가 없고 데이터 공유 할 때 쓴다
	/*
	 * 내부 클래스 호출 방법 => Server.Client
	 * 한 개의 프로그램 안에서 여러 개의 프로그램을 동시에 실행 -> 쓰레드를 통해서
	 * -----------		 ---------------
	 * 	프로세스				쓰레드
	 */
	class Client extends Thread {
		Socket s; // 클라이언트의 IP
		OutputStream out; // 송신
		BufferedReader in; // 수신 => 한글이 포함 => 2 byte 로 받아오기 때문에 Reader 로 처리
		
		String id, name, sex, pos;
		// DB => id 중복체크 => 중복 없이 => PRIMARY KEY
		public Client (Socket s) {
			try {
				/*
				 * 서버 => 클라이언트 IP
				 * 클라이언트 => 서버 IP
				 * 
				 * => readLine() <=> write() 주고 받아서 처리한다
				 * => write() <=> readLine() // readLine() 통해서 받는다
				 */
				this.s = s;
				// s -> 클라이언트 정보
				out = s.getOutputStream();
				// 클라이언트로 전송
				in = new BufferedReader(new InputStreamReader(s.getInputStream())); // InputSream 을 Reader 로 변환
				// 클라이언트로부터 값을 수신
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			/*
			 * 자바 프로그램에서 가장 쉬운 프로그램
			 * 					---------- 패턴의 개수
			 * => 네트워크
			 * => 데이터베이스
			 */
		}
	}
}
