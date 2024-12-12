package com.sist.client;
import java.awt.GridLayout;

import javax.swing.*;
/*
 * BorderLayout => North / South / East / West / Center
 * FlowLayout => 일자(행)
 * GridLayout 
 */
public class MenuForm extends JPanel{ // 목적 : DB 연동 숙련
	public JButton b1 = new JButton("홈");
	public JButton b2 = new JButton("맛집");
	public JButton b3 = new JButton("맛집 검색");
	public JButton b4 = new JButton("맛집 예약");
	public JButton b5 = new JButton("커뮤니티");
	public JButton b6 = new JButton("실시간 채팅");
	public JButton b7 = new JButton("실시간 뉴스");
	
	// 초기화 => 배치
	public MenuForm() {
		// 시작과 동시에 처리해야 하는 => 생성자
		setLayout(new GridLayout(1, 5, 10, 10)); // 1, 5 => 행 열 / 10, 10 => 간격 (좌우, 위아래)
		add(b1); add(b2); add(b3); add(b4); add(b5); add(b6); add(b7);
	}
}
