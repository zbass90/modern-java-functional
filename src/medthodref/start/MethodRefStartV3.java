package medthodref.start;

import java.util.function.BinaryOperator;

public class MethodRefStartV3 {
    /**
     * 메서드 참조 : 이미 정의된 메서드를 그대로 참조하여 람다 표현식을 더 간결하게 작성하는 방법
     *
     * - 코드가 간결해지고 가독성이 향상
     * - 컴파일러가 매개변수를 자동으로 매칭해서 명시적으로 작성할 필요 없음
     * - 별도의 로직 분리로 인해 재사용성 향상
     */
    public static void main(String[] args) {
        BinaryOperator<Integer> add1 = MethodRefStartV3::add; // (x, y) -> add(x, y)
        BinaryOperator<Integer> add2 = MethodRefStartV3::add; // (x, y) -> add(x, y)

        Integer result1 = add1.apply(1, 2);
        System.out.println("result1 = " + result1);

        Integer result2 = add2.apply(1, 2);
        System.out.println("result2 = " + result2);


    }

    static int add(int x, int y) {
        return x + y;
    }
}
