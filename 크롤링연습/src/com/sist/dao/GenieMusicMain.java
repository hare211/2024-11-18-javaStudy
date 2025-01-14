package com.sist.dao;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class GenieMusicMain {
	public static void main(String[] args) {
		String[] url = {
				"https://www.genie.co.kr/chart/top200",
				"https://www.genie.co.kr/chart/genre?ditc=D&ymd=20250113&genrecode=M0100",
				"https://www.genie.co.kr/chart/genre?ditc=D&ymd=20250113&genrecode=M0200",
				"https://www.genie.co.kr/chart/genre?ditc=D&ymd=20250113&genrecode=M0300",
				"https://www.genie.co.kr/chart/genre?ditc=D&ymd=20250113&genrecode=M0107",
				"https://www.genie.co.kr/chart/genre?ditc=D&ymd=20250113&genrecode=M0500",
				"https://www.genie.co.kr/chart/genre?ditc=D&ymd=20250113&genrecode=M0600"
		};
		
		MusicDAO dao = MusicDAO.newInstance();
		
		for (int i = 0; i < url.length; i++) {
			try {
				Document doc = Jsoup.connect(url[i]).get();
				Elements title = doc.select("table.list-wrap a.title");
				Elements singer = doc.select("table.list-wrap a.artist");
				Elements album = doc.select("table.list-wrap a.albumtitle");
				Elements poster = doc.select("table.list-wrap a.cover img");
				Elements etc = doc.select("table.list-wrap span.rank");
				System.out.println(url[i]);
				for (int j = 0; j < title.size(); j++) {
					try {
						System.out.println(title.get(j).text());
						System.out.println(singer.get(j).text());
						System.out.println(album.get(j).text());
						System.out.println(poster.get(j).attr("src"));
						//System.out.println(etc.get(j).text());
						String s = etc.get(j).text();
						String state = "";
						String id = "";
						if (s.equals("유지")) {
							state = "유지";
							id = "0";
						} else {
							// 1상승
							// 숫자 제거
							state = s.replaceAll("[^가-힣]", "");
							// 한글 제거
							id = s.replaceAll("[^0-9]", "");
						}
						System.out.println(state);
						System.out.println(id);
						System.out.println("===========================");
						
						MusicVO vo = new MusicVO();
						
						vo.setCno(i + 1);
						vo.setTitle(title.get(j).text());
						vo.setSinger(singer.get(j).text());
						vo.setAlbum(album.get(j).text());
						vo.setPoster(poster.get(j).attr("src"));
						vo.setState(state);
						vo.setIdcrement(Integer.parseInt(id));
						vo.setKey("");
						dao.genieMusicInsert(vo);
						
					} catch (Exception ex) {
						ex.printStackTrace();
					}
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		System.out.println("데이터 저장 완료");
		
	}
	
}
