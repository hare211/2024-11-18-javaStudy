package com.sist.util;
import java.util.*;
/*
 * 
 */
public class 라이브러리_3 {
	public static void main(String[] args) {
		String color = "red|yellow|green|pink|magenta|blue|black|cyan";
		StringTokenizer st = new StringTokenizer(color, "|"); // split 은 정규식을 사용하기 때문에 | 전에 \\ 를 써야함.
		System.out.println("컬러 개수 : " + st.countTokens());
		// 초과 시에는 오류
		String color1 = st.nextToken();
		
		while (st.hasMoreTokens()) { // 토큰이 더 남아있나? => true, false
			System.out.println(st.nextToken());
		}
		/*
		 * hasMoreTokens
		 * 
		 * =>before First
		 * 
		 * red => st.nextToken() // 다음이 있으면 true, 없으면 false
		 * green => st.nextToken() // | boolean 값 반환
		 * ...
		 * => after last
		 */
	}
}
