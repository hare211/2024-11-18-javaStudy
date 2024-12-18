package com.sist.exception;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/*
 * Class.forname("") => ClassNotFoundException
 * CheckException => 반드시 예외처리 후 사용
 * 
 */
class Movie {
	public void display() {
		System.out.println("Movie:display() Call...");
	}
}
public class 예외처리_메모리할당_리플렉션 {
	public static void main(String[] args) {
		Movie m = new Movie();
		m.display();
		try {
			// 클래스 정보 읽기
			Class clsName = Class.forName("com.sist.exception.Movie");
			
			Object obj = clsName.getDeclaredConstructor().newInstance();
			
			Method[] methods = clsName.getDeclaredMethods();
			
			methods[0].invoke(obj, null);
		} catch (ClassNotFoundException ex) { 
		} catch (NoSuchMethodException e) {
		} catch (InvocationTargetException e) {
		} catch (Exception e) {
		}
	}
}
