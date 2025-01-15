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
				}
				System.out.println("=================");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
