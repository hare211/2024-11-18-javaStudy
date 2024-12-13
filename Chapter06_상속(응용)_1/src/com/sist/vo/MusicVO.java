package com.sist.vo;
// 사용자 정의 데이터형
public class MusicVO {
	private int no;
	private String title;
	private String singer;
	private String album;
	// 변수 => 읽기(메모리에서 데이터 가지고 오기) / 쓰기(메모리 저장)
	//			  getXxx(매개 변수)				   setXxx(매개 변수)
	// 캡슐화 => getter / setter
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getSinger() {
		return singer;
	}
	public void setSinger(String singer) {
		this.singer = singer;
	}
	public String getAlbum() {
		return album;
	}
	public void setAlbum(String album) {
		this.album = album;
	}
	
}
