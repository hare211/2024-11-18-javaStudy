package com.sist.client;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.*;
import java.util.List;

import javax.swing.*;
import javax.swing.border.LineBorder;

import com.sist.vo.*;
import com.sist.commons.*;
import com.sist.dao.*;

public class HomePanel extends JPanel implements MouseListener, ActionListener {
	ControlPanel cp;
	JPanel pan = new JPanel();
	// 이미지 출력
	JButton b1, b2; // 이전, 다음
	JLabel la = new JLabel("0 page / 0 pages");
	JLabel[] imgs = new JLabel[12];
	
	int curPage = 1;
	int totalPage = 0;
	// 데이터베이스 연동(FoodDAO)
	FoodDAO dao = FoodDAO.newInstance();
	
	public HomePanel(ControlPanel cp) {
		// JPanel : FlowLayout 일자
		setLayout(new BorderLayout());
		this.cp = cp;
		pan.setLayout(new GridLayout(3, 4, 5, 5));
		add("Center", pan);
		
		b1 = new JButton("이전");
		b2 = new JButton("다음");
		
		JPanel p = new JPanel();
		p.add(b1);
		p.add(la);
		p.add(b2);
		add("South", p);
		print();
		
		b1.addActionListener(this); // 이전
		b2.addActionListener(this); // 다음
		
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
		totalPage = dao.foodTotalPage();
		List<FoodVO> list = dao.foodListData(curPage);
		
		for (int i = 0; i < list.size(); i++) {
			FoodVO vo = list.get(i);
			try {
				URL url = new URL(vo.getPoster());
				Image image = ImageChange.getImage(new ImageIcon(url), 200, 180);
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
					
					cp.fdp.detailPrint(i, vo);
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
		if (e.getSource() == b1) { // 이전
			if (curPage > 1) {
				curPage--;
				init();
				print();
			}
		} else if (e.getSource() == b2) { // 다음
			if (curPage < totalPage) {
				curPage++;
				init();
				print();
			}
		}
	}
	
}







