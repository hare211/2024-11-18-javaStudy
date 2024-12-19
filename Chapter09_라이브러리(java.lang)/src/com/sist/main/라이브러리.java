package com.sist.main;
/*
 * 자바에서 지원하는 라이브러리
 * 				-------- 프로그램에 필요한 클래스를 모아서 개발 시 사용
 * => 라이브러리 중심 => 조립
 * => Scanner / System / String...
 *  라이브러리
 *  	1) 자바에서 지원
 *  	-	java.lang
 *  	=>	Object
 *  		System
 *  		String
 *  		StringBuffer
 *  		Math
 *  		Wrapper
 *  		------
 *  		Integer
 *  		Double
 *  		Boolean
 *  		Byte
 *  		Float
 *  		Long
 *  
 *  	-	java.util
 *  	=>	Scanner
 *  		Date / Calendar
 *  		Collection
 *  		-----------> 배열 대체
 *  		List / Set / Map
 *  		----------------- interface	  |Queue
 *  		List : ArrayList, Vector, LinkedList, Stack
 *  		Set : TreeSet / HashSet : 중복 없는 데이터
 *  		Map : HashMap / HashTable
 *  	-	java.io
 *  	=>	FileReader / FileWriter
 *  		InputStream / OutputStream
 *  		BufferedReader / BufferedWriter
 *  		BufferedInputStream / BufferedOutputStream
 *  		File
 *  		~Stream, Reader / Writer
 *  		-------	 ---------------
 *  		 1byte		  2byte(한글포함)
 *  		  |네트워크, 파일업-다운로드
 *  		입출력 : 파일 / 메모리 / 네트워크
 *  	-	java.sql
 *  	=>	Connection
 *  		Statement
 *  		ResultSet
 *  	-	java.net
 *  	=>	URL / ServerSocket / Socket
 *  	-	java.text
 *  	=>	SimpleDateFormat / MessageFormat / DecimalFormat
 *  	-	java.reflect
 *  	=>	리플렉션 => 메소드 / 클래스 / 변수 / 생성자
 *  	****Annotation, enum
 *  	J2Se
 *  	웹 라이브러리 : JSP / Servelt / Spring => 2차 자바
 *  	J2EE
 *  	J2ME(X) => Kotlin => Dart(Flutter)
 *  
 *  
 *  		=> javax.http
 *  		=> savax.servlet.http
 *  		=> org.spingframework
 *  
 *  	Java / Oracle / JSP / Spring / Spring-Boot
 *  			| MyBatis / JPA
 *  			| Oracle / MySQL(MariaDB)
 *  	------------------------------------------ Back
 *  	HTML / CSS / JavaScript / TypeScript
 *  	-----------------------
 *  					|
 *  					JQuery / VueJS / ReactJS / NodeJS / NextJS
 *  					-------------------------------------------
 *  	1. 데이터 분석 : 파이썬(넘파이, 판다스, Matplotlib) 
 *  					Spring <=> 파이썬 - Django
 *  	2. 검색 엔진 : ElasticSearch : CRUD / 검색
 *  
 *  	2) 외부업체 지원 /JSoup lombok / Spring
 *  		=> my.repository.com...
 *  		=> simple-json / bson
 *  	3) 사용자 정의 : 잘 만들어진 클래스 / 자주 쓰이는 클래스
 *  		=> .jar
 *  		=> 1차 => JSP(MVC => Spring 형식)
 *  	===================================================================
 *  	9장
 *  	java.lang 패키지
 *  	1) import 생략 => 자동 추가
 *  		=> 가장 많이 사용한 라이브러리(String, System)
 *  	2) 대표 클래스
 *  		= Object : 모든 클래스의 상위 클래스
 *  				   ---------- Object 상속을 받는다
 *  		  public class A extends Object
 *  						 ---------------> 생략
 *  		= 모든 클래스에서 사용하는 기능(메서드)
 *  		= toString() : 객체 주소
 *  			=> 명시적 / 묵시적
 *  			A a = new A();
 *  			 => System.out.println(a.toString())
 *  			 => System.out.println(a)
 *  			=> 자주 사용 된다 / 객체의 값이 정상적으로 처리 확인
 *  			=> 객체를 문자열화 시킨다
 *  		= clone() : 객체를 복사할 경우
 *  			=> 객체 복사
 *  				얕은 복사 => 같은 주소를 이용
 *  				-------    Call By Reference
 *  				깊은 복사 => clone => 새로운 메모리에 저장
 *  				-------    게임(아바타) => prototye
 *  		= finalize() : 소멸자 => 메모리 해제 시에 자동 호출
 *  		  --------- System.gc() : 바로 회수
 *  					프로그램 종료 시에 회수
 *  		= equals() => 객체 비교 => 재정의(오버라이딩)
 *  		= hashCode() => 비교
 */
class Student {
	
	private String name;
	private String phone;
	private String address;
	
	// 접근 가능 => 메서드
	public Student(String name, String phone, String address) {
		/*
		 * 지역 변수 / 매개 변수
		 * 
		 * 1. 지역 변수, 매개변수 찾기
		 * 2. 멤버 변수
		 * 
		 * ** 지역 변수 우선 순위
		 */
		this.name = name;
		this.phone = phone;
		this.address = address;
	}
	public void print() {
		System.out.println("이름 : " + name);
		System.out.println("주소 : " + address);
		System.out.println("번호 : " + phone);
	}
	@Override
	public String toString() {
		System.out.println("이름 : " + name);
		System.out.println("주소 : " + address);
		System.out.println("번호 : " + phone);
		return super.toString();
	}
	
}
public class 라이브러리 {
	public static void main(String[] args) {
		Student s1 = new Student("홍길동", "010-1111-1111", "서울");
		Student s2 = new Student("심청이", "010-2222-2222", "경기");
		
		//s1.print();
		System.out.println(s1); // toString 생략되어있음 -> 객체 출력 시 자동으로 toString() 호출
		//s2.print();
		System.out.println(s2.toString());
	}
}

















