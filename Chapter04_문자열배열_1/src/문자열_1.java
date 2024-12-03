
import java.util.*;
public class 문자열_1 {
	public static void main(String[] args) {
		String[] name = {"홍길동", "박문수", "강감찬", "이순신", "김두한"};
		
		for (int i = 0; i < name.length; i++) {
			System.out.print(name[i] + " ");
		}

		System.out.println();
		for (String names : name) {
			System.out.print(names + " ");
		}
		System.out.println();
		System.out.println(Arrays.toString(name));
	}

}
