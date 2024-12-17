package com.sist.main;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/*
 * 1. 이벤트 처리
 * 	  --------
 * 	  제공하는 메서드 => 구현이 안됨 -> 인터페이스
 * 	  = ActionListener : 버튼, 메뉴 클릭, 엔터...
 * 		=> actionPerfomed() => 구현해서 사용
 * 	  = MouseListener / MouseMotionListener
 * 	  = KeyListener
 * 
 * => 문제 발생
 * 		=> 입력창에서 정수 입력
 * 					------ 예외처리
 */
public class 숫자야구게임 extends JFrame implements ActionListener{
	JTextArea ta; // 힌트 출력창
	JTextField tf; // 텍스트 입력창
	JButton b1, b2; // 난수 발생, 종료 버튼 / null 클래스는 선언 => null
	// => NullPointerException
	// 멤버 변수 사용 => 클래스 전체에서 사용 가능
	int[] com = new int[3];
	int[] user = new int[3];
	
	
	// 초기화 => 생성자 // 또는 인스턴스 초기화 블럭(static 블록은 불가능)
	public 숫자야구게임() {
		// JTextPan(word) JtextArea(메모장)
		ta = new JTextArea();
		JScrollPane js = new JScrollPane(ta); // 스크롤펜(Vertical, horizontal 두 개 모두) 안에 ta 삽입
		ta.setEditable(false); // 편집 방지
		tf = new JTextField(10);
		tf.setEditable(true); // 비활성화
		b1 = new JButton("시작");
		b2 = new JButton("종료");
		
		// 배치
		JPanel p = new JPanel();
		p.add(tf);
		p.add(b1);
		p.add(b2);
		
		add("Center", js);
		add("South", p);
		
		setSize(350, 300);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		// 이벤트 등록
		
		b1.addActionListener(this); // -> actionPerformed
		b2.addActionListener(this); // 자신이 가지고 있는 actionPerformed 호출
		// 마우스 => addMouseListener
		tf.addActionListener(this);
	}
	// 중복 없이 3 자리의 난수 발생
	public void getRand() {
		for (int i = 0; i < com.length; i++) {
			com[i] = (int) (Math.random() * 9) + 1; // 1 ~ 9
			for (int j = 0; j < i; j++) { // 중복 체크
				if (com[i] == com[j]) { // i -> 저장된 값. j -> 발생된 값
					i--;
					break;
				}
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == b2) {
			int sel = JOptionPane.showConfirmDialog(this, "종료하시겠습니까", "종료", JOptionPane.YES_NO_OPTION); // YES_NO -> 상수 -> int
			if (sel == JOptionPane.YES_OPTION) { // YES -> 0, NO -> 1
				System.exit(0); 
			}
		} else if (e.getSource() == b1) {
			getRand(); // 난수 발생
			
			tf.setEnabled(true); // tf 황성화
			tf.requestFocus(); // 키 이벤트를 받을 컴포넌트를 강제로 설정
			
			b1.setEnabled(false); // 중복 실행 방지
		} else if (e.getSource() == tf) {
			try {
				// 입력된 데이터 읽기
				String str = tf.getText(); // 입력한 tf -> str 대입
				int input = Integer.parseInt(str);
				
				user[0] = input / 100;
				user[1] = (input % 100) / 10;
				user[2] = input % 10;
				if (user[0] == user[1] || user[1] == user[2] || user[0] == user[2]) {
					JOptionPane.showMessageDialog(this, "중복된 정수는 사용할 수 없습니다.");
					tf.setText("");
					tf.requestFocus(); // 커서 깜빡임
					return; // 메서드 종료
				}
				if (user[0] == 0 || user[1] == 0 || user[2] == 0) {
					JOptionPane.showMessageDialog(this, "0 은 사용할 수 없습니다.");
					tf.setText("");
					tf.requestFocus(); // 커서 깜빡임
					return; // 메서드 종료
				} 
				
				// 비교
				int s = 0, b = 0;
				for (int i = 0; i < 3; i++) {
					for (int j = 0; j < 3; j++) {
						if (com[i] == user[i]) { // 같은 정수 존재 여부
							if (i == j) { // 같은 자릿수인지
								s++; // 같은 자릿수
							} else {
								b++; // 다른 자릿수
							}
						}
					}
					
					String hint = "Input Number : " + input + ", Result : " + s + " S - " + b + " B\n";
					ta.append(hint);
					
				}
				
			} catch (NumberFormatException ex) {
				JOptionPane.showMessageDialog(this, "세 자리 정수만 입력하세요.");
				tf.setText("");
				tf.requestFocus();
				// 예외 복구
			}
		}
		
	}
	
	public static void main(String[] args) {
		new 숫자야구게임();
	}
}
