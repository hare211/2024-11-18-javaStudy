package com.sist.main;

import java.awt.Color;
import java.awt.Font;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import com.sist.vo.*;
import com.sist.manager.*;
import java.awt.event.*;
/*
 * 		<table border=1>
 * 		 <tr>
 * 		  <th>순위</th>
 * 		  <th>곡명</th>
 * 		  <th>가수명</th>
 * 		  <th>앨범</th>
 * 		 </tr>
 * 		</table border>?
 */		 
public class MusicListPanel extends JPanel implements ActionListener {
	JLabel la;
	JButton b1, b2;
	JTable table;
	DefaultTableModel model;
	GenieMusicSystem gms = new GenieMusicSystem();
	MelonMusicSystem mms = new MelonMusicSystem();
	public MusicListPanel() {
		setLayout(null);
		la = new JLabel("Top 50", JLabel.CENTER);
		la.setFont(new Font("궁서체", Font.BOLD, 35));
		la.setBounds(10, 15, 760, 50);
		add(la);
		
		b1 = new JButton("Genie");
		b1.setBounds(10, 40, 72, 20);
		add(b1);
		b2 = new JButton("Melon");
		b2.setBounds(90, 40, 72, 20);
		add(b2);
		
		String[] col = {"Ranking", "Title", "Artist", "Album"};
		String[][] row = new String[0][4];
		model = new DefaultTableModel(row, col);
		table = new JTable(model);
		JScrollPane js = new JScrollPane(table);
		js.setBounds(10, 70, 760, 450);
		add(js);
		
		musicPrint(1);
		
		b1.addActionListener(this);
		b2.addActionListener(this);
//		JPanel p = new JPanel();
//		b1 = new JButton("Prev");
//		b2 = new JButton("Next");
//		p.add(b1);
//		p.add(b2);

	}
	
	public void musicPrint(int type) {
		for (int i = model.getRowCount() - 1; i >= 0; i--) {
			model.removeRow(i);
		}
//		if (type == 1) {
//			gms = new GenieMusicSystem();
//		} else if (type == 2) { // else
//			gms = new MelonMusicSystem();
//		}
		
		
		
		// 추가
		  if(type==1)
		  {
			  gms = new GenieMusicSystem();
			  la.setText("Genie Top 50");
		  }
		  else
		  {
			  gms = new MelonMusicSystem();
			  la.setText("Melon Top 50");
		  }
		// 추가
		
		MusicVO[] musics = gms.musicAllDate();
		for (MusicVO vo : musics) {
			String[] data = {
					String.valueOf(vo.getNo()),
					vo.getTitle(),
					vo.getSinger(),
					vo.getAlbum()
			};
			model.addRow(data);
		};
	}
	// 버튼 처리
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == b1) { // getSource == b1 => b1 버튼 클릭
			musicPrint(1);
		} else if (e.getSource() == b2) {
			musicPrint(2);
		}
		
	}
}













