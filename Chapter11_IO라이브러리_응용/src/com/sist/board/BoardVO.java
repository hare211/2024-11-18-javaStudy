package com.sist.board;

import lombok.Data;

/*
 * 파일 => ArrayList => 제어
 * -----------------------
 * 	1. Collection : 다수의 데이터를 저장하고 제어하는 라이브러리
 * 	   ----------
 * 			|
 * --------------------------------
 * |				|			|
 * List			   Set		   Map
 * |				|			|
 * ArrayList	  HashSet	  HashMap
 * ---------	  -------	  -------
 * 1) add()		  1) add()	  웹에서 가장 많이 사용되는 라이브러리
 * 2) set()		  2) remove() 키와 값
 * 3) remove()	  3) size()
 * 4) get()		  4) isEmpty()
 * 5) size()	  5) clear()
 * 6) isEmpty()	  => 순서 X
 * => 데이터 중복 O  => 중복 X
 * => 순서 O		  
 */
@Data
public class BoardVO {
	private int no; // 게시물 번호
	private String name; // 글쓴이
	private String subject; // 제목
	private String content; // 내용
	private String pwd; // 게시글 비밀번호 -> 본인 여부 확인
	private int hits; // 조회수
}
