package com.sist.client;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.*;
public class ControlPanel extends JPanel{
	Image back; // 이미지 백그라운드
	JLabel la1, la2;
	JTextField tf; // ID 라벨
	JPasswordField pf; // PW 라벨 => * 로
	JButton b1, b2;
	public ControlPanel() {
		back = Toolkit.getDefaultToolkit().getImage("c:\\javaDev\\background.jpeg"); // 이미지 백그라운드
		la1 = new JLabel("ID");
		la2 = new JLabel("Password");
		tf = new JTextField();
		pf = new JPasswordField();
		b1 = new JButton("로그인");
		b2 = new JButton("취소");
		
		// 배치 => 실행과 동시에 실행 명령 => 초기화 => 생성자
		setLayout(null);
		la1.setBounds(ALLBITS, ABORT, WIDTH, HEIGHT);
		//			  왼쪽 너비 / 위 너비 / 가로 / 세로 
		la1.setBounds(57, 15, 80, 30); // ID 
		tf.setBounds(95,  15, 200, 30); // ID 입력창
		add(la1); add(tf);
		la2.setBounds(10, 50, 80, 30); // Password
		pf.setBounds(95,  50, 200, 30); // Password 입력창
		add(la2); add(pf);
		
		JPanel p = new JPanel();
		p.setOpaque(false); // 로그인, 취소 투명도
		p.add(b1);
		p.add(b2);
		p.setBounds(10, 90, 285, 35);
		add(p);
	}
	// 오버라이딩
	@Override
	public void paintComponent(Graphics g) {
		g.drawImage(back, 0, 0, getWidth(), getHeight(), this);
	}
	

}
/*
 * -- 오라클 1차 정리
/*
1. SELECT 문장 : 데이터 검색 명령어
= 순서 / 형식
	=> 출력에 필요한 데이터만 추출 / 전체 데이터 추출 (*)
	     ---------------------------- column 나열
	SELECT * | column_list
	FROM table 명 => 파일
	[
		WHERE 조건 => 연산자
		GROUP BY 그룹컬럼
		HAVING 그룹조건
		ORDER BY 컬럼 (ASC | DESC)
	]
	컬럼명이 길거나 알 수 없는 경우 => 별칭
	컬럼명 "별칭", 컬럼명 as 별칭
	중복 없는 데이터 : DISTINCT 컬럼명

	=> WHERE 문장 처리 => 연산자
	산술연산자 : +, -, *, /
		=> 순수하게 산술만 처리(/ => 정수 / 정수 = 실수)
	오라클에서 지원하지 않는 부분 => row 단위 통계(X)
		=> CUBE / ROLLUP => GROUP BY 이용한다
	비교연산자 : =, >?(!=, ^=), <, >, <=, >=
	논리연산자 : AND, OR
			-----
			BETWEEN ~ AND
	OR 가 여러 개인 경우 : IN
		WHERE deptnno = 10 OR deptno = 20 OR deptno = 30
		=> WHERE deptno IN(10, 20, 30)
		기간, 범위 : BETWEEN ~ AND
		WHERE 1 <= page AND page <= 10
		null 연산자 => null 은 값이 없는 상태 => 연산처리가 안된다
		---- 1. IS NULL, 2. IS NOT NULL, 3. NVL() => NULL 값을 변경해서 사용
	부정연산자 : NOT
		=> NOT IN, NOT LIKE, NOT BETWEEN
	LIKE => 검색
		% : 문자의 제한이 없다
		_ : 문자 1개
		=> startsWith => 'Java%'
		=> endsWith => '%Java'
		=> contains => '%Java%'
		=> '__K%'
		=> 오라클에 저장된 데이터는 대소문자를 구분한다
	----------------------------------------------------------------------
	상세보기 : =
	검색 : LILe '%검색어%'
	목록 : WHERE page BETWEEN 1 AND 10
	-----------------------------------------------------------------------
	내장 함수
	-----------
	단일행 함수 : row => 한 줄씩 처리
		문자 관련 함수
		LENGTH(문자열|컬럼명) => 문자 개수
		SUBSTR(문자열|컬럼명, 시작번호, 개수) => 문자를 자르는 경우
		INSRT(문자열|컬럼명, 찾는 문자, 시작 번호, 몇번째)
		PRAD(문자열, 출력 개수, 문자 지정) : 아이디 찾기
		숫자 관련 함수
		CEIL(실수) : 올림 함수 => CEIL(10.1) => 11
		날짜 관련 함수
		변환 함수
		기타 함수
	집계 함수 : column => 컬럼 1개에 대한 통계
			AVG(sal) => 평균
			SUM(sal) => 총액
*/
