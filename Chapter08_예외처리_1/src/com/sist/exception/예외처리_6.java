package com.sist.exception;
/*
 * 
 * 예외처리
 * 	=> 개발자 실수, 사용자 입력이 잘못된 경우, 시스템...
 * 	=> 소스 상에서 수정이 가능한 에러
 * 		---------------------
 * 	형식)
 * 		try {
 * 			정상 수행 문장
 * 			오류 발생 시 catch 문으로
 * 		} catch (예상되는 예외클래스) { => 순서가 존재
 * 			오류에 대한 확인
 * 			변수명.getMessage() -> 에러 메세지 출력/ 변수명.printStackTrace() -> 에러 라인 출력
 * 		} catch (예상되는 예외클래스) { => 아래로 갈 수록 상위 클래스
 * 			=> 에러 복구
 * 			return 시 다시 돌아감
 * 		} finally {
 * 			try / catch 를 수행하든 상관없이 무조건 수행하는 문
 * 			=> 파일 닫기, 오라클 연결 해제, 서버 연결 해제
 * 		}
 * 		|
 * 		종료하는 프로그램
 * 사용자명 : system
 * 비밀번호 : happy
 * 
 * 사용자 계정 생성
 * alter session set "_ORACLE_SCRIPT" = true;
 * create user hr identified by happy; user -> id, pw -> happy
 * 
 * 권한 부여
 * greant create session to hr;
 * grant connect resouce to hr;
 * alter user hr default tablespace users quota unlimited on users;
 * 
 * 접속
 * conn hr/happy
 * @c:\oracleDev\emp.sql
 * 
 * 확인
 * SELECT * FROM dept
 */

// => CheckException : IO, SQL
public class 예외처리_6 {

}
