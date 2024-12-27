package com.sist.main;
/*
 * 객체 단위로 저장
 * ------------
 * 네트워크 / 일반 프로그램을 설정
 * -----
 * 1. 값 형식 데이터
 * 	  int / float / char... Stack 영역에 저장, 직접 접근이 가능
 * 2. 참조 형식 데이터
 * 	  객체 => 주소만 저장 => 실제 데이터는 Heap 영역에 저장
 * => 네트워크 전송
 * 	  값 자체를 저장 후에 전송
 * 	  => 실제 값을 저장 후에 전송
 * => 다른 프로그램 : CVS / JSON => 자체에서 값을 저장된 상태
 * 
 * 참조 => 값 : 시리얼라이즈(직렬화)
 * 			=> implements Serialize
 * => 값을 받을 경우에는 다시 참조형으로 저장(역직렬화)
 * 			=> ObjectOutputStream / ObjectInputStream 사용
 * 			=> 원상 복귀가 가능
 * => 초창기에는 많이 사용 => 오라클
 */
import java.util.*;
import java.io.*;
// 객체의 실제값을 스택(실제 저장값) => 다른 컴퓨터로 전송
// 직렬화 => 빅데이터 분석 => 하둡 => 파이썬(넘파일, 판다스)
//								----------------
// 지하철 혼잡도, 날씨 에측, 범죄 예측, 자동차 리필
// data.go.kr : 공공포탈
// 최종 프로그램 : 스프링 <=> 장고(웹연동)
// 채팅 => NodeJS
/*
 * Heap => 병렬 형식 -> 객체의 실제값 저장	=>	-----------
 * Stack => 직렬 형식
 * 		 => ---------------				-----------
 * 			|	|	|	|
 * 			---------------				-----------
 * 병렬 => 직렬 -> 직렬화
 * 직렬 => 병렬 -> 역직렬화
 */
class Sawon implements Serializable {
	private int sabun;
	private String name;
	private String dept;
	private String job;
	private int pay;
	
	public int getSabun() {
		return sabun;
	}
	public void setSabun(int sabun) {
		this.sabun = sabun;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public int getPay() {
		return pay;
	}
	public void setPay(int pay) {
		this.pay = pay;
	}
	
	public Sawon(int sabun, String name, String dept, String job, int pay) {
		this.sabun = sabun;
		this.name = name;
		this.dept = dept;
		this.job = job;
		this.pay = pay;
	}
	
	// 디폴트 생성자 => 생성자가 이미 존재 -> 자동 생성이 안됨
	public Sawon() {
	}
	
	
	// 값을 저장
	
}
public class IO_1 {
	public static void main(String[] args) {
		List<Sawon> list = new ArrayList<Sawon>();
		// Object 단위 -> 데이터(name, dept, job...)롤 모아서 저장 가능
		list.add(new Sawon(1, "홍씨", "개발부", "사원", 3200));
		list.add(new Sawon(2, "박씨", "개발부1", "상무", 5200));
		list.add(new Sawon(3, "김씨", "개발부2", "부장", 4200));
		list.add(new Sawon(4, "이씨", "개발부3", "이사", 6200));
		list.add(new Sawon(5, "촤씨", "개발부4", "회장", 7200));
		
		ObjectOutputStream oos = null;
		
		try {
			File file = new File("c:\\java_data\\sawon_infotxt");
			if (file.exists()) { // 파일이 없다면
				file.createNewFile(); // 파일을 생성
			}
			FileOutputStream fos = new FileOutputStream(file); // 파일을 읽어오고 oos 에 저장
			oos = new ObjectOutputStream(fos); // fos 를 oos 로 감쌈 -> oos 는 fos 에 의존
			
			// 저장
			oos.writeObject(list);
			System.out.println("객체 단위 저장 완료");
			fos.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			try {
				
				oos.close();
				
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}
}





