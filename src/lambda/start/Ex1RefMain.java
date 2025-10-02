package lambda.start;

import java.util.Random;

import lambda.Procedure;

public class Ex1RefMain {
    /**
     * 어떻게 외부에서 코드 조각을 전달할 수 있을까?
     *
     * 동작 매개변수화로 해결 가능!!!
     *
     * 코드 조각을 메서드 안에 두는 것이 아니라,
     * 매개변수를 통해서 외부에서 전달 받아
     * 메서드의 동작을 달리하고 재사용성을 높이는 방법!
     *
     * 자바8에서 등장한 람다로 코드 조각을 매우 편리하게 전달 할 수 있다.
     */
    public static void hello(Procedure procedure) {
        long startNs = System.nanoTime();
        //코드 조각 시작
        procedure.run();
        //코드 조각 종료
        long endNs = System.nanoTime();
        System.out.println("실행 시간: " + (endNs - startNs) + "ns");
    }

    static class Dice implements Procedure {
        @Override
        public void run() {
            //코드 조각 시작
            int randomValue = new Random().nextInt(6) + 1;
            System.out.println("주사위 = " + randomValue);
            //코드 조각 종료
        }
    }

    static class Sum implements Procedure {
        @Override
        public void run() {
            //코드 조각 시작
            for (int i = 1; i <= 3; i++) {
                System.out.println("i = " + i);
            }
            //코드 조각 종료
        }
    }

    public static void main(String[] args) {
        hello(new Dice());
        hello(new Sum());
    }

}