import java.util.Scanner;

public class 문자열_2 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		String[] ids = {"admin", "hong", "park", "kim", "shim"};
		String[] pws = {"1234", "1234", "1234", "1234", "1234"};
		String[] names = {"이순신", "홍길동", "박문수", "김두한", "심청이"};
		
		// 로그인 처리
		System.out.print("ID 입력 : ");
		String id = scanner.next();
		
		System.out.print("Password 입력 : ");
		String pwd = scanner.next(); // pwd 암호화 / 복호화
		
		int count = 0;
		int index = 0;
		for (int i = 0; i < ids.length; i++) {
			if (ids[i].equals(id)) {
				count++;
				index = i;
				break;
			}
		}
		
		if (count == 0) {
			System.out.println("ID 가 존재하지 않습니다");
		} else { // ID 존재
			if (pws[index].equals(pwd)) { // 로그인 처리
				System.out.println(names[index] + "님 로그인 되었습니다");
			} else { // 비밀번호 틀린 경우
				System.out.println("비밀번호가 틀립니다");
			}
		}
		
		
		
	}

}
