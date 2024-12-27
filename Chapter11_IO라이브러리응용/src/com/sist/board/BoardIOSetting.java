package com.sist.board;

import java.awt.geom.Area;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class BoardIOSetting {
	public static void main(String[] args) {
		ObjectOutputStream oos = null;
		try {
			List<BoardVO> list = new ArrayList<BoardVO>();
			FileOutputStream fos = new FileOutputStream("c:\\java_data\\board.txt");
			oos = new ObjectOutputStream(fos);
			oos.writeObject(list);
			System.out.println("파일에 저장공간 생성");
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally { 
			// 오라클 / 서버 / 파일
		}
	}
}
