package com.sist.client;
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.*;
import com.sist.commons.*;
public class ClientChatMain extends JFrame implements ActionListener, Runnable {
	JButton b1, b2;
	JTextArea ta; // 채팅창
	JTextField tf; // 채팅 입력창
	private String name; // 누가 보냈는 지 알 수없으니 이름 선언
	// 서버 연결 => 네트워크 관련
	Socket s; // 전화기 / Server 에 있는 소켓과 동일해야함
	// 단방향
	OutputStream out; // 서버에서 들어오는 값은 자동화 / 실시간 채팅 -> 자동화 처리
	BufferedReader in;
	// 쓰레드를 통해서 자동화 처리, BufferedReader 처리
	// 레이아웃
	public ClientChatMain() {
		b1 = new JButton("접속");
		b2 = new JButton("종료");
		
		tf = new JTextField(25); // 채팅 입력창
		tf.setEnabled(false);
		ta = new JTextArea(); // 채팅창
		ta.setEditable(false);
		JScrollPane js = new JScrollPane(ta);
		
		JPanel p = new JPanel();
		p.add(tf);
		p.add(b1);
		p.add(b2);
		
		add("Center", js);
		add("South", p);
		setSize(450, 400);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		b1.addActionListener(this); // 접속
		b2.addActionListener(this); // 종료
		tf.addActionListener(this); // 채팅 입력창
	}
	
	// 서버에서 들어오는 값 처리
	@Override
	public void run() {
		try {
			while (true) {
				String msg = in.readLine();
				// 서버에서 전송한 값
				ta.append(msg + "\n");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	// 버튼 클릭 시 처리
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == b2) { // 종료
			System.exit(0);
		} else if (e.getSource() == b1) {
			name = JOptionPane.showInputDialog("이름 입력 : "); // 이름이 없으면 아래 try 문 실행 X, 무조건 입력한다고 가정
			
			try {
				// 전화 => 서버 연결
				s = new Socket("192.168.10.107", 3050);
				// 송수신
				out = s.getOutputStream(); // 서버에 값을 보내겠다
				in = new BufferedReader(new InputStreamReader(s.getInputStream())); // 서버에서 보내준 값을 받는다(서버에 보내줄 때 byte 단위로 
				//																		보냈기 때문에 받을 때는 2 byte 로 전환해서 받는다)
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			tf.setEditable(true); // 접속 시 입력창 활성화
			b1.setEnabled(false); // 접속은 한 번만 -> 접속 시 접속 버튼 비활성화
			// 서버에서 들어오는 값을 받는다
			new Thread(this).start(); // run() 호출
		} else if (e.getSource() == tf) { // 채팅 입력창에 문자 입력하고 엔터
			String msg = tf.getText();
			if (msg.trim().length() < 1) { // 입력이 안 됐을 때
				tf.requestFocus();
				return;
			}
			try {
				out.write(("[" + name + "]" + msg + "\n").getBytes());
				return;
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		new ClientChatMain();
	}
}
