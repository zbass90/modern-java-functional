기본 타입(int, long, double 등)을 다루기 위한****특화 함수형 인터페이스(Primitive Functional Interface)****들을 살펴보았다. 제네릭 기반의 Function<T, R>이나 Predicate<T>는 편리하지만, 오토박싱과 언박싱으로 인해 성능 손실이 발생할 수 있다는 점을 다시 확인했다. 이에 반해 IntPredicate, IntFunction, LongSupplier 같은 특화 인터페이스는 기본 타입을 직접 처리해 이러한 오버헤드를 줄여준다는 점이 기억에 남는다.

```rust
IntPredicate isEven = n -> n % 2 == 0;
IntSupplier random = () -> new Random().nextInt(10);
IntFunction<String> toLabel = n -> "번호: " + n;
```

이처럼 원시 타입을 직접 다루면 코드가 더 깔끔하고 효율적으로 동작한다.

다음으로는 입력 인자가 두 개인 Bi 계열과 반환형이 원시 타입인 To 계열 인터페이스들이다.

```rust
BiFunction<String, Integer, String> repeat = (s, n) -> s.repeat(n);
BiPredicate<String, String> startsWith = (a, b) -> a.startsWith(b);
ToIntFunction<String> length = s -> s.length();
```

두 개의 입력값을 처리하는 로직이나, 객체를 특정 타입으로 변환하는 상황에서 훨씬 직관적인 표현이 가능하다는 점이 매력적으로 다가왔다.

오늘의 학습을 통해 함수형 인터페이스가 단순히 ‘형태가 비슷한 여러 개념의 집합’이 아닌 용도와 상황에 따라 정교하게 구분된 구조적인 설계라는 것을 학습하는 시간이었다.

3일차도 무리 없이 성공!🚀