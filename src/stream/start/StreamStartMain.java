package stream.start;

import java.util.List;
import java.util.stream.Stream;

public class StreamStartMain {
    /**
     *
     * [스트림 API]
     * - 스트림은 자바 8부터 추가된 기능으로 데이터의 흐름을 추상화해서 다루는 도구
     * - 컬렉션 or 배열 등의 요소들을 연산 파이프라인을 통해 연속적인 형태로 처리 가능
     *
     * [용어 : 파이프라인]
     * 스트림이 여러 단계를 거쳐 변환되고 처리되는 모습이 마치 물이 여러 관을 타고 이동, 정수, 필터를 거치는 과정과 유사
     *
     * [스트림의 특징]
     * 1. 데이터 소스를 변경하지 않음(Immutable) -> 원본 컬렉션을 변경하지 않고 결과만 새로 생성함
     * 2. 한 번 소비된 스트림은 다시 사용할 수 없으며, 필요하다면 새로 스트림을 생성해야함
     * 3. 중간 연산은 필요할 때까지 실제로 동작하지 않고, 최종 연산이 실행될 때 한 번에 처리됨
     * 4. 스트림으로부터 병렬 스트림(Parallel Stream)을 쉽게 만들 수 있어,
     *    멀티코어 환경에서 병렬 연산을 비교적 단순한 코드로 작성 가능
     *
     */
    public static void main(String[] args) {
        List<String> names = List.of("Apple", "Banana", "Berry", "Tomato");

        // "B"로 시작하는 이름만 필터 후 대문자로 바꿔서 리스트 수집
        Stream<String> stream = names.stream();
        List<String> result = stream
                .filter(name -> name.startsWith("B"))
                .map(s -> s.toUpperCase())
                .toList();

        System.out.println("=== 외부 반복 ===");
        for (String s : result) {
            System.out.println(s);
        }

        System.out.println("=== forEach, 내부 반복 ===");
        names.stream()
                .filter(name -> name.startsWith("B"))
                .map(s -> s.toUpperCase())
                .forEach(s -> System.out.println(s));

        System.out.println("=== 메서드 참조 ===");
        names.stream()
                .filter(name -> name.startsWith("B"))
                .map(String::toUpperCase)
                .forEach(System.out::println);
    }
}