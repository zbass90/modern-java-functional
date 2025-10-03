package lambda.lambda3;

public class GenericMain4 {
	public static void main(String[] args) {
		GenericFunction<String, String> upperCase = new GenericFunction<String, String>() {
			@Override
			public String apply(String s) {
				return s.toLowerCase();
			}
		};
		String str = upperCase.apply("zbass");
		System.out.println("str = " + str);

		GenericFunction<Integer, Integer> square = new GenericFunction<Integer, Integer>() {
			@Override
			public Integer apply(Integer n) {
				return n * n;
			}
		};
		Integer num = square.apply(3);
		System.out.println("num = " + num);
	}

	@FunctionalInterface
	interface GenericFunction<T, R> {
		R apply(T s);
	}
}
