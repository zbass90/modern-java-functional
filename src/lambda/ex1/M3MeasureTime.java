package lambda.ex1;

import java.util.Arrays;

import lambda.Procedure;

public class M3MeasureTime {

    // 공통: 실행 시간 측정 메서드
    public static void measure(Procedure p) {
        long startNs = System.nanoTime();
        p.run(); // 바뀌는 로직 실행 (익명 클래스 or 람다로 전달)
        long endNs = System.nanoTime();
        System.out.println("실행 시간: " + (endNs - startNs) + "ns");
    }

    public static void main(String[] args) {
        // 1. 익명 클래스로 1부터 N까지 합 구하기
        measure(new Procedure() {
            @Override
            public void run() {
                int N = 100;
                long sum = 0;
                for (int i = 0; i < N; i++) {
                    sum += i;
                }
                System.out.println("[1부터 " + N + " 까지의 합] 결과: " + sum);
            }
        });

        // 2. 익명 클래스로 배열 정렬
        measure(new Procedure() {
            @Override
            public void run() {
                int[] arr = {4, 3, 2, 1};
                System.out.println("원본 배열: " + Arrays.toString(arr));
                Arrays.sort(arr);
                System.out.println("배열 정렬: " + Arrays.toString(arr));
            }
        });
    }
}
