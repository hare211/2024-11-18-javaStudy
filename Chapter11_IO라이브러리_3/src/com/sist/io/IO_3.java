package com.sist.io;
import java.util.*;
import java.io.*;

// BufferedInputStream / BufferedOutputStream
// String StringBuffer
// 파일 자체 제어 => FileReader / FileWriter
//					BufferedReader / BufferedWriter
//					=> 한 줄씩 읽기, 한 줄씩 저장
//					=> readLine(), writeLine()
public class IO_3 {
	public static void main(String[] args) {
		final int EOF = -1;
		try (
			FileInputStream fis = new FileInputStream("c:\\javaDev\\mydata.jar");
			BufferedInputStream bis = new BufferedInputStream(fis);
			FileOutputStream fos = new FileOutputStream("c:\\java_data\\mydata.jar");
			BufferedOutputStream bos = new BufferedOutputStream(fos);
		 ) {
			int i = 0;
			byte[] buffer = new byte[1024];
			
			while ((i = bis.read(buffer, 0, 1024)) != EOF) {
				bos.write(buffer, 0, i);
			}
			System.out.println("파일 복사 완료");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
/*
 *public class IO_3 {
    public static void main(String[] args) {
        final int EOF = -1;
        try (
            BufferedInputStream bis = new BufferedInputStream(new FileInputStream("c:\\javaDev\\mydata.jar"));
            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("c:\\java_data\\mydata.jar"))
        ) {
            int i = 0;
            byte[] buffer = new byte[1024];

            while ((i = bis.read(buffer, 0, 1024)) != EOF) {
                bos.write(buffer, 0, i);
            }
            System.out.println("파일 복사 완료");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
 * 
 * */

