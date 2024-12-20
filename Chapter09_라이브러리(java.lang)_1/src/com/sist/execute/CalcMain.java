package com.sist.execute;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
// 윈도우 계산기
public class CalcMain extends JFrame implements ActionListener {
	// 웹
	// 입력된 값 읽어올 때 String 으로
	// 계산하기 위해 정수형으로
	// 계산된 값을 출력하기 위해 문자열로
	JTextField tf1, tf2, tf3;
	JLabel la;
	JComboBox box;
	JButton b1, b2;
	
	public CalcMain() {
		tf1 = new JTextField(7);
		tf2 = new JTextField(7);
		tf3 = new JTextField(7);
		
		la = new JLabel("=");
		box = new JComboBox();
		box.addItem("+");
		box.addItem("-");
		box.addItem("*");
		box.addItem("/");
		
		b1 = new JButton("계산");
		b2 = new JButton("종료");
		
		setLayout(new FlowLayout()); // -> 한 줄로 출력
		
		add(tf1);
		add(box);
		add(tf2);
		add(la);
		add(tf3);
		add(b1);
		add(b2);
		
		setSize(500, 80);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		// actionPerformed 메서드 호출
		b1.addActionListener(this);
		b2.addActionListener(this);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == b2) {
			System.exit(0);
		} else if (e.getSource() == b1) {
			int n1 = 0;
			int n2 = 0;
			
			try { // 첫 번째 칸에 문자가 입력되면 지우고 커서 고정
				String no1 = tf1.getText();
				n1 = Integer.parseInt(no1);
			} catch (Exception ex) {
				tf1.setText("");
				tf1.requestFocus();
				return;
				
			}
			try { // 두 번째 칸에 문자가 입력되면 지우고 커서 고정
				String no2 = tf2.getText();
				n2 = Integer.parseInt(no2);
			} catch (Exception ex) {
				tf2.setText("");
				tf2.requestFocus();
				return;
			}				// | Object 형이기 때문에 toString()
			String op = box.getSelectedItem().toString();
		}
	}
	public static void main(String[] args) {
		new CalcMain();
	}
}






















