package com.sist.client;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.*;
public class ControlPanel extends JPanel{
	Image back;
	JLabel la1, la2;
	JTextField tf; // ID 라벨
	JPasswordField pf; // PW 라벨 => * 로
	JButton bl, bl2;
	public ControlPanel() {
		back = Toolkit.getDefaultToolkit().getImage("c:\\javaDev\\background.jpeg");
		
	}
	// 오버라이딩
	@Override
	public void paintComponent(Graphics g) {
		g.drawImage(back, 0, 0, getWidth(), getHeight(), this);
	}
	

}
