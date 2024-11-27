// 대문자 변환 => toUpperCase()
/*
 * 	함수 : function
 * 	메소드 : method
 * 	============= 기능상으로는 동일
 * 	class 종속
 * 	C / C++ / Python => function(함수)
 * 	Java / Kotlin => method
 * 
 * 	String data = "Hello Java"
 * 	data.replace('a', 'b') => "Hello Jbvb"
 * 	replace(문자, 문자)
 * 			---- ----
 * 			old, new
 * 
 * 	String data = "Hello Java"
 * 	data.replace("Java", "Oracle") => "Hello Oracle"
 * 	replace(문자열, 문자열)
 * 			----- -----
 * 			old	   new
 * 
*/
public class 문자열_8 {
	public static void main(String[] args) {
		String name = "hong gil dong";
		System.out.println(name.toUpperCase());
		// Upper / Lower => 오라클
		// 데이터 관리 => 자바 + 오라클 => JSP에서 HTML로 변환
		
		String data = "Hello Java";
		System.out.println(data.replace('a', 'k'));
		System.out.println(data.replace("Java", "Oracle")); // equalsIgnoreCase() 제외 나머지는 대소문자 구분
		
		// 이미지, 줄거리, 내용
		// |, &, '' => 오라클에서 첨부할 수 없다
		// & => replace
		// & => Scanner
		// || => 문자열 결합
		// 문자열 => ''
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
