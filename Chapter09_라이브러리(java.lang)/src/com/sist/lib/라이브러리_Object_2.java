package com.sist.lib;
// finalize() => 소멸자 함수 => 객체가 메모리에서 해제 => 자동 호출
class Sawon {
	private int sabun;
	private String name;
	
	public Sawon() {
		sabun = 1;
		name = "홍길동";
		System.out.println("객체 생성, 초기화 완료");
	}
	
	public void print() {
		System.out.println("사번 : " + sabun);
		System.out.println("이름 : " + name);
	}

	@Override
	protected void finalize() throws Throwable {
		System.out.println("사원 객체 소멸, Heap 영역에서 소멸");
	}
	
	// 소멸 여부 확인
}
public class 라이브러리_Object_2 {
	public static void main(String[] args) {
		// 객체 생명 주기
		Sawon sa = new Sawon(); // 객체 생성
		sa.print(); // 객체 활용
		sa = null; // 주소값 지우기
		
		// 직접해제
		System.gc(); // 가비지 컬렉션 호출 => null, 사용하지 않는 데이터 회수
		
		Object obj = 10;
		int i = (int) obj;
		/*
		 * Object obj = 10; => AutoBox => 일반 데이터형과 동일 취급
		 * int i (int) obj; => UnBox
		 * int a = (int) 10.5;
		 * 
		 * Object / String / Wrapper
		 */
		
		
	}
}
