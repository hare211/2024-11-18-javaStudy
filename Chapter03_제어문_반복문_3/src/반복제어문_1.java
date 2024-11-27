/*
break ==> 사용하는 위치 반복문,선택문에서만 사용이 가능 
 *             조건문에서는 사용이 불가능 
 *             -----
 *             for()
 *             {
 *                if()
 *                {
 *                  break
 *                }
 *             }
 *             
 *             if() => 단독으로 사용시에는 사용할 수 없다 
 *             {
 *                break; => X
 *             }
 *             
 *             ==> 반복문이 선택문을 종료할 때 사용하는 제어문 
 *   continue : 반복문에서만 사용이 가능 
 *              조건문 / 선택문에서는 사용이 불가능 
 *              => 특정부분을 제외할때 사용 
 *              => for문에서는 증가식으로 이동 
 *              => while문에서는 조건식으로 이동 
 *   *** break,continue가 있는 경우에 다음에는 소스 코딩할 수 없다 
 *   
 *   for()
 *   {
 *      if()
 *      {
 *         // 소스 코딩 가능 
 *         break; => 종료
 *         // => 소스 코딩 불가능
*/
public class 반복제어문_1 {
	public static void main(String[] args) {
		for (int i = 1; i <= 10; i++) {
			if (i == 5) {
				continue; // i++ 로 이동 => 6 부터 출력된다
			}
			System.out.print(i + " ");
			
		}
	}

}
