package lambda.ex3;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import lambda.ex2.MyPredicate;

public class FilterExampleEx2 {

    /**
     * Predicate<Integer> 또는 IntPredicate 해결하면 됨.
     */
    public static List<Integer> filter(List<Integer> list, Predicate<Integer> predicate) {
        List<Integer> result = new ArrayList<>();
        for (int val : list) {
            if (predicate.test(val)) {
                result.add(val);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<Integer> numbers = List.of(-3, -2, -1, 1, 2, 3, 5);
        System.out.println("원본 리스트: " + numbers);

        List<Integer> negativeQuantity = filter(numbers, num -> num < 0);
        System.out.println("음수만: " + negativeQuantity);

        List<Integer> evenNum = filter(numbers, num -> num % 2 == 0);
        System.out.println("짝수만: " + evenNum);
    }
}