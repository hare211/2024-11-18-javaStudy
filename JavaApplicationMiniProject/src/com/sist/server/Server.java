package com.sist.server;
import java.util.*;

import com.sist.commons.Function;

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
public class Server implements Runnable {
	// 동기화 배열
	Vector<Client> waitVc = new Vector<Client>();
	// 접속을 받는다
	ServerSocket ss;
	// 클라이언트 - 서버를 연결하는 구분자(PORT)
	final int PORT = 3355;
	
	public Server() {
		try {
			// 연결 시 IP, PORT 가 매칭
			// 자동으로 IP 인식
			ss = new ServerSocket(PORT);
			System.out.println("Server Start...");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	@Override
	public void run() { // Server 의 run 메서드
		try {
			while (true) {
				Socket s = ss.accept();
				
				Client client = new Client(s);
				client.start();
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	// 통신 담당 클래스
	//
	class Client extends Thread {
		// Client 의 모든 정보
		String id, name, sex;
		// Client 와 Server 를 연결하는 끝점
		Socket s;
		
		// 송수신
		// 송신
		OutputStream out;
		// 수신
		BufferedReader in;
		
		public Client (Socket s) { // 생성자
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
		// 통신 (Thread 메서드)
		public void run() { // Client 의 run 메서드
			try {
				while (true) {
					// ------------------------------------------------------------
					if (in == null) {
						System.out.println("InputStream is null.");
						return;
					}
					// ------------------------------------------------------------
					
					// 사용자 전송한 메세지를 받는다
					String msg = in.readLine();
					
					// ------------------------------------------------------------
                    if (msg == null || msg.trim().isEmpty()) {
                        System.out.println("Client disconnected");
                        break;
                    }
                    // ------------------------------------------------------------
                    
					System.out.println("Client => " + msg);
					// 100|shim|심청이|여자
					StringTokenizer st = new StringTokenizer(msg, "|");
					int protocol = Integer.parseInt(st.nextToken());
					
					switch (protocol) {
					// 로그인 요청 시
					case Function.LOGIN :
						id = st.nextToken();
						name = st.nextToken();
						sex = st.nextToken();
						
						// 1. 전체적으로 로그인 정보 전송
						messageAll(Function.LOGIN + "|" + id + "|" + name + "|" + sex);
						// 2. 입장메세지 전송
						messageAll(Function.WAITCHAT + "|[알림]" + name + " 님이 입장하셨습니다.");
						// 3. waitVc 에 저장
						waitVc.add(this);
						messageTo(Function.MYLOG + "|" + id); // 메인화면으로 이동
						// 4. 먼저 접속한 사람의 정보 전체를 보낸다
						for (Client client : waitVc) {
							messageTo(Function.LOGIN + "|" + client.id + "|" + client.name + "|" + client.sex);
						}
						// 5. 방 정보 전송
						break;

					}
					closeStreams(); // stream 닫기
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		// 개인별 전송
		public synchronized void messageTo(String msg) { // stream 닫기
			try {
				out.write((msg + "\n").getBytes()); // 서버에서 클라이언트로 msg 전송
			} catch (Exception ex) {
				closeStreams();
				disconnect();
				ex.printStackTrace();
			}
		}
		// 접속자 전체 전송
		public synchronized void messageAll(String msg) { // stream 닫기
			try {
				for (Client client : waitVc) {
					client.messageTo(msg);
				}
			} catch (Exception ex) {
				closeStreams();
				disconnect();
				ex.printStackTrace();
			}
		}
		
		private void closeStreams() {
			try {
				if (in != null) {
					in.close();
					in = null;
				}
				if (out != null) {
					out.close();
					out = null;
				}
				if (s != null) {
					s.close();
					s = null;
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
        private void disconnect() {
            try {
                if (s != null && !s.isClosed()) {
                    s.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

	}
	public static void main(String[] args) {
		// 시작점
		Server server = new Server();
		// 서버 설정 => 서버 구동
		new Thread(server).start(); // 접속 처리 => run()
	}
	

}












