package parallel;

import static util.MyLogger.*;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class ParallelMain5 {
    /**
     * 왜 요청수가 가면 갈수록 처리 속도가 늦을까?
     *
     * 각 요청 스레드별마다 공용 풀에 작업 요청을 함.
     * 만약 요청 스레드1이 먼저 요청한 상태이고, 요청 스레드2가 공용 풀을 확인하면 스레드가 없음.
     * 결국 요청 스레드1이 끝날때까지 기다려야함.
     *
     *
     * - 공용 풀의 제한된 병렬성
     * - 처리 시간의 불균형 발생
     * - 스레드 작업 분배
     *
     * 핵심 문제점
     * 1. 공용 풀 병목 현상
     * 2. 자원 경쟁
     * 3. 예측 불가능한 성능
     *
     * 요청 스레드 갯수가 많으면 많을수록 처리 시간은 확연하게 올라감!
     * nThreads를 늘리는 것보다 parallel()를 해제하는게 더 빠르다!
     *
     */

    public static void main(String[] args) throws InterruptedException {
        // 병렬 수준 3으로 제한
        System.setProperty("java.util.concurrent.ForkJoinPool.common.parallelism", "3");

        // 요청 풀 추가
        ExecutorService requestPool = Executors.newFixedThreadPool(100);
        int nThreads = 1; // 1, 2, 3, 10, 20
        for (int i = 1; i <= nThreads; i++) {
            String requestName = "request" + i;
            requestPool.submit(() -> logic(requestName));
            Thread.sleep(100); // 스레드 순서를 확인하기 위해 약간 대기
        }
        requestPool.close();
    }

    private static void logic(String requestName) {
        log("[" + requestName + " ] START");
        long startTime = System.currentTimeMillis();

        int sum = IntStream.rangeClosed(1, 4)
                .parallel()
                .map(i -> HeavyJob.heavyTask(i, requestName))
                .reduce(0, (a, b) -> a + b);

        long endTime = System.currentTimeMillis();
        log("[" + requestName + "] time: " + (endTime - startTime) + "ms, sum: " + sum);
    }

}
