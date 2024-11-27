/*
 * 	문자 자르기
 * 	***
 * 
 * 	substring : 문자열을 자르기
 * 	|	지정된 위치부터 마지막까지 자르기
 * 		Hello Java
 * 		0123456789
 * 		substring(6) => "J" 부터 마지막까지 자르기 => "Java"
 * 	|	중간에서 자르기
 * 		substring(1, 4) => "ell"
 * 					 -- endIndex -1 마지막 문자는 제외
 * 		--------------------------- JavaScript 와 동일
 * 
 *	프로젝트 본인 담당 파트 캡처 / 본인 담당 외 파트 캡처
 *	주요 기능, 담당 역할 서술
*/
public class 문자열_6 {
	public static void main(String[] args) {
		/*String data = "Hello.Hello.java";
		
		System.out.println(data.substring(data.lastIndexOf(".") + 1));
		*/
		/*
		String data = "ID : admin, PW : 1234";
		String id = data.substring(data.indexOf(":") + 1, data.indexOf(","));
		
		System.out.println(id.trim());
		
		String pw = data.substring(data.lastIndexOf(":") + 1);
		System.out.println(pw.trim());
		
		System.out.println(data);
		
		
		String address = "경기 가평군 가평읍 달전리 68 [새주소] 경기 가평군 가평읍 북한강변로 1078-19";
		
		String addr1 = address.substring(0, address.indexOf("["));
		String addr2 = address.substring(address.indexOf("]") + 2);
		
		System.out.println(addr1);
		System.out.println(addr2.trim()); // trim() => 좌우 공백을 제거
		
		System.out.println(address);
		
		String str = "Hello Java";
		str = str.substring(str.indexOf("J"));
		System.out.println(str);
		*/
		
		String name = "hare, cage, green, dash";
		
		String tag = name.substring(name.indexOf("hare"), name.indexOf(", dash"));
		
		System.out.println(tag.trim());
	}

}
