/*
 * 	대입연산자
 * 	------- = int a = 10; => 뒤에서부터 처리
 * 			  10 을 a 에 대입
 * 	복합대입연산자
 * 	==========
 * 		+= => 여러 개 증가
 * 		-= => 여러 개 감소
 * 		*=
 * 		/=
 * 		%=
 * 		|=
 * 		^=
 * 		&=
 * 		<<=
 * 		>>=
*/
public class 연산자_이항연산자_대입연산자 {
	public static void main(String[] args) {
		int a = 10;
		a++;
		a++;
		a++;
		a++;
		a++;
		
		System.out.println("a = " + a);
		
		int b = 10;
		b += 5;
		
		System.out.println("b = " + b);
		
		int c = 10;
		c = c + 5;
		System.out.println("c = " + c);
		
		// 여러 번 증가 => 복합대입연산자 사용
		// 1씩 => 증감연산자 사용
	}

}
