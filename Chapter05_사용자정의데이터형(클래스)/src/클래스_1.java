/*
 * 	데이터 저장하는 방법
 * 	---------------
 * 	변수 : 데이터 한 개 저장 => 데이터를 변경할 수 있다
 * 			읽기 (메모리에서 데이터를 가지고 온다)
 * 			쓰기 (메모리에 저장)
 * 			수정 (값 수정)
 * 			=> 데이터형 변수명 = 값;
 * 	상수 : 데이터 한 개 저장 => 데이터 변경이 불가능
 * 			읽기 (메모리에서 데이터를 가지고 온다)
 * 			쓰기 ( 메모리 저장)
 * 				final 데이터형 변수명 = 값;
 * 				=> 변수는 소문자로 시작
 * 				=> 상수는 전체 대문자
 * 	--------------- 변수와 상수가 많은 경우에는 제어 
 * 	배열 : 변수 여러 개를 한 개 이름으로 제어 (관리가 쉽다)
 * 			=> 고정적
 * 			=> 같은 데이터형만 모아서 관리
 * 	클래스 : 여러 개의 데이터를 저장할 수 있다
 * 			=> 고정적이 아니다 (원하는 개수만큼 저장이 가능)
 * 		=>
 * 			1) 데이터를 모아준다 => 한 개의 대한 정보
 * 				사람 => 사람 1 명에 대한 변수
 * 				학생 => 학생 1 명에 대한 정보 저장
 * 				영화 => 영화 정보 1 개
 * 	--------------- 메모리에 저장
 * 	파일
 * 	데이터베이스
*/
class Student {
	int studentNum;
	String name;
	int age;
}
public class 클래스_1 {
	public static void main(String[] args) {
		Student hong = new Student();
		hong.studentNum = 1;
		hong.name = "홍길동";
		hong.age = 20;
		
		System.out.println(hong);
		System.out.println(hong.age);
		System.out.println(hong.name);
		System.out.println(hong.studentNum);
		
		
		Student shim = new Student();
		shim.age = 21;
		shim.name = "심청이";
		shim.studentNum = 2;
		
		System.out.println(shim);
		System.out.println(shim.age);
		System.out.println(shim.name);
		System.out.println(shim.studentNum);
		
	}

}
