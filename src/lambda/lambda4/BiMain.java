package lambda.lambda4;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;

public class BiMain {
	/**
	 * 아래 add Function의 경우 타입이 같기 때문에 BinaryOperator를 사용하는게 더 적절함.
	 * Supplier는 매개변수가 없으므로 당연히 BiSpplier는 존재하지 않음.
	 *
	 * 입력값이 3개라면 직접 만들어서 사용해야함.
	 */
	public static void main(String[] args) {
		BiFunction<Integer, Integer, Integer> add = (a, b) -> a + b;
		System.out.println("Sum : " + add.apply(5, 10));

		BiConsumer<String, Integer> repeat = (count, num) -> {
			for (int i = 0; i < num; i++) {
				System.out.print(count);
			}
			System.out.println();
		};
		repeat.accept("*", 10);

		BiPredicate<Integer, Integer> isGreater = (a, b) -> a > b;
		System.out.println("isGreater: " + isGreater.test(10, 5));
	}
}
