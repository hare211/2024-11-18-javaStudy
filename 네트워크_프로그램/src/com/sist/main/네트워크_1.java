package com.sist.main;
class MyThread extends Thread {
	// 동작 => 한가지 일만 수행 
	public void run() {
		for (int i = 0; i <=10; i++) {
			try {
				Thread.sleep(100);
			}catch(Exception ex) {}
			System.out.println(getName()+":"+i);
		}
	}
}
public class 네트워크_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyThread m1=new MyThread();
		MyThread m2=new MyThread();
		MyThread m3=new MyThread();
		MyThread m4=new MyThread();
		MyThread m5=new MyThread();
		// 쓰레드 이름 부여
		m1.setName("홍길동");
		m2.setName("이순신");
		m3.setName("강감찬");
		m4.setName("박문수");
		m5.setName("심청이");
		// 쓰레드 우선순위
		m1.setPriority(Thread.MIN_PRIORITY);
		m2.setPriority(Thread.MIN_PRIORITY);
		m3.setPriority(Thread.MAX_PRIORITY);
		m4.setPriority(Thread.MIN_PRIORITY);
		m5.setPriority(Thread.MIN_PRIORITY);
		// 동작을 해라 => 명령 => run() 
		m1.start(); // run() 호출
		m2.start();
		m3.start();
		m4.start();
		m5.start();
	}

}