// 수정 => 다시 저장
public class 변수_3 {
	public static void main(String[] args) {
		int a = 100;
		// a(100)
		System.out.println(a);
		
		a = 200;
		// a(100) => a(200)
		System.out.println(a);
		
		a = 1000;
		System.out.println(a);
		// 같은 블럭 안에서는 같은 변수명을 사용할 수 없다
		/*
		 * 	학생 1명
		 * 	국어점수 : 90
		 * 	수학점수 : 90
		 * 	영어점수 : 90
		 * 	총점 : 270
		 *  평균 : 90.0
		 *  학점 : A
		 *  등수 : 2
		*/
		
		int studentCount = 1;
		int korScore = 90;
		int mathScore =  90;
		int engScore = 90;
		int sum = 270;
		double average = 90.0;
		char grade = 'A';
		int rank = 2;
		
		System.out.println(studentCount + "명");
		System.out.println(korScore);
		System.out.println(mathScore);
		System.out.println(engScore);
		System.out.println(sum);
		System.out.println(average);
		System.out.println(grade);
		System.out.println(rank);
		
	}

}
