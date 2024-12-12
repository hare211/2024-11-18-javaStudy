package com.sist.client;

import javax.swing.*;
//	 						상속 => 재사용 => 변경
public class ClientMainFrame extends JFrame{
	MenuForm mf = new MenuForm(); // 포함 클래스 => 있는 그대로 사용
	ControlPanel cp = new ControlPanel();
	// 배치
	public ClientMainFrame() {
		setLayout(null); // null => 사용자 정의 => 직접 배치
		mf.setBounds(70, 15, 1450, 45);
		add(mf);
		cp.setBounds(30, 70, 1530, 780);
		add(cp);
		setSize(1600, 900);
		setVisible(true);
		
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
}
