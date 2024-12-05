// 메소드형 숫자 야구 게임
import java.util.*;
public class 메소드응용_변경 {
	// 중복 없는 난수 (3 개의 정수)
	static int[] random() {
		int[] com = new int[3];
		
		for (int i = 0; i < com.length; i++) {
			com[i] = (int) (Math.random() * 9) + 1;
			for (int j = 0; j < i; j++) {
				if (com[i] == com[j]) {
					i--; // 같은 정수가 있는 경우
					break;
				}
			}
		}
		
		return com;
	}
	// 사용자 입력 => 유효성 검사
	// 힌트 제공
	// 종료 여부
	// 전체 조합 => 새로운 게임 여부 확인
	public static void main(String[] args) {
		
	}

}
