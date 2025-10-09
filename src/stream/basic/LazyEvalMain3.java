package stream.basic;

import java.util.List;

import lambda.lambda5.mystream.MyStreamV3;

public class LazyEvalMain3 {
  /**
   * 단축 평가(short-circuit)라 하며, 조건을 만족하는 결과를 찾으면 더 이상 연산을 진행하지 않는 방식!
   * 지연 연산과 파이프라인 방식이 있기 때문에 가능한 최적화 중 하나!
   */
    public static void main(String[] args) {
        List<Integer> data = List.of(1, 2, 3, 4, 5, 6);
        ex1(data);
        ex2(data);
    }

    private static void ex1(List<Integer> data) {
        System.out.println("== MyStreamV3 시작 ==");
        Integer result = MyStreamV3.of(data)
                .filter(i -> {
                    boolean isEven = i % 2 == 0;
                    System.out.println("filter() 실행: " + i + "(" + isEven + ")");
                    return isEven;
                })
                .map(i -> {
                    int mapped = i * 10;
                    System.out.println("map() 실행: " + i + " -> " + mapped);
                    return mapped;
                })
                .getFirst();
        System.out.println("result = " + result);
        System.out.println("== MyStreamV3 종료 ==");
    }

    private static void ex2(List<Integer> data) {
        System.out.println("== Stream API 시작 ==");
        Integer result = data.stream()
                .filter(i -> {
                    boolean isEven = i % 2 == 0;
                    System.out.println("filter() 실행: " + i + "(" + isEven + ")");
                    return isEven;
                })
                .map(i -> {
                    int mapped = i * 10;
                    System.out.println("map() 실행: " + i + " -> " + mapped);
                    return mapped;
                })
                .findFirst().get();
        System.out.println("result = " + result);
        System.out.println("== Stream API 종료 ==");
    }
}
