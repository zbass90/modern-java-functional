package lambda.lambda4;

import java.util.function.Function;

public class FunctionMain {

    public static void main(String[] args) {
        // 익명 클래스
        /**
         * 직접 코딩하고 익혀야, 친해지는 시간이 필요하다.
         */
        Function<String, Integer> function1 = new Function<String, Integer>() {
            @Override
            public Integer apply(String s) {
                return s.length();
            }
        };
        System.out.println("function1 ? " + function1.apply("hello"));

        //람다로 변환
        Function<String, Integer> function2 = s -> s.length();
        System.out.println("function ? " + function2.apply("hello"));
    }
}
