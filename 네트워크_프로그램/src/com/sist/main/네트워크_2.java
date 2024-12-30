package com.sist.main;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class 네트워크_2 extends JFrame implements ActionListener{
	JProgressBar[] bar = new JProgressBar[5];
	JButton b1,b2;
	BarThread[] bt = new BarThread[5];
	// 동기화
	static int rank;
	public 네트워크_2() {
		b1=new JButton("시작");
		b2=new JButton("종료");
		
		JPanel p =new JPanel();
		p.setLayout(new GridLayout(5,1,5,5));
		Color[] color= {
				Color.yellow,
				Color.magenta,
				Color.orange,
				Color.pink,
				Color.cyan
		};
		for (int i = 0; i < 5; i++) {
			bar[i]=new JProgressBar();
			bar[i].setBackground(Color.white);
			bar[i].setForeground(color [i]);
			bar[i].setMinimum(0);
			bar[i].setMaximum(100);
			bar[i].setStringPainted(true);
			p.add(bar[i]);
		}
		JPanel p2 = new JPanel();
		p2.add(b1);
		p2.add(b2);
		
		add("Center",p);
		add("South",p2);
		
		setSize(640, 480);
		setVisible(true);
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new 네트워크_2();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==b2) {
			System.exit(0);
		}
		else if(e.getSource()==b1) {
			for (int i = 0; i <5; i++) {
				bt[i]=new BarThread(i);
				bt[i].start();
			}
		}
	}
	// 내부 클래스 => 멤버클래스 => 클래스가 가지고 있는 모든 데이터 
	// ----- 쓰레드 / 네트워크 / 빅데이터 
	/*
	 *    class A
	 *    {
	 *       ------------
	 *         A 데이터 
	 *       ------------
	 *       class B 
	 *       { 
	 *          필요시마다 A 데이터를 사용할 수 있다 
	 *          => 객체선언 없이 사용이 가능
	 *       }
	 *    }
	 */
	// => JavaScript => Ajax => 날씨 => Vue / React (Ajax 포함)
	class BarThread extends Thread {
		// 프로그래바를 한개만 작동
		int index; 
		public BarThread(int index) {
			this.index=index;
		}
		// 동작 
		public void run() {
			try {
				for (int i = 0; i <=100; i++) {
					bar[index].setValue(i);
					// bar => 실제 값
					int a=(int)(Math.random()*300); // 일시정지
					Thread.sleep(a);
					
					if(i==100) {
						rank++;
						interrupt(); // 쓰레드 종료
					}
				}
				System.out.println((index+1)+"번째:"+rank+"등");
			}catch(Exception ex) {}
		}
	}

}