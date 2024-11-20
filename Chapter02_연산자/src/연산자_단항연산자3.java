/*
 * 	형변환연산자
 * 	==== long => int. char => int, byte => int
 * 		 int => double, double => int
 * 	숫자 / 문자(정수인식) => boolean 은 제외
 * 
 * 	데이터 형의 크기
 * 			<====				====>
 * 			DownCasting			UpCasting
 * 			:데이터 형을 작게		:데이터 형을 크게
 * 			=> 강제				=> 자동
 * 		byte < short < int < long < float < double
 * 				char
 * 
 * 		byte b = 10;
 * 		int i = b;
 * 				--- int 로 변경
 * 
 * 		int a = 10;
 * 		double d = a; ==> 10.0
 * 
 * 			10 + 10.5 ==> 20.5 => 연산은 같은 데이터 형만 처리가 가능
 * 			int  double
 * 			|		
 * 			10.0 + 10.5
 * 
 * 		*** 가장 큰 데이터 형으로 변경
 * 		*** int 이하 데이터 형(byte, char, short)은
 * 			byte + byte
 * 			100		50 => 150 => int
 * 			char + char = int
 * 			short + byte + char = int
 * 			byte + int = int
 * 			double + float = double
 * 
 *		*** 필요 시에는 강제로 변환
 *					=========== 형변환 연산식
 *		(int) 10.5 + (int) 20.5
 *			10			20		=> 30
 *
 *		=> 연산자 => () 최우선순위 연산자
 *		=> (3 + 5) * 2 = 16			
 * 
*/
public class 연산자_단항연산자3 {
	public static void main(String[] args) {
		int a = 10;
		double d = a;
		System.out.println(d);
		
		char c = 'A';
		int e = c;
		System.out.println(e);
		
		byte b1 = 100;
		byte b2 = 27;
		int b3 = b1 + b2;
		
		int a1 = 123456;
		double d1 = 123456.78;
		int res = (int)((d1-a1) * 100);
	}

}
