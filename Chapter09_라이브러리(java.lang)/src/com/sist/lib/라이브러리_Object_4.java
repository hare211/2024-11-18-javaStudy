package com.sist.lib;
/*
 *   equals() => Object 에서 객체 비교 
 *               String => equals() 문자열 비교 => 오버라이딩
 */
class Human
{
	String name;
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public Human(String n)
	{
		name=n;
	}

	// h1                  h2 => h1.equals(h2)
	// 문자열만 비교 
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Human)
		{
			Human s=(Human)obj; // 메소드 역할 => 형변환 
			return name==s.name;
		}
		else
			return false;
	}
	
	
}
public class 라이브러리_Object_4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Human h1=new Human("홍길동");
        Human h2=new Human("홍길동");
        //Human h2=h1;
        if(h1.equals(h2))
        {
        	System.out.println(h1+"=="+h2);
        }
        else
        {
        	System.out.println(h1+"!="+h2);
        }
	}

}