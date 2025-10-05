package lambda.ex3;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class MapExample {

    /**
     * UnaryOperator<String> 또는 Function<String, String> 해결하면 됨.
     */
    public static List<String> map(List<String> list, Function<String, String> func) {
        List<String> result = new ArrayList<>();
        for (String str : list) { //"hello", "java", "lambda"
            result.add(func.apply(str));
        }
        return result;
    }

    public static void main(String[] args) {
        List<String> words = List.of("hello", "java", "lambda");
        System.out.println("원본 리스트: " + words);
        // 1. 대문자 변환
        List<String> upperCaseList = map(words, str -> str.toUpperCase());
        System.out.println(upperCaseList);

        // 2. 앞뒤에 *** 붙이기 (람다로 작성)
        List<String> specialString = map(words, str -> String.format("***%s***", str));
        System.out.println(specialString);

        // 1. 대문자 변환
        List<String> upperList = map(words, s -> s.toUpperCase());
        System.out.println("대문자 변환 결과: " + upperList);

        // 2. 앞뒤에 *** 붙이기 (람다로 작성)
        List<String> decoratedList = map(words, s -> "***" + s + "***");
        System.out.println("특수문자 데코 결과: " + decoratedList);
    }
}