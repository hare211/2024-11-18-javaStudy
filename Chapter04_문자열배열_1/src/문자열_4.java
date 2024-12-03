
public class 문자열_4 {
	public static void main(String[] args) {
		String s1 = "Hello Java";
		String s2 = "Hello Java";
		String s3 = new String("Hello Java");
		// 대소문자 구분 / equlasIgnoreCase() 구분 X
		// equals 문자열 비교 / == 참조값 비교
		if (s1 == s3) {
			System.out.println("s1 == s3");
		} else {
			System.out.println("s1 != s3");
		}
	}

}
