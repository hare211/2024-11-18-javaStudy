
package com.sist.main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import com.sist.dao.*;
import com.sist.vo.*;
//	 						상속 => 재사용 => 변경
public class ClientMainFrame extends JFrame implements ActionListener {
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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		cp.b1.addActionListener(this); // 로그인 버튼
		cp.b2.addActionListener(this); // 취소 버튼
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
	// JavaScript
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == cp.b2) {
			System.exit(0);
		} else if (e.getSource() == cp.b1) {
			String id = cp.tf.getText();
			if (id.trim().isEmpty()) {
				cp.tf.requestFocus();
				return;
			}
			String pwd = String.valueOf(cp.pf.getPassword());
			// char[] => String 으로 변경
			if (pwd.trim().isEmpty()) {
				cp.pf.requestFocus();
				return;
			}
			MemberDAO dao = MemberDAO.newIntance();
			MemberVO vo = dao.isLogin(id, pwd);
			if (vo.getMsg().equals("NOID")) { // 아이디 X
				JOptionPane.showMessageDialog(this, "아이디가 존재하지 않습니다");
				cp.tf.setText("");
				cp.pf.setText("");
				cp.tf.requestFocus();
			} else if (vo.getMsg().equals("NOPWD")) { // 비밀번호 X
				JOptionPane.showMessageDialog(this, "비밀번호가 틀립니다.");
				cp.pf.setText("");
				cp.pf.requestFocus();
			} else { // 로그인 된 상태
				String msg = vo.getName() + " 님 로그인 되었습니다.\n메인페이지로 이동합니다.";
				JOptionPane.showMessageDialog(this, msg);
			}
		}
	}
}
