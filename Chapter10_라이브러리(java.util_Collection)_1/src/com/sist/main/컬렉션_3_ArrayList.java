package com.sist.main;

import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor // 매개 변수가 있는 생성자
// 디폴트 생성자
@NoArgsConstructor
class Student {
	private int hakbunl;
	private String name;
	private int kor, eng, math;
}
public class 컬렉션_3_ArrayList {
	public static void main(String[] args) {
		ArrayList list = new ArrayList(1); // 배열 고정 => 가변
		// 추가 시마다 자동으로 메모리가 늘어난다
		list.add(new Student(1, "홍길동", 90, 86, 70));
		list.add(new Student(2, "심씨", 93, 88, 72));
		list.add(new Student(3, "박씨", 92, 84, 74));
		list.add(new Student(4, "이씨", 97, 81, 77));
		list.add(new Student(5, "강씨", 96, 87, 75));
		// Student[] std = new Student[5];
		// => 사용자 정의 클래스를 저장할 수 있다.
		
		System.out.println("학생 인원 : " + list.size());
		for (Object obj : list) {
			Student s = (Student) obj; // 그대로 쓰면 Object 의 메서드만 있음 -> 형변환 필요
			String ss = String.format("%.2f", s.getKor() + s.getEng() + s.getMath() / 3.0);
			System.out.println(s.getHakbunl() + " " 
							 + s.getName() + " "
							 + s.getKor() + " "
							 + s.getEng() + " "
							 + s.getMath() + " "
							 + (s.getKor() + s.getEng() + s.getMath())
							 + " "
							 + ss);
							 
		}
	}
}
