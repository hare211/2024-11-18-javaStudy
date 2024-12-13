package com.sist.manager;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import com.sist.vo.MusicVO;

public class MelonMusicSystem extends GenieMusicSystem{
	//public MusicVO[] musics = new MusicVO[50];
	public String title = "Melon Top 50";
	{ // 인스턴스 초기화 블럭 => 호출(X), 상속(X)
		//  파일, 네트워크, 데이터베이스 관련 => 예외 처리 필수
		// URL => Web Network
		try {
			// 정상 수행 하는 문장
			Document doc = Jsoup.connect("https://www.melon.com/chart/index.htm").get();
			Elements title = doc.select("div.wrap_song_info div.rank01");  // title
			Elements singer = doc.select("div.wrap_song_info div.rank02");
			Elements album = doc.select("div.wrap_song_info div.rank03"); // alt
			
			for (int i = 0; i < 50; i++) {
				System.out.println(title.get(i).text());
				System.out.println(singer.get(i).text());
				System.out.println(album.get(i).text());
				System.out.println("==========================");
				
				musics[i] = new MusicVO();
				musics[i].setNo(i + 1);
				musics[i].setTitle(title.get(i).text());
				musics[i].setSinger(singer.get(i).text());
				musics[i].setAlbum(album.get(i).text());
				
			}
		} catch (Exception ex) {
			// 에러 발생 시 복구 / 에러 출력 / 에러를 건너뛴다
		}
	}
	// GenieMusicSystem 상속 받음 => musicAllData() 상속 받음  

}
