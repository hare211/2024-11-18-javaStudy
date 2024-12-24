package com.sist.main;
/*
 * Collection Framework
 * 1) 다수의 데이터를 쉽고 효율적으로 처리가 가능하게 만든 표준화, 라이브러리, 클래스의 집합
 * 2) 자료구조 => CRUD(추가 / 읽기 / 수정 / 삭제)
 * 3) 배열의 단점 보완 => 고정 => 가변
 * 		=> 동적으로 변환(메모리 추가, 삭제 자동 조절)
 * 4) 단점 => 모든 데이터를 저장할 수 있다
 * 			--------- 제어하기 어렵다(Object)
 * 			| 한 가지 데이터형만 저장해서 사용하는 것을 권장
 * 			  ------------
 * 			  | 제네릭을 이용한다
 * => 제네릭
 * 	1) 데이터형 통일화(Object => 원하는 데이터형으로 변경)
 * 	2) 소스가 간결하다
 * 	3) 어떤 데이터를 저장하는 지 확인이 가능(명시적)
 * 	4) 형변환이 필요없다
 * 	5) 컬렉션에서 주로 사용
 * 	6) 제네릭을 지정 시에는 반드시 클래스형으로만 사용이 가능
 * 		=> 기본형은 사용할 수 없다
 * 		   ----------------- 자바에 지원 => Wrapper
 * 			Wrapper : 기본형을 클래스화
 * 			형식) List<int> => X
 * 			     List<Integer>
 * 				 List<double> => List<Double>
 * 			=> T / E / K / V
 * 				type => 클래스
 * 				element => 클래스
 * 				key => 문자열
 * 				value => Object
 * 		class Box<T> {
 * 			T t;
 * 			public void setT(T t) {
 * 				this.t = t;
 * 			}
 * 			public T getT() {
 * 				return t;
 * 			}
 * 		}
 * 		Box box = new Box(); => T(Object)
 * 		Box<String> box = new Box<String>() => T => String
 * 		=> T 가 한 번에 지정된 데이터형으로 변경
 * 		=> 사용자 정의 클래스로 변경
 * 		Box<Sawon> => T => Sawon
 * 		
 * 			Collection => interface
 * 				|
 * 	-----------------------------
 * 	|			|				|
 * List		   Set			   Map => 인터페이스
 * 순서 O		  순서 X			key, value 를 동시에 저장
 * (인덱스)	  중복 X			key 중복 X
 * 중복 O						value 중복 O
 * 	|
 * 구현된 클래스
 * ArrayList
 * 	데이터베이스 : 목록
 * 	=> 브라우저로 전송
 * 	=> 웹
 * LinkedList
 * 	수정 / 삭제 / 추가 시 속도 빠름
 * 	=> 일반 윈도우(게시판)
 * 	=> 예제
 * Vector
 * 	동기화 => 네트워크
 * 	=> Vector 를 보완한 클래스 -> ArrayList
 * 	=> 같은 기능을 가지고 있다
 * 	   ---------------
 * 		add() : 추가
 * 		set() : 수정
 * 		get() : 읽기
 * 		remove() : 삭제
 * 	   --------------- CRUD
 * 					Create / Read / Update / Delete
 * 					추가		 읽기		수정		 삭제
 * 			=> 오라클	INSERT	 SELECT UPDATE	 DELETE
 * 		size() : 저장 개수
 * 		isEmpty() : 저장된 데이터가 있는 지 확인
 * 		clear() : 전체 삭제
 * 		-----------------
 * 		addAll() : 다른 List, Set 에 있는 데이터를 복사
 * 		subList / retain / contains()...
 * 		---------------------------------
 * 		=> 오라클 : MINUS / INTERSECT / UNION / UNIONA
 * 	Set
 * 		=> HashSet
 * 		=> TreeSet
 * 		1) List 데이터의 중복 제거
 */
public class 컬렉션_1 {

}





















