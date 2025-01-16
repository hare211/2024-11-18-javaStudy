package com.sist.client;
import java.awt.*;
import javax.swing.*;
public class HomePanel extends JPanel {
	ControlPanel cp;
	JPanel pan = new JPanel();
	// 이미지 출력
	JButton b1, b2; // 이전, 다음
	JLabel la = new JLabel("0 page / 0 pages");
	JLabel[] imgs = new JLabel[12];
	
	int curPage = 1;
	int totalPage = 0;
	
	public HomePanel(ControlPanel cp) {
		this.cp = cp;
	}
	
}
