package com.sist.manager;
import java.util.Scanner;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import com.sist.vo.*;
// 같은 패키지에 존재하면 import X, 다른 패키지에 존재하면 import O
// import : 사용자 정의, 라이브러리 클래스 로드
// import java.lang.*; => 자동 추가
public class GenieMusicSystem {
	public MusicVO[] musics = new MusicVO[50];
	public String title = "Genie Top 50"; // 지니 선택할 때마다 Top 50 을 Genie Top 50 으로 변경
	
	{ // 인스턴스 초기화 블럭 => 호출(X), 상속(X)
		//  파일, 네트워크, 데이터베이스 관련 => 예외 처리 필수
		// URL => Web Network
		try {
			// 정상 수행 하는 문장
			Document doc = Jsoup.connect("https://www.genie.co.kr/chart/top200").get();
			Elements title = doc.select("table.list-wrap a.title");  // 태그명.구분자 (list-wrap)
			Elements singer = doc.select("table.list-wrap a.artist");
			Elements album = doc.select("table.list-wrap a.albumtitle");
			
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
	
	public MusicVO[] musicAllDate() { // 웹 / 윈도우 => 리턴으로 데이터 메인으로 반환
		return musics;
	}
	
	public MusicVO[] musicFindData (String fd) {
		int count = 0;
		for (MusicVO vo : musics) {
			if (vo.getTitle().contains(fd)) {
				count++;
			}
		}
		// 동적 배열 생성 => 가변 Collection
		MusicVO[] music = new MusicVO[count];
		// 배열 단점 => 메모리 개수 고정
		int i = 0;
		for (MusicVO vo : musics) {
			if (vo.getTitle().contains(fd)) {
				music[i] = vo;
				i++;
			}
		}
		return music;
	}
	
}
