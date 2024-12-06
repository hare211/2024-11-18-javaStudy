
public class 메소드 {
	static int plus(int a, int b) {
		return a + b;
	}
	static int plus(int a, int b, int c) {
		return a + b + c;
	}
	
	static int plus(int a, int b, int c, int d) {
		return a + b + c + d;
	}
	public static void main(String[] args) {
		int a = plus(3, 4, 3);
		System.out.println(a);
		a = plus(2, 2, 3, 10);
		System.out.println(a);
	}

}
