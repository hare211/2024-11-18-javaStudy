/*
 * 프로그램 ======================= 저장 ============= 화면 UI ========= => 테스트 => 배포
 * 요구사항 분석					데이터 베이스								|		|
 * 																				발표(실행)
 * (벤치마킹)																단위 테스트(JUnit)
 * 	  |																	디버깅
 * 	기능 설정
 * 	필요한 데이터를 추출
 * 	===============			===============			==========		=========
 * 		|						|						출력				|
 * 		클래스 설계				메모리 할당								클래스와 클래스 연관
 * 		=> 메소드					=> new										|
 * 		=> 변수																클래스 다이어그램
 * 			|						|
 * 			유스케이스 다이어그램			정규 (1 ~ 3)
 * 		객체 : 현실 세계에 있는 모든 사물(Object) => OOP
 * 				| 단순화(시뮬레이션) => 가정
 * 					---- 추상화 : 누구나 생각하는 공통된 데이터를 추출
 * 						| 개발자만 알아보면 된다
 * 	예)
 * 		사원 관리
 * 		------
 * 		사번 / 이름 / 부서명 / 직위 / 입사일 / 근무지 / 연봉 / 성과급 => 멤버변수
 * 		출근한다 / 영업한다 / 점심 먹는다 => 메소드
 * 		
 * 		변수 추출 => 기능 추출 => 구현 => 사용
 * 					| 추가, 수정
 * 		=> 클래스는 사원 => 1 명에 대한 정보를 가지고 있다
 * 		=> 컴퓨터 => 1 개만 설계
 * 		=> 영화 => 1 개
 * 		=> 레시피 => 1 개
*/
// 변수 => 1. 기본형, 2. 배열, 3. 클래스
// 평점, 구분 번호, String, actor, String[]
// Card[]
/*
 * 	1. 클래스 구성요소
 * 	class ClassName {
 * 		---------------
 * 		변수
 * 			1. 변수의 종류
 * 				= 인스턴스 변수(객체 변수)
 * 				  new 이용해서 메모리 따라 저장이 가능하게 만든다
 * 				  인스턴스 : 메모리에 데이터가 저장 된 상태
 * 				  객체 = 인스턴스
 * 				= 공통 변수(정적 변수)
 * 				  모든 객체가 공통으로 사용하는 변수
 * 				  => 메모리 공간이 한 개
 * 		---------------
 * 		생성자
 * 		---------------
 * 		메소드
 * 		---------------
 *	}
 *	=> new : 클래스의 메모리 크기를 확인 후에 메모리를 할당
 *										--------
 *										메모리 공간 생성
 *										사용된 주소값을 객체
 *		생성자 : 변수의 초기값을 대입 => 메모리에 초기값을 넘겨준다
 *
 * 		=> new 생성자()		
 * 	class A {
 * 		int aa;
 * 		double dd;
 * 	}
 * 
 * 	A a = new A(); => 메모리 생성
 * 	----
 * 		|
 * 	--- a ---
 * 
 * 	---------	------------
 * 				  -- aa --
 * 				------------
 * 				  -- dd --
 * 				------------
*/

import java.nio.file.spi.FileSystemProvider;
import java.text.DecimalFormat;

class Recipe2 {
	String poster;
	String title;
	String chef;
	String chef_poster;
	int star;
	int hit;
	
	
}
public class 클래스_3 {
	
	public static void main(String[] args) {
		// 1. recipe 저장
		// 1. 데이터를 저장할 메모리 공간(메모리 할당)
		Recipe2 recipe1 = new Recipe2(); // 24 byte 메모리 생성
		// => 기본형, 클래스형 => 4 byte
		// => 데이터 초기화
		recipe1.poster = "https://recipe1.ezmember.co.kr/cache/recipe/2024/11/24/565de119b099835a80ffdfc4006583621_m.jpg";
		recipe1.title = "치킨너겟 교촌 허니콤보 만들기";
		recipe1.chef = "태형제맘";
		recipe1.chef_poster = "https://recipe1.ezmember.co.kr/cache/rpf/2024/10/24/1455cb2a66c286ac31d1c570f1276de11.jpg";
		recipe1.hit = 1845;
		recipe1.star = 5;
		// 변수값 지정
		// 저장된 데이터 출력
		System.out.println("레시피 포스터 : " + recipe1.poster);
		System.out.println("레시피 제목 : " + recipe1.title);
		System.out.println("쉐프명 : " + recipe1.chef);   
		System.out.println("쉐프 포스터 : " + recipe1.chef_poster);
		
		// 정수 => 변경
		DecimalFormat df = new DecimalFormat("###,###"); // 1,845 
		System.out.println(df.format(recipe1.hit));
		
		for (int i = 1; i <= recipe1.star; i++) {
			System.out.print("★");
		}
		
		System.out.println();
		
		Recipe2 recipe2 = new Recipe2(); 
		
		recipe2.poster = "https://recipe1.ezmember.co.kr/cache/recipe/2024/11/29/90f0a79083c1000c78cac7882ab984051_m.jpg";
		recipe2.title = "간단간식 데리야끼소스 데리야끼 떡볶이 안매운떡볶이 가래떡떡볶이";
		recipe2.chef = "쿡따라";
		recipe2.chef_poster = "https://recipe1.ezmember.co.kr/cache/rpf/2015/12/28/596415237fa788d9a68fa166bca6040b1.png";
		recipe2.hit = 161;
		recipe2.star = 5;
		
		System.out.println("레시피 포스터 : " + recipe2.poster);
		System.out.println("레시피 제목 : " + recipe2.title);
		System.out.println("쉐프명 : " + recipe2.chef);   
		System.out.println("쉐프 포스터 : " + recipe2.chef_poster);
		System.out.println(df.format(recipe2.hit));
		for (int i = 1; i <= recipe2.star; i++) {
			System.out.print("★");
		}
	}
}



























