/*
 * 멤버 변수의 초기화
 * 	= 생성자 => 인스턴스 변수, static 변수의 초기화
 * 		=> 반드시 호출
 * 	--------------------------------------------- 
 * 	= 인스턴스 블록 => 인스턴스 변수, static 변수의 초기화
 * 	= static 블록 => static 변수의 초기화만 가능
 * 	--------------------------------------------- 호출 없이 자동 처리
 * 	-----------> 멤버의 초기화, 시작 동시에 처리 하는 기능
 * 					구현이 가능, 상속은 예외가 된다
 * 
 * 	=> 기본 초기화 => 명시적 초기화 => static 블록
 * 	=> 인스턴스 블록 => 생성자
 * 	=> 명시적 초기화 우선
 * 	=> 불가능 => 생성자, static 블록을 이용한다
 * 	=> ---------------------------------
 * 		구현
 * 
 * 	=> int[] arr = new int[5];
 * 
 * 		난수값 5 개를 초기화
*/
class Movie {
	int movieNo = 1; 
	static int id = 1;
	{ // 명시적 초기화
		// 인스턴스 블록
		System.out.println("인스턴스 블록 진입");
		movieNo = 2;
		System.out.println("인스턴스 블록에서 movieNo 변수 저장");
	}
	
	Movie() {
		System.out.println("생성자 호출");
		movieNo = 3;
		System.out.println("생성자에서 movieNo 저장");
	}
	static {
		System.out.println("static 블록 진입");
		id = 100;
		System.out.println("스태틱 블록에서 id 저장");
	}
}
public class 클래스_5 {
	public static void main(String[] args) {
		Movie m = new Movie();
		System.out.println(m.movieNo);
		System.out.println(Movie.id); // static 은 메모리 할당이 필요없다 => 생성자 호출이 필요없다
	}
}
