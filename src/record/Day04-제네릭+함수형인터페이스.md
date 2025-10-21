오늘은 직접 filter와 map을 구현하면서 제네릭과 함수형 인터페이스의 결합을 통해 람다를 실전적으로 활용하는 방법을 익혔다.

`Function<T, R>`을 인자로 받아 리스트의 각 요소를 변환하는`map()`메서드를 작성했다. 이 과정을 통해 Stream의`map()`이 내부적으로 어떻게 작동하는지를 구조적으로 이해할 수 있었다.

```java
public static <T, R> List<R> map(List<T> list, Function<T, R> mapper) {
    List<R> result = new ArrayList<>();
    for (T item : list) {
        result.add(mapper.apply(item));
    }
    return result;
}
```

여기서`<T, R>`제네릭 선언을 통해 입력과 출력 타입을 자유롭게 지정할 수 있다는 점이 흥미로웠다. 예를 들어,`List<String>`을 받아`List<Integer>`로 바꾸거나,`List<Integer>`를 받아`List<Boolean>`으로 변환하는 것도 손쉽게 가능했다.

또한`map()`과`filter()`를 직접 구현해보면서 람다가 단순히 문법적인 편의 수단이 아닌 행동을 값처럼 전달하는 개념이라는 것을 이해했다.

```java
List<String> names = List.of("Alice", "Bob", "Charlie");
List<Integer> lengths = GenericMapper.map(names, s -> s.length());
```

이처럼 람다를 통해 함수 자체를 전달함으로써 로직을 추상화할 수 있다는 점이 흥미로웠다.

오늘의 학습을 통해 지난 3일차에 이어 함수형 프로그래밍이 단순히 “짧고 간결한 코드”가 아닌 유연하고 재사용 가능한 구조적인 설계 방식이라는 걸 다시 한번 느꼈다.

4일차도 흔들림 없이 성공!🚀