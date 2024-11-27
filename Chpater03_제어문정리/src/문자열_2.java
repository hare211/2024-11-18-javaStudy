// contains : 포함된 문자열 => web 데이터 읽기 => 크롤링
// Jsoup => 크롤링 라이브러리
/* => 데이터가 필요 => 데이터를 읽어온다 => 자바 기능...
 * => 다음 => 데이터를 모아서 처리 => 배열
 * 
 * 
*/
import java.util.*;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.*;

public class 문자열_2 {
	public static void main(String[] args) throws Exception{
		Scanner scanner = new Scanner(System.in);
		System.out.print("검색어 : ");
		String findData = scanner.next();
		
		int k = 1;
		
		for (int i = 1; i <= 4; i++) {
			Document doc = Jsoup.connect("https://www.genie.co.kr/chart/top200?ditc=D&ymd=20241127&hh=11&rtm=Y&pg=" + i).get();
			// 곡명
			Elements title = doc.select("table.list-wrap a.title");
			for (int j = 0; j < title.size(); j++) {
				// => 데이터가 많이 있어야 => 프로그램
				//if (title.get(j).text().contains(findData)) // %검색어%
				//if (title.get(j).text().startsWith(findData)) // 검색어% 
				if (title.get(j).text().endsWith(findData)) {	// %검색어
					System.out.println((k) + ". " + title.get(j).text());
					//Thread.sleep(2000);
					k++;
				}
			}
			
		}
		
		/*
		for (int i = 1; i <= 4; i++) {
			Document doc = Jsoup.connect("https://www.genie.co.kr/chart/top200?ditc=D&ymd=20241127&hh=11&rtm=Y&pg=" + i).get();
			// 곡명
			Elements artist = doc.select("table.list-wrap a.artist");
			for (int j = 0; j < artist.size(); j++) {
				System.out.println(k + ". " + artist.get(j).text());
				k++;
			}
		}
		*/
		
		
	}

}
