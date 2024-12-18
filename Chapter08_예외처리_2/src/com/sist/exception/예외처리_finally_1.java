package com.sist.exception;
/*
 * try ~ catch ~ finally
 * finally 생략 가능
 * 사용처 -> 파일 닫기, 오라클 연결 해제, 서버 연결 해제 => 반드시 닫아야 하는 것들
 * 정상, 오류 상관없이 무조건 수행
 */
import java.io.*; // 파일 읽기 -> CheckException
// check -> 확인 -> 반드시 -> 네트워크 관련
/*
 * FileReader fr;
 * try {
 * 	fr = new FileReader()
 * } catch (IOException e) {
 * 	
 * } finally {
 * 	fr (O)
 * }
 * 
 */
public class 예외처리_finally_1 {
	public static void main(String[] args) {
		/*FileReader fr = null;
		// 모든 클래스의 초기값은 null
		
		try {
			fr = new FileReader("C:\\javaDev\\seoul_nature.txt"); // File -> CheckException
			int i = 0; // 한 글자씩 읽어온다
			// => 정수형으로 'A' -> 65
			while ((i = fr.read()) != -1) {
				// -1 -> EOF
				System.out.print((char) i);
			}
		} catch (IOException e) { // Exception, Throwable
			e.printStackTrace();
		} finally { 
			try {
				fr.close(); // fr -> 예외
			} catch (IOException e2) {
				
			}
		} */
		// 자동 Resource
		try(FileReader fr = new FileReader("C:\\javaDev\\seoul_nature.txt")) { // 자동으로 파일 닫기 가능
			int i = 0;
			while ((i = fr.read()) != -1 ){
				System.out.println((char) i);
			}
		} catch(IOException e) {
			System.out.println(e.getMessage());
		}
	}
}
