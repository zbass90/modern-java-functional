package lambda.lambda3;

public class GenericMain2 {
	/**
	 * Object로 변경해도 되지만 모든걸 캐스팅해야해서 상당히 복잡하고 안전하지 않은 캐스팅 과정이 필요하다.
	 *
	 */
	public static void main(String[] args) {
		ObjectFunction upperCase = s -> ((String)s).toLowerCase();
		String str = (String) upperCase.apply("zbass");
		System.out.println("str = " + str);

		ObjectFunction square = n -> (Integer)n * (Integer)n;
		Integer num = (Integer) square.apply(3);
		System.out.println("num = " + num);
	}

	@FunctionalInterface
	interface ObjectFunction {
		Object apply(Object s);
	}
}
