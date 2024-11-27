/*
 *   while문 : 반복횟수가 지정이 안된 상태 
 *   
 *   형식)
 *        초기값 ======== 1
 *          초기값 |
 *              조건식 
 *               | false ==> 종료
 *        while(조건식) = 2
 *        {      | true 문장 수행 
 *           반복수행문장 = 3
 *           증감식     = 4
 *        }
 *        
 *        사용처 : 데이터베이스 , 서버(자바서버 => 인터라넷) , 파일읽기 
 *                                | 사내 메신저 
 *                                | 게임 
 *               => 무한루프 while(true) 
 *                  | Front 
 *        while문은 실행이 안되는 경우 => 선조건 
 *        
 *        초기식 ========= 1
 *        do{
 *            반복수행문장 = 2
 *            증감식    === 3
 *        }while(조건식); == 4  ==> 후조건 : 무조건 1이상을 수행 
 *       
*/
public class 반복문_4 {
	public static void main(String[] args) {
		// 1 ~ 10 까지 출력
		
		int i = 1;
		while (i <= 10) {
			System.out.println(i + " ");
			i++;
		}
	}

}
