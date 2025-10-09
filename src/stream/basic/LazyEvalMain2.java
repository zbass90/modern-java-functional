package stream.basic;

import java.util.List;

import lambda.lambda5.mystream.MyStreamV3;

public class LazyEvalMain2 {
  /**
   * 3. 중간 연산은 필요할 때까지 실제로 동작하지 않고, 최종 연산이 실행될 때 한 번에 처리됨
   *
   * toList, forEach() 등 최종 연산을 하지 않으면 Stream이 실행되지 않음
   * ex1 실행하면 log가 확인되는 반면, ex2는 안에 log가 출력되지 않음
   * => 지연 연산을 극명하게 보여주는 예시이다.
   */

    public static void main(String[] args) {
        List<Integer> data = List.of(1, 2, 3, 4, 5, 6);
        ex1(data);
        ex2(data);
    }

    private static void ex1(List<Integer> data) {
        System.out.println("== MyStreamV3 시작 ==");
        MyStreamV3.of(data)
                .filter(i -> {
                    boolean isEven = i % 2 == 0;
                    System.out.println("filter() 실행: " + i + "(" + isEven + ")");
                    return isEven;
                })
                .map(i -> {
                    int mapped = i * 10;
                    System.out.println("map() 실행: " + i + " -> " + mapped);
                    return mapped;
                });
        System.out.println("== MyStreamV3 종료 ==");
    }

    private static void ex2(List<Integer> data) {
        System.out.println("== Stream API 시작 ==");
        data.stream()
                .filter(i -> {
                    boolean isEven = i % 2 == 0;
                    System.out.println("filter() 실행: " + i + "(" + isEven + ")");
                    return isEven;
                })
                .map(i -> {
                    int mapped = i * 10;
                    System.out.println("map() 실행: " + i + " -> " + mapped);
                    return mapped;
                });
        System.out.println("== Stream API 종료 ==");
    }
}
