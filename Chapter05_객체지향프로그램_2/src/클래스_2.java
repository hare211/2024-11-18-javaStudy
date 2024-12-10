// 멤버 변수, 공유 변수의 초기화 => 값 주입
/*
 * 	구성요소 => 설계 => 메모리에 저장 후에 사용
 * 					------------------ 객체
 * 	클래스
 * 		= ***멤버 변수만 가지고 있는 경우 => 데이터형 클래스
 * 				사용자 정의 데이터형 : ~VO, DTO
 * 		= ***메소드만 가지고 있는 경우 => 액션 클래스(기능)
 * 				연결용 : 오라클 연결 / 브라우저 연결
 * 						-------		-------
 * 						~DAO		~Model(~Controller, ~Action)
 * 				브라우저 ============ 오라클(X)
 * 				----- HTML / CSS => 화면 UI
 * 				브라우저 ====== 자바 ====== 오라클
 * 					=> React => Class 형
 * 					=> React => Hooks => function
 * 					=> React => Redux
 * 					=> React => React-Query
 * 					=> React => Next
 * 		= 혼합형 : 변수 + 메소드
 * 
 * 	오버로딩의 조건
 * 		# 메소드명이 동일
 * 		# 리턴형은 관계 없다
 * 		# 매개 변수 => 개수나 데이터형이 다른 경우
 * 		# 접근지정어는 관계 없다
 * 		# 한 개 클래스 안에서 존재
 * 		class A
 * 			=> A()
 * 			=> A(int a)
 * 			=> A(int a, int b)
 * 			=> A(String s)
 * 		= 상속에서 예외
 * 		= 생성자가 필요한 위치
 * 			A() => 매개 변수가 없는 생성자 => 디폴트 생성자
 * 			*** 생성자가 없는 경우에는 컴파일러에 의해 생성
 * 				--------------- 디폴트 생성자
 * 	생성자의 용도
 * 		= 변수 초기화(명시적인 초기화가 안되는 경우)
 * 					=> 구현 후에 데이터 처리
 * 		= 시작과 동시에 처리하는 기능이 있는 경우
 * 		  윈도우 초기화 (화면 UI)
 * 		  파일 읽기...
 * 	생성자 호출 시
 * 		= new 생성자() = 메모리가 할당
 * 		= new 생성자() = 메모리가 할당
 * 		= new 생성자() = 메모리가 할당
 * 		  => 한 번만 호출
 * 
*/
class Student {
	int studentNum;
	String name, sex;
	Student(int studentNum, String name, String sex){
		this.studentNum = studentNum;
		this.name = name;
		this.sex = sex;
		System.out.println(this.studentNum + " " + this.name + " " + this.sex);
	}
	Student(String name, String sex){
		this(1, "d", "w");
		this.name = name;
		this.sex = sex;
		System.out.println(this.name + " " + this.sex);
	}
	Student() {
		System.out.println(this.name + " " + this.studentNum + " " + this.sex);
	}
}
public class 클래스_2 {
	public static void main(String[] args) {
		Student sdt = new Student(1876051277, "김", "남자");
		
		Student sdt1 = new Student("신", "남자");
		
		Student sdt2 = new Student();
		
	}
}





















