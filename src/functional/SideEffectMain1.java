package functional;

import java.util.function.Function;

public class SideEffectMain1 {
    /**
     * count 가 변한다? 외부 상태 변화가 부수 효과의 대표적인 예
     */
    public static int count = 0;

    public static void main(String[] args) {
        System.out.println("before count = " + count);

        Function<Integer, Integer> func = x -> {
            count++;
            return x * 2;
        };
        func.apply(10);
        System.out.println("after count = " + count);
    }
}
