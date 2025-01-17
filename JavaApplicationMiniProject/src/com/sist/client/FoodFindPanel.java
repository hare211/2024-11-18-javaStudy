package com.sist.client;
import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
import java.net.URL;
import java.util.List;

import com.sist.vo.*;
import com.sist.commons.ImageChange;
import com.sist.dao.*;

public class FoodFindPanel extends JPanel implements ActionListener {
	ControlPanel cp;
	JTable table;
	DefaultTableModel model;
	
	JTextField tf;
	JButton b;
	TableColumn column;
	FoodDAO dao = FoodDAO.newInstance();
	
	public FoodFindPanel(ControlPanel cp) {
		this.cp = cp;
		String[] col = {
				"번호", "", "업체명", "주소", "음식종류", "평점"
		};
		Object[][] row = new Object[0][6];
		model = new DefaultTableModel(row, col) {

			@Override
			public boolean isCellEditable(int row, int column) {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public Class<?> getColumnClass(int columnIndex) {
				// TODO Auto-generated method stub
				return getValueAt(0, columnIndex).getClass();
			}
			
			
		};
		table = new JTable(model);
		table.setRowHeight(40);
		JScrollPane js1 = new JScrollPane(table);
		
		for (int i = 0; i < col.length; i++) {
			column = table.getColumnModel().getColumn(i);
			if (i == 0) {
				column.setPreferredWidth(80);
			} else if (i == 1) {
				column.setPreferredWidth(100);
			} else if (i == 2) {
				column.setPreferredWidth(180);
			} else if (i == 3) {
				column.setPreferredWidth(350);
			} else if (i == 41) {
				column.setPreferredWidth(160);
			} else if (i == 5) {
				column.setPreferredWidth(80);
			}
		}
		
		b = new JButton("검색");
		tf = new JTextField();
		
		setLayout(null);
		
		tf.setBounds(20, 20, 200, 30);
		b.setBounds(225, 20, 80, 30);
		js1.setBounds(20, 60, 800, 500);
		add(tf);
		add(b);
		add(js1);
		
		b.addActionListener(this);
		tf.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == b || e.getSource() == tf) {
			String address = tf.getText();
			if (address.trim().isEmpty()) {
				tf.requestFocus();
				return;
			}
			print(address);
		}
	}
	public void print(String address) {
		for (int i = model.getRowCount() - 1; i >= 0; i--) {
			model.removeRow(i);
		}
		List<FoodVO> list = dao.foodFindData(address);
		for (FoodVO vo : list) {
			try {
				URL url = new URL(vo.getPoster());
				Image image = ImageChange.getImage(new ImageIcon(url), 30, 30);
				Object[] data = {
						vo.getFno(), 
						new ImageIcon(image),
						vo.getName(),
						vo.getAddress(),
						vo.getType(),
						vo.getScore()
				};
				model.addRow(data);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		
	}
	
	
}
