import java.awt.Choice;
import java.lang.reflect.Array;
import java.text.ChoiceFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;

public class 메소드문제 {
	// 1 번
	static void printOneToTen() {
		for (int i = 1; i < 11; i++) {
			System.out.print(i + " ");
		}
	
	}
	// 2 번
	static int plusOneToTen() {
		int sum = 0;
		for (int i = 1; i < 11; i++) {
			sum += i;
		}
		return sum;
	}
	// 3 번
	static int plusOneToN(int n) {
		int sum = 0;
		for (int i = 1; i <= n; i++) {
			sum += i;
		}
		return sum;
	}
	// 4 번
	static String divide(int a, int b) {
			String result = "";
			if (b == 0) {
				result = "0 으로 나눌 수 없습니다.";
			} else {
				result = String.valueOf(a / (double) b);
			}
			return result;
	}
	// 5 번
	
	static String upperCase(String s) {
		return s.toUpperCase();
	}
	// 6 번
	static boolean isSymmetry() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("문자열 입력 : ");
		String s = scanner.next();
		 int n = s.length();
	        for (int i = 0; i < n / 2; i++) {
	            if (s.charAt(i) != s.charAt(n - i - 1)) {
	                return false;
	            }
	        }
	        return true;
	}
	// 7 번
	static void reverse(String s) {
        String reversed = "";
		
			for (int i = s.length() - 1; i >= 0; i--) {
				reversed += s.charAt(i);
			}
			System.out.println(reversed);
		
	}
	
	// 8 번
	static void gradeScore() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("점수 입력 : ");
		int grade = scanner.nextInt();
		
		
		if (0 > grade || grade > 100) {
			System.out.println("잘못된 점수입니다.");
			return;
		}
		int gradeScore = grade / 10;
		switch (gradeScore) {
		case 10, 9:
			System.out.println("A");
			break;
		case 8:
			System.out.println("B");
			break;
		case 7:
			System.out.println("C");
			break;
		case 6:
			System.out.println("D");
			break;
		default:
			System.out.println("F");
		}
		
	}
	// 8 번
	static void gradeScore2(int score) {
		double[] limit = {50,60,70,80,90};
		String[] grade = {"F", "D", "C", "B", "A"};
		ChoiceFormat cf = new ChoiceFormat(limit, grade);
		System.out.println(cf.format(score));
	}
	// 9 번
	static boolean isLeapYear() {
		Scanner scanner = new Scanner(System.in);
		int year = scanner.nextInt();
		
        if (year % 4 == 0) {
            if (year % 100 == 0) {
                return year % 400 == 0; // 400의 배수일 때만 윤년
            }
            return true; // 4의 배수이면서 100의 배수가 아닌 경우 윤년
        }
        return false; // 4의 배수가 아니면 윤년 아님
    }
	// 10 번
	static void max() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("첫 번째 정수 : ");
		int a = scanner.nextInt();
		
		System.out.print("두 번째 정수 : ");
		int b = scanner.nextInt();
		
		if (a < b) {
			System.out.println(b);
		} else {
			System.out.println(a);
		}
		
	}
	
	// 11번
	static void isEvenOdd() {
		Scanner scanner = new Scanner(System.in);
		
		int a = scanner.nextInt();
		
		if (a % 2 == 0) {
			System.out.println(a + "는(은) 짝수입니다.");
		} else {
			System.out.println(a + "는(은) 홀수입니다.");
		}
	}
	
	// 12 번
	static boolean isThreeMulti(int a) {
		if (a % 3 == 0) {
			return true;
		}
		return false;
	}
	
	// 13 번
	static void dayOfWeek() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("년도 입력 :");
		int year = scanner.nextInt();
		
		System.out.print("월 입력 :");
		int month = scanner.nextInt();
		
		System.out.print("일 입력 :");
		int day = scanner.nextInt();
		
		Calendar cal = Calendar.getInstance(); 
		
		cal.set(Calendar.YEAR, year);
		cal.set(Calendar.MONTH, month - 1);
		cal.set(Calendar.DATE, day);
		
		char[] strWeek = {' ','일','월','화','수','목','금','토'};
		
		
		int week = cal.get(Calendar.DAY_OF_WEEK);
		System.out.println(year + "년도 " + month + "월 " + day + "일은 " + strWeek[week] + "요일입니다");
	} 
	// 14 번
	static int[] reverseArray(int[] arr) {
		int[] arrReversed = new int[arr.length];
		
        for (int i = 0; i < arr.length; i++) {
            arrReversed[i] = arr[arr.length - 1 - i]; // 뒤집기
        }
		return arrReversed;
	}
	
	
	public static void main(String[] args) {
		
//		// 1 번
//		printOneToTen();
//		
//		System.out.println();
//		
//		// 2 번
//		System.out.println(plusOneToTen());
//		
//		System.out.println();
//		
//		// 3 번
//		System.out.println(plusOneToN(10));
//		
//		System.out.println();
//		
//		// 4 번
//		System.out.println(divide(2, 0));
//		
//		System.out.println();
//		
//		// 5 번
//		System.out.println(upperCase("dd"));
//		
//		// 6 번
//		System.out.println(isSymmetry());
//		
//		// 7 번
//		reverse("ddddwwwweeeaaa");
//		
//		// 8 번
//		gradeScore();
//		gradeScore2(88);
//		
//		// 9 번
//		System.out.println(isLeapYear());
//		
//		// 10 번
//		max();
//		
//		// 11 번
//		isEvenOdd();
//		
//		// 12 번
//		dayOfWeek();
//		
//		
//		// 13 번
//		int[] arr = {1,3,5,7,9};
//		System.out.println(Arrays.toString(reverseArray(arr)));
//		
		
	}

}
