package com.sist.main;

import javax.swing.*;
/*
 * Container
 * 	= JFrame
 * 	= JDialog
 * 	= JWindow
 * 	= JPanel
 * 	
 */
public class MusicUserMain extends JFrame{
	JTabbedPane tp;
	MusicListPanel mlp = new MusicListPanel();
	MusicFindPanel mfp = new MusicFindPanel();
	MusicDetailPanel mdp = new MusicDetailPanel();
	
	public MusicUserMain() {
		tp = new JTabbedPane();
		tp.addTab("Music List", mlp);
		tp.addTab("Music Find", mfp);
		tp.addTab("Music Detail", mdp);
		tp.setTabPlacement(JTabbedPane.TOP); // LEFT, RIGHT, TOP(default), BOTTOM
		// 윈도우에 추가
		add("Center", tp);
		// 크기
		setSize(800, 600);
		setVisible(true);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		// 생성자 호출
		new MusicUserMain();
	}
}
