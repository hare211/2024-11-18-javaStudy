package com.sist.main;
import java.util.*;

import lombok.Data;
/*
 * List
 * --- 순서가 있다 / 중복 허용 O
 * 		=> 웹 => 중복 허용(오라클)
 * Set
 * --- 순서가 없다 / 중복 허용 X 
 * 		=> List 에서 중복을 제거하는 역할
 * 		=> 장르 / 회원명 / 장바구니
 * 		=> 오라클 : DISTINCT -> 명령어
 * 
 * HashSet / TreeSet
 * -------	 -------
 * | 저장용	 | 검색
 * -------
 * | 웹 채팅 =>
 * 
 * ==========================================
 * 345 page
 * --------
 * Set
 * 	1) 저장되는 순서가 없다
 * 	   --------------- 출력이 다르게 나올 수 있다
 * 	2) 중복된 데이터는 허용하지 않는다
 * 	3) HashSet / TreeSet
 * 				 ------- 검색 속도 빠르다
 * 	4) 주요 메서드
 * 		= add() => 객체 추가(데이터 추가)
 * 		= remove() => 삭제 => remove(Object ob)
 * 		= isEmpty() => 데이터 저장 여부
 * 		= size() => 데이터 저장 개수
 * 		= iterator() => 순차적으로 데이터를 읽을 경우
 * 		= clear() => 모든 데이터 지울 경우
 * 	5) List 에서 중복된 데이터를 제거
 * 	6) 일반 데이터 => 중복 제거
 * 		객체 => 데이터 값이 같은 경우에는 데이터를 제거하지 못한다
 * 
 * 		Sawon s1 = new Sawon(1, "A", "A");	
 * 		Sawon s2 = new Sawon(1, "A", "A");	
 * 		hashCode() / equals() 를 재정의
 */
@Data
// hashCode, equals => 오버라이딩
class Sawon2 {
	private int sabun;
	private String name, dept;
	
	public Sawon2(int sabun, String name, String dept) {
		this.sabun = sabun;
		this.name = name;
		this.dept = dept;
		// 지역 변수 / 매개 변수 우선순위
		// => this. 은 생략 가능 => 구분자(멤버 변수와 지역 변수가 같을 때)
	}
}
public class 컬렉션_6_Set_1 {
    public static void main(String[] args) {
    	Sawon2 s1 = new Sawon2(1, "홍씨", "개발부");
    	Sawon2 s2 = new Sawon2(1, "홍씨", "개발부");
    	
    	System.out.println("s1 = " + s1);
    	System.out.println("s2 = " + s2);
    	
    	System.out.println("s1 = " + s1.hashCode());
    	System.out.println("s2 = " + s2.hashCode());
    	
    	if (s1.equals(s2)) {
			System.out.println("같은 사원");
		} else {
			System.out.println("다른 사원");
		}
    	
    }
}
