
public class PayService {
	public void processPay(String paySystem, int amount) {
		System.out.println("결제를 시작합니다. 결제 시스템 : " + paySystem + " 금액 : " + amount);
		Pay pay = Payment.findPay(paySystem);
		
		boolean result = pay.pay(amount);
		
		if (result) {
			System.out.println("결제가 완료되었습니다.");
		} else {
			System.out.println("결제가 실패했습니다.");
		}
		
		
	}

}
