package stream.basic;

import java.util.List;

import lambda.lambda5.mystream.MyStreamV3;

public class LazyEvalMain1 {
  /**
   * 파이프 라인 구성
   *
   *
   * 일괄 처리(Batch Processing) 비유
   * - 데이터 전체를 한 번에 처리하고, 결과를 저장해두었다가 다음 단계로 넘겨 수행함
   *
   * 파이프라인 처리 비유
   * - 하나의 결과물이 끝나면 다음 단계로 바로 넘겨서 처리함
   *
   */
    public static void main(String[] args) {
        List<Integer> data = List.of(1, 2, 3, 4, 5, 6);
        ex1(data);
        ex2(data);
    }

    private static void ex1(List<Integer> data) {
        System.out.println("== MyStreamV3 시작 ==");
        List<Integer> result = MyStreamV3.of(data)
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
                .toList();
        System.out.println("result = " + result);
        System.out.println("== MyStreamV3 종료 ==");
    }

    private static void ex2(List<Integer> data) {
        System.out.println("== Stream API 시작 ==");
        List<Integer> result = data.stream()
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
                .toList();
        System.out.println("result = " + result);
        System.out.println("== Stream API 종료 ==");
    }
}