package lambda.start;

public class Ex0RefMain {
	/**
	 * 프로그래밍에서 중복을 제거하고, 좋은 코드를 유지하는 핵심은
	 * 변하는 부분과 변하지 않는 부분을 분리하는 것이다.
	 *
	 * 매개변수를 통해 외부에서 받아서 메서드의 동작을 달리하고
	 * 재사용성을 높이는 방법을 '값 매개변수화' 한다.
	 */
	public static void hello(String msg) {
		System.out.println("프로그램 시작"); // 변하지 않는 부분
		System.out.println(msg); // 변하는 부분
		System.out.println("프로그램 종료"); // 변하지 않는 부분
	}

	public static void main(String[] args) {
		hello("Hello Java");
		hello("Hello Spring");
	}
}
