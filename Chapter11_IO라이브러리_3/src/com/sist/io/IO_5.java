package com.sist.io;
import java.io.BufferedWriter;
import java.io.FileWriter;
/*
 * 혼자 단위 저장 => write(String s)
 */
import java.util.*;

public class IO_5 {
	public static void main(String[] args) {
		try (FileWriter fw = new FileWriter("c:\\java_data\\student.txt", true);
			 BufferedWriter bw = new BufferedWriter(fw);
		) {
//			String msg = "Hello Java => IO => Hello\n";
//			fw.write(msg);
//			System.out.println("저장 완료");
			
			String msg = "Hello oracle";
			bw.write(msg);
			System.out.println("저장 완료");
			
		} catch (Exception ex) {
			// TODO: handle exception
		}
	}
}
