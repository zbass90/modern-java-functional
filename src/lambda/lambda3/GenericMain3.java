package lambda.lambda3;

public class GenericMain3 {
	/**
	 * 익명 클래스로 변환해도 당연히 결과는 동일하다.
	 * 결국,코드 재사용과 타입 안전성이라는 두 마리 토끼를 잡기가 어렵다.
	 *
	 * 각각 타입별로 함수형 인터페이스를 정의하면 코드 재사용 X, 타입 안전성 O
	 * Object 다형성을 활용해서 하나의 함수형 인터페이스만 정의하면 코드 재사용 O, 타입 안전성 X
	 *
	 * 대안은 제네릭...
	 */
	public static void main(String[] args) {
		ObjectFunction upperCase = new ObjectFunction() {
			@Override
			public Object apply(Object s) {
				return ((String)s).toLowerCase();
			}
		};
		String str = (String) upperCase.apply("zbass");
		System.out.println("str = " + str);

		ObjectFunction square = new ObjectFunction() {
			@Override
			public Object apply(Object n) {
				return (Integer)n * (Integer)n;
			}
		};
		Integer num = (Integer) square.apply(3);
		System.out.println("num = " + num);
	}

	@FunctionalInterface
	interface ObjectFunction {
		Object apply(Object s);
	}
}
