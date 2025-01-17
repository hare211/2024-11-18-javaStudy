package com.sist.client;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

public class MessagePanel extends JPanel {
	ControlPanel cp;
	JLabel titleLabel;
	public MessagePanel(ControlPanel cp) {
		this.cp = cp;
		
		setLayout(new BorderLayout());
		
		titleLabel = new JLabel("쪽지 보내기", SwingConstants.CENTER);
		titleLabel.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		add(titleLabel, BorderLayout.NORTH);
		
		JPanel centerP = new JPanel();
		centerP.setLayout(new BorderLayout());
		
		JTextArea messageArea = new JTextArea();
	}
	
}
