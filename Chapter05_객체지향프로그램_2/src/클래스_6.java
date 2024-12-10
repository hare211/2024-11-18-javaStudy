class Rand {
	int[] arr = new int[5]; // 저장이 안됨
	static int[] arr2 = new int[5]; // 이미 저장
	// 인스턴스 초기화 블록
	{
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int) (Math.random() * 100 ) + 1; 
		}
	}
	// 생성자 => 인스턴스 변수의 초기화는 보통 => 생성자
	// static 의 초기화 => static 블록에서 주로 사용
	Rand() {
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int) (Math.random() * 100 ) + 1; 
		}
	}
	
	static {
		for (int i = 0; i < arr2.length; i++) {
			arr2[i] = (int) (Math.random() * 100 ) + 1;
		}
	}
	
}
public class 클래스_6 {
	public static void main(String[] args) {
		Rand r = new Rand();
		// r => arr => 메모리가 따로 저장
		
		for (int i = 0; i < r.arr.length; i++) {
			System.out.println(r.arr[i]);
		}
		System.out.println();
		for (int i = 0; i < Rand.arr2.length; i++) {
			System.out.println(Rand.arr2[i]);
		}
		
		
	}
}
