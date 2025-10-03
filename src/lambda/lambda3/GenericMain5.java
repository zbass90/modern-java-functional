package lambda.lambda3;

public class GenericMain5 {
	/**
	 * GenericFunction은 매개변수가 1개, 반환값이 있는 모든 람다에 사용 가능!
	 * 제네릭이 도입된 함수형 인터페이스는 재사용성이 압도적!
	 */
	public static void main(String[] args) {
		GenericFunction<String, String> upperCase = s -> s.toLowerCase();
		String str = upperCase.apply("zbass");
		System.out.println("str = " + str);

		GenericFunction<Integer, Integer> square = n -> n * n;
		Integer num = square.apply(3);
		System.out.println("num = " + num);
	}

	@FunctionalInterface
	interface GenericFunction<T, R> {
		R apply(T s);
	}
}
