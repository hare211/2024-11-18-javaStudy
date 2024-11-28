/*
 * 1. 대소문자가 있는 문자열을 입력받아서 대문자는 소문자로 소문자는 대문자로 변경 예) abdDef => ABDdEf
 * 2. 문자열을 입력받아서 역순으로 출력하는 프로그램 작성
 * 
*/
import java.lang.*;
import java.util.Iterator;
public class 문자열_5 {
	public static void main(String[] args) {
		
		
		String str = "aaAA";
		String change = "";
		
		/*
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if ('A' <= c && c <= 'Z') {
				change += Character.toLowerCase(c);
			} else if ('a' <= c && c <= 'z') {
				change += Character.toUpperCase(c);
			}
		}
		System.out.println(change);
		*/
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if ('A' <= c && c <= 'Z') {
				change += c;
				change = change.toLowerCase();
			}
			if ('a' <= c && c <= 'z') {
				change += c;
				change = change.toUpperCase();
			}
		}
		System.out.println(change);
		
		
		/*
		System.out.println(new StringBuilder(str).reverse());
		*/
		/*
		for (int i = str.length() - 1; i >= 0; i--) {
			System.out.print(str.charAt(i));
		
		}
		*/
	}

}
