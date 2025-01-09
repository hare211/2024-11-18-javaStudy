package com.sist.main;
import java.util.*;
import com.sist.dao.*;
import com.sist.vo.*;

public class MainClass {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("페이지 입력 : ");
		int page = scanner.nextInt();
		
		FoodDAO dao = FoodDAO.newInstance();
		List<FoodVO> list = dao.foodListData(page);
		for (FoodVO vo : list) {
			System.out.println(vo.getFno() + "." + vo.getName());
			
		}
	}
}
