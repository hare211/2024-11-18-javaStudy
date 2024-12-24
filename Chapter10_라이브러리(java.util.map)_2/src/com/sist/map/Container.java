package com.sist.map;
import java.util.*;
public class Container {
	private Map<String, Model> clsMap = new HashMap<String, Model>();
	
	public Container() { // 클래스 객체를 생성하는 공장
		// 스프링 / 필요한 클래스를 Key 를 통해 객체를 가져온다
		clsMap.put("board", new BoardModel());
		clsMap.put("recipe", new RecipeModel());
		clsMap.put("mypage", new MyPageModel());
		clsMap.put("food", new FoodModel());
		clsMap.put("member", new MemberModel());
	}
	
	public Model getBean(String key) {
		
		return clsMap.get(key);
	}
}
