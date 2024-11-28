import java.util.Date;

public class 문자열_2 {
	public static void main(String[] args) {
		
		int sum = 0;
		double avg = 0;
		/*
		 * 변수 => 선언
		 * 초기화
		 * int = 0
		 * double = 0.0
		 * char = '/0'
		 * long = 0L
		 * float = 0.0F
		 * String = null => 메소드 주소가 없는 상태
		 * 			---- NullPointerException
		 * 			---- 모든 클래스가 메모리 할당이 안된 상태
		 * 
		 * 	1. 변수 설정 => 변경되는 값 확인
		 * 	2. 제어문 처리 => 어떤 제어문 사용 여부
		 * 	3. 연산 처리 => 사용자 요청 연산
		 * 	--------------- 웹 / 모바일 / 애플리케이션
		 * 	4. 결과값 출력 => 화면에 출력
		 * 		------- 브라우저 : HTML, 모바일 : Kotlin
		*/
		
		for (int i = 1; i <= 10; i++) {
			int num = (int)(Math.random() * 10) + 1;
			// 1 ~ 10
			System.out.print(num + " ");
			// 누적 => 평균
			sum += num;
		}
		// 평균 구하기
		avg = sum / 10.0;
		String msg = String.format("평균 %.2f", avg); // 출력 형식
		// %d : 정수, %f : 실수, %c : 문자, %s : 문자열
		// 날짜 변환, 학점, MessageFormat
		System.out.println("\n" + msg);
		System.out.println(new Date());
	}

}
