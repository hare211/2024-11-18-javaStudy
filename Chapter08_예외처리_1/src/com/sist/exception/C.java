package com.sist.exception;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Scanner;

public class C {
	public static void main(String[] args) {
		
		String s = "20";
		int a = 23;
		
		System.out.println(Integer.parseInt(s));
		System.out.println(String.valueOf(a) + 2);
		System.out.println("23" + 2);
		System.out.println(23 + 2);
		System.out.println(Integer.parseInt(s) + 2);
		
		int b = Integer.parseInt(s);
		String s1 = String.valueOf(a);
		
		System.out.println(b + 2);
		System.out.println(s1 + 2 + 2 + 32);
		
		// 첫 번째 요일
		// 다음 달의 첫 번째 요일
		// 달의 첫번쨰 요일이 시작하는 날
		// DayOfWeek.SATURDAY
		
		int year = 2024;
		int month = 12;
		
		LocalDate firstDayOfMonth = LocalDate.of(year, month, 1);
		LocalDate firstDayOfNextMonth = firstDayOfMonth.plusMonths(1);
		
		int offset = firstDayOfMonth.getDayOfWeek().getValue() % 7;
		
		System.out.println("Su Mo Tu We Th Fr Sa");
		for (int i = 0; i < offset; i++) {
			System.out.println("    ");
		}
		
		LocalDate ldt = firstDayOfMonth;
		
		while (ldt.isBefore(firstDayOfNextMonth)) {
			System.out.printf("%2d ", ldt.getDayOfMonth());
			if (ldt.getDayOfWeek() == DayOfWeek.SATURDAY) {
				System.out.println();
			}
			ldt = ldt.plusDays(1);
		}
		
		
		
		
		
	}
}
