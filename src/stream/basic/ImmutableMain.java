package stream.basic;

import java.util.List;

public class ImmutableMain {
	/**
   * 1. 데이터 소스를 변경하지 않음(Immutable) -> 원본 컬렉션을 변경하지 않고 결과만 새로 생성함
	 */
	public static void main(String[] args) {
		List<Integer> originList = List.of(1, 2, 3, 4, 5);
		System.out.println("originList = " + originList);

		List<Integer> filteredList = originList.stream()
			.filter(n -> n % 2 == 0)
			.toList();
		System.out.println("filteredList = " + filteredList);
		System.out.println("originList = " + originList);
	}
}
