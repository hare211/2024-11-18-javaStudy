package com.sist.user;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Commons {
	public static Image getImage(ImageIcon icon, int width, int height) { // 크기만큼 이미지가 편집 됨
		Image img = icon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH); // 이미지를 축소 또는 확대 할 때
		
		return img;
	}
}
