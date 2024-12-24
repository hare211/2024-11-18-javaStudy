package com.sist.map;

public class UserMain {
	public static void main(String[] args) {
		Container c = new Container();
		Model model = c.getBean("member");
		model.execute();
		
		System.out.println(model);
		Model model1 = c.getBean("member"); // -> 스프링 형태
		System.out.println(model1); // 같은 객체 
		
	}
}
