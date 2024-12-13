package com.sist.main;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import com.sist.vo.*;
import com.sist.manager.*;
import java.awt.event.*; // 사용자 입력 

public class MusicFindPanel extends JPanel implements ActionListener{
		JLabel la;
		JButton b1, b2;
		JTable table;
		DefaultTableModel model;
		JTextField tf;
		GenieMusicSystem gms = new GenieMusicSystem();
		public MusicFindPanel() {
			setLayout(null);
			tf = new JTextField();
			la = new JLabel("Top 50", JLabel.CENTER);
			la.setFont(new Font("궁서체", Font.BOLD, 35));
			la.setBounds(10, 15, 760, 50);
			add(la);
			
			tf.setBounds(10, 70, 200, 20);
			add(tf);
			
			String[] col = {"Ranking", "Title", "Artist", "Album"};
			String[][] row = new String[0][4];
			model = new DefaultTableModel(row, col);
			table = new JTable(model);
			JScrollPane js = new JScrollPane(table);
			js.setBounds(10, 105, 760, 450);
			add(js);
			
			tf.addActionListener(this);
			
			b1 = new JButton("Search");
			b1.setBounds(220, 70, 80, 20);
			add(b1);
			
			 
//			JPanel p = new JPanel();
//			b1 = new JButton("Prev");
//			b2 = new JButton("Next");
//			p.add(b1);
//			p.add(b2);
/*
 * Event
 * 	버튼 / 텍스트 엔터 / 메뉴 actionPerformed
 * 마우스
 * 	mouseClicked, mouseReleased, mousePressed
 * 	mouse
 */
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == tf) { // 엔터
				// 입력된 데이터 읽기
				String fd = tf.getText();
				if (fd.trim().length() < 1) { // 입력이 안된 상태
					JOptionPane.showMessageDialog(this, "검색어를 입력하세요");
					tf.requestFocus();
					return;
				}
				musicFind(fd);
			}
		}
		
		public void musicFind(String fd) {
			for (int i = model.getRowCount() - 1; i >= 0; i--) {
				model.removeRow(i);
			}
			MusicVO[] music = gms.musicFindData(fd);
			for (MusicVO vo : music) {
				String[] data = {
						String.valueOf(vo.getNo()),
						vo.getTitle(),
						vo.getSinger(),
						vo.getAlbum()
				};
				model.addRow(data);
			}
		}
}
