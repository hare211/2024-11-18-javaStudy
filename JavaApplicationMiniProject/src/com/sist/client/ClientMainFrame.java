
package com.sist.client;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import com.sist.vo.*;
import com.sist.commons.Function;
import com.sist.dao.*;
import java.io.*;
import java.util.*;
import java.util.List;
import java.net.*;
//	 						상속 => 재사용 => 변경
// 메뉴, 채팅만 인터페이스 구현, 각 메뉴별 상호작용은 프레임에서 구현
public class ClientMainFrame extends JFrame implements ActionListener, Runnable, MouseListener, KeyListener {
	// 네트워크 통신
	Socket s; // 연걸점
	OutputStream out; // 보내는 통로
	BufferedReader in; // 들어오는 통로
	
	MenuForm mf = new MenuForm(); // 포함 클래스 => 있는 그대로 사용
	ControlPanel cp = new ControlPanel();
	Login login = new Login();
	int selectRow = -1;
	private List<User> users = new ArrayList<>();
	private String currentUserId;
	User user;
	// 배치
	// 데이터베이스
	MemberDAO mDao = MemberDAO.newInstance();
	FriendDAO fDao = FriendDAO.newInstance();
	public ClientMainFrame() {
		
		setLayout(null); // null => 사용자 정의 => 직접 배치
		mf.setBounds(10, 15, 800, 50);
		add(mf);
		cp.setBounds(10, 75, 820, 570);
		add(cp);
		setSize(850, 700);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// 등록
		// 로그인
		login.b1.addActionListener(this); // 로그인
		login.b2.addActionListener(this); // 취소
		login.tf.addKeyListener(this);
		login.pf.addKeyListener(this);
		
		mf.b6.addActionListener(this); // 실시간 채팅
		mf.b1.addActionListener(this); // 홈
		mf.b2.addActionListener(this); // 맛집
		mf.b3.addActionListener(this); // 검색
		mf.b7.addActionListener(this); // 뉴스
		mf.b5.addActionListener(this); // 커뮤니티
		
		cp.cp.tf.addActionListener(this); // 채팅입력창
		cp.cp.table.addMouseListener(this);
		cp.cp.b2.addActionListener(this); // 정보보기
		cp.cp.b1.addActionListener(this); // 쪽지보내기
		
    	cp.cp.addFriendBtn.addActionListener(this); // 친구추가
		cp.cp.listFriendBtn.addActionListener(this); // 친구목록
		addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				try {
					out.write((Function.EXIT + "|\n").getBytes());
				} catch (Exception ex) {
					// TODO: handle exception
				}
			}
			
		});
	}
	
	public static void main(String[] args) {
		// screenshots, server computer, port 0 ~ 65535 (0 ~ 1023 사용 중) 4000 / 8080 / 1521
		// HiFiLookAndFeel, 3500,
		try {
			UIManager.setLookAndFeel("com.jtattoo.plaf.hifi.HiFiLookAndFeel");
		} catch (Exception ex) {
			
		}
		new ClientMainFrame();
	}

	// 서버에서 응답 받기(쓰레드)
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			while (true) {
				String msg = in.readLine(); // 서버에서 보낸 값을 받는다
				if (msg == null) {
					break;
				}
				StringTokenizer st = new StringTokenizer(msg, "|");
				int protocol = Integer.parseInt(st.nextToken());
				
				switch(protocol)
				{
				  case Function.LOGIN:
				  {
					    String id = st.nextToken();
					    String name = st.nextToken();
					    String sex = st.nextToken();

					    // ID 저장
					    user = new User(id, name, sex);
					    users.add(user);

					    // 접속 인원 출력
					    cp.cp.model.addRow(new String[]{id, name, sex});
				  }
				  break;
				  case Function.MYLOG:
				  {
					  String id=st.nextToken();
					  setTitle(id);
					  currentUserId = id; // 여기서 현재 ID 구하기!
					  login.setVisible(false);
					  setVisible(true);
				  }
				  break;
				  case Function.WAITCHAT:
				  {
					  cp.cp.ta.append(st.nextToken()+"\n");
				  }
				  break;
				  case Function.MYEXIT :
				  {
					  dispose();
					  System.exit(0);
				  }
				  break;
				  case Function.EXIT :
				  {
					  String exitId = st.nextToken();
					  users.removeIf(user -> user.getId().equals(exitId));
					  for (int i = 0; i < cp.cp.model.getColumnCount(); i++) {
						String id = cp.cp.model.getValueAt(i, 0).toString();
						if (exitId.equals(id)) {
							cp.cp.model.removeRow(i); // ChatPanel 에서 접속인원 제거
							break;
						}
					}
					
				  }
				  break;
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	public String getCurrentUserId() {
	    return currentUserId;
	}


	// 서버에 요청(로그인, 채팅 보내기)
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == login.b2) {
			dispose(); // 윈도우 메모리 해제
			System.exit(0); // 프로그램 종료
		} else if (e.getSource() == login.b1) {
			String id = login.tf.getText();
			if (id.trim().isEmpty()) {
				JOptionPane.showMessageDialog(this, "아이디를 입력하세요");
				login.tf.requestFocus();
				return;
			}
			String pwd = String.valueOf(login.pf.getPassword());
			if (pwd.trim().isEmpty()) {
				JOptionPane.showMessageDialog(this, "비밀번호를 입력하세요");
				login.pf.requestFocus();
				return;
			}
			// 로그인 검색
			MemberVO vo = mDao.isLogin(id, pwd);
			if (vo.getMsg().equals("NOID")) {
				JOptionPane.showMessageDialog(this, "아이디가 존재하지 않습니다");
				login.tf.setText("");
				login.pf.setText("");
				login.tf.requestFocus();
			} else if (vo.getMsg().equals("NOPWD")) {
				JOptionPane.showMessageDialog(this, "비밀번호가 틀립니다");
				login.pf.setText("");
				login.pf.requestFocus();				
			} else {
				// 서버 연결
				connection(vo);
//				JOptionPane.showMessageDialog(this, "로그인 되었습니다\n서버로 연결합니다");
//				login.setVisible(false);
//				setVisible(true);
			}
		} else if (e.getSource() == mf.b6) {
			cp.card.show(cp, "CHAT");
		} else if (e.getSource() == mf.b1) {
			cp.card.show(cp, "HOME");
		} else if (e.getSource() == mf.b2) {
			cp.card.show(cp, "FOOD");
		} else if (e.getSource() == mf.b3) {
			cp.card.show(cp, "FIND");
		} else if (e.getSource() == mf.b5) {
			cp.card.show(cp, "BLIST");
		} else if (e.getSource() == cp.cp.tf) {
			String msg = cp.cp.tf.getText();
			if (msg.trim().isEmpty()) {
				cp.cp.tf.requestFocus();
				return;
			}
			
			try {
				out.write((Function.WAITCHAT + "|" + msg + "\n").getBytes());
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			cp.cp.tf.setText("");
			cp.cp.tf.requestFocus();
		} else if (e.getSource() == mf.b7) {
			cp.card.show(cp, "DETAIL");
		} else if (e.getSource() == cp.cp.b2) {
			if (selectRow == -1) {
				JOptionPane.showMessageDialog(this, "정보 볼 대상을 선택하세요");
				return;
			}
			String id = cp.cp.model.getValueAt(selectRow, 0).toString();
			MemberVO vo = mDao.memberInfo(id);
			
			String info = "이름 : " + vo.getName() + "\n성별 : " + vo.getSex() + "\n이메일 : " + vo.getEmail() + "\n생년월일 : " + vo.getBirthdate().toString()
					+ "\n주소 : " + vo.getAddress() + "\n등록일 : " + vo.getRegdate().toString();
			JOptionPane.showMessageDialog(this, info);
			
		} else if (e.getSource() == cp.cp.addFriendBtn) {
			int selectedRow = cp.cp.table.getSelectedRow();
			
			String receiverId = cp.cp.model.getValueAt(selectedRow, 0).toString();
			String requesterId = getCurrentUserId();
			
			if (fDao.isAlreadyFriend(requesterId, receiverId)) {
				JOptionPane.showMessageDialog(this, "이미 친구인 상대입니다");
				return;
			}
			
			
			try {
				fDao.addFriend(requesterId, receiverId);
				
				JOptionPane.showMessageDialog(this, "친구 요청을 보냈습니다");
			} catch (Exception ex) {
				ex.printStackTrace();
				JOptionPane.showMessageDialog(this, "친구 요청에 실패했습니다");
			}
		} else if (e.getSource() == cp.cp.listFriendBtn) {
			String currentUserId = getCurrentUserId();
			
			List<String> friendList = fDao.getFriendList(currentUserId);
			
			if (friendList.isEmpty()) {
				JOptionPane.showMessageDialog(this, "친구 목록이 비어있습니다.");
			} else {
				StringBuilder friends = new StringBuilder("친구 목록:\n");
				for (String friend : friendList) {
					friends.append(friend).append("\n");
				}
				JOptionPane.showMessageDialog(this, friends.toString(), "친구 목록", JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}
	// 서버 연결
	public void connection(MemberVO vo) {
		try {
			// 서버와 연결
			s = new Socket("localhost", 4455);
			// 서버로 전송
			out = s.getOutputStream();
			// 서버로 부터 값 받기
			in = new BufferedReader(new InputStreamReader(s.getInputStream()));
			
			// 서버로 로그인 요청
			out.write((Function.LOGIN + "|" 
						+ vo.getId() + "|" 
						+ vo.getName() + "|" 
						+ vo.getSex() + "\n").getBytes());
		} catch (Exception ex) {
		}
		// 서버로부터 값을 받아서 출력
		new Thread(this).start(); // run 메서드 호출
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == cp.cp.table) {
			 selectRow = cp.cp.table.getSelectedRow();
			String myId = getTitle();
			String id = cp.cp.model.getValueAt(selectRow, 0).toString();
			if (myId.equals(id)) {
				cp.cp.b1.setEnabled(false);
				cp.cp.b2.setEnabled(false);
				cp.cp.addFriendBtn.setEnabled(false);
			} else {
				cp.cp.b1.setEnabled(true);
				cp.cp.b2.setEnabled(true);				
				cp.cp.addFriendBtn.setEnabled(true);
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
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			login.b1.doClick();
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
