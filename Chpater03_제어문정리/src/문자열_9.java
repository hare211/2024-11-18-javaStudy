/*
 * 	replaceAll("", "")
 * 	
*/
public class 문자열_9 {
	public static void main(String[] args) {
		String data = "Hello 자바 1234";
		// 한글 외 모두 제외
		System.out.println(data.replaceAll("[^가-힣]", ""));
		// 한글만 제외
		
		// 영문만 출력
		System.out.println(data.replaceAll("[^A-Za-z]", ""));
		
		// 숫자
		System.out.println(data.replaceAll("[^0-9]", "")); // ^ => ^ 이후 " " 외 모두 공백으로
	}

}
