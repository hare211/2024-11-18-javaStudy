package com.sist.lib;

import java.util.Objects;

/*
 *   hashCode() => 객체의 구분자 
 *   
 *   *** toString() => 오버라이딩 => 객체의 주소값을 출력 
 *   *** clone() => 복제해서 새로운 메모리에 저장 
 *   *** equals() => 객체 비교 (주로 주소값 => 재정의 : 멤버변수)
 *   finalize() => 소멸자 함수 (객체 메모리 해제 => 자동 호출)
 *   hashCode() => 객체마다 구분 번호를 가지고 있다
 *   
 *   Object클래스는 모든 데이터형 (기본형) , 모든 클래스 대입이 가능 
 *                                    -------------------
 *                                    | 사용시에는 반드시 형변환
 *                                    | 라이브러리 => 클래스를 매개변수,리턴형 사용시 대부분이 Object
 *                                    
 */
class Member2
{
	private int mno;
	private String name;
	
	public int getMno() {
		return mno;
	}
	public void setMno(int mno) {
		this.mno = mno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	// 초기화 
	public Member2(int mno,String name)
	{
		this.mno=mno;
		this.name=name;
	}
	
	public void print()
	{
		System.out.println("회원번호:"+mno);
		System.out.println("이름:"+name);
	}
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return Objects.hash(mno,name);
	}
	
	
}
public class 라이브러리_Object_5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Member2 m1=new Member2(1, "박문수");
        Member2 m2=new Member2(1, "박문수");
        
        System.out.println("m1:"+m1);
        System.out.println("m2:"+m2.toString());
        
        System.out.println("m1:"+m1.hashCode());
        System.out.println("m2:"+m2.hashCode());
        
        if(m1.hashCode()==m2.hashCode())
        {
        	System.out.println("m1==m2");
        }
        else
        {
        	System.out.println("m1!=m2");
        }
	}

}