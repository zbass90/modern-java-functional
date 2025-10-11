package defaultmethod.ex2;

import java.time.LocalDateTime;
import java.util.List;

public class NotifierMainV2 {
	/**
	 * 기존 인터페이스와 같이 계약(Contract) 역할에 충실하자!
	 *
	 * default method()
	 *
	 * 1. 하위 호환성을 위한 최소한의 활용
	 * 2. 인터페이스 본연의 추상화 목적 유지
	 * 3. 다중 상속에 따른 충돌 문제
	 * 4. 상태를 두지 말자 - 디폴트 메서드는 메서드 구현부만 제공하는 것!
	 *
	 */
	public static void main(String[] args) {
		List<Notifier> notifiers = List.of(new EmailNotifier(), new SMSNotifier(), new AppPushNotifier());
		notifiers.forEach(n -> n.notify("서비스 가입을 환영해요!"));

		// 스케줄 기능 추가
		LocalDateTime plus1Days = LocalDateTime.now().plusDays(1);
		notifiers.forEach( n -> {
			n.scheduleNotification("hello!", plus1Days);
		});
	}
}
