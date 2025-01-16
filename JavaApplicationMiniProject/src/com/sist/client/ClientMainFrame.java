
package com.sist.client;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import com.sist.vo.*;
import com.sist.commons.Function;
import com.sist.dao.*;
import java.io.*;
import java.util.*;
import java.net.*;
//	 						상속 => 재사용 => 변경

public class ClientMainFrame extends JFrame implements ActionListener, Runnable {
	// 네트워크 통신
	Socket s; // 연걸점
	OutputStream out; // 보내는 통로
	BufferedReader in; // 들어오는 통로
	
	MenuForm mf = new MenuForm(); // 포함 클래스 => 있는 그대로 사용
	ControlPanel cp = new ControlPanel();
	Login login = new Login();
	// 배치
	// 데이터베이스
	MemberDAO mDao = MemberDAO.newInstance();
	public ClientMainFrame() {
		
		setLayout(null); // null => 사용자 정의 => 직접 배치
		mf.setBounds(70, 15, 1450, 45);
		add(mf);
		cp.setBounds(30, 70, 1530, 780);
		add(cp);
		setSize(1600, 900);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// 등록
		// 로그인
		login.b1.addActionListener(this); // 로그인
		login.b2.addActionListener(this); // 취소
		
	}
	
	public static void main(String[] args) {
		// screenshots, server computer, port 0 ~ 65535 (0 ~ 1023 사용 중) 4000 / 8080 / 1521
		// HiFiLookAndFeel, 3500,
		try {
			UIManager.setLookAndFeel("com.jtattoo.plaf.hifi.HiFiLookAndFeel");
		} catch (Exception ex) {
			
		}
		new ClientMainFrame();
	}

	// 서버에서 응답 받기(쓰레드)
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			while (true) {
				String msg = in.readLine(); // 서버에서 보낸 값을 받는다
				if (msg == null) {
					break;
				}
				StringTokenizer st = new StringTokenizer(msg, "|");
				int protocol = Integer.parseInt(st.nextToken());
				
				switch (protocol) {
				case Function.LOGIN :
					
					break;
				case Function.MYLOG :
					String id = st.nextToken();
					setTitle(id);
					login.setVisible(false);
					setVisible(true);
					break;
				case Function.WAITCHAT :
				
					break;
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	// 서버에 요청(로그인, 채팅 보내기)
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == login.b2) {
			dispose(); // 윈도우 메모리 해제
			System.exit(0); // 프로그램 종료
		} else if (e.getSource() == login.b1) {
			String id = login.tf.getText();
			if (id.trim().isEmpty()) {
				JOptionPane.showMessageDialog(this, "아이디를 입력하세요");
				login.tf.requestFocus();
				return;
			}
			String pwd = String.valueOf(login.pf.getPassword());
			if (pwd.trim().isEmpty()) {
				JOptionPane.showMessageDialog(this, "비밀번호를 입력하세요");
				login.pf.requestFocus();
				return;
			}
			// 로그인 검색
			MemberVO vo = mDao.isLogin(id, pwd);
			if (vo.getMsg().equals("NOID")) {
				JOptionPane.showMessageDialog(this, "아이디가 존재하지 않습니다");
				login.tf.setText("");
				login.pf.setText("");
				login.tf.requestFocus();
			} else if (vo.getMsg().equals("NOPWD")) {
				JOptionPane.showMessageDialog(this, "비밀번호가 틀립니다");
				login.pf.setText("");
				login.pf.requestFocus();				
			} else {
				// 서버 연결
				connection(vo);
//				JOptionPane.showMessageDialog(this, "로그인 되었습니다\n서버로 연결합니다");
//				login.setVisible(false);
//				setVisible(true);
			}
		}
	}
	// 서버 연결
	public void connection(MemberVO vo) {
		try {
			// 서버와 연결
			s = new Socket("localhost", 3355);
			// 서버로 전송
			out = s.getOutputStream();
			// 서버로 부터 값 받기
			in = new BufferedReader(new InputStreamReader(s.getInputStream()));
			
			// 서버로 로그인 요청
			out.write((Function.LOGIN + "|" 
						+ vo.getId() + "|" 
						+ vo.getName() + "|" 
						+ vo.getSex() + "\n").getBytes());
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		// 서버로부터 값을 받아서 출력
		new Thread(this).start(); // run 메서드 호출
	}
}
