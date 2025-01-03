package com.sist.main;
import java.util.*;
import java.util.List;

import com.sist.dao.*;
import com.sist.vo.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PostMain extends JFrame implements ActionListener{
	JTextField tf;
	JButton jb;
	JTable table;
	DefaultTableModel model;
	
	public PostMain() {
		tf = new JTextField(10);
		jb = new JButton("우편번호 검색");
		
		String[] col = {"우편번호", "주소"};
		String[][] row = new String[0][2];
		model = new DefaultTableModel(row, col);
		
		table = new JTable(model);
		JScrollPane js = new JScrollPane(table);
		
		JPanel p = new JPanel();
		p.add(tf);
		p.add(jb);
		
		add("North", p);
		add("Center", js);
		
		setSize(500, 450);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		jb.addActionListener(this);
		tf.addActionListener(this);
	}
	public static void main(String[] args) {
		new PostMain();
	}
	
	// 우편번호 출력
	public void postFind(String dong) {
		// 1. 테이블에 있는 데이터 지우기
		for (int i = model.getRowCount() - 1; i >= 0; i--) {
			model.removeRow(i);
		}
		
		// 2. 오라클로부터 데이터 읽기
		ZipcodeDAO dao = ZipcodeDAO.newInstance();
		List<ZipcodeVO> list = dao.postFind(dong);
		
		for (ZipcodeVO vo : list) {
			String[] data = {
				vo.getZipcode(),
				vo.getAddress()
			};
			model.addRow(data);
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == jb || e.getSource() == tf) {
			String dong = tf.getText();
			if (dong.trim().length() < 1) {
				tf.requestFocus();
				return;
			}
			ZipcodeDAO dao = ZipcodeDAO.newInstance();
			int count = dao.postFindCount(dong);
			
			if (count == 0) {
				JOptionPane.showMessageDialog(this, "검색 결과가 없습니다.");
				tf.setText("");
				tf.requestFocus();
			} else {
				postFind(dong);
			}
			postFind(dong);
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
