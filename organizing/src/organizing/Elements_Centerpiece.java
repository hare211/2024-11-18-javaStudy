package organizing;

/*
 * 	기능 구현 우선순위 : 상 - 중 - 하
 * 	주요 기능, 담당 파트 서술, 담당 파트 외 팀원들 파트 서술
 * 
 * 
 * 
 * 	영화 순위 / 영화 평점 / 예매율 / 누적 관객 / 갤러리 / 예고편(영상) / 비슷한 작품 / 장르 속성 / 출연, 제작 / 게시판(코멘트형식) / 로그인 / 회원가입 / 회원 등급
 *  																	|장르 통해 추천
 *  																	|추천
 *  
 *  
 *  
 *  
 *  
 * 
 *  문제: 상속 관계 상품
쇼핑몰의 판매 상품을 만들어보자.
Book , Album , Movie 이렇게 3가지 상품을 클래스로 만들어야 한다.
코드 중복이 없게 상속 관계를 사용하자. 부모 클래스는 Item 이라는 이름을 사용하면 된다.
공통 속성: name , price
Book : 저자( author ), isbn( isbn )
Album : 아티스트( artist )
Movie : 감독( director ), 배우( actor )
다음 코드와 실행결과를 참고해서 Item , Book , Album , Movie 클래스를 만들어보자.





```java
package extends1.ex;
public class ShopMain {
 public static void main(String[] args) {
 Book book = new Book("JAVA", 10000, "han", "12345");
 Album album = new Album("앨범1", 15000,"seo");
 Movie movie = new Movie("영화1", 18000,"감독1", "배우1");
 book.print();
 album.print();
 movie.print();
 int sum = book.getPrice() + album.getPrice() + movie.getPrice();
 System.out.println("상품 가격의 합: " + sum);
 }
}
```
실행 결과
```
이름:JAVA, 가격:10000
- 저자:han, isbn:12345
이름:앨범1, 가격:15000
- 아티스트:seo
이름:영화1, 가격:18000
- 감독:감독1, 배우:배우1
상품 가격의 합: 43000


 */
public class Elements_Centerpiece {

}
