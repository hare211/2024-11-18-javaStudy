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
 */
public class 컬렉션_1 {

}
