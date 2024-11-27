/*

 *   1. String 
 *      문자열 저장 클래스 / 일반 데이터형처럼 사용이 가능 
 *      String name=""; ==> 선호
 *                  ---
 *      String name=new String("초기값");
 *      
 *      클래스 => 문자열을 제어하는 기능을 제공 
 *                            --- 메소드 
 *            => 완전 표준화 (확장불가능 => 변경해서 사용이 불가능)
 *      메소드 
 *        = 결과값 (리턴형)
 *        = 어떤 데이터를 첨부 (매개변수)
 *        = 메소드명 
 *                     | 매개변수 
 *        = 기능       --
 *          int length() 
 *          --- --------
 *               | 메소드명
 *          |리턴형 
 *          
 *          boolean equals(String s) => if
 *          String s1="";
 *          String s2="";
 *          // 아이디 중복체크 , 로그인 ....
 *          if(s1.equals(s2)) => 같은 경우
 *          if(!s1.equals(s2)) => 같지 않은 경우
 *          
 *          if(s2.equals(s1)) => 같은 경우
 *          if(!s2.equals(s1)) => 같지 않은 경우
 *          
 *          // 우편번호 검색 , 검색 
 *          boolean contains(String s) => 포함된 문자인지 여부
 *          String s1="abscscskc";
 *          String s2="a";
 *          if(s1.contains(s2)) => 포함 
 *          
 *          // 서제스트 => 자동 완성기 
 *          boolean startsWith(String s)
 *          String s1="Hello Java";
 *          String s2="He";
 *          String s3="Java";
 *          if(s1.startsWith(s2)) => 시작하는 문자열인지 여부 
 *          if(s1.endsWith(s3)) => 끝나는 문자열이 Java인지 확인
 *          -----------------------------------------------
 * 				
*/
public class 제어문_문제_While_정리 {

}
