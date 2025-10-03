package lambda.lambda3;

public class GenericMain1 {
	/**
	 * StringFunction, NumberFunction 의 차이는 매개변수의 타입이 다를 뿐이다.
	 * 따라서, Object 타입으로 합쳐보자.
	 * 서서히 빌드업의 과정을 거친다.
	 * GenericMain2로 이동
	 *
	 */
	public static void main(String[] args) {
		StringFunction upperCase = s -> s.toLowerCase();
		String str = upperCase.apply("zbass");
		System.out.println("str = " + str);

		NumberFunction square = n -> n * n;
		Integer num = square.apply(3);
		System.out.println("num = " + num);
	}

	@FunctionalInterface
	interface StringFunction {
		String apply(String s);
	}

	@FunctionalInterface
	interface NumberFunction {
		Integer apply(Integer s);
	}
}
