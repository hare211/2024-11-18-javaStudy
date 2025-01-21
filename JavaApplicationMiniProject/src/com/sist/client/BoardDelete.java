package com.sist.client;

import java.awt.Font;
import java.util.*;
import javax.swing.*;

import com.sist.dao.ReplyBoardDAO;

import java.awt.event.*;

public class BoardDelete extends JPanel implements ActionListener {
	JLabel titleLa, la, noLa;
	JPasswordField pf;
	JButton b1, b2;
	ControlPanel cp;
	public BoardDelete (ControlPanel cp) {
		this.cp = cp;
		
   	 	titleLa = new JLabel("삭제하기", JLabel.CENTER);// <table>
   	 	titleLa.setFont(new Font("맑은 고딕", Font.BOLD,30)); //<h3></h3>
 	 	setLayout(null);
 	 	titleLa.setBounds(10, 15, 620, 50);
	 	add(titleLa);
	 	
    	noLa = new JLabel();
    	noLa.setBounds(470, 75, 50, 30);
    	add(noLa);
    	noLa.setVisible(false);
	 	
	 	la = new JLabel("비밀번호");
	 	pf = new JPasswordField();
	 	b1 = new JButton("삭제");
	 	b2 = new JButton("취소");
	 	
	 	// 배치
	 	la.setBounds(235, 75, 80, 30);
	 	pf.setBounds(315, 75, 150, 30);
	 	
	 	JPanel p = new JPanel();
	 	p.add(b1);
	 	p.add(b2);
	 	p.setBounds(230, 115, 235, 35);
	 	add(p);
	 	add(la);
	 	add(pf);
	 	
	 	b1.addActionListener(this); // 삭제
	 	b2.addActionListener(this); // 취소
	 	
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == b1) { // 삭제
			String pwd = String.valueOf(pf.getPassword());
			if (pwd.isEmpty()) {
				pf.requestFocus();
				return;
			}
			String no = noLa.getText();
			
			// db 연동
			ReplyBoardDAO dao = ReplyBoardDAO.newInstance();
			boolean bCheck = dao.replyDelete(Integer.parseInt(no), pwd);
			
			if (bCheck == true) {
				// 화면 이동
				cp.card.show(cp, "BLIST");
				// 삭제 후 글 목록으로 이동
				cp.bList.print();
			} else {
				JOptionPane.showMessageDialog(this, "비밀번호가 틀립니다\n다시 입력하세요");
				pf.setText("");
				pf.requestFocus();
			}
		} else if (e.getSource() == b2) { // 취소 
			cp.card.show(cp, "BDETAIL");
		}
	}

}
