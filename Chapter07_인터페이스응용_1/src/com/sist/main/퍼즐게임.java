package com.sist.main;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
/*
 * ActionListener : 버튼 / enter / Menu
 * 	=> actionPerformed
 * MouseListener / MouseMotionListener
 * KeyListener
 * 
 * 인터페이스 : 처리하는 기능이 여러 개 있다
 * 			-----------------------
 * 			| 메서드는 선언 => 프로그램에 맞게 구현하여 사용
 * 			| 단점 => 선언된 메서드가 많은 경우
 * 					| 선택적으로 사용할 수 없다
 * 					| 메서드는 {} 구현 완료
 * 			| 가급적이면 구현해서 전송
 * 						------- 선택적으로 처리가 가능
 * 						------- default
 */
public class 퍼즐게임 extends JFrame implements ActionListener {
	
	JButton[] btns = new JButton[9];
	JLabel la = new JLabel("퍼즐게임", JLabel.CENTER);
	JButton b1, b2;
	int[] panCount = new int[9];
	int last = 0; // 빈칸
	
	// 초기화
	public 퍼즐게임() {
		b1 = new JButton("시작");
		b2 = new JButton("종료");
		
		JPanel p = new JPanel(); // 컴퍼넌트 여러 개를 묶어서 배치
		JPanel pan = new JPanel();
		pan.setLayout(new GridLayout(3, 3, 5, 5));
		for (int i = 0; i < 9; i++) {
			btns[i] = new JButton(String.valueOf(i + 1));
			btns[i].setFont(new Font("궁서체", Font.BOLD, 45));
			pan.add(btns[i]);
			btns[i].addActionListener(this);
		}
		setLayout(null);
		
		pan.setBounds(10, 15, 350, 350);
		add(pan);
		
		p.setBounds(10, 370, 350, 35);
		p.add(b1); p.add(b2);
		add(p);
		
		setSize(400, 470);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		// 등록
		b1.addActionListener(this); // this -> actionPerformed 호출 / 자신을 호출
		b2.addActionListener(this);
	}
	// 버튼 처리하는 메서드 => 개발자가 구현 => 자동 호출
	@Override
	public void actionPerformed(ActionEvent e) {
		for (int i = 0; i < 9; i++) {
			if (e.getSource() == btns[last]) {
				return;
			}
			if (e.getSource() == btns[i]) {
				panCount[i] = 8;
				
				panCount[last] = Integer.parseInt(btns[i].getText()) - 1;
				last = i;
				
				if (isEnd()) {
					JOptionPane.showMessageDialog(this, "Game Over");
					
				}
				puzzleLayout();
			}
		}
		if (e.getSource() == b2) {
			System.exit(0); // 프로그램 종료
		} else if (e.getSource() == b1) {
			getRand();
			puzzleLayout();
		}
	}
	
	// 사용자 정의 메서드
	public void getRand() {
		for (int i = 0; i < 9; i++) {
			panCount[i] = (int) (Math.random() * 9);
			for (int j = 0; j < i; j++) {
				if (panCount[i] == panCount[j]) {
					i--;
					break;
				}
			}
		}
		for (int i = 0; i < 9; i++) {
			if (panCount[i] == 8) {
				last = i;
				break;
			}
		}
	}
	
	// 배치
	public void puzzleLayout() {
		for (int i = 0; i < 9; i++) {
			if (last == i) {
				btns[i].setText("");
			} else {
				btns[i].setText(String.valueOf(panCount[i] + 1));
			}
		}
	}
	public boolean isEnd() {
		for (int i = 0; i < 9; i++) {
			if (panCount[i] != i) {
				return false;
			} 
		}
		return true;
	}
	public static void main(String[] args) {
		new 퍼즐게임();
	}
}