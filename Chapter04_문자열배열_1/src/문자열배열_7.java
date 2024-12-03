/*
 * 1|
 * 도봉산|
 * 하늘을 깎아세운 만길 봉우리도봉(道峰)산은 이름 그대로 봉우리가 길인 산|
 * 132-010 서울특별시 도봉구 도봉동 경기 의정부시, 양주시 장흥면 일대
 * 
*/

import java.util.Arrays;

import com.sist.data.ArrayData;

public class 문자열배열_7 {
	public static void main(String[] args) {
		String seoul = ArrayData.arrayData("seoul_location.txt");
		String[] seoul_data = seoul.split("\n");
		System.out.println(seoul_data[3]);
		/*
		for (String s : seoul_data) {
			String[] data = s.split("\\|");
			if (data[3].contains("마포")) {
				
			System.out.println("번호 : " + data[0]);
			System.out.println("명소명 : " + data[1]);
			System.out.println("주소 : " + data[3]);
			System.out.println("소개 : " + data[2]);
			System.out.println("=============================================");
			}
		}*/
	}
}
