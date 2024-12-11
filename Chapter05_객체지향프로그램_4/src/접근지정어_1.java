/*
 * 	1. 주의점
 * 		1) static 메소드에서는 인스턴스 변수, 인스턴스 메소드를 사용할 수 없다
 * 			=> 사용 시에는 객체 생성 후에 사용이 가능
 * 		2) static 메소드, static 변수 this 를 사용할 수 없다
 * 		3) static 블록은 static 변수만 초기화 가능
 * 		4) 인스턴스 메소드에서는 인스턴스 변수, static 을 사용할 수 있다
 * 		5) 초기화 => 생성자를 이용하는 이유
 * 					-------- this, 인스턴스, static
 * 	2. 접근 지정어 => 객체 사용 범위 지정
 * 
 * 	=> 멤버 변수
 * 		[접근지정어] 데이터형 변수명
 * 		[접근지정어] [제어어] 리턴형 메소드명(매개변수)
 * 	=> 지역 변수에는 접근 지정어를 사용할 수 없다
 * 		메소드안에서 사용
 * 		=> final 만 사용이 가능 => 상수 / 변수
 * 클래스, 멤버변수, 메소드 => 접근 제어
 * 접근 지정어		적용대상				접근 가능 대상				접근 불가 대상
 * 	public : 클래스, 필드(멤버 변수)		모든 대상					X					
 * 			 생성자, 메소드
 * 
 * 	protected : 멤버 변수, 생성자		같은 풀더(패키지)			다른 풀더에서 사용이 불가능
 * 				메소드				또는 상속받은 클래스
 * 									=> 다른 풀더에 있는 경우
 * 
 * 	default : 클래스, 멤버 변수			같은 풀더에서만 접근 가능		다른 풀더에서 사용이 불가능		
 * 			  생성자, 메소드
 * 
 * 	private : 멤버 변수, 생성자			자신의 클래스 내부			클래스 외부에서는 사용 불가능
 * 			  메소드
 * 	=> 크기
 * 		private < default < protected < public
 * 		오버라이딩 => 접근 지정어 처리
 * 					=> 접근 지정어는 확장은 가능 => 축소는 안된다
 * 
 * 	*** 많이 사용
 * 		멤버 변수 => 은닉화 private
 * 		생성자, 클래스, 메소드 => 모든 클래스 연결 : public
 * 								= 다른 클래스에서 사용
 * 									= 다른 풀더에서 존재할 수 있다
 * 	제어어
 * 		=> static | abstract | final
 * 		static => 공통적인
 * 		final => 마지막 => 변수(상수), 메소드(종단), 클래스(종단) 
 * 									------------------- 
 * 									| 있는 그대로 사용
 * 									| String, Math, Scanner, System
 * 		abstract => 추상적인 => 공통 기능
 * 					=> 추상클래스, 인터페이스 => 구현(X)
 * 						-------------------- 미완성 클래스
 * 		-------- 클래스, 메소드에서만 사용이 가능
 * 		기능 설계
 * 		데이터베이스 : 데이터를 저장하는 장소
 * 				= 메모리 : 변수, 배열, 클래스 => 휘발성
 * 				= 파일
 * 				= 오라클
 * 		게시판 => CRUD
 * 				Insert Select Update Delete
 * 				Create Read Update Delete => SQL
 * 				생성	   목로
 * 
 * 
 * 	클래스 : public / default => public : 모든 클래스 사용
 * 	메소드 : public / default / private / protected
 * 			=> 메소드의 역할 : 다른 클래스와 통신(메세지) => public
 * 	생성자 : public
 * 	멤버 변수 : private(데이터 보호) => 은닉화
 * 				가정 => 메모리에서 보이지 않는다
 * 				=> 어떻게 통신
 * 				=> 변수 : 쓰기(메모리 저장), 읽기
 * 							=> 메소드로 처리 : getter / setter
 * 	지역 변수 : 접근 지정어가 필요없다(메소드안에서만 사용이가능)
 * 				=> 상수(final)
 * 	*** 객체지향의 3대 특성(권장)
 * 		1. 캡슐화 : 외부로부터 데이터 보호
 * 					데이터 송산(id, pw)...
 * 				=> 데이터 손상을 방지
 * 				   데이터를 감춘다
 * 					=> 필요한 경우에 메소드 기능을 이용해서 사용이 가능하게 만든다
 * 		2. 상속 : 재사용
 * 		3. 다형성 : 기능 추가, 기능 변경
 * 					오버로딩	오버라이딩
 * 		4. 추상화 : 중복 제거(공통적인 내용 모아서 관리)
 * 					=> 공통 모듈
*/
class Member {
	private String id; // Member 클래스 안에서만
	protected String guys; // 같은 풀더
	String hello; // 같은 풀더
	public String name; // 모든 클래스
}
public class 접근지정어_1 {
	public static void main(String[] args) {
		Member m = new Member();
		m.hello = "2";
		System.out.println(m.hello);
		m.hello = "3";
		System.out.println(m.hello);
	}
}






















