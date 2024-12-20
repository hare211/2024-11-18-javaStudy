package com.sist.util;

import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Date;

/*
 * 날짜 관련
 * -------
 * Date => 기능이 없다
 * 			현재 시스템의 날짜와 시간을 읽어 온다
 * 			--------
 * 			오라클과 호환성이 좋다
 * 			java.util.Date => 오라클과 호환 O
 * 			java.sql.Date => 오라클과 호환 X
 * Calendar => Date 에 해당 기능을 추가
 * 				Date 를 확장 => 제어가 간단하다
 * 				-------------------------
 * 				메서드 기능이 좋다
 * 				추상 클래스
 * 			=> 반드시 동행
 * 				SimpleDateFormat => java.text
 * 				----------------
 * 				날짜 출력 시 원하는 형태로 출력
 * 				24/12/20 2024-12-20
 * 			
 * 				년도
 * 					yyyy / yy
 * 				월
 * 					MM / M => 10/10  // MM => 두자리 M => 있는 그대로
 * 						   => 09/9
 * 				일	
 * 					dd / d
 * 				시간
 * 					hh / h
 * 				분
 * 					mm / m
 * 				초
 * 					ss / s
 */

public class 라이브러리_4 {
	public static void main(String[] args) {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		
		System.out.println(sdf.format(date)); // date 의 날짜를 sdf 의 형식으로 출력
		
		
		int year = 2024;
		int month = 12;
		LocalDate firstDayOfMonth = LocalDate.of(year, month, 1);
		LocalDate firstDayOfNextMonth = firstDayOfMonth.plusMonths(1);
		
		int offset = firstDayOfMonth.getDayOfWeek().getValue() % 7;
		
		System.out.println("Su Mo Tu We Th Fr Sa");
		for (int i = 0; i < offset; i++) {
			System.out.print("  ");
		}
		
		LocalDate ld = firstDayOfMonth;
		while (ld.isBefore(firstDayOfNextMonth)) {
			System.out.printf("%2d ", ld.getDayOfMonth());
			if (ld.getDayOfWeek() == DayOfWeek.SATURDAY) {
				System.out.println();
			}
			ld = ld.plusDays(1);
		}
		
		
	}
}
