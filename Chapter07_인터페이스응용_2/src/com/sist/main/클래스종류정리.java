package com.sist.main;
/*
 * 응용(X)
 * -----
 * => 목적
 * => 형식
 * => 기능 : 상속 / 형변환 / 오버라이딩
 * 			--------------------
 * 
 * 추상 클래스 / 인터페이스 => 같은 기능
 * 				-----
 * 				| 추상 클래스의 기능 보완
 * 				| 기능별로 모아서 처리
 * 				=> 윈도우 이벤트 처리
 * 				= Collection
 * 				1) 순서가 있다, 중복 데이터 저장 허용
 * 					List => ArrayList / LinkedList / Stack
 * 											|
 * 										Queue
 * 				2) 순서가 없다, 중복 데이터 저장을 허용하지 않는다
 * 					Set => TreeSet / HashSet
 * 				3) 키, 값을 동시에 저장, 키 중복이 없다, 중복 데이터 저장 허용
 * 					Map => HashMap, HashTable
 * 				= 기능별 분리
 * 				= 데이터베이스
 * 					= Connection / Statement / ResultSet
 * 				= 네트워크 연결
 * 					= Socket
 * 				= 쓰레드
 * 					= Thread => run()
 * 				--------------------- 라이브러리
 * 				사용자 정의 => 인터페이스, 추상 클래스
 * 						 => 공통으로 적용되는 기능
 * 						 => 웹 : 사용자 요청 받기
 * 								처리 결과값 보내기
 * 					| 관련된 클래스 모아서 관리
 * 					---------------------- 인터페이스
 *	=> 형식
 *	=> 기능
 */
class A {
	void aa() {
		System.out.println("aa");
	}
}
public class 클래스종류정리 {
	static void a () {
		System.out.println("a");
	}
	public static void main(String[] args) {
		
		Object obj = new Object();
		String str = "";
		StringBuffer sb = new StringBuffer();
		
		if (obj instanceof Object) {
			System.out.println("obj는 object 클래스");
		}
		if (str instanceof Object) {
			System.out.println("OK1");
		}
		if (sb instanceof Object) {
			System.out.println("OK2");
		}
		if (obj instanceof String) {
			System.out.println("OK3");
		}

	}

}
