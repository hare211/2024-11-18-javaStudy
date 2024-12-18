package com.sist.music;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
// ActionListener => actionPerformed()
/*
 * extends -> 상속 : 클래스가 가지고 있는 모든 변수 / 메서드를 가지고 온다
 * 			------- 생성자, static, 초기화 블럭 => 예외
 * 객체지향
 * 	1. 캡슐화 : 데이터 보호 => 사용자 정의 데이터형
 * 		=> 메서드를 이용하여 변수의 기능 설정
 * 						----
 * 						읽기 => getter -> getXxx()
 * 						쓰기(저장, 수정) => setter -> setXxx
 * 		=> 데이터 손실 / 변경을 방지
 * 	2. 상속 : 기존의 클래스 재사용
 * 			----------- 라이브러리 클래스
 * 			----------- 기능 변경 후 사용
 * 	3. 변경 / 추가 => 다형성
 * 		오버로딩 -> 기능 추가
 * 		오버라이딩 -> 재정의, 변경
 * 			오버로딩		오버라이딩
 * 상태		자신의 클래스	상속
 * 메서드명	동일			동일
 * 매개변수	개수 다름		동일
 * 			데이터형 다름	
 * 리턴형		관계 X		동일
 * 접근제어자	관계 X		확장 O, 축소 X
 * 기능		새로운기능추가	재정의
 * ------------------------------------------------
 * 			추상 클래스			인터페이스
 * 형식		abstract class		public interface
 * 멤버변수	일반 멤버변수			상수
 * 상속		단일 상속				다중 상속
 * 메서드		구현된 메서드			구현 안된 메서드
 * 			구현 안된 메서드		구현된 메서드
 * 			-> 추상메서드			-> default, static
 * 
 * 역할 관련된 클래스를 모아서 한 개의 객체명으로 관리
 * 		같은 클래스 여러 개 (배열) -> ArrayList
 * 		다른 클래스 여러 개 (인터페이스)
 * 								
 * 			
 */
public class MusicMainWindow extends JFrame implements ActionListener{
	String[] names = {
			"TOP 50",
			"가요",
			"POP",
			"OST",
			"트롯",
			"JAZZ",
			"CLASSIC"};
	JButton[] btns = new JButton[7];
	JTable table;
	DefaultTableModel model;
	// 재사용 => 포함 클래스 has-a
	/*
	 * 	클래스 : 다른 클래스 사용 가능 -> public
	 * 	생성자 : 다른 클래스 사용 가능 -> public
	 * 	멤버변수 : 자신 클래스에서만 사용 -> private
	 * 	-> 기본형 / 클래스 / 배열
	 * 			  ----------- 참조변수
	 * 	메서드 : 다른 클래스와 통신 -> public
	 */
	// 초기화
	public MusicMainWindow() {
		JPanel p = new JPanel();
		p.setLayout(new GridLayout(1, 7));
		for (int i = 0; i < btns.length; i++) {
			btns[i] = new JButton(names[i]);
			p.add(btns[i]);
			btns[i].addActionListener(this);
		}
		
		add("North", p);
		
		String[] col = {"곡명", "가수명", "앨범"};
		String[][] row = new String[0][3];
		
		model = new DefaultTableModel(row, col);
		table = new JTable(model);
		JScrollPane js = new JScrollPane(table);
		
		table.setRowHeight(35);
		table.getTableHeader().setBackground(Color.cyan);
		table.setShowVerticalLines(false); // 세로줄 false
		table.setShowHorizontalLines(true);// 가로줄 true
		
		add("Center", js);
		setSize(640, 480);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		display(1);
	}
	// 출력
	public void display(int type) {
		for (int i = model.getRowCount() - 1; i >= 0; i--) {
			model.removeRow(i);
		}
		
		MusicSystem ms = new MusicSystem();
		MusicVO[] music = ms.musicData(type);
		
		for (MusicVO vo : music) {
			String[] data = {
					vo.getTitle() +
					vo.getSinger() +
					vo.getAlbum()};
			model.addRow(data);
		}
	}
	public static void main(String[] args) {
		new MusicMainWindow(); // 생성자 호출
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		for (int i = 0; i < btns.length; i++) {
			if (e.getSource() == btns[i]) {
				display(i + 1);
				break;
			}
		}
	}
}

















