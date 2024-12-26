package com.sist.io;
import java.io.*;
import com.sist.model.*;
import java.util.*;

public class Container {
	// 클래스를 모아서 관리 => 관련된 클래스가 여러 개 있는 경우
	// Model(브라우저 전송), DAO => 스프링
	private Map<String, I> clsMap = new HashMap<String, I>();
	
	public Container() {
		
	}
	// 요청 시 마다 클래스를 찾아주는 역할
	public I getBean(String key) {
		
		return clsMap.get(key);
	}
	
}
