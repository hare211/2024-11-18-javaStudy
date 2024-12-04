/*
 * 	메소드 호출 => 매개변수
 * 	1) Call By Value
 * 		=> 값만 전송
 * 	2) Call By Reference
 * 		=> 주소값 전송
*/
public class 메소드_6 {
	static void swap(int a, int b) {
		System.out.println("swap 메소드 진입");
		System.out.println("사용자가 요청한 값");
		System.out.println("a = " + a);
		System.out.println("b = " + b);
		System.out.println("swap 메소드 요청 완료");
	}
	// 시작 = 종료 = 자동 호출
	// 사용자 정의는 자동 호출이 안된다
	// Trace => 디버깅 => F6
	public static void main(String[] args) {
		System.out.println("main 시작");
		swap(10, 20);
		System.out.println("main 종료 => 프로그램 종료");
	}

}
