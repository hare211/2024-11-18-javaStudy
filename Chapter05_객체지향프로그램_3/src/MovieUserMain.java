import java.util.*;
public class MovieUserMain {
	public static void main(String[] args) {
		MovieSystem ms = new MovieSystem();
		Scanner scanner = new Scanner(System.in);
		
		while (true) {
			System.out.println("===== 메뉴 =====");
			System.out.println("1. 영화목록");
			System.out.println("2. 영화 상세보기");
			System.out.println("3. 영화명 검색");
			System.out.println("4. 출연진 검색");
			System.out.println("5. 종료");
			System.out.println("===============");
			System.out.print("메뉴 선택 : ");
			int menu = scanner.nextInt();
			
			switch (menu) {
			case 1:
				System.out.print("페이지 선택 : ");
				int page = scanner.nextInt();
				Movie[] movies = ms.movieListData(page);
				for (Movie m : movies) {
					System.out.println(m.no + "." + m.title);
				}
				break;
			case 2:
				System.out.print("영화 번호 선택 : ");
				int no = scanner.nextInt();
				Movie movie = ms.movieDetail(no); // 리턴형 클래스
				System.out.println("영화명 :" + movie.title + "\n출연진 : " + movie.actor 
						+ "\n감독 : " + movie.director + "\n장르 : " + movie.genre
						+ "\n등급 : " + movie.grade + "\n개봉일 : " + movie.regdate);
				break;
			case 5:
				return;
			}
		}
	}
}
