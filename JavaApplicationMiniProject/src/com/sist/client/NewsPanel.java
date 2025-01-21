package com.sist.client;
import java.util.*;
import java.util.List;

import javax.swing.*;
import javax.swing.border.LineBorder;

import com.sist.manager.NaverNewsSearch;
import com.sist.manager.NewsVO;

import java.awt.*;
import java.awt.event.*;
public class NewsPanel extends JPanel implements ActionListener, MouseListener {
	NewsCard[] cards = new NewsCard[10];
	JTextField tf;
	JButton b;
	JPanel pan;
	JScrollPane pane;
	ControlPanel cp;
	List<NewsVO> list = new ArrayList<NewsVO>();
	public NewsPanel(ControlPanel cp) {
		this.cp =  cp;
		
		tf = new JTextField();
		b = new JButton("검색");
		
		for (int i = 0; i < cards.length; i++) {
			cards[i] = new NewsCard(); // 메모리 할당?
		}
		
		pan = new JPanel();
		pan.setLayout(new GridLayout(10, 1, 5, 5));
		
		setLayout(null);
		
		tf.setBounds(10, 15, 250, 30);
		b.setBounds(265, 15, 100, 30);
		
		add(tf);
		add(b);
		
		pan.setPreferredSize(new Dimension(830, 1200));
		pane = new JScrollPane(pan);
		pane.setPreferredSize(new Dimension(750, 650));
		pane.setBounds(10, 55, 720, 650);
		
		add(pane);
		
		tf.addActionListener(this); // 검색입력창
		b.addActionListener(this); // 검색버튼
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == tf || e.getSource() == b) {
			String fd = tf.getText();
			
			if (fd.trim().isEmpty()) {
				JOptionPane.showMessageDialog(this, "검색어를 입력하세요");
				tf.requestFocus();
				return;
			}
			newsPrint(fd);
		}
	}

	public void newsPrint(String fd) {
		// TODO Auto-generated method stub
		list = NaverNewsSearch.newsSearchData(fd);
		
		int i = 0;
		for (NewsVO vo : list) {
			cards[i].titleLa.setText("<html><body>" + vo.getTitle() + "</body></html>");
			cards[i].contentTp.setText("<html></body>" + vo.getDescription() + "</body></html>");
			cards[i].dateLa.setText(vo.getPubDate());
			pan.add(cards[i]);
			cards[i].titleLa.addMouseListener(this); 
			i++;
		}
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		for (int i = 0; i < cards.length; i++) {
			if (e.getSource() == cards[i].titleLa) {
				try {
					Runtime.getRuntime().exec("C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe " + list.get(i).getLink());
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		}
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		for (int i = 0; i < cards.length; i++) {
			if (e.getSource() == cards[i].titleLa) {
				cards[i].titleLa.setBorder(new LineBorder(Color.green, 5));
			}
		}
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		for (int i = 0; i < cards.length; i++) {
			if (e.getSource() == cards[i].titleLa) {
				cards[i].titleLa.setBorder(new LineBorder(null));
			}
		}
	}
}
