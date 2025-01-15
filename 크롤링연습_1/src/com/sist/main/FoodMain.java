package com.sist.main;
import java.util.*;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.sist.dao.*;
public class FoodMain {
	public static void main(String[] args) {
		try {
			for (int i = 1; i <= 347; i++) {
				Document doc = Jsoup.connect("https://www.menupan.com/restaurant/bestrest/bestrest.asp?page=" 
											+ i + "&trec=8655&pt=rt").get(); // 식당 목록
				Elements link = doc.select("p.listName span.restName a"); // 식당 상세보기
				System.out.println("=====" + i + " page =====");
				for (int j = 0; j < link.size(); j++) {
					//System.out.println(link.get(j).attr("href"));
					String url = "https://www.menupan.com" + link.get(j).attr("href");
					Document doc2 = Jsoup.connect(url).get();
					// 식당 name
					Element name = doc2.selectFirst("div.areaBasic dl.restName dd.name");
					String strName = name.text();
					strName = strName.substring(0, strName.indexOf("["));
					System.out.println(strName);;
					// 식당 type
					Element type = doc2.selectFirst("div.areaBasic dl.restType dd.type");
					System.out.println(type.text());
					// 식당 phone
					Element phone = doc2.selectFirst("div.areaBasic dl.restTel dd.tel1");
					System.out.println(phone.text());
					// 식당 address
					Element address = doc2.selectFirst("div.areaBasic dl.restAdd dd.add1");
					System.out.println(address.text());
					// 식당 score
					Element score = doc2.selectFirst("div.areaBasic dl.restGrade span.total");
					System.out.println(score.text());
					// 식당 theme
					Element theme = doc2.selectFirst("div.areaBasic dl.restTheme dd.Theme");
					System.out.println(theme.text());
					// 식당 price
					Element price = doc2.selectFirst("div.restPrice p.price");
					System.out.println(price.text());
					
					// poster, time, parking, content
					// 식당 time
					Element time = doc2.selectFirst("div.tabInfo ul.tableTopA dd.txt2");
					System.out.println(time.text());
					// 식당 content
					Element content = doc2.selectFirst("div.tabInfo ul.tableBottom div#info_ps_f"); // id 이기 때문에 #
					System.out.println(content.text()); // <div id="info_ps_f">
					// 식당 parking
					Elements tableLR = doc2.select("div.tabInfo ul.tableLR dt");
					Element parking = null;
					for (int k = 0; k < tableLR.size(); k++) {
						String s = tableLR.get(k).text();
						if (s.equals("주차")) {
							parking = doc2.select("div.tabInfo ul.tableLR dd").get(k);
							System.out.println(parking.text());
						}
					}
					// 식당 poster
					Element poster = doc2.selectFirst("div.areaThumbnail img#rest_bigimg");
					System.out.println(poster.attr("src"));
					// 식당 images
					Elements image = doc2.select("div#id_restphoto_slides img[src*=/restimg/]");
					String images = "";
					for (int k = 0; k < image.size(); k++) {
						images += image.get(k).attr("src") + ",";
					}
					images = images.substring(0, images.lastIndexOf(","));
					//Elements images = doc2.select("ul#id_restphoto_list_ul img");
					System.out.println(images);
					/*
					 <dl class="restGrade"> *** 최상위클래스
					<dt>평점</dt>
					<dd class="rate">
					<p class="point"><span class="star" style="width:67.8571428571429%"></span><!-- ☆☆☆☆☆ //--></p>
					<p class="score"><span class="total">3.4</span><span class="line">|</span><span class="count">7명 참여</span></p>
					</dd>
					restGrade 최상위 클래스 다음 바로 원하는 클래스
					.text() 태그 무시하고 문자열만 가져온다
					 */
				}
				System.out.println("=================");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
