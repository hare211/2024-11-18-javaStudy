
public class 문자열_3 {
	public static void main(String[] args) {
		String movie = "1|movie|드라마|url";
		String[] data = movie.split("\\|"); // '|' 만 쓰면 X
		// 정규식 => *, +, ., |, ? => \\ 사용해야 함 // split() 구분자 별로 자른다
		
		for (String m : data) {
			System.out.println(m);
		}
	}

}
