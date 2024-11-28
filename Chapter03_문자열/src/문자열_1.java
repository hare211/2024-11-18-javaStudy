/*
 * 	String 클래스 => char[]을 제어
 * 	=> 문자 여러 개 저장하는 공간
 * 		-------- 문자열 : "" char => ''
 * 	=> 문자열을 저장하는 일반 데이터형식 / 기능(메소드)을 가지는 클래스형
 * 	=> 웹 / 윈도우 => 자바로 만들 수 있는 모든 프로그램의 핵심
 * 		=> 오라클 : varchar2 / clob, Mysql : varchar, text
 * 		=> C / C++ : 문자열이 없다 => char[], char*
 * 	=> 문자열 저장하는 방법
 * 		String name = "홍길동"
 * 		------ ----
 * 		 데이터형 변수명
 * 	=> 클래스형으로 저장하는 방법
 * 		String name = new String("홍길동");
 * 	=> String 에서 지원하는 기능(메소드)
 * 		# 메소드
 * 			리턴형(처리 결과값) 메소드명(매개변수...) {
 * 			--------------------------------
 * 			데이터형			|기능		|어떤 값을 첨부
 * 				요청처리
 * 				결과값 전송 return;
 * 			}
 * 			리턴형 : 결과값 1 개
 * 			매개변수 : 없는 경우 / 한 개인 경우 / 여러 개
 * 					 random()	substring() ---- substring(1, 4)
 * 					 length()
 * 			메소드 : 라이브러리 => 이미 만들어져 있는 상태
 * 					*** 사용자 정의 => 직접 만들어서 처리
 * 						-------- 조립
 * 			*** 객체지향 프로그램 : 변수 / 메소드
 * 			------------------------------
 * 		String 에서 사용하는 메소드
 * 		1) length() : 문자의 길이 (한글 / 알파벳) => 동일
 * 						* 알파벳 => 저장 시 1 byte : ASC / Unicode
 * 						* 한글 => 저장 시 2 byte : Unicode
 * 							=> "UTF-8"
 * 			예)
 * 				String word = "홍길동"
 * 				int len = word.length(); word 안에 있는 글자의 개수
 * 				=> len = 3
 * 				=> 비밀번호 글자수, 입력여부 확인
 * 					if (word.length() < 1) => 입력이 안된 상태
 * 				=> 유효성 검사
 * 		2) charAt => 원하는 위치의 문자 한 개 추출
*/
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
public class 문자열_1 {
	public static void main(String[] args) {
		String msg = "Hello Java";
//		int len = msg.indexOf("Java");
//		System.out.println(len);
		// 대소문자 구분
//		if(msg.contains("va"))
//		{
//			System.out.println("포함되어 있습니다");
//		}
//		else
//		{
//			System.out.println("포함되지 않는 문자입니다");
//		}
//		if(msg.startsWith("Hello"))
//		{
//			System.out.println("Yes");
//		}
//		else
//		{
//			System.out.println("No");
//		}

		/*
		String[] data = {
				"자바와 JSP",
				"혼자 배우는 자바",
				"스프링과 자바",
				"자바의 정석",
				"자바의 기초",
				"스프링 부트와 자바"
		};
		Scanner scanner =new Scanner(System.in);
		System.out.print("검색어 입력 : ");
		*/
		
		int a = 10;
		int b = 20;
		System.out.println(a + b);
		System.out.println(String.valueOf(a) + String.valueOf(b));
		System.out.println("10" + "20");
		
		String s = "s";
		
		
		/*
		Map<String, Integer> map = new HashMap<>();
		
		map.put("apple", 2);
		map.put("melon", 4);
		map.put("banana", 3);
		
		for (Map.Entry<String, Integer> entry : map.entrySet()) {
			System.out.println(entry.getKey() + " " + entry.getValue());
			
		}
		*/
		
	}

}
