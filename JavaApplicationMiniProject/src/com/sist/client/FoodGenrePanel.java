package com.sist.client;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.URL;

import javax.swing.*;
import javax.swing.border.LineBorder;

import java.awt.*;

import com.sist.commons.ImageChange;
import com.sist.dao.*;
import com.sist.vo.*;
import java.util.*;
import java.util.List;

public class FoodGenrePanel extends JPanel  implements MouseListener, ActionListener {
	ControlPanel cp;
	JButton[] genre = new JButton[5]; // 한식, 중식, 양식...
	
	JButton prev, next; // 이전, 다음
	JLabel la = new JLabel("0 page / 0 pages");
	JLabel[] imgs = new JLabel[12];
	
	int curPage = 1;
	int totalPage = 0;
	FoodDAO dao = FoodDAO.newInstance();
	String strGenre = "한식";
	
	JPanel pan = new JPanel(); // 이미지
	public FoodGenrePanel(ControlPanel cp) {
		this.cp = cp;

		
		prev = new JButton("이전");
		next = new JButton("다음");
		
		JPanel p1 = new JPanel();
		p1.setLayout(new GridLayout(1, 5, 5, 5));
		String[] temp = {"한식", "중식", "양식", "일식", "기타"};
		for (int i = 0; i < genre.length; i++) {
			genre[i] = new JButton(temp[i]);
			p1.add(genre[i]);
			genre[i].addActionListener(this);
		}

		
		JPanel p2 = new JPanel();
		p2.add(prev);
		p2.add(la);
		p2.add(next);
		
		pan.setLayout(new GridLayout(3, 4));
		
		setLayout(new BorderLayout());
		add("North", p1);
		add("Center", pan);
		add("South", p2);
		print();
		
		prev.addActionListener(this);
		next.addActionListener(this);
	}
	

	// 초기화
	public void init() {
		for (int i = 0; i < imgs.length; i++) {
			imgs[i] = new JLabel("");
		}
		pan.removeAll();
		pan.validate(); // 재배치
	}
	// 이미지 출력
	public void print() {
		// 총 페이지
		totalPage = dao.foodGenreTotalPage(strGenre);
		List<FoodVO> list = dao.foodGenreData(curPage, strGenre);
		
		for (int i = 0; i < list.size(); i++) {
			FoodVO vo = list.get(i);
			try {
				URL url = new URL(vo.getPoster());
				Image image = ImageChange.getImage(new ImageIcon(url), 180, 145);
				imgs[i] = new JLabel(new ImageIcon(image)); // imgs : JLabel
				imgs[i].setToolTipText(vo.getName() + "^" + vo.getFno());
				
				pan.add(imgs[i]);
				// 이벤트 등록
				imgs[i].addMouseListener(this);
				
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		la.setText(curPage + " page / " + totalPage + " pages");
	}


	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		for (int i = 0; i < imgs.length; i++) {
			if (e.getSource() == imgs[i]) {
				if (e.getClickCount() == 2) {
					String fno = imgs[i].getToolTipText();
					fno = fno.substring(fno.lastIndexOf("^") + 1);
					FoodVO vo = dao.foodDetailData(Integer.parseInt(fno));
					cp.fdp.detailPrint(2, vo);
					cp.card.show(cp, "DETAIL");
				}
			}
		}
	}


	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		for (int i = 0; i < imgs.length; i++) {
			if (e.getSource() == imgs[i]) {
				imgs[i].setBorder(new LineBorder(Color.red, 3));
			}
		}
	}


	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		for (int i = 0; i < imgs.length; i++) {
			if (e.getSource() == imgs[i]) {
				imgs[i].setBorder(null);
			}
		}
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		for (int i = 0; i < genre.length; i++) {
			if (e.getSource() == genre[i]) {
				strGenre = genre[i].getText();
				curPage = 1;
				init();
				print();
			}
		}
		// 이전
		if (e.getSource() == prev) {
			if (curPage > 1) {
				curPage--;
				init();
				print();
			}
		} else if (e.getSource() == next) {
			if (curPage < totalPage) {
				curPage++;
				init();
				print();
			}
		}
	}
	
}
