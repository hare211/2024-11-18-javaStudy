package com.sist.client;
import java.util.*;
import javax.swing.*;
import java.awt.*;

public class NewsCard extends JPanel {
	JLabel titleLa; // 제목
	JTextPane contentTp;
	JLabel dateLa; 
	
	public NewsCard() {
		setLayout(null);
		titleLa = new JLabel("");
		
		contentTp = new JTextPane();
		JScrollPane js = new JScrollPane(contentTp);
		
		contentTp.setEditable(false); // 내용 출력이기 때문에 편집 불가
		contentTp.setContentType("text/html"); // html 출력 가능
		
		dateLa = new JLabel("");

		titleLa.setBounds(10, 10, 450, 35); // 제목
		js.setBounds(10, 50, 750, 100); // 내용
		dateLa.setBounds(470, 10, 200, 35); // 날짜(시간)
		
		add(titleLa);
		add(js);
		add(dateLa);
	}
}
