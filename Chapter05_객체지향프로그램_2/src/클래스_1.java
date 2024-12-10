/*
 * 객체 지향 프로그램(OOP)
 * ------------------
 * 1. 독립적으로 작동이 가능
 * 	  ------- 
 * 	  1) 변수 2) 메소드 => 모아서 연결
 * 						--------- 객체
 * 						--------- 설계 => 클래스
 * 	  => 기계 : 부품(객체) => 조립(객체를 조립)
 * 							-- 재사용
 * 	  => 부품(컴포넌트) => 컴포넌트 여러 개를 묶어서 조립
 * 						----------------------
 * 						| 컨테이너
 * 	2. 변수가 많거나 소스가 길어지면 => 분석, 수정하기 어렵다
 * 		=> 보완
 * 		=> 동일한 목적이나 기능을 수행하는 변수나 메소드 묶어서
 * 			한 개의 파일을 제작(객체)
 * 			객체끼리 상호 통신(메소드) 전체 프로그램
 * 			------------------------------
 * 			예)
 * 				컴퓨터
 * 					CPU / HDD / GPU / Memory...
 * 					---------------------------
 * 					| 메인보드(조립)
 * 					사이트
 * 						회원 관련, 예약 관련, 구매(장바구니)
 * 						커뮤니티, 영화 관련
 * 
*/
class Member2 {
	// 자동으로 초기화 된다
	// int = 0, long = 0L, String = null, boolean = false, double = 0.0
	/*
	 * 필요 시 명시적 초기화
	 * String id = "hong"; *** 우선순위
	 * 명시적 초기화가 불가능
	 * 	=> 구현해서 처리(제어문, 연산처리, 라이브러리)
	 * 	=> 쿠키 읽기 => 초기화
	 * 	=> 파일 읽기
	 * 	=> 데이터베이스 연동
	 * 	=> 생성자 / 초기화 블록
	 * 클래스 블록에서는 선언만 가능
	*/
	String id;
	String name;
	// 생성자가 추가
}
class MemberSystem { // 따로 저장해야 하는 것은 static X, 공유는 O 
	static Member2[] members = new Member2[10]; // Member => null
}
public class 클래스_1 {
	public static void main(String[] args) {
		MemberSystem ms1 = new MemberSystem();
		ms1.members[0] = new Member2();
		ms1.members[0].id = "hong";
		ms1.members[0].name = "홍길동";
		
		System.out.println("아이디 : " + ms1.members[0].id);
		System.out.println("이름 : " + ms1.members[0].name);
		
		MemberSystem ms2 = new MemberSystem();
		//ms2.members[0] = new Member(); // 새로운 메모리 할당
		System.out.println("아이디 : " + ms2.members[0].id);
		System.out.println("이름 : " + ms2.members[0].name);
	}

}












