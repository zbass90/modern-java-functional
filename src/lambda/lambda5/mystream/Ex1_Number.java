package lambda.lambda5.mystream;

import java.util.ArrayList;
import java.util.List;

import lambda.lambda5.filter.GenericFilter;
import lambda.lambda5.map.GenericMapper;

public class Ex1_Number {
    /**
     * direct() : 프로그램을 [어떻게 수행]해야 하는지 수행 절차를 명시 -> 명령형 프로그래밍
     * lambda() : [무엇을 수행]해야 하는지 원하는 결과에 초점을 맞춤 -> 선언적 프로그래밍
     */
    public static void main(String[] args) {
        // 짝수만 남기고, 남은 값의 2배를 반환
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        List<Integer> directResult = direct(numbers);
        System.out.println("directResult = " + directResult);

        List<Integer> lambdaResult = lambda(numbers);
        System.out.println("lambdaResult = " + lambdaResult);
    }
    static List<Integer> direct(List<Integer> numbers) {
        List<Integer> result = new ArrayList<>();

        for (Integer number : numbers) {
            if (number % 2 == 0) { // 짝수 필터링
                int numberX2 = number * 2;
                result.add(numberX2); // 2배로 변환하여 추가
            }
        }
        return result;
    }

    static List<Integer> lambda(List<Integer> numbers) {
        List<Integer> filter = GenericFilter.filter(numbers, n -> n % 2 == 0);
        return GenericMapper.map(filter, n -> n * 2);
    }
}