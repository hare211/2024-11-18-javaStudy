package com.sist.util;
import java.text.SimpleDateFormat;
import java.util.*;
public class 라이브러리_6 {
	public static void main(String[] args) {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-M-d");
		
		String today = sdf.format(date);
		// 2024-12-20
		StringTokenizer st = new StringTokenizer(today, "-");
		int year = Integer.parseInt(st.nextToken());
		int month = Integer.parseInt(st.nextToken());
		int day = Integer.parseInt(st.nextToken());
		
		Calendar cal1 = Calendar.getInstance();
		// 추상 클래스 => new 를 이용할 수 없다.
		/*
		 * 날짜 설정
		 * 	=> set()
		 * 날짜 읽기
		 * 	=> get() => int 반환
		 * 달의 마지막 날짜
		 * 	=> getActualMaximum() => int 반환
		 * 요일 읽기
		 * 	=> get(Calendar.DAY_OF_WEEK) => int 반환
		 */
		cal1.set(Calendar.YEAR, year);
		cal1.set(Calendar.MONTH, month - 1);
		cal1.set(Calendar.DATE, day); // day 는 DATE
		
		int week = cal1.get(Calendar.DAY_OF_WEEK) - 1;
		
		String[] strWeek = {"일", "월", "화", "수", "목", "금", "토"};
		
		System.out.println(year + "년도 " + month + "월 " + day + "일 " + strWeek[week] + "요일");
		
		int lastDay = cal1.getActualMaximum(Calendar.DATE); // 이번 달의 마지막 날짜
		
		Calendar cal2 = Calendar.getInstance();
		cal2.set(Calendar.YEAR, year);
		cal2.set(Calendar.MONTH, month - 1);
		cal2.set(Calendar.DATE, 1);
		
		int week2 = cal2.get(Calendar.DAY_OF_WEEK) - 1;
		
		for (String s : strWeek) {
			System.out.print(s + "\t");
		}
		
		System.err.println();
		
		for (int i = 1; i < lastDay + 1; i++) {
			if (i == 1) {
				for (int j = 0; j < week2; j++) {
					System.out.print("\t");
				}
			}

			System.out.printf("%2d\t", i);
			
//			if (i % 7 == 1) {
//				System.out.println();
//			}
			
			week2++;
			if (week2 > 6) {
				System.out.println();
				week2 = 0;
			}
		}
	}
}


























