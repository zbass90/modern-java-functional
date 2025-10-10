package stream.operation;

import java.util.IntSummaryStatistics;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class PrimitiveStreamMain {
    /**
     *
     * 기본형 특화 스트림을 사용하면 숫자 계산을 간편하게 처리 가능,
     * 박싱/언박싱 오버헤드를 줄여 성능상의 이점도 얻음
     *
     * 객체 스트림 <-> 기본형 특화 스트림 자유롭게 가능(matToXXX, boxed(), summaryStatistics() 등
     *
     *
     * 성능은 대략 참고
     * 1. 전통적인 for()가 보통 가장 빠름
     * 2. 스트림보다 전통적인 for()가 1.5배 ~ 2배정도 빠름
     *  - 여기서 말하는 스트림은 Integer 같은 객체를 다루는 Stream()을 말함
     *  - 박싱 / 언박싱 오버헤드가 발생함
     * 3. 기본형 특화 스트림은 전통적인 for()에 가까운 성능을 보임
     *  - 전통적인 for()과 거의 비슷하거나, 전통적인 for()이 10% - 20% 정도 더 빠름
     *  - 박싱 / 언박싱 오버헤드 피함
     *  - 내부적으로 최적화된 연산을 수행 가능
     *
     *  실무에서는...?
     *  - 이런 성능 차이는 일반적인 애플리케이션에서는 거의 차이가 없음....
     *  따.라.서 코드의 가독성과 유지보성을 위해 스트림 API 사용 하는 것을 지향함.
     *
     */
    public static void main(String[] args) {
        // 기본형 특화 스트림 생성(IntStream, LongStream, DoubleStream)
        IntStream stream = IntStream.of(1, 2, 3, 4, 5);
        stream.forEach(i -> System.out.print(i + " "));
        System.out.println();

        // 범위 생성 메서드 (IntStream, LongStream)
        IntStream range1 = IntStream.range(1, 6); // [1,2,3,4,5]
        IntStream range2 = IntStream.rangeClosed(1, 5); // [1,2,3,4,5]

        range1.forEach(i -> System.out.print(i + " "));
        System.out.println();

        range2.forEach(i -> System.out.print(i + " "));
        System.out.println();

        // 1. 통계 관련 메서드(sum, average, max, min, count)
        int sum = IntStream.range(1, 6).sum();
        System.out.println("sum = " + sum);

        // average(): 평균값 계산
        double avg = IntStream.range(1, 6)
                .average()
                .getAsDouble();
        System.out.println("avg = " + avg);

        // summaryStatistics(): 모든 통계 정보 - 이게 좀 대박;
        IntSummaryStatistics stats = IntStream.range(1, 6).summaryStatistics();
        System.out.println("합계: "+ stats.getSum());
        System.out.println("평균: "+ stats.getAverage());
        System.out.println("최대값: "+ stats.getMax());
        System.out.println("최소값: "+ stats.getMin());
        System.out.println("개수: "+ stats.getCount());

        // 2. 타입 변환 메서드
        // IntStream -> LongStream
        LongStream longStream = IntStream.range(1, 5).asLongStream();
        // IntStream -> DoubleStream
        DoubleStream doubleStream = IntStream.range(1, 5).asDoubleStream();

        // IntStream -> Stream<Integer>
        Stream<Integer> boxedStream = IntStream.range(1, 5).boxed();

        // 3. 기본형 특화 매핑
        // int -> long 변환 매핑
        LongStream mappedLong = IntStream.range(1, 5)
                .mapToLong(i -> i * 10L);

        // int -> double
        DoubleStream mappedDouble = IntStream.range(1, 5)
                .mapToDouble(i -> i * 1.5);

        // int -> 객체 변환 매핑
        Stream<String> mappedObj = IntStream.range(1, 5)
                .mapToObj(i -> "Number: " + i);

        // 4. 객체 스트림 -> 기본형 특화 스트림으로 매핑
        Stream<Integer> integerStream = Stream.of(1, 2, 3, 4, 5);
        IntStream intStream = integerStream.mapToInt(i -> i);
        IntSummaryStatistics intSummaryStatistics = intStream.summaryStatistics();
        System.out.println("intSummaryStatistics = " + intSummaryStatistics);

        // 5. 객체 스트림 -> 기본형 특화 스트림으로 매핑 활용
        int result = Stream.of(1, 2, 3, 4, 5)
                .mapToInt(i -> i)
                .sum();
        System.out.println("result = " + result);
    }
}
