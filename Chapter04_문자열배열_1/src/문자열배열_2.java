import java.util.*;
import com.sist.data.*;
public class 문자열배열_2 {
	public static void main(String[] args) {
		// 데이터 읽기
		String[] fdata = ArrayData.korEng;
		// 데이터 확인 / 출력
		Scanner scanner = new Scanner(System.in);
		System.out.print("과일명 입력 : ");
		String fruit = scanner.nextLine();
		
		
		for (String f : fdata) {
			if (f.contains(fruit)) {
				String change = f.substring(f.indexOf(":") + 1);
				System.out.println(fruit + "의 영문명 : " + change);
				break;
				
			}
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		scanner.close();
	}
}
