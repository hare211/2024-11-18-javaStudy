package com.sist.main;
import javax.swing.*;

import com.sist.dao.*;
import com.sist.vo.*;

import java.util.Date;
import java.util.List;
import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
public class BoardMainForm extends JFrame implements ActionListener, MouseListener {
    CardLayout card = new CardLayout();
    BoardList bList = new BoardList();
    BoardDetail bDetail = new BoardDetail();
    BoardInsert bInsert = new BoardInsert();
    BoardUpdate bUpdate = new BoardUpdate();
    BoardDelete bDelete = new BoardDelete();
    // 게시판 관리자 
    FreeBoardDAO dao = new FreeBoardDAO();
    // 변수 설정 
    int curPage = 1;
    int totalPage = 0;
    public BoardMainForm() {
    	setLayout(card);
    	
    	// 추가 
    	add("LIST", bList);
    	add("DETAIL", bDetail);
    	add("INSERT", bInsert);
    	add("UPDATE", bUpdate);
    	add("DELETE", bDelete);
    	
    	setTitle("윈도우 게시판 ver 1.0");
    	listPrint();
    	setSize(640, 550);
    	setVisible(true);
    	setDefaultCloseOperation(EXIT_ON_CLOSE);
    	// 이벤트 등록 
    	bList.inBtn.addActionListener(this);// 글쓰기 이동버튼
    	bInsert.b1.addActionListener(this);// 글쓰기
    	bInsert.b2.addActionListener(this);// 취소 
    	
    	// 이전
    	bList.prevBtn.addActionListener(this);
    	// 다음
    	bList.nextBtn.addActionListener(this);
    	// table
    	bList.table.addMouseListener(this);
    	
    	// 목록
    	bDetail.b3.addActionListener(this);
    	// 삭제
    	bDetail.b1.addActionListener(this);
    	// 수정
    	bDetail.b2.addActionListener(this);
    	
    	// 실제 삭제
    	bDelete.b1.addActionListener(this); // 삭제
    	bDelete.b2.addActionListener(this); // 취소
    }
    public void listPrint() {
    	// 테이블 전체 데이터 지우기
    	for (int i = bList.model.getRowCount() - 1; i >= 0; i--) {
			bList.model.removeRow(i);
		}
    	// JLabel => init => JLabel
    	FreeBoardDAO dao = FreeBoardDAO.newInsatance();
    	List<FreeBoardVO> list = dao.boardListData(curPage);
    	
    	for (FreeBoardVO vo : list) {
			String[] data = {
					String.valueOf(vo.getNo()),
					vo.getSubject(),
					vo.getName(),
					vo.getRegdate().toString(),
					String.valueOf(vo.getHit())
			};
			
			bList.model.addRow(data); // 목록 출력
		}
    	
    	totalPage = dao.boardTotalPage();
    	bList.pageLa.setText(curPage + " page / " + totalPage + " pages");
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        new BoardMainForm();
	}
	@Override
	public void actionPerformed (ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == bList.prevBtn) { // 이전 버튼
			if (curPage > 1) { // 현재 페이지 
				curPage--;
				listPrint();
			}
		} else if (e.getSource() == bList.nextBtn) { // 다음 버튼
			if (curPage < totalPage) {
				curPage++;
				listPrint();
			}
		}
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	// onMouseUp
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	// onMouseOver
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	// onMouseOut
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}