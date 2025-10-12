package parallel;

import static util.MyLogger.*;

import java.util.concurrent.ForkJoinPool;
import java.util.stream.IntStream;

public class ParallelMain4 {
    /**
     * [ForkJoinPool]
     *
     * - Fork / Join 작업을 실행하는 특수한 ExecutorService 스레드 풀이다.
     * - 작업 스케줄링 및 스레드 관리를 담당
     * - 기본적으로 사용 가능한 프로세서 수 만큼 스레드 생성
     * - 분할 정복과 작업 훔치기에 특화된 스레드 풀임!!!
     *
     * [ForkJoinTask]
     *
     * - Fork / Join 작업의 기본 추상 클래스
     * - Future 구현함
     *
     * - 개발자는 아래 두 하위 클래스를 구현해서 사용함
     *      1. RecursiveTask<V> : 결과를 반환하는 작업
     *      2. RecursiveAction : 결과를 반환지 않는 작업(void)
     *
     *
     *  .parallel() 추가를 통해 병렬 스트림 가능!!!!
     *  => Stream 에서 parallel()를 선언하면 공용 ForkJoinPool을 사용하고,
     *      내부적으로 병렬 처리 가능한 스레드 숫자와 작업의 크기 등을 확인하면서,
     *      Spliterator를 통해 데이터를 자동으로 분할한다.
     *
     *      분할 방식은 데이터 소스의 특성에 따라 최적화되어 있다....허허
     *
     *      그리고 공용 풀을 통해 작업을 적절한 수준으로 분할(Fork), 처리(Execute)하고 그 결과를 모은다(Join)
     *
     *  ***********물론 주의사항이 있음*************
     *  ***********병렬 스트림 사용 시 주의점********
     *
     *  !!!Fork / Join 프레임워크는 CPU 바운드 작업에만 사용해라!!!
     *
     *  I/O 바운드 작업에는 적합하지 않다.
     *  예) 외부 API 호출, 데이터베이스 조회
     *
     *  1. 스레드 블로킹에 따른 CPU 낭비
     *  - ForkJoinPool은 CPU 코어 수에 맞춰 제한된 개수의 스레드를 사용함 ( 특히 공용 풀 )
     *  - I/O 작업으로 스레드가 블로킹되면 CPU가 놀게 되어, 전체 병렬 처리 효율이 크게 떨어짐
     *
     *  2. 컨텍스트 스위칭 오버헤드 증가
     *  - I/O 작업 때문에 스레드를 놀리면, 실제 연산보다 대기 시간이 길어지는 상황이 발생함
     *  - 스레드가 많아질수록 컨텍스트 스위칭 비용도 증가하여 오히려 성능이 떨어짐
     *
     *  3. 작업 훔치기 기법 무력화
     *  - ForkJoinPool이 제공하는 작업 훔치기 알고리즘은, CPU 바운드 작업에서 빠르게 작업 단위를 계속 처리하도록 설계됨
     *  - I/O 대기 시간이 많은 작업은 스레드가 I/O로 인해 대기하고 있는 경우가 많아, 병렬 처리의 장점을 살리기 어려움
     *
     *  4. 분할-정복(작업 분할) 이점 감소
     *  - Fork / Join 방식을 통해 작업을 잘게 나누어도, I/O 병목 발생하면 CPU 병렬화 이점이 크게 줌
     *  - 오히려 분할된 작업들이 각기 I/O 대기를 반복하며, fork(), join()에 따른 오버헤드만 증가함
     *
     *  따.라.서
     *  I/O 바운드 작업은 별도의 전용 스레드 풀을 사용하는 편이 더 적합하다.
     *  예) Executors.newFixedThreadPool() 등등
     *
     */
    public static void main(String[] args) {
        int processorCount = Runtime.getRuntime().availableProcessors();
        ForkJoinPool commonPool = ForkJoinPool.commonPool();
        log("processorCount = " + processorCount + ", commonPool = " + commonPool.getParallelism());

        long startTime = System.currentTimeMillis();

        int sum = IntStream.rangeClosed(1, 8)
                .parallel() // 추가
                .map(HeavyJob::heavyTask)
                .reduce(0, (a, b) -> a + b); // sum();

        long endTime = System.currentTimeMillis();
        log("time: " + (endTime - startTime) + "ms, sum: " + sum);
    }
}
