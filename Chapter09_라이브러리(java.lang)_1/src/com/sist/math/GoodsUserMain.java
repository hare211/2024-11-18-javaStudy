package com.sist.math;

public class GoodsUserMain {
	public static void main(String[] args) {
		// 객체 생성
		GoodsDAO dao = GoodsDAO.newInstance();
		// newInstance(), getInsatance() 싱글톤패턴
		// Calendar cal = Calendar.getInstance() -> 싱글톤 (java.util)
		int count = dao.goodsTotalPage();
		int totalPage = (int) (Math.ceil(count / 15.0));
		System.out.println("총페이지 : " + totalPage);
	}
}
