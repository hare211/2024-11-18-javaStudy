package com.sist.lib;
import java.util.*;
/*
 *    5장 
 *      클래스 구성 요소 
 *       => 멤버변수 / 메소드 / 생성자 
 *       => static 
 *    6장 
 *      상속 / 포함 
 *       => 상속 권한 (상속받는 클래스)
 *    7장 
 *      추상클래스 => 인터페이스 
 *                 --------- 오버라이딩 
 *    8장 
 *      try ~ catch 
 *      throws 
 *      
 *    ----------------------
 *    9장 
 *     Object 
 *     String 
 *    ----------------------
 */
class Movie
{
	private int mno;
	private String title;
	public int getMno() {
		return mno;
	}
	public void setMno(int mno) {
		this.mno = mno;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	public Movie(int mno,String title)
	{
		this.mno=mno;
		this.title=title;
	}
}
// getClass() => 클래스 타입 (패키지명 클래스명을 찾는 경우)
// => 객체 생성 => 복제 => 소멸 => 비교 => 타입 

public class 라이브러리_Object_5_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Movie m1=new Movie(1, "홍길동전");
        System.out.println(m1.getClass());// 데이터형 
        String s="";
        System.out.println(s.getClass());
	}

}
