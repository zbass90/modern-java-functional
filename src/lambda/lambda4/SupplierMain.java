package lambda.lambda4;

import java.util.Random;
import java.util.function.Supplier;

public class SupplierMain {
	/**
	 * 입력을 받지 않고 어떤 데이터를 공급해주는 함수형 인터페이스
	 * ex) 객체나 값 생성, 지연 초기화 등
	 */
	public static void main(String[] args) {
		// 익명 클래스
		Supplier<Integer> randomInteger = new Supplier<Integer>() {
			@Override
			public Integer get() {
				return new Random().nextInt(10);
			}
		};
		System.out.println("익명 클래스 randomInteger.get() : " + randomInteger.get());

		// 람다로 변환
		Supplier<Integer> randomIntegerLambda = () -> new Random().nextInt(10);
		System.out.println("람다 randomIntegerLambda.get() : " + randomIntegerLambda.get());
	}
}
