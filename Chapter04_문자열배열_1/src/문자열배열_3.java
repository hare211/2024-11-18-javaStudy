import java.util.*;
import com.sist.data.*;
public class 문자열배열_3 {
	/*
	 * class music() {
	 * 		String title, singer, album;
	 * }
	*/
	public static void main(String[] args) {
		String[] title = ArrayData.title;
		
		String[] singer = ArrayData.singer;
		
		String[] album = ArrayData.album;
		
		String[] state = ArrayData.state;
		
		int[] modify = ArrayData.modify;
		// => String[][] music = new String[50][5];
		// => Music[] music = new Music[50];
		// 뮤직 목록
		System.out.println("Music Top 50");
		for (int i = 0; i < title.length; i++) {
			String s = state[i];
			String m = "";
			if (s.equals("유지")) {
				m = "-";
			} else if (s.equals("상승")) {
				m = " ▲ " + modify[i];
			} else if (s.equals("하강")) {
				m = " ▼ " + modify[i];
			}
			System.out.println(
					(i + 1) + "." + m + " " + title[i] + " " + singer[i] + " "
					+ album[i]);
		}
		System.out.println("==========================================");
		
		/*
		Scanner scanner = new Scanner(System.in);
		System.out.print("카테고리 선택\n1. 곡명 | 2. 가수명 : ");
		int menu = scanner.nextInt();
		
		if (menu == 1) { // 제목
			System.out.print("제목 입력 : ");
			String titleName = scanner.next();
			int count = 0;
			for (int i = 0; i < title.length; i++) {
				if (title[i].contains(titleName)) {
					System.out.println("노래명 : " + title[i]);
					System.out.println("가수명 : " + singer[i]);
					System.out.println("앨범명 : " + album[i]);
					System.out.println("등폭 : " + (state[i].equals("유지") ? "" : state[i] + " " + modify[i]));
					System.out.println("==========================================");
					count++;
				}
			}
			System.out.println("총 " + count + "건 검색");
		} else if (menu == 2) { // 가수명
			System.out.print("가수 입력 :	");
			String singerName = scanner.next();
			int count = 0;
			for (int i = 0; i < singer.length; i++) {
				if (singer[i].contains(singerName)) {
					System.out.println("노래명 : " + title[i]);
					System.out.println("가수명 : " + singer[i]);
					System.out.println("앨범명 : " + album[i]);
					System.out.println("등폭 : " + (state[i].equals("유지") ? "" : state[i] + " " + modify[i]));
					System.out.println("==========================================");
					count++;
				}
			}
			System.out.println("총 " + count + "건 검색");
		} else {
			System.out.println("잘못된 메뉴입니다.");
		}
		*/
		
		// 등폭(상승, 하강)이 가장 많은 노래명, 가수명을 출력
		int max = modify[0];
		int min = modify[0];
		int maxIndex = 0;
		int minIndex = 0;
		for (int i = 0; i < 50; i++) {
			if (max < modify[i]) {
				max = modify[i];
				maxIndex = i;
			}
			if (min > modify[i] && modify[i] != 0) {
				min = modify[i];
				minIndex = i;
			}
		}
		System.out.println(max);
		System.out.println("가수명 : " + singer[maxIndex] + "  노래명 : " + title[maxIndex]);
		
		int maxCount = 0;
		for (int i = 0; i < 50; i++) {
			if (max == modify[i]) {
				maxCount++;
			}
		}
		System.out.println("배열 개수 : " + maxCount);
		// 동적 배열 생성 
		int[] maxArr = new int[maxCount];
		int j = 0;
		for (int i = 0; i < 50; i++) {
			if (max == modify[i]) {
				maxArr[j] = i;
				j++;
			}
		}
		int minCount = 0;
		int[] minArr = new int[minCount];
		int k = 0;
		for (int i = 0; i < 50; i++) {
			if (min == modify[i]) {
				minArr[k] = i;
				k++;
			}
		}
		
		// 데이터 출력
		for (int i : maxArr) {
			System.out.println("곡명 : " + title[i] + " 가수 : " + singer[i]);
		}
		for (int i : minArr) {
			System.out.println("곡명 : " + title[i] + " 가수 : " + singer[i]);
		}
		
		
		
		
		
		
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
