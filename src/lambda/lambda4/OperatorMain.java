package lambda.lambda4;

import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.UnaryOperator;

public class OperatorMain {

	/**
	 *
	 * Operator(UnaryOperator, BinaryOperator) : 입력, 반환 O
	 * ex) 동일한 타입의 연산 수행, 입력과 같은 타입을 반환하는 연산 용도
	 *
	 * 수학에서 연산자는 보통 같은 타입의 값들을 받아서 동일한 타입의 결과를 반환!
	 * ex) 덧셈 연산자(+) : 숫자 + 숫자 -> 숫자
	 * 		곱센 연산자(*) : 숫자 * 숫자 -> 숫자
	 * 		논리 연산자(AND) : boolean AND boolean -> boolean
	 *
	 * UnaryOperator -> 단항 연산은 하나의 피연산자에 대해 연산을 수행
	 * Function을 상속받아서 대입이 가능!
	 *
	 * BinaryOperator -> 이항 연산은 두개의 피연산자에 대해 연산을 수행
	 * BiFunction을 상속받아서 대입이 가능! -> T 2개를 입력받아서 모두 같은 T로 반환
	 *
	 * Function, BiFunction 으로 왠만해서 커버가 가능하지만
	 * 의도(목적)의 명시성, 가독성과 유지보수성을 위함이다.
	 */
	public static void main(String[] args) {
		// UnaryOperator
		Function<Integer, Integer> square1 = x -> x * x;
		UnaryOperator<Integer> squareUnary = x -> x	* x;
		System.out.println("square1.apply(5) : " + square1.apply(5));
		System.out.println("squareUnary.apply(5) : " + squareUnary.apply(5));

		// BinaryOperator
		BiFunction<Integer, Integer, Integer> addition1 = (a, b) -> a + b;
		BinaryOperator<Integer> addition2 = (a, b) -> a + b;

		System.out.println("addition1 : " + addition1.apply(1,3));
		System.out.println("addition2 : " + addition2.apply(1,3));
	}
}
