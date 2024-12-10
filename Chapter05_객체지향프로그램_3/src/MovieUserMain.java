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
				break;
			case 5:
				return;
			}
		}
	}
}
