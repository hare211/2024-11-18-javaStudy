package com.sist.inter;
/*
 * Service 구현
 * 
 * 사용자 요청 => Controller => Service => ServiceImpl
 */
public class HelloImpl implements Hello{
	@Override
	public void sayHello(String str) {
		System.out.println(str + "님 환영.");
	}

}
