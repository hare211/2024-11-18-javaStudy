package com.sist.main;
import javax.swing.*;

import com.sist.dao.*;
import com.sist.vo.*;

import java.util.BitSet;
import java.util.Date;
import java.util.List;
import java.awt.*;
import java.awt.event.*;import java.nio.file.FileVisitOption;
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
    	
    	// 상세보기
    	// 목록 버튼
    	bDetail.b3.addActionListener(this);
    	// 삭제 버튼
    	bDetail.b1.addActionListener(this);
    	// 수정 버튼
    	bDetail.b2.addActionListener(this);
    	
    	// 실제 삭제
    	bDelete.b1.addActionListener(this); // 삭제
    	bDelete.b2.addActionListener(this); // 취소
    	
    	// 수정
    	bUpdate.b1.addActionListener(this); // 수정
    	bUpdate.b2.addActionListener(this); // 취소
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
    
    public void detailPrint(int no) {
		FreeBoardDAO dao = FreeBoardDAO.newInsatance();
		
		FreeBoardVO vo = dao.boardDetailData(no); // no 번의 free_board VO 를 가져온다
		
    	bDetail.no.setText(String.valueOf(vo.getNo()));
    	bDetail.name.setText(vo.getName());
    	bDetail.day.setText(vo.getRegdate().toString());
    	bDetail.hit.setText(String.valueOf(vo.getHit()));
    	bDetail.sub.setText(vo.getSubject());
    	bDetail.ta.setText(vo.getContent());
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try
		{
			UIManager.setLookAndFeel("com.jtattoo.plaf.mcwin.McWinLookAndFeel");
		}catch(Exception ex) {}
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
		} 
		
		else if (e.getSource() == bList.nextBtn) { // 다음 버튼
			if (curPage < totalPage) {
				curPage++;
				listPrint();
			}
		}
		
		else if (e.getSource() == bList.inBtn) { // 글쓰기 버튼
			card.show(getContentPane(), "INSERT"); // UI 분리
			
			bInsert.nameTf.setText("");
			bInsert.subTf.setText("");
			bInsert.ta.setText("");
			bInsert.pwdPf.setText("");
			// card 단점 : 윈도우가 종료되지 않는다 => 입력된 내용을 그대로 유지
			bInsert.nameTf.requestFocus();
		}
		
		else if (e.getSource() == bInsert.b1) { // 글쓰기 등록
			// 입력한 데이터 읽기
			// 유효성 검사 => NOT NULL 속성을 가지고 있는 경우
			// 웹 => 자바스크립트
			String name = bInsert.nameTf.getText();
			if (name.trim().isEmpty()) {
				// 이름 입력 안된 상태
				JOptionPane.showMessageDialog(this, "이름을 입력하세요"); // this : 윈도우 창
				// alert() 창
				bInsert.nameTf.requestFocus();
				// name.focus()
				return;
			}
			
			String subject = bInsert.subTf.getText();
			if (subject.trim().isEmpty()) {
				JOptionPane.showMessageDialog(this, "제목을 입력하세요");
				// alert() 창
				bInsert.subTf.requestFocus();
				// name.focus()
				return;
			}
			
			String content = bInsert.ta.getText();
			if (content.trim().isEmpty()) {
				JOptionPane.showMessageDialog(this, "내용을 입력하세요");
				// alert() 창
				bInsert.ta.requestFocus();
				// name.focus()
				return;
			}
			
			String pwd = String.valueOf(bInsert.pwdPf.getPassword());
			if (pwd.trim().isEmpty()) {
				JOptionPane.showMessageDialog(this, "비밀번호를 입력하세요");
				// alert() 창
				bInsert.pwdPf.requestFocus();
				// name.focus()
				return;
			}
			// 유효성 : NOT NULL / CHECK / PRIMARY KEY
			
			// 오라클 연동
			FreeBoardDAO dao = FreeBoardDAO.newInsatance();
			FreeBoardVO vo = new FreeBoardVO();
			vo.setName(name);
			vo.setSubject(subject);
			vo.setContent(content);
			vo.setPwd(pwd);
			
			dao.boardInsert(vo);
			
			card.show(getContentPane(), "LIST");
			listPrint();
			
		}
		
		else if (e.getSource() == bInsert.b2) { // 글쓰기 취소
			// JavaScript : history.back()
			card.show(getContentPane(), "LIST");
			// 화면 이름 getContentPane() : Panel 관리자
			// => 이동 시 card 이름 부여 => 해당 card 로 이동
		}
		// 상세보기에서 목록으로 이동
		else if (e.getSource() == bDetail.b3) {
			card.show(getContentPane(), "LIST");
			listPrint(); // 목록으로 돌아간 뒤 조회수가 증가된 목록으로 최신화
		}
		// 상세보기에서 수정으로
		else if (e.getSource() == bDetail.b1) {
			card.show(getContentPane(), "UPDATE");
			// 수정하려던 글의 정보를 다시 읽고 채우기
			FreeBoardDAO dao = FreeBoardDAO.newInsatance();
			
			String no =  bDetail.no.getText(); // 수정하려는 글의 번호(PK) 가져오기
			
			FreeBoardVO vo = dao.boardUpdateData(Integer.parseInt(no));
			// 웹일 시 : String no = request.getParameter("no");
			
			bUpdate.nameTf.setText(vo.getName());
			bUpdate.subTf.setText(vo.getSubject());
			bUpdate.ta.setText(vo.getContent());
			bUpdate.pwdPf.setText("");
		}
		// 위 수정 창에서 진행하는 수정
		else if (e.getSource() == bUpdate.b1) { // 실제 수정
			String name = bUpdate.nameTf.getText();
			if (name.trim().isEmpty()) {
				// 이름 입력 안된 상태
				JOptionPane.showMessageDialog(this, "이름을 입력하세요"); // this : 윈도우 창
				// alert() 창
				bUpdate.nameTf.requestFocus();
				// name.focus()
				return;
			}
			
			String subject = bUpdate.subTf.getText();
			if (subject.trim().isEmpty()) {
				JOptionPane.showMessageDialog(this, "제목을 입력하세요");
				// alert() 창
				bUpdate.subTf.requestFocus();
				// name.focus()
				return;
			}
			
			String content = bUpdate.ta.getText();
			if (content.trim().isEmpty()) {
				JOptionPane.showMessageDialog(this, "내용을 입력하세요");
				// alert() 창
				bUpdate.ta.requestFocus();
				// name.focus()
				return;
			}
			
			String pwd = String.valueOf(bUpdate.pwdPf.getPassword());
			if (pwd.trim().isEmpty()) {
				JOptionPane.showMessageDialog(this, "비밀번호를 입력하세요");
				// alert() 창
				bUpdate.pwdPf.requestFocus();
				// name.focus()
				return;
			}
			String no = bDetail.no.getText();
			
			FreeBoardVO vo = new FreeBoardVO();
			vo.setNo(Integer.parseInt(no));
			vo.setName(name);
			vo.setSubject(subject);
			vo.setContent(content);
			vo.setPwd(pwd);
			
			FreeBoardDAO dao = FreeBoardDAO.newInsatance();
			boolean bCheck = dao.boardUpdate(vo);
			
			if (bCheck = true) {
				card.show(getContentPane(), "DETAIL");
				detailPrint(Integer.parseInt(no));
			} else {
				JOptionPane.showMessageDialog(this, "비밀번호가 틀렸습니다");
				bUpdate.pwdPf.setText("");
				bUpdate.pwdPf.requestFocus();
			}
		}
		else if (e.getSource() == bUpdate.b2) { // 수정 취소
			card.show(getContentPane(), "DETAIL");
		}
		// 상세보기에서 삭제로
		else if (e.getSource() == bDetail.b2) {
			card.show(getContentPane(), "DELETE");
			
			bDelete.pf.setText("");
			bDelete.pf.requestFocus();
		}
		// 위 삭제 창에서 진행하는 실제 삭제
		else if (e.getSource() == bDelete.b1) {
			String no = bDetail.no.getText();
			String pwd = String.valueOf(bDelete.pf.getPassword());
			
			FreeBoardDAO dao = FreeBoardDAO.newInsatance();
			
			boolean bCheck = dao.boardDelete(Integer.parseInt(no), pwd);
			if (bCheck) {
				card.show(getContentPane(), "LIST");
				listPrint();
			} else {
				JOptionPane.showMessageDialog(this, "비밀번호가 틀립니다");
				bDelete.pf.setText("");
				bDelete.pf.requestFocus();
			}
		}
		else if (e.getSource() == bDelete.b2) {
			card.show(getContentPane(), "DETAIL");
		}
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
			if (e.getSource() == bList.table) {
				if (e.getClickCount() == 2) {
					int row = bList.table.getSelectedRow(); // 몇 번째를 선택했는 지
					String no = bList.model.getValueAt(row, 0).toString(); // row 번 째의 게시글 번호를 읽어온다
					card.show(getContentPane(), "DETAIL");
					detailPrint(Integer.parseInt(no));

				}
			}
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