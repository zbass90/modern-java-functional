package lambda.lambda5.mystream;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

// static factory 추가
public class MyStreamV2 {
    /**
     * 정적 팩토리 메서드 : 객체 생성을 담당하는 static method로 생성자(constructor)대신
     *                  인스턴스를 생성하고 반환하는 역할을 한다.
     *                  일반적인 생성자 대신 클래스의 인스턴스를 생성하고 초기화하는 로직을
     *                  캡슐화하여 제공하는 정적 메서드이다.
     *
     * 주요 특징 :
     *  1. 클래스 레벨에서 호출되며, 인스턴스 생성 없이 접근 가능.
     *  2. 내부에서 생성하느 객체(또는 이미 존재하는 객체)를 반환.
     *  3. 생성자와 달리 메서드 이름을 명시하여 생성 과정의 목적을 명확하게 표현 가능.
     *  4. 객체 생성 과정에서 캐싱, 객체 재활용, 하위 타입 객체 반환 등 다양한 로직 적용 가능.
     */

    private List<Integer> internalList;

    private MyStreamV2(List<Integer> internalList) {
        this.internalList = internalList;
    }

    // static factory
    public static MyStreamV2 of(List<Integer> internalList) {
        return new MyStreamV2(internalList);
    }

    public MyStreamV2 filter(Predicate<Integer> predicate) {
        List<Integer> filtered = new ArrayList<>();
        for (Integer element : internalList) {
            if (predicate.test(element)) {
                filtered.add(element);
            }
        }
        return new MyStreamV2(filtered);
    }

    public MyStreamV2 map(Function<Integer, Integer> mapper) {
        List<Integer> mapped = new ArrayList<>();
        for (Integer element : internalList) {
            mapped.add(mapper.apply(element));
        }
        return new MyStreamV2(mapped);
    }

    public List<Integer> toList() {
        return internalList;
    }
}
