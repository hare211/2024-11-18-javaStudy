package com.sist.main;
import java.util.*;
import com.sist.seoul.Seoul;
import com.sist.seoul.SeoulLocation;
import com.sist.seoul.SeoulNature;
import com.sist.vo.*;
/*
 * 1. 클래스
 * 		멤버 변수 / 메소드 / 생성자
 * 2. 캡슐화 : getter / setter
 * 3. 상속 => 포함
 * 4. 추상 클래스 / 인터페이스
 * 				=> 추상 클래스 보완
 * 5. 예외 처리
 * 
 * 형식, 개념, 프로그램
 */

public class UserMain {
	public static void main(String[] args) {
		Seoul seoul = null;
		Scanner scanner = new Scanner(System.in);
		System.out.print("1. 명소 | 2. 자연 : ");
		int type = scanner.nextInt();
		
		if (type == 1) {
			seoul = new SeoulLocation();
		} else {
			seoul = new SeoulNature();
		}
		
		while (true) {
			System.out.println("===== Menu =====");
			System.out.println("1. 전체 목록");
			System.out.println("2. 상세보기");
			System.out.println("3. 검색");
			System.out.println("4. 종료");
			System.out.println("================");
			System.out.print("메뉴 선택 : ");
			int menu = scanner.nextInt();
			
			if (menu == 1 ) {
				SeoulVO[] datas = seoul.seoulAllData(type);
				for (SeoulVO vo : datas) {
					System.out.println(vo.getNo() + ". " + vo.getName());
				}
			}
			
			else if (menu == 4) {
				System.out.println("프로그램 종료");
				break;
			}
		}
	}
}
