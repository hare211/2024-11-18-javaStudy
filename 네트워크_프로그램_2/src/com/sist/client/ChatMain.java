package com.sist.client;
import java.util.*;
import java.net.*;
import java.awt.CardLayout;
import java.awt.HeadlessException;
import java.io.*;
import javax.swing.*;
import com.sist.commons.*;

public class ChatMain extends JFrame {
	Login login = new Login();
	WaitRoom wr = new WaitRoom();
	CardLayout card = new CardLayout(); // 화면을 숨긴 뒤 보여준다
	// <jsp:include>
	public ChatMain() {
		setLayout(card);
		add("WR", wr);
		add("LOG", login);
		
		setSize(800, 600);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new ChatMain();
	}
}
