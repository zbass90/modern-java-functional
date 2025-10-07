package lambda.lambda5.mystream;

import java.util.List;

public class MyStreamLoopMain {

    /**
     * 내부 반복 : 반복의 제어를 스트림에게 위임하기 때문에 코드가 간결
     *           개발자는 어떤 작업을 할지 집중하고 어떻게 순회할지 스트림이 담당하도록 개발
     *           => 선언형 프로그래밍 스타일
     *
     * 외부 반복 : 개발자가 직접 반복 구조를 제어함
     *           => 간단한 1~2줄 코드 수행 혹은 반복 제어에 대한 복잡하고 세밀한 조정이 필요한 경우에 사용
     *           ex) break, continue 등을 사용하는 경우
     */
    public static void main(String[] args) {
        List<Student> students = List.of(
                new Student("Apple", 100),
                new Student("Banana", 80),
                new Student("Berry", 50),
                new Student("Tomato", 40)
        );

        List<String> result = MyStreamV3.of(students)
                .filter(s -> s.getScore() >= 80)
                .map(s -> s.getName())
                .toList();

        // 외부 반복
        for (String s : result) {
            System.out.println("name: " + s);
        }

        // 추가
        MyStreamV3.of(students)
                .filter(s -> s.getScore() >= 80)
                .map(s -> s.getName())
                .forEach(name -> System.out.println("name: " + name));
    }

}
