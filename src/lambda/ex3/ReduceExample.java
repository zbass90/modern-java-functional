package lambda.ex3;

import java.util.List;
import java.util.function.BinaryOperator;

public class ReduceExample {

    /**
     * BinaryOperator<Integer> 또는 IntBinaryOperator 해결!
     * BiFunction으로 풀 수 있지만, Operator가 입, 출력에 대한 의도를 명확히 들어내서 확실한 선택이다.
     */
    public static int reduce(List<Integer> list, int initial, BinaryOperator<Integer> reducer) {
        int result = initial;
        for (int val : list) {
            result = reducer.apply(result, val);
        }
        return result;
    }

    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4);
        System.out.println("리스트: " + numbers);

        // 1. 합 구하기 (초기값 0, 덧셈 로직)
        int sum = reduce(numbers, 0, (a, b) -> a + b);
        System.out.println("합(누적 +): " + sum);

        // 2. 곱 구하기 (초기값 1, 곱셈 로직)
        int product = reduce(numbers, 1, (a, b) -> a * b);
        System.out.println("곱(누적 *): " + product);
    }
}