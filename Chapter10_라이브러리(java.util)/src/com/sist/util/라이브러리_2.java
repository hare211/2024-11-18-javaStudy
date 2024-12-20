package com.sist.util;

import java.util.StringTokenizer;

// StringTokenizer
/*
 * givDev 풀더
 *  - 이클립스 paste 
 *  - projectStudy 
 */
/*
 * 1. 자른 데이터를 읽기 => nextToken() // 몇 개를 잘랐는 지 알 때
 * 2. 총 자른 개수 : counterTokens()
 * 3. 자른 데이터가 있는 동안(Loop) : hasMoreTokens() // 몇 개를 잘랐는 지 모를 때
 * 		=> 영화 출연진 => , -> 자른 개수만큼 데이터를 가져와달라
 * 4. 일반 데이터형 => 사용 빈도 많다
 * 5. 네트워크 입출력
 */
// split 구분자를 통한 String 제어는 값이 너무 많기 때문에 제어가 어렵다.
// StringTokenizer 를 통해 한 번에 저장하여 나열한다.
public class 라이브러리_2 {
	public static void main(String[] args) {
//		String data = "현빈 ,  박정민 ,  조우진 ,  전여빈 ,  박훈 ,  유재명 ,  릴리 프랭키 ,  이동욱";
//		StringTokenizer st = new StringTokenizer(data, ",");
//		// new StringTokenizer(data) => " "
//		System.out.println("출연 총 인원 : " + st.countTokens() + " 명");
//		while (st.hasMoreTokens()) { // 자른 개수만큼 루프
//			System.out.println(st.nextToken().trim()); // 자른 String 값을 반환.공백제거
//		}
		String make = "그릭요거트 4 큰 술, 땅콩버터 1 큰 술을 고르게 섞어 줍니다.^https://recipe1.ezmember.co.kr/cache/recipe/2024/12/05/c608f60aeb98bbd3116a764c0dde400e1_m.jpg";
		StringTokenizer st = new StringTokenizer(make, "^");
		
		System.out.println("레시피 제작법 : " + st.nextToken());
		System.out.println("레시피 이미지 : " + st.nextToken());
		
		/*
		 * 서버, 클라이언트 작성
		 * 100|admin|1234 | 을 StringTokenizer 로 잘라서 아래 코드로 로그인 코드 작성
		 * 1. 클라이언트 => 서버로 데이터 전송
		 * 		100|admin|1234
		 * 		switchj = h(protocol) {
		 * 			case 100:
		 * 				로그인
		 * 		}
		 * 
		 * 		200|
		 */
	}
}
