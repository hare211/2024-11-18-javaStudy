
public class KakaoPay implements Pay{

	@Override
	public boolean pay(int amount) {
		System.out.println("카카오 페이로 결제를 시작합니다.");
		System.out.println(amount + "원을 결제합니다.");
		return true;
	}

}
