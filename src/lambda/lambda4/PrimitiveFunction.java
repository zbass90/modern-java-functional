package lambda.lambda4;

import java.util.function.IntFunction;
import java.util.function.IntToLongFunction;
import java.util.function.IntUnaryOperator;
import java.util.function.ToIntFunction;

public class PrimitiveFunction {
	/**
	 * 기본형 지원 함수형 인터페이스가 존재하는 이유
	 * 1. 오토박싱/언박싱으로 인한 성능 절감
	 * 2. 자바 제네릭의 한계를 극복하기 위해서
	 *  -> 자바 제네릭은 기본형 타입을 직접 다룰 수 없어서, Function<int, R> 이런 식으로 선언할 수 없다.
	 *
	 */
	public static void main(String[] args) {
		/**
		 * 기본형 매개변수 -> IntFunction, LongFunction, DoubleFunction
		 */
		IntFunction<String> intFunction = x -> "숫자 : " + x;
		System.out.println("intFunction.apply(100) : " + intFunction.apply(100));

		/**
		 * 기본형 반환 -> ToIntFUnction, ToLongFunction, ToDoubleFunction
		 */
		ToIntFunction<String> toIntFunction = s -> s.length();
		System.out.println(toIntFunction.applyAsInt("hello"));

		/**
		 * 기본형 매개변수, 기본형 반환
		 */
		IntToLongFunction intToLongFunction = x -> x * 100L;
		System.out.println(intToLongFunction.applyAsLong(10));

		/**
		 * IntUnaryOperator: int -> int
		 */
		IntUnaryOperator intUnaryOperator = num -> num * 100;
		System.out.println(intUnaryOperator.applyAsInt(10));

		/**
		 * 기타, IntConsumer, IntSupplier, IntPredicate 등 종류가 다양함
		 */
	}
}
