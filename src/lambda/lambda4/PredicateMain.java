package lambda.lambda4;

import java.util.function.Predicate;

public class PredicateMain {
	/**
	 * 특화 함수형 인터페이스
	 * Predicate : 입력 O, 반환은 boolean
	 * ex) 조건 검사, 필터링 용도
	 *
	 * => 수학/논리학에서 "술어" 즉, 참/거짓을 판별하는 명제를 표현한다.
	 *
	 * <Predicate 꼭 필요한가?> => Function 으로도 가능하지만 필요한 이유는 아래와 같다.
	 * 1. 의미의 명확성
	 * 2. 가독성 및 유지보수성(직관성으로 협업에 유리)
	 *
	 * => 목적(조건 검사)과 용도(필터링 등)에 대해 더 분명하게 표현하고,
	 * 		가독성과 유지보수를 위해 Predicate<T> 별도의 함수형 인터페이스가 필요함
	 *
	 */
	public static void main(String[] args) {
		// 익명 클래스
		Predicate<Integer> integerPredicate = new Predicate<Integer>() {
			@Override
			public boolean test(Integer num) {
				return num % 2 == 0;
			}
		};

		System.out.println("5는 : " + integerPredicate.test(5));

		// 람다로 변환
		Predicate<Integer> integerPredicateLambda = n -> n % 2 == 0;
		System.out.println("10은 : " + integerPredicateLambda.test(10));
	}
}
