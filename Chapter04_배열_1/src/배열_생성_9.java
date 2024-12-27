// 1~10까지 난수 발생 => 배열[10] => 중복이 없이 저장 

import java.util.Arrays;

public class 배열_생성_9 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        // 저장 공간 
		int[] arr=new int[100];
		// => Set,Cookie
		// 초기화 => 중복 
		// i=1
		for(int i=0;i<arr.length;i++)
		{
			// 난수 발생 
			arr[i]=(int)(Math.random()*100)+1;// 재실행 
			for(int j=0;j<i;j++)
			{
				if(arr[i]==arr[j])
				{
					i--; // 0 ==> 다시 난수 발생
					break;
				}
			}
		}
		
		// 출력 
		System.out.println(Arrays.toString(arr));
	}

}