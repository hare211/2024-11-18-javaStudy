/*
 *   어떤 데이터를 모아서 관리 
 *   --------
 *   데이터형
 *   몇개 저장 
 *   [10]
 *   ==
 *   데이터형[] 관리변수(배열명)=new 데이터형[10]
 *   
 *   정수 : int[] , long[]
 *   실수 : double[]
 *   논리 : boolean[]
 *   문자열 : String[]
 *   문자 : char[]
 */
public class 배열_생성_4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        // 가위 바위 보 
		int com=(int)(Math.random()*3); 
		System.out.print("컴퓨터:");
		String[] arr={"가위","바위","보"};
		System.out.println(arr[com]);
		/*if(com==0)
			System.out.print("가위");
		else if(com==1)
			System.out.print("바위");
		else if(com==2)
			System.out.print("보");*/
			
	}

}