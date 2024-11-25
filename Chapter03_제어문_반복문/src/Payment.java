
public abstract class Payment {
	public static Pay findPay(String paySystem) {
		if (paySystem.equals("kakao")) {
			return new KakaoPay();
		} else if (paySystem.equals("naver")) {
			return new NaverPay();
		} else {
			return new DefaultPay();
		}
	}

}
