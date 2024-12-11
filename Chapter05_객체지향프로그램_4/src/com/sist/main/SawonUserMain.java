package com.sist.main;
import com.sist.vo.*; // 라이브러리, 사용자 정의 => 패키지가 다른 경우 import 를 사용해서 사용
public class SawonUserMain { // 끔찍함

	public static void main(String[] args) {
		Sawon hong = new Sawon(1, "홍길동", "개발부", "대리", "2021-10-10", 3600);
		// 변수 => 읽기 / 쓰기
		// 초기화 => 생성자 => 변경이 불가능
		// 나머지 변경 => Setter
		// 출력
		System.out.println("===== 홍길동 사원 정보=====");
		System.out.println("사번 : " + hong.getSabun() + "\n이름 : " + hong.getName() 
						+ "\n부서 : " + hong.getDept() + "\n직위 : " + hong.getJob() 
						+ "\n입사일 : " + hong.getRegdate() + "\n연봉 : " + hong.getPay());
		// 변경
		hong.setDept("영업부");
		hong.setJob("과장");
		hong.setPay(4200);
		
		System.out.println("===== 홍길동 사원 정보=====");
		System.out.println("사번 : " + hong.getSabun() + "\n이름 : " + hong.getName() 
						+ "\n부서 : " + hong.getDept() + "\n직위 : " + hong.getJob() 
						+ "\n입사일 : " + hong.getRegdate()+ "\n연봉 : " + hong.getPay());
	}
}
