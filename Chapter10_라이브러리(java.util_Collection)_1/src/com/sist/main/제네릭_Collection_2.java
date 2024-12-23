package com.sist.main;

import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// 제네릭 / 어노테이션 / 열거형 / 리플렉션
// 		  ----------------------- JSP (웹)
@Data
// 매개 변수가 있는 생성자
@AllArgsConstructor
// 매개 변수가 없는 생성자
@NoArgsConstructor
class Member {
	private int mno;
	private String name;
	private String sex;
	private String address;
	private String phone;
}
public class 제네릭_Collection_2 {
	public static void main(String[] args) {
//		ArrayList<Integer> list = new ArrayList<Integer>();
//		list.add(1);
//		list.add(2);
//		list.add(3);
//		
//		for (int i = 0; i < list.size(); i++) {
//			System.out.println(list.get(i));
//		}
//		ArrayList<String> list = new ArrayList<String>();
//		// ArrayList 안에 문자열만 저장한 후 관리
//		list.add("홍씨");
//		list.add("박씨");
//		list.add("이씨");
//		
//		for (int i = 0; i < list.size(); i++) {
//			System.out.println(list.get(i));
//		}
		// 사용자 정의 데이터형을 이용한 데이터 추가
		ArrayList<Member> list = new ArrayList<Member>();
		list.add(new Member(1, "홍씨", "남자", "서울", "010-2123-1233"));
		list.add(new Member(2, "심씨", "여자", "경기", "010-6666-7777"));
		list.add(new Member(3, "박씨", "남자", "부천", "010-5555-7777"));
		list.add(new Member(4, "이씨", "남자", "세종", "010-3288-8888"));
		list.add(new Member(5, "강씨", "남자", "광명", "010-5544-3333"));
		
		// 회원 => 인원수
		System.out.println("회원 인원 : " + list.size());
		
		// 회원 목록 출력
		for (Member m : list) {
			System.out.println(m.getMno() + ". " + m.getName());
		}
		
		System.out.println("서울에 사는 회원 목록");
		for (Member m : list) {
			if (m.getAddress().equals("서울")) {
				System.out.println(m.getName() + " " + m.getAddress());
			}
		}
	}
}
















