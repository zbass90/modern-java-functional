package lambda.lambda1;

public class SamMain {

    public static void main(String[] args) {
        SamInterface samInterface = () -> {
            System.out.println("sam");
        };
        samInterface.run();

        // 컴파일 오류
        /**
         * NotSamInterface 함수형 인터페이스가 아니라는 컴파일 오류 발생
         *
         * 람다는 하나의 함수 -> 인터페이스에 담으려면 하나만 할당해야함
         * 단, 하나의 추상 메서드 (SAM: Single Abstract Method)
         *
         * @FunctionalInterface : 컴파일 단계에서 오류가 발생하여 함수형 인터페이스를 보장함
         *                       -> 누군가 실수로 추상 메서드를 추가할 때 컴파일 오류 발생
         */
/*
        NotSamInterface notSamInterface = () -> {
            System.out.println("not sam");
        };
        notSamInterface.go();
        notSamInterface.run();
*/

    }
}
