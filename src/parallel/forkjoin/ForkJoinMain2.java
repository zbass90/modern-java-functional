package parallel.forkjoin;

import static util.MyLogger.*;

import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.IntStream;

public class ForkJoinMain2 {
    /**
     * 명시적으로 ForkJoinPool Instance 생성하지 않고 Common Pool 사용
     *
     * invoke() 현재 스레드에서 작업을 시작하지만,
     * fork()로 작업 분할 후에는 공용 풀의 워커 스레드들이 분할된 작업을 처리함.
     *
     * processorCount : 현재 CPU 코어 수
     * parallelism : 동시에 처리할 수 있는 작업 수준(스레드 수와 관련) CPU -1 수 만큼 생성함
     *
     * CPU -1만큼 스레드를 생성하는 이유
     *
     * 1. Fork / Join 작업은 공용 풀의 워커 스레드뿐만 아니라 메인 스레드의 참여 가능
     * 2. 다른 프로세스와의 자원 경쟁 고려
     * 3. 병목을 일으키지 않는 선에서 효율적인 자원 활용
     */
    public static void main(String[] args) {
        int processorCount = Runtime.getRuntime().availableProcessors();
        ForkJoinPool commonPool = ForkJoinPool.commonPool();
        log("processorCount = " + processorCount + ", commonPool = " + commonPool.getParallelism());

        List<Integer> data = IntStream.rangeClosed(1, 8)
                .boxed()
                .toList();

        log("[생성] " + data);
        SumTask task = new SumTask(data);
        Integer result = task.invoke(); // 공용 풀 사용
        log("최종 결과: " + result);
    }
}
