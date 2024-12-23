package com.sist.main;
/*
 * 제네릭
 * ----
 * 1) 데이터형을 변경해서 사용을 쉽게 한다
 * 		=> 리턴형 / 매개 변수 => Object => 원하는 데이터형으로 변경
 * 2) 한 번에 데이터형 통일이 가능하다
 * 3) 형변환 없이 사용이 가능 => 소스 간결 / 가독성
 * 4) Object 단점
 * 		=> 데이터 읽기가 어렵다(데이터의 통일성이 없는 경우에는 반복문을 사용할 수 없다)
 * => 배열과 동일 시 => 같은 데이터형만
 * 				  ----------- 제어가 쉽다
 * => 사용자 정의(X) => 표준화
 * => 사용법 <클래스형>
 * => 임시 데이터형
 * 		T / E / K / V
 * 		=> T / E => 클래스
 * 			type / element
 * 		=> K / V => Map
 * 			key / value
 * 
 * 	Box<String> b = new Box<String> // 명시적
 * 	T => String -> 설정하면 String 으로
 * 	Box b = new Box()
 * 	T => Object -> 설정하지 않으면 Object 로
 * 
 * 객체의 데이터형 안정성 => 제어문 사용이 편리하다
 * 형변환을 하지 않기 때문에 소스가 간결
 * 명시적으로 코딩 => 유지보수 시 어떤 데이터가 첨부되는 지 확인이 된다
 * 사용법
 * 	ArrayList<String>
 *	ArrayList<Integer>
 */
class Box<T> {
	T t; // String t
	public void setT(T t) { // String t
		this.t = t;
	}
	public T get() { // String t
		return t;
	}
}
public class 제네릭_Collection_1 {
	public static void main(String[] args) {
		Box<String> b = new Box<String>();
		b.setT("d");
	}
}

































