package com.sist.client;
import java.util.*;
import java.net.*;
import java.awt.CardLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import javax.swing.*;
import com.sist.commons.*;
import java.awt.*;
// 마우스 / 버튼 / 엔터 => 서버로 전송
// 서버에서 전송하는 값 읽기 => 자동화 처리 => 쓰레드

public class ChatMain extends JFrame implements ActionListener, Runnable {
	Login login = new Login();
	WaitRoom wr = new WaitRoom();
	CardLayout card = new CardLayout(); // 화면을 숨긴 뒤 보여준다
	// <jsp:include>
	// 네트워크 관련 클래스
	Socket s;
	OutputStream out;
	BufferedReader in;
	// 본인 여부 확인
	String myId;
	public ChatMain() {
		setLayout(card);
		add("LOG", login);
		add("WR", wr);
		
		setSize(800, 600);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		login.b1.addActionListener(this);
		login.b2.addActionListener(this);
	}
	// 서버 => 수신 => 화면 출력
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			while (true) {
				String msg = in.readLine();
				StringTokenizer st = new StringTokenizer(msg, "|");
				int protocol = Integer.parseInt(st.nextToken());
				
				switch (protocol) {
				case Function.LOGIN:
					String[] data = {
							st.nextToken(),
							st.nextToken(),
							st.nextToken(),
							st.nextToken()
					};
					wr.model2.addRow(data);
					break;
				case Function.MYLOG:
					card.show(getContentPane(), "WR");
					myId = st.nextToken();
					setTitle(myId);
					break;
				case Function.WAITCHAT:
					wr.ta.append(st.nextToken() + "\n");
					break;
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	// 서버로 요청 값 전송
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == login.b2) {
			dispose(); // 윈도우 메모리 해제
			System.exit(0); // 프로그램 종료
			// React-Query => TanStack-Query
		} else if (e.getSource() == login.b1) {
			// 1. 입력값 읽기
			String id = login.tf1.getText();
			if (id.trim().length() < 1) { // 텍스트가 공백일 때
				JOptionPane.showMessageDialog(this, "아이디를 입력하세요.");
				login.tf1.requestFocus();
				return;
			}
			String name = login.tf2.getText();
			if (name.trim().length() < 1) { // 텍스트가 공백일 때
				JOptionPane.showMessageDialog(this, "이름을 입력하세요.");
				login.tf2.requestFocus();
				return;
			}
			
			String sex = "남자";
			if (login.rb1.isSelected()) { // rb1 -> 남자 버튼
				sex = "남자";
			} else {
				sex = "여자";
			}
			// 서버와 연결
			connection(id, name, sex);
		}
	}
	public void connection(String id, String name, String sex) {
		try {
			s = new Socket("localhost", 3050);
			// 서버 정보
			out = s.getOutputStream();
			in = new BufferedReader(new InputStreamReader(s.getInputStream()));
			// login 요청
			out.write((Function.LOGIN + "|" + id + "|" + name + "|" + sex + "\n").getBytes());
			// ObjectOutputStream
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		// 서버와 통신 요청
		new Thread(this).start();
	}

	public static void main(String[] args) {
		new ChatMain();
	}

}
