package com.sist.util;
import java.util.*;
import java.text.*;
public class 라이브러리_5 {
	public static void main(String[] args) {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-M-d");
		// MM => 09 => 정수형 변환 => 오류 -> 앞에 0 -> 8 진법으로 해석
		
		String today = sdf.format(date);
		
		StringTokenizer st = new StringTokenizer(today, "-");
		
		int year = Integer.parseInt(st.nextToken());
		int month = Integer.parseInt(st.nextToken());
		int day = Integer.parseInt(st.nextToken());
		
		Calendar cal = Calendar.getInstance(); // => getInstance() 싱글톤
		cal.set(Calendar.YEAR, year);
		cal.set(Calendar.MONTH, month - 1); // month 는 0 번 부터 시작 => - 1
		cal.set(Calendar.DATE, day);
		
		int week = cal.get(Calendar.DAY_OF_WEEK);
		String[] strWeek = {"", "일", "월", "화", "수", "목", "금", "토"};
		// week => 1 번 부터 DAY_OF_WEEK
		System.out.println(year + "년도 " + month + "월 " + day + "일은 " + strWeek[week] + "요일입니다.");
		
		
	}
}
