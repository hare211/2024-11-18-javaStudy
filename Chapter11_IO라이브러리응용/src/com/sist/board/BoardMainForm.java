package com.sist.board;
import javax.swing.*;
import java.awt.*;

public class BoardMainForm extends JFrame{
	CardLayout card = new CardLayout();
	public BoardMainForm() {
		setLayout(card);
		setSize(640, 480);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		new BoardMainForm();
	}

}
