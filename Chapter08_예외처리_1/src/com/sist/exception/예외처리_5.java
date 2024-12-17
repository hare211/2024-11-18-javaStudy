package com.sist.exception;
/*
 * 예외처리 => try ~ catch
 * => IO / SQL
 * => try : 정상 수행하는 문장
 * 			=> 입력값, 실수 => 오류 발생
 * 			=> 찾아서 복구 -> 변수명.getMessage(), 변수명.printStackTrace()
 * 			------------
 * 			catch
 * 		try => if
 * 		catch => else
 * 		=> if ~ else if...
 * 		catch => 한 개만 수행
 * 		catch => 클래스 크기에 따라 작은 순서부터 작성
 * 				--------------------------
 * 				1. 계층 구조
 * 					Object : 최상위 클래스
 * 					  |
 * 				  Throwable
 * 					  |
 * 			----------------------
 * 			|					 |
 * 		  Error				 Exception
 * 		  => 처리 불가능		 => 처리 가능한 에러
 * 
 * 		Exception
 * 			|
 * 	Check		 UnCheck
 * => 컴파일 시	 => 필요 시에만 예외처리
 * 	  예외처리가
 * 	  되었는 지 확인
 * ------------------------------------
 * |								  |
 * IOException					실행 시 => 입력값 확인
 * SQLException					RuntimeException
 * ClassNotFoundException			  |
 * 							 NumberFormateException
 * 							 ArrayIndexOfBoundsException
 * 							 ClassCastException
 * 							 NullPointerException
 * 예외를 잡을 수 있는 능력은 상위 클래스일수록 크다
 * => catch(Exception ex)
 * => catch
 */
public class 예외처리_5 {

}
