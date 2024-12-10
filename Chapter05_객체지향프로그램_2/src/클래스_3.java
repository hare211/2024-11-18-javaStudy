/*
 * static 메소드에서는 멤버 변수 사용 불가능(객체 생성하여 a.b 식으로 사용은 가능)
*/
class Member {
	int no = 100; // Heap => 멤버 변수
	Member() {
		System.out.println("this = " + this);
		int no = 200; // Stack (변수명 저장위치) => 지역 변수
		System.out.println(this.no + no);
		// 1. 지역 변수 우선
		// 지역 변수 => 매개 변수 => 멤버 변수
		// this => 클래스 자신이 가지고 있는 멤버(변수, 메소드)
	}
}
public class 클래스_3 {
	public static void main(String[] args) {
		Member m = new Member();
		System.out.println("m = " + m);
		// static 에서는 this 를 사용할 수 없다
		// this 인스턴스에서만 사용 가능
		// => 공유
	}
}
