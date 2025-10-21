오늘은 **데이터를 다루는 기능적 확장과 결과를 수집하는 Collector의 원리**를 학습했다. 이전까지는 스트림을 생성하고, 중간 연산(map, filter 등)을 통해 데이터를 변환하고, forEach나 collect로 결과를 소비하는 흐름 정도를 이해했다면 다른 다양한**Collecotr의 기능들을 나열하고 학습**해보았다.

---

### **🧩스트림 API의 기능적 확장**

- **스트림 생성 (Stream.of, Arrays.stream, iterate, generate)**

  다양한 데이터 소스로부터 스트림을 만들 수 있다는 걸 직접 실습했다. 특히`Stream.iterate()`와`Stream.generate()`가 만들어내는 '무한 스트림'의 개념을 처음 알게 되었다. limit()으로 조정 가능한데 어떤 방향으로 사용할지 궁금하다.

- **중간 연산과 최종 연산의 구분**

  filter(), map(), sorted(), distinct() 같은**중간 연산**은 지연되고, forEach(), count(), collect() 같은**최종 연산**에서 실제로 수행된다.

- **FlatMap의 강력함**

  평소 실무에서 무의식적으로 사용하던`flatMap()`을 강사님의 시각 자료를 통해 데이터의 흐름과 내부 동작 과정을 함께 보니 훨씬 쉽게 이해할 수 있었다.

- **Optional 간단 설명 & 기본형 특화 스트림**

  Optional은 이번 강의에서 간단히 맛보기 수준으로만 다루었다. Stream API와 함께 이해해야 활용이 가능하기 때문에, 이후 강의에서 더 깊이 학습한 뒤 정리 노트를 작성할 예정이다.


---

### **🧠컬렉터(Collector)와 다운스트림**

섹션 10에서는 스트림의 결과를 수집하는 “Collector”의 내부 구조를 집중적으로 다뤘다.

Collector는 단순히 데이터를 모으는 도구가 아니라,**어떻게(accumulator), 어디에(container), 어떤 형태로(finisher)**결과를 만들지 정의하는 규약이었다.

- `toList()`,`toSet()`,`joining()`,`counting()`,`averagingInt()`등 기본 제공 메서드들을 실습을 통해 내부적으로는`Collector<T, A, R>`구조가 동작한다는 걸 이해했다.
- **다운스트림 컬렉터(Downstream Collector)**

  `groupingBy()`나`partitioningBy()`에서 또 다른 Collector를 인자로 넘겨**그룹 내부의 데이터를 다시 수집**할 수 있다는 개념이다.

  예를 들어`groupingBy(Classifier, counting())`처럼 상위 컬렉터가 하위 컬렉터를 호출하는 구조로 사용된다.

- **중첩 수집의 흐름**

  예를 들어 groupingBy → mapping → joining 과 같은 중첩 구조를 통해**데이터 변환과 수집**이 한 파이프라인 안에서 모두 이루어진다.

  단순히 데이터를 모으는 게 아니라,**로직 자체를 조립한다**는 느낌이었다.


---

### **💬실무와의 연결, 그리고 나의 질문**

이 과정을 학습하면서 문득 궁금증이 생겼다.

스트림의`Collector`는`toList()`나`groupingBy()`같은 기본 도구만으로도 충분히 강력한데, 과연 실무에서는 직접`Collector`를 구현해야 하는 상황이 있을까?

만약 그렇다면, 병렬 스트림 환경에서도 안전하게 동작하도록 어떤 설계 포인트를 고려해야 할까?

이러한 궁금증을 해결하기 위해 미션 수행을 겸해 아래와 같이 질문을 작성했다.

![스크린샷 2025-10-10 22.01.28.png.webp](https://cdn.inflearn.com/public/files/posts/f9a071ef-a7f1-4168-bd84-7a051149ef5b/c4d91ed7-a828-4dbc-a0a1-972a41ae8e46.webp)

---

8일차도 완벽히 성공!🚀