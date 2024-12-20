package exception;
import java.util.*;
import java.sql.*;
/*
 *     클래스 요소 
 *       => 라이브러리
 *          어떤 라이브러리 사용여부 
 *          => 네트워크 : java.net
 *          => 오라클  : java.sql 
 *          => 파일    : java.io 
 *          => 전체적으로 사용 : String , Object 
 *                       java.lang => 가장 많이 사용되는 클래스
 *                       => import 문 생략 
 *                       => 자동 추가 
 *          => 자동 
 *             1) import java.lang.*;
 *             2) class ClassName extends Object
 *                                ---------------
 *                Object : 객체 생성 / 객체 정보 / 객체 소멸 
 *                                  => *** toString() => finalize()
 *                                  => hashCode()
 *                         객체 비교 / 객체 복제   
 *                         => ** equals ** clone
 *                         => 프로그램에 맞게 => 오버라이딩 
 *             3) 생성자가 없는 경우 
 *                => 자동으로 default 생성자 생성 (매개 변수가 없다)
 *                => 생성자 => 시작과 동시에 처리 / 초기화 (파일, 데이터베이스)
 *                   -----> 초기화블럭 (인스턴스 블럭, 정적 블럭)
 *                => 다른 클래스에서 연결해서 사용 => public 
 *             4) 각 클래스마다 기능 => 메소드 
 *                메소드 => 한가지 기능 수행 
 *                     => 반복이 많은 경우 
 *                     => 재사용할 목적 
 *                *** 메소드 필요 시 에러를 방지하기 위해 예외처리
 *                    --------------------
 *                    | 라이브러리중에 CheckException => 반드시 처리 
 *                    | try ~ catch 를 주로 사용 
 *                *** static 메소드 / static 블럭 
 *                    1) static 만 사용이 가능 
 *                    2) 인스턴스 사용시에는 반드시 객체 생성후 사용이 가능
 *                    3) static 은 컴파일시에 자동으로 저장
 *                       인스턴스는 객체를 생성해야 저장됨 
 *       => 사용자 변수 : 클래스 전체 / 다른 클래스 
 *          => 벤치마킹 
 *       => 초기화 방법 : 생성자, 초기화블록 
 *       => 기능 설정 : 무슨 기능을 가지고 있는지 여부 
 *          => 어떤 기능 : 메뉴, 버튼
 *          => 결과화면 => ** 리턴형 
 *          => ** 매개변수  
 *          
 *       => 라이브러리를 사용 
 *          -------------
 *          예외처리가 필요한 경우 
 *          
 *       1) 메소드안에서 예외처리 
 *          [접근제어자] 리턴형 메소드명(사용자 요청값)
 *          {
 *              리턴할 변수 선언 
 *              String s=""
 *              try
 *              {
 *                 int a=10;
 *              }catch()
 *              {
 *                 
 *              }
 *              finally
 *              {
 *                 
 *              }
 *              return s(X)
 *              
 *          }
 *          
 *          => 전체적 사용 => 멤버 변수 
 *             사용하고 버리는 변수 => 지역 변수 
 *             
 *      JDBC : 원시소스 
 *        |
 *      DBCP : 미리 연결 => 속도 
 *        |
 *      **** MyBatis : google 제공 
 *        |
 *       JPA
 */
public class MemberDAO {
	 // 멤버변수 => 클래스 전체적으로 사용하는 변수 
	   private Connection conn;// 오라클 연결 => null 초기화
	   private PreparedStatement ps; 
	     // 오라클에 명령문 전송/결과값 읽기
	   private final String URL="jdbc:oracle:thin:@211.238.142.124:1521:XE";
	   // 오라클은 공유된 데이터 => static 변수 
	   // 초기화 
	   public MemberDAO() // throws => 호출하는 위치에서 예외처리를 한 후에 사용
	   {
		   // 드라이버 등록 
		  try
		  {
		    Class.forName("oracle.jdbc.driver.OracleDriver");
		   
		  }catch(ClassNotFoundException e) 
		  {
			  System.out.println(e.getMessage());
			  // 에러 발생 => 확인 
			  // getMessage():무슨 에러 / printStackTrace() 위치확인 
		  }
		   
	   }
	   // 오라클 연결 => 오라클 연결 : 문장전송 : 결과값 읽기 : 오라클 닫기
	   // 공통모듈 
	   // 오라클 연결 
	   public void getConnection()
	   {
		   
	   }
	   // 오라클 닫기 
	   public void disConnection()
	   {
		   
	   }
}
