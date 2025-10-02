package lambda.lambda1;

import lambda.Procedure;

public class InstanceMain {
    /**
     *
     * class.class = class lambda.lambda1.InstanceMain$1
     * class.instance = lambda.lambda1.InstanceMain$1@6f496d9f
     * lambda.class = class lambda.lambda1.InstanceMain$$Lambda/0x000000012b003948
     * lambda.instance = lambda.lambda1.InstanceMain$$Lambda/0x000000012b003948@10f87f48
     *
     * 익명 클래스 : $(순번)
     * 인스턴스 : $(순번)@ -> getClass().getName() + "@" + Integer.toHexString(hashCode());
     * 람다 : $$Lambda/숫자(JVM 내부에서 식별하기 위한 해시값/주소 기반 ID)
     *
     */

    public static void main(String[] args) {
        int procedure11 = System.identityHashCode("procedure1");
        Procedure procedure1 = new Procedure() {
            @Override
            public void run() {
                System.out.println("hello! lambda");
            }
        };
        System.out.println("class.class = " + procedure1.getClass());
        System.out.println("class.instance = " + procedure1);

        Procedure procedure2 = () -> {
            System.out.println("hello! lambda");
        };
        System.out.println("lambda.class = " + procedure2.getClass());
        System.out.println("lambda.instance = " + procedure2);

    }
}
