import java.util.Scanner;

public class PayMain {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		PayService payService = new PayService();
		
		
		while(true) {
			
			System.out.print("1. 결제 | 2. 종료 : ");
			int menu = scanner.nextInt();
			
		switch(menu) {
		case 1:
			System.out.print("결제 수단을 입력해주세요 : ");
			String paySystem = scanner.next();
			System.out.print("결제 금액을 입력해주세요 : ");
			int amount = scanner.nextInt();
			
			payService.processPay(paySystem, amount);
			
			continue;
		case 2:
			System.out.println("종료합니다.");
			break;
			
		}
		}
	}

}
