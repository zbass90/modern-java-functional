package stream.operation;

import java.util.Optional;

public class OptionalSimpleMain {
    /**
     * Optional에 대한 최소한의 이해를 돕기 위한 예제
     */
    public static void main(String[] args) {
        Optional<Integer> optional1 = Optional.of(10);
        System.out.println("optional1 = " + optional1);
        if (optional1.isPresent()) { // 값이 있는지 확인할 수 있는 안전한 메서드 제공
            Integer i = optional1.get();
            System.out.println("i = " + i);
        }

        Optional<Object> opitonal2 = Optional.ofNullable(null);
        System.out.println("opitonal2 = " + opitonal2);
        if (opitonal2.isPresent()) {
            Object o = opitonal2.get();
            System.out.println("o = " + o);
        }

        // 값이 없는 Optional에서 get()을 호출하면 NoSuchElementException 발생한다.
        Object o2 = opitonal2.get();
        System.out.println("o2 = " + o2);
    }
}
