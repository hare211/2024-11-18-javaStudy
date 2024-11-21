// 사용자로부터 값을 받아서 => 합격 => 60 점 이상 
import java.util.Scanner;
public class 연산자_삼항연산자2 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		// 클래스 객체명	|메모리 생성 생성자
		System.out.print("0 ~ 100 사이의 점수 입력 : ");
		int score = scanner.nextInt();
		
		System.out.println(60 <= score ? "합격" : "불합격");
	}

}
