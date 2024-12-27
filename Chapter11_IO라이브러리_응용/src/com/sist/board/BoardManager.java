package com.sist.board;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

public class BoardManager {
	// 게시물을 모아서 관리 영역
	// 게시물을 모든 사용자에게 공유
	private static List<BoardVO> boardList = new ArrayList<BoardVO>();
	// 오라클 => 저장된 데이터가 static => 공유된 데이터
	// 초기화
	static {
		ObjectInputStream ois = null;
		try {
			FileInputStream fis = new FileInputStream("c:\\java_data\\board.txt");
			ois = new ObjectInputStream(fis);
			boardList =(List<BoardVO>) ois.readObject();
			// ObjectInputStream => 파일과 연결되어 있어야 함
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			try {
				ois.close();
			} catch (Exception ex) {
				ex.printStackTrace(); 
			}
		}
	}
}
