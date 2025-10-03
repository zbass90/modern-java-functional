package lambda.lambda3;

public class TargetType1 {
    /**
     * 람다는 그 자체만으로는 구체적인 타입이 정해져 있지 않고,
     * '타겟 타입'이라고 불리는 맥락 즉, 대입되는 참조형에 의해 타입이 결정된다.
     *
     * 타입이 결정되고 나서는 다른 타입에 대입하는 것이 불가능하다.
     * 이것은 마치 Integer에 String을 대입하는 것과 같다.
     *
     * 그래서 자바가 기본으로 제공하는 수많은 Function 존재!
     */

    public static void main(String[] args) {
        // 람다 직접 대입: 문제 없음
        FunctionA functionA = i -> "value = " + i;
        FunctionB functionB = i -> "value = " + i;

        // 이미 만들어진 FunctionA 인스턴스를 FunctionB에 대입: 불가능
        //FunctionB targetB = functionA; // 컴파일 에러!
    }

    @FunctionalInterface
    interface FunctionA {
        String apply(Integer i);
    }

    @FunctionalInterface
    interface FunctionB {
        String apply(Integer i);
    }
}
