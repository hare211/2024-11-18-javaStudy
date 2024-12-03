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
				m = "▲" + modify[i];
			} else if (s.equals("하강")) {
				m = "▼" + modify[i];
			}
			System.out.println(
					(i + 1) + "." + m + " " + title[i] + " " + singer[i] + " "
					+ album[i]);
		}
	}

}
