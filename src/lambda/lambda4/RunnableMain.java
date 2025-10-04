package lambda.lambda4;

public class RunnableMain {
	/**
	 *
	 * 1. 입력값, 반환값 모두 없는 함수형 인터페이스
	 * 2. 스레드 실행을 위한 인터페이스로 쓰였지만, 자바 8 이후 람다식으로도 많이 표현됨
	 * 3. 업데이트 되면 @FunctionalInterface 애노테이션도 붙음
	 * 4. java.lang 패키지에 위치해서 원래의 하위 호환을 유지함
	 * 5. 주로 멀티스레딩에서 스레드의 작업을 정의할 때 사용함
	 *
	 */
	public static void main(String[] args) {
		Runnable runnable = new Runnable() {
			@Override
			public void run() {
				System.out.println("Runnable start!");
			}
		};
		runnable.run();

		Runnable runnableLambda = () -> System.out.println("Runnable Lambda Start!");
		runnableLambda.run();
	}
}
