package stream.operation;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class CreateStreamMain {
	public static void main(String[] args) throws IOException {

		System.out.println("1. 컬렉션으로부터 생성");
		List<String> list = List.of("a", "b", "c");
		Stream<String> stream1 = list.stream();
		stream1.forEach(System.out::println);

		System.out.println("\n2. 배열로부터 생성");
		String[] arr = {"a", "b", "c"};
		Stream<String> stream2 = Arrays.stream(arr);
		stream2.forEach(System.out::println);

		System.out.println("\n3. Stream.of() 사용");
		Stream<String> stream3 = Stream.of("a", "b", "c");
		stream3.forEach(System.out::println);

		System.out.println("\n4. 기본형 스트림 - IntStream.range()");
		// 0 이상 5 미만의 정수 스트림
		IntStream intStream = IntStream.range(0, 5);
		intStream.forEach(System.out::println);

		System.out.println("\n5. 무한 스트림 - iterate()");
		// 초기값 0, 다음값 n+2
		Stream<Integer> evenNumbers = Stream.iterate(0, n -> n + 2);
		evenNumbers.limit(5).forEach(System.out::println);

		System.out.println("\n6. 무한 스트림 - generate()");
		// Supplier를 이용해 무한 생성 (난수 예시)
		Stream<Double> randomStream = Stream.generate(Math::random);
		randomStream.limit(3).forEach(System.out::println);

		System.out.println("\n7. Stream.builder()");
		// 빌더 패턴처럼 수동으로 요소를 추가 후 build()
		Stream<String> builderStream = Stream.<String>builder()
			.add("alpha")
			.add("beta")
			.add("gamma")
			.build();
		builderStream.forEach(System.out::println);

		System.out.println("\n8. Files.lines() - 파일로부터 스트림 생성");
		// 파일의 각 줄을 스트림으로 읽기 (try-with-resources로 자동 close)
		Path path = Files.createTempFile("stream-example", ".txt");
		Files.write(path, List.of("line1", "line2", "line3"));
		try (Stream<String> lineStream = Files.lines(path)) {
			lineStream.forEach(System.out::println);
		}

		System.out.println("\n9. Pattern.splitAsStream() - 정규식 분리");
		// 문자열을 정규식 기준으로 나누어 스트림으로 처리
		String csv = "apple,banana,orange";
		Pattern pattern = Pattern.compile(",");
		Stream<String> splitStream = pattern.splitAsStream(csv);
		splitStream.forEach(System.out::println);

		System.out.println("\n10. Stream.concat() - 스트림 병합");
		Stream<String> s1 = Stream.of("A", "B");
		Stream<String> s2 = Stream.of("C", "D");
		Stream<String> merged = Stream.concat(s1, s2);
		merged.forEach(System.out::println);

		System.out.println("\n11. Stream.empty() - 빈 스트림 생성");
		Stream<String> empty = Stream.empty();
		System.out.println("empty count = " + empty.count());

		System.out.println("\n✅ Stream 생성 완전판 예제 종료");
	}
}
