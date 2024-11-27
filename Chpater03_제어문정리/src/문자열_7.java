/*
 * 	변경
 * 	 = toUpperCase() : 대문자 변환
 * 	 = toLowerCase() : 소문자 변환
 * 	 = replace() : 지정된 데이터 변경
 * 	 = replaceAll() : 전체를 변경 => 정규식
 * 		맛있+
 * 		[가-힣] => 한글 전체
 * 		[0-9] => 숫자 전체
 * 		[A-Za-z] => 알파벳 전체
 * 		+ : 한 글자 이상
 * 		* : 0 글자 이상
 * 		| : 선택
 * 		. : 임의의 문자 한 개
 * 		? : 존재 여부 확인
 * 	 = valueOf() : 모든 데이터형을 문자열로 변환
 * 		valueOf(10) => "10"
 * 		=> 브라우저 / 윈도우창 => TextField
 * 			<input type = "text">
*/

import javax.swing.JFrame;
import javax.swing.JTextField;

public class 문자열_7 extends JFrame{
	public 문자열_7() {
		JTextField tf = new JTextField();
		tf.setText(String.valueOf(100)); // static => 클래스 명 그대로 // 인스턴스.변수 와 구분해야 함
		add("North", tf);
		setSize(600, 480);
		setVisible(true);
	}
	public static void main(String[] args) {
		new 문자열_7();
	}

}
