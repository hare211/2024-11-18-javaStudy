package com.sist.main;
import javax.swing.*;
import java.awt.*;
import javax.swing.table.*;

public class EmpFindPanel extends JPanel {
	JTable table;
	DefaultTableModel model;
	JComboBox box = new JComboBox();
	JTextField tf = new JTextField(10);
	JButton b = new JButton("검색");
	
	public EmpFindPanel() {
		setLayout(new BorderLayout());
		box.addItem("ename");
		box.addItem("hiredate");
		box.addItem("dname");
		box.addItem("loc"); // 컬럼명
		
		JPanel p = new JPanel();
		p.add(box);
		p.add(tf);
		p.add(b);
		add("North", p);

		
		String[] col = {"사번", "이름", "직위", "입사일", "부서명", "근무지"}; 
		String[][] row = new String[0][6];
		model = new DefaultTableModel(row, col) {
			@Override
			public boolean isCellEditable(int row, int column) {
				// TODO Auto-generated method stub
				return false;
			}
		};
		table = new JTable(model);
		table.setRowHeight(30);
		JScrollPane js = new JScrollPane(table);
		add("Center", js);
	}
	
	
}
