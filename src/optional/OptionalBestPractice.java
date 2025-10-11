package optional;

public class OptionalBestPractice {
	/**
	 * 1. 반환값으로 사용하되, 클래스 필드에는 Optional 사용 금지
	 * 2. 메서드 파라미터로 Optional 받기 금지
	 * 3. 컬렉을 Optional 감싸기 금지
	 * 4. isPresent() + get() 조합 금지
	 * 5. orElse() vs orElseGet() 차이 이해하고 사용
	 * 6. 무조건 Optional 정답이 아님
	 *
	 * => 값이 무조건 있거나, 없거나, 예외를 던지는게 자연스러울 경우에는 사용 금지!
	 */
}
