package com.sist.io;
import java.io.*;
import com.sist.model.*;
import java.util.*;

public class Container {
	// 클래스를 모아서 관리 => 관련된 클래스가 여러 개 있는 경우
	// Model(브라우저 전송), DAO => 스프링
	private Map<String, Object> clsMap = new HashMap<String, Object>();
	
	public Container() {
//		clsMap.put("a", new A());
//		clsMap.put("b", new B());
//		clsMap.put("c", new C());
//		clsMap.put("d", new D());
//		clsMap.put("e", new E());
//		clsMap.put("f", new F());
//		clsMap.put("g", new G());
		// => 클래스가 계속 추가됨 -> 작업하기 어려워짐
		// 서버를 설계 시 이런 구조의 컨테이너는 서버를 내려야 클래스를 추가 할 수 있음
		// 애노테이션 활용 시 편하게 찾기 가능
		
		File dir = new File("C:\\Users\\sist-117\\git\\java-study\\Chapter11_IO라이브러리_1\\src\\com\\sist\\model"); // properties -> Location 
		String pack = "com.sist.model";
		File[] files = dir.listFiles();
		
		for (File f : files) {
			if (f.isFile()) {
				try {
					String name = f.getName();
					String n = name.substring(0, name.lastIndexOf(".")); // 확장자 찾기
					String cls = pack + "." + n;
					// 동적으로 메모리 할당 => 리플렉션...
					Class clsName = Class.forName(cls);
					Object obj = clsName.getDeclaredConstructor().newInstance();
					clsMap.put(n.toLowerCase(), obj);
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		}
		
	}
	
	// 요청 시 마다 클래스를 찾아주는 역할
	public Object getBean(String key) {
		
		return (I)clsMap.get(key);
	}
	
}
