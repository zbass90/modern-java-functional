package stream.basic;

import java.util.List;
import java.util.stream.Stream;

public class DuplicateExecutionMain {
	/**
	 * 2. 한 번 소비된 스트림은 다시 사용할 수 없으며, 필요하다면 새로 스트림을 생성해야함
	 */
	public static void main(String[] args) {
		// 스트림 중복 실행 확인
		Stream<Integer> stream = Stream.of(1, 2, 3);
		stream.forEach(System.out::println); // 최초로 실행함

		// stream.forEach(System.out::println); // 주석 해제 후 스트림 중복 발생하면 아래 예외 발생함
		// "스트림이 이미 작동했거나 닫혔습니다"라는 예외 발생
		// Exception in thread "main" java.lang.IllegalStateException: stream has already been operated upon or closed

		// 대안 : 대상 리스트를 스트림으로 새로 생성해서 사용하면 됨
		List<Integer> list = List.of(1, 2, 3);
		Stream.of(list).forEach(System.out::println);
		Stream.of(list).forEach(System.out::println);
	}
}
