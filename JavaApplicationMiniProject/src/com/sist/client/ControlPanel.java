package com.sist.client;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.*;
public class ControlPanel extends JPanel{
	Image back; // 이미지 백그라운드
	JLabel la1, la2;
	JTextField tf; // ID 라벨
	JPasswordField pf; // PW 라벨 => * 로
	JButton b1, b2;
	public ControlPanel() {
		back = Toolkit.getDefaultToolkit().getImage("c:\\javaDev\\background.jpeg"); // 이미지 백그라운드
		la1 = new JLabel("ID");
		la2 = new JLabel("Password");
		tf = new JTextField();
		pf = new JPasswordField();
		b1 = new JButton("로그인");
		b2 = new JButton("취소");
		
		// 배치 => 실행과 동시에 실행 명령 => 초기화 => 생성자
		setLayout(null);
		la1.setBounds(ALLBITS, ABORT, WIDTH, HEIGHT);
		//			  왼쪽 너비 / 위 너비 / 가로 / 세로 
		la1.setBounds(57, 15, 80, 30); // ID 
		tf.setBounds(95,  15, 200, 30); // ID 입력창
		add(la1); add(tf);
		la2.setBounds(10, 50, 80, 30); // Password
		pf.setBounds(95,  50, 200, 30); // Password 입력창
		add(la2); add(pf);
		
		JPanel p = new JPanel();
		p.setOpaque(false); // 로그인, 취소 투명도
		p.add(b1);
		p.add(b2);
		p.setBounds(10, 90, 285, 35);
		add(p);
	}
	// 오버라이딩
	@Override
	public void paintComponent(Graphics g) {
		g.drawImage(back, 0, 0, getWidth(), getHeight(), this);
	}
	

}
