// 60점 이상이면 합격 / 불합격
public class 자바제어문_단일조건문6 {
	public static void main(String[] args) {
		int score = (int)(Math.random() * 101);
		
		System.out.println(score >= 60 ? "합격" : "불합격");
	}
}


