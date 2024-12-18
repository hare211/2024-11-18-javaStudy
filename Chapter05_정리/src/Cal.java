import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Scanner;

public class Cal {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("년도 : ");
		int year = scanner.nextInt();
		
		System.out.print("월 : ");
		int month = scanner.nextInt();
		
		printerCalendar(year, month);
	}

	/*
	 * 달의 첫째날, 다음 달의 첫째날
	 * 달의 첫번째 요일이 시작하는 날
	 * for i < offset
	 * while 문 조건 : 다음달까지
	 * getDayOfMonth 출력
	 * if 문 조건 : DayOfWeek.SATURDAY 토요일이 되면 다음줄
	 * 다음 출력 plusDays 1
	*/
	public static void printerCalendar(int year, int month) {
		LocalDate firstDayOfMonth = LocalDate.of(year, month, 1);
		LocalDate firstDayOfNextMonth = firstDayOfMonth.plusMonths(1);
		
		int offset = firstDayOfMonth.getDayOfWeek().getValue() % 7;
		
		System.out.println("Su Mo Tu We Th Fr Sa ");
		for (int i = 0; i < offset; i++) {
			System.out.print("   ");
		}
		
		LocalDate dayIt = firstDayOfMonth;
		while (dayIt.isBefore(firstDayOfNextMonth)) {
			System.out.printf("%2d ", dayIt.getDayOfMonth());
			if (dayIt.getDayOfWeek() == DayOfWeek.SATURDAY) {
				System.out.println();
			}
			dayIt = dayIt.plusDays(1);
		}
	}
}








