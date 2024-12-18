package com.sist.exception;

import java.util.Arrays;

public class 예외처리_CheckException_예제_1 {
	public static void main(String[] args) {
		try {
			int[] lotto = new int[6];
			for (int i = 0; i < lotto.length; i++) {
				lotto[i] = (int) (Math.random() * 45) + 1;
				
				for (int j = 0; j < i; j++) {
					if (lotto[i] == lotto[j]) {
						i--;
						break;
					}
				}
			}
			// 정렬
			Arrays.sort(lotto);
			
			// 출력
			for (int i : lotto) { // Thread 부분만 try ~ catch 로 잡아도 됨. 부분적으로 try ~ catch 문을 사용하는 것을 권장
				Thread.sleep(1000); // Thread -> 예외처리 반드시 해야하는 클래스 
				System.out.print(i + " ");
			}
		} catch (InterruptedException ex) {
			ex.printStackTrace();
			
		} finally {
			System.out.println("프로그램 종료");
		}
	}
}
