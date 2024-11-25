/*
 * 	선택문 : 다중조건문을 단순화 시킨 제어문 
 *           => 한개만 수행이 가능 
 *           => 게임 / 네트워크 
 *           => ------------ 값을 한개만 선택(선택문) , 범위(다중조건문)
 *                           -------
 *           => 웹에서 사용 빈도가 거의 없다 
 *              if / if~else / for / while / break 
 *              ==================================
 *    1. 형식)
 *            switch(정수|문자|문자열)
 *                           ----
 *            1) 정수 => 메뉴 
 *                  no=0
 *                    | 0 => 처리문장 0,1,2,3,4까지 처리 
 *            switch(no) => 0,1,2..
 *            {
 *              case 0:
 *                 처리문장 1
 *                 break; => 종료 break는 반드시 주는 것은 아니다 
 *                           같은 내용을 실행할때가 있다 
 *              case 1:
 *                 처리문장 2
 *                 break;
 *              case 2:
 *                 처리문장 3
 *                 break;
 *              default: ==> else => 해당번호가 없는 경우에 처리  
 *                 처리문장 4
 *            }
 *            
 *            예) 
 *               90~100 => A => 90~100 => 10 => case문장을 최대한 줄여서 사용 
 *               case 10:
 *               case 9:
 *                 A
 *                 break
 *               
 *               case 10: case 9: ==> if(score==10 || score==9)
 *                   처리문장 
 *                   break;
*/
// 다중조건문 동일 => 한 개의 case 에 있는 문장만 수행
public class 자바선택문_1 {
	public static void main(String[] args) {
		int score = (int)(Math.random() * 101);
		int avg = score / 10; // 0 ~ 10
		
		
		// 다중조건문보다 가독성이 좋다
		// ========= 범위를 지정하기 때문에 => 페이징
		// 선택문은 범위 지정이 불가능
		// => 데이터베이스는 10000 단위 가능
		switch (avg) {
		case 10:
		case 9:
			System.out.println(score + "점은 A 등급입니다");
			break;
		case 8:
			System.out.println(score + "점은 B 등급입니다");
			break;
		case 7:
			System.out.println(score + "점은 C 등급입니다");
			break;
		case 6:
			System.out.println(score + "점은 D 등급입니다");
			break;
		default:
			System.out.println(score + "점은 F 등급입니다");
			break;
		}
	}

}
