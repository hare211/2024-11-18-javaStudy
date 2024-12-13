package com.sist.main;

import java.util.ArrayList;
import java.util.Arrays;

/*
 * 1. 상속
 * 2. 포함 : has - a : 클래스 안에 클래스를 포함
 * 	객체 전체가 4 byte 를 가지고 있다
 * 	=> 형변환
 * 		자동 형변환(묵시적 형변환)
 * 		=> 상위 클래스 객체 = new 하위 클래스 생성자()
 * 			double d = 10 => 10.0
 * 		강제 형변환
 * 		=> int a = (int) 10.5
 * 			하위 클래스 객체 = new 상위 클래스() => 오류 
 * 			하위 클래스 객체 = (하위 클래스) new 상위 클래스()
 * 			=> 라이브러리는 클래스를 리턴할 경우 => Object 리턴하기 때문에 형변환을 해야한다 
 */
class Sawon {
	String name, dept, loc;
	
	public void display() {
		System.out.println("이름 : " + name);
		System.out.println("부서 : " + dept);
		System.out.println("근무지 : " + loc);
	}
}
public class 재사용 {
	public static void main(String[] args) {
		ArrayList<Sawon> list = new ArrayList<Sawon>();
//		ArrayList list = new ArrayList(); 
		Sawon s1 = new Sawon();
		
		s1.name = "홍길동";
		s1.dept = "개발부";
		s1.loc = "서울";
		list.add(s1);
		s1.display();
		
		Sawon s = list.get(0);
		s.display();
		//Sawon s = (Sawon) list.get(0); // 형변환
		//s.display();
	}
	

}
