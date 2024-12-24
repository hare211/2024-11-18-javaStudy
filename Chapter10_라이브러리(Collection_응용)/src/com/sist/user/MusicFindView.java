package com.sist.user;
import java.util.*;
import java.util.List;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.net.URL;

import com.sist.vo.*;
import com.sist.*;
import com.sist.dao.MusicDAO;
// return selectList(sql) -> 아래 코드들이 다 들어있음
public class MusicFindView extends JFrame {
	JTextField tf; // 입력창
	JButton jb; // 검색 버튼
	JTable table;
	DefaultTableModel model;
	// 초기화
	public MusicFindView() {
		tf = new JTextField(10);
		jb = new JButton("검색");
		String[] col = {"순위", "", "곡명", "가수명", "앨범"};
		Object[][] row = new Object[0][5];
		
		model = new DefaultTableModel(row, col) {

			// 편집 방지
			@Override
			public boolean isCellEditable(int row, int column) {
				
				return false;
			}
			
			// 이미지 출력
			@Override
			public Class<?> getColumnClass(int columnIndex) {
				
				return getValueAt(0, columnIndex).getClass();
			}
			// 익명 클래스 => 메서드 재정의(오버라이딩)
			// 내부 클래스의 대표적인 클래스
			// 상속 없이 오버라이딩 가능
		};
		table = new JTable(model);
		JScrollPane js = new JScrollPane(table);
		
		JPanel p = new JPanel();
		
		p.add(tf);
		p.add(jb);
		add("North", p);
		add("Center", js);
		
		table.setRowHeight(40);
		// 데이터 처리
		MusicDAO dao = MusicDAO.newInstance();
		List<MusicVO> list = dao.musicFindData("그");
		
		for (MusicVO vo : list) {
			try {
				String s ="http:" + vo.getPoster();
				URL url = new URL(s);
				Image img = Commons.getImage(new ImageIcon(url), 30, 30);
				
				Object[] data = {
						vo.getMno(),
						new ImageIcon(img),
						vo.getTitle(),
						vo.getSinger(),
						vo.getAlbum()
				};
				model.addRow(data);
				
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		
		setSize(640, 600);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
	}
	public static void main(String[] args) {
		new MusicFindView();
	}
}
















