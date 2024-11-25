/*
 * 	10 개의 알파벳을 추출
 * 	사용자가 입력 => 몇 번째 위치하고 있는 지 확인
 *  A C D F Z H O P Q K
 *  
 *  => D => 3 번째 위치하고 있다 => index 구하는 방법
 *  		=> 크롤링 (웹에서 데이터 수집)
 *  
 *  => A ~ Z 사이 => 입력 => 몇 번째 위치
*/

import java.util.*;

public class 반복문_10 {
	public static void main(String[] args) {
		
	
	Scanner scanner = new Scanner(System.in);
	
	System.out.print("대문자 알파벳을 입력하세요 : ");
	char c = scanner.next().charAt(0);
	// Scanner 는 char 를 가지고 오는 것은 없다
	// => 문자열만 => 첫 번째 문자를 추출 => charAt(0)
	
	System.out.println("c = " + c);
	
	// 확인
	//System.out.println("몇 번째 위치 : " + (c - 64));
	
	int index = 1;
	
		
	for (char ch = 'A'; ch <= 'Z'; ch++) {
		if (ch == c) {
			break;
		}
		index++;
	}
	System.out.println(c + "는(은) " + index + " 번째 위치하고 있습니다.");
	/*
	 *	구구단 => 2차
	 *	페이징 => 1차 => 조건문
	*/
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	}

}
