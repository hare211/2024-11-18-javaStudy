import java.util.*;
import java.io.*;
public class 제어문_다중조건문1 {
	public static void main(String[] args) throws Exception {
		Scanner scanner = new Scanner(System.in);

        System.out.print("인덱스 번호 입력 :");

        int index = scanner.nextInt();

        // Chrome 실행 파일 경로
        String chromePath = "C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe";

        // URL 초기화
        String url = "";

        // URL 설정
        if (index == 1) {
            url = "http://www.daum.net";
        } else if (index == 2) {
            url = "http://www.naver.com";
        } else if (index == 3) {
            url = "http://www.google.co.kr";
        } else {
            System.out.println("잘못된 인덱스 번호입니다.");
            return;
        }

        // 실행 명령어 구성
        Runtime.getRuntime().exec(new String[]{chromePath, url});
	}

}
