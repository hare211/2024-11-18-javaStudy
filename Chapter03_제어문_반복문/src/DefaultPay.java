
public class DefaultPay implements Pay{

	@Override
	public boolean pay(int amount) {
		System.out.println("결제 수단이 존재하지 않습니다.");
		return false;
	}

}
