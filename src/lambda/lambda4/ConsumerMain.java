package lambda.lambda4;

import java.util.function.Consumer;

public class ConsumerMain {
	/**
	 * 입력 값(T)만 받고, 결과를 반환하지 않는(void) 연산을 수행하는 함수형 인터페이스
	 * Consumer => "소비자" 의미로, 데이터를 받아서 소비(사용)만 하고 아무것도 돌려주지 않는다는 개념을 표현
	 * accept => "받아들이다" 의미로, 입력값을 받아들여서 처리한다는 동작을 설명
	 *
	 * ex) 컬렉션에 값 추가, 콘솔 출력, 로그 작성, DB 저장 등 ...
	 *
	 * => 입력을 받아 소비를 한다.
	 */
	public static void main(String[] args) {
		// 익명 클래스
		Consumer<String> log = new Consumer<String>() {
			@Override
			public void accept(String s) {
				System.out.println(s);
			}
		};

		log.accept("log 출력");

		// 람다로 변환
		Consumer<String> lambdaLog = s -> System.out.println(s);
		lambdaLog.accept("lambda log 출력");
	}
}
