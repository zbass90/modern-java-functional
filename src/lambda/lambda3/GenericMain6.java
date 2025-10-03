package lambda.lambda3;

public class GenericMain6 {
	public static void main(String[] args) {
		GenericFunction<String, String> toUpperCase = s -> s.toUpperCase();
		GenericFunction<String, Integer> stringLength = s -> s.length();
		GenericFunction<Integer, Integer> square = n -> n * n;
		GenericFunction<Integer, Boolean> isEven = n -> n % 2 == 0;

		System.out.println(toUpperCase.apply("zbass"));
		System.out.println(stringLength.apply("zbass"));
		System.out.println(square.apply(3));
		System.out.println(isEven.apply(3));
	}

	@FunctionalInterface
	interface GenericFunction<T, R> {
		R apply(T s);
	}
}
