package com.sist.music;
import java.util.*;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
public class MusicMain {
	// 지니 뮤직
	// 멜론
	// => 공통(교집합), 차집합 / 합집합
	public Set<String> genieMusic() {
		Set<String> set = new HashSet<String>();
		try {
			Document doc = Jsoup.connect("https://www.genie.co.kr/chart/top200").get();
			// 웹 서버에 접근
			Elements title = doc.select("table.list-wrap a.title");
			// | ArrayList 상속 받음
			//System.out.println(title);
			
			for (int i = 0; i < title.size(); i++) {
				set.add(title.get(i).text());
			}
		} catch (Exception ex) {
			// TODO: handle exception
		}
		return set;
	}
	
	public Set<String> melonMusic() {
		Set<String> set = new HashSet<String>();
		try {
			Document doc = Jsoup.connect("https://www.melon.com/chart/index.htm").get();
			// 웹 서버에 접근
			Elements title = doc.select("div.wrap_song_info div.rank01 a");
			// | ArrayList 상속 받음
			//System.out.println(title);
			
			for (int i = 0; i < title.size(); i++) {
				set.add(title.get(i).text());
			}
		} catch (Exception ex) {
			// TODO: handle exception
		}
		return set;
	}
	public static void main(String[] args) {
		MusicMain mm = new MusicMain();
		Set<String> genie = mm.genieMusic();
		
		for (String music : genie) {
			System.out.println(music);
		}
		
		System.out.println("=========================");

		Set<String> melon = mm.melonMusic();
		for (String music : melon) {
			System.out.println(music);
		}
		
		System.out.println("==== 차집합 ====");
		// 오라클 => MINUS removeAll()
		// [1, 2, 3, 4, 5] - [4, 5, 6, 7, 8] => [1, 2, 3]
//		genie.removeAll(melon); 
//		for (String music : genie) {
//			System.out.println(music);
//		}
		System.out.println("==== 교집합 ====");
		// [1, 2, 3, 4, 5] [4, 5, 6, 7, 8] => 4, 5
		// retainAll() => INTERSECT => JOIN
		genie.retainAll(melon);
		System.out.println("동일곡 : " + genie.size());
		for (String music : genie) {
			System.out.println(music);
		}
		
		System.out.println("==== 합집합 ====");
		// UNION => addAll()
		// => 중복된 경우 1 개만 첨부
		List<String> list = new ArrayList<String>();
		list.addAll(genie);
		list.addAll(melon);
		// UNION ALL => 중복된 데이터 포함
		System.out.println("데이터 개수 : " + list.size());
		for (String music : list) {
			System.out.println(music);
		}
		
		Set<String> hap = new HashSet<String>();
		hap.addAll(list); // 중복 제거

		System.out.println("==== 중복 제거 ====");
		System.out.println("곡 수 : " + hap.size());
		for (String music : hap) {
			System.out.println(music);
		}
		// addAll() : 모든 데이터 (합) / removeAll() : 차집합 / retainAll() : 교집합
		// => JOIN
		
		
		
	}
}















