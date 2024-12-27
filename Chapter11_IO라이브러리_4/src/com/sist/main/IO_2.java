package com.sist.main;
import java.util.*;
import java.io.*;

public class IO_2 {
	public static void main(String[] args) {
		ObjectInputStream ois = null;
		
		try {
			FileInputStream fis = new FileInputStream("c:\\java_data\\sawon_info.txt"); // 파일을 읽고
			ois = new ObjectInputStream(fis); // Object 단위로 데이터를 읽어온다
			// 파일을 읽어서 Object 단위로 데이터를 읽어온다
			
			List<Sawon> list = (List<Sawon>) ois.readObject();
			
			for (Sawon sa : list) {
				System.out.println(sa.getSabun() + " "
						+ sa.getName()
						+ sa.getDept()
						+ sa.getJob()
						+ sa.getPay());
			}
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
