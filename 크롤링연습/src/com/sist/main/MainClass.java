package com.sist.main;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class MainClass {
	public static void main(String[] args) {
		/*
		 * class : 중복 가능 => tag.className
		 * id : 중복 없음 => tag#idName
		 */
		String html ="<html>" /* HTML 문서 시작 */
				+ "<body>"	  // 브라우저에 출력
				+ "<div id=aaa>" /* 구부낮 class / id */
				+ "<div>Java</div>" /* div 데이터 하나를 가져오는 것을 Element */
				+ "<div>Oracle</div>"
				+ "<div>HTML/CSS</div>"
				+ "</div>"
				+ "<div class=bbb>"
				+ "<div>JavaScript</div>"
				+ "<div>JSP</div>"
				+ "<div>Spring</div>"
				+ "</div>" /* div 데이터 여러 개를 가져오는 것을 Elements */
				+ "<img src=http://www.daum.net>" // 속성
				+ "</body>"	  /* 브라우저에 출력 종료 */
				+ "</html>";  /* HTML 문서 종료 */
		try {
			// Element => text(), attr() : 속성값을 읽어올 때
			// html() : html 태그 모두 읽어올 때, data() : JavaScript 값 읽어올 때
			// Elements => get() : 태그를 한 개씩 읽어올 때
			// -------- 태그 개수 확인 : size()
			// Element 태그 하나 / Elements 태그 여러 개
			Document doc = Jsoup.parse(html); // jsoup.nodes.Document / html 전체를 모아주는 것
			
			//System.out.println(doc);
			
			Elements div = doc.select("div.bbb div"); // jsout.nodes / jsoup.select
			// div#id_name => id_name 의 div 태그를 가져온다
			// Elements div = doc.select("div.bbb div"); => 후손 태그 : 밑에 있는 태그를 가져온다
			
			//System.out.println(div);
			//System.out.println("div count = " + div.size()); // div 태그 개수
			
			Element div1 = div.get(0); // div 태그의 첫 번째
			
			//System.out.println(div1.text());
			
			for (int i = 0; i < div.size(); i++) {
				System.out.println(div.get(i).text());
			}
			Element img = doc.selectFirst("img"); // 상세보기 ("tagName")
			System.out.println(img.attr("src")); // 속성값 읽어오기
			/*
			 * 1. 읽어 올 태그를 구분할 땐 위에 있는 상위 태그를 봐야한다 (구분자 판별) 
			 */
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
