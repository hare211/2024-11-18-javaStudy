package com.sist.io;
import java.util.*;
import java.io.*;

public class IO_4 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
//		FileWriter fw = null; // 파일에 저장
//		FileReader fr = null; // 파일 읽기
		final int EOF = -1;
		
		// 한글로 된 파일 제어 => 2byte => Reader / Writer
		try {
			
			
			// ObjectInputStream / ObjectOutputStream
			// => List 가 통째로 저장이 가능
			while (true) {
				System.out.println("==== Menu ====");
				System.out.println("1. 사원 목록");
				System.out.println("2. 사원 등록");
				System.out.println("3. 종료");
				System.out.println("==============");
				
				System.out.print("메뉴 선택 : ");
				int menu = scanner.nextInt();
				
				switch (menu) {
				case 1:
					FileReader fr = new FileReader("c:\\java_data\\sawon2.txt");
					int i = 0;
					String data = "";
					while ((i = fr.read()) != EOF) {
						data += (char) i;
					}
					
					String[] sawons = data.split("\n");
					
					for (String sa : sawons) {
						if (sa == null || sa.equals("")) {
							System.out.println("등록된 사원이 없습니다.");
							break;
						}
						String[] sawon = sa.split("\\|");
						System.out.println("사번 : " + sawon[0]);
						System.out.println("이름 : " + sawon[1]);
						System.out.println("부서 : " + sawon[2]);
						System.out.println("직위 : " + sawon[3]);
						System.out.println("근무지 : " + sawon[4]);
						System.out.println("연봉 : " + sawon[5]);
						System.out.println("===================");
					}
					fr.close();
					break;
				case 2:
					FileWriter fw = new FileWriter("c:\\java_data\\sawon2.txt", true);
					
					Sawon sa = new Sawon();
					System.out.print("이름 입력 : ");
					sa.setName(scanner.next());
					
					System.out.print("부서 입력 : ");
					sa.setDept(scanner.next());
					
					System.out.print("직위 입력 : ");
					sa.setJob(scanner.next());
					
					System.out.print("근무지 입력 : ");
					sa.setLoc(scanner.next());
					
					System.out.print("연봉 입력 : ");
					sa.setPay(scanner.nextInt());
					
					String msg = maxSabun() + "|"
							+ sa.getName() + "|"
							+ sa.getDept() + "|"
							+ sa.getJob() + "|"
							+ sa.getLoc() + "|"
							+ sa.getPay() + "\r\n";
					
					fw.write(msg);
					System.out.println("사원 등록 완료");
					fw.close();
					
					break;
				case 3:
					System.out.println("프로그램 종료");
					return;
				default:
					break;
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} 
	}
	
	public static int maxSabun() {
		int max = 0;
		FileReader fr = null;
		try {
			fr = new FileReader("c:\\java_data\\sawon2.txt");
			int i = 0;
			String data = "";
			
			while ((i = fr.read()) != -1) {
				data += (char) i;
			}
			
			String [] datas = data.split("\n");
			for (String sa : datas) {
				if (sa == null || sa.equals("")) {
					break;
				}
				String [] sawon = sa.split("\\|");
				if (max < Integer.parseInt(sawon[0])) {
					max = Integer.parseInt(sawon[0]);
				}
				
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			try {
				fr.close();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		return max + 1;
	}
}
