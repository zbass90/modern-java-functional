# 📘 Modern Java Functional Programming

최신 자바 개발에 필수적인 **람다, 스트림, 함수형 프로그래밍**을 기초부터 실무 수준까지 학습하는 저장소입니다.  
김영한님의 강의를 기반으로 **코드 예제와 학습 기록을 정리하며, 실제 소스를 직접 경험**합니다.  

또한 [향로님의 추석 스터디 챌린지](https://www.inflearn.com/challenge/x27%ED%96%A5%EB%A1%9Cx27-%EC%99%80-%ED%95%A8%EA%BB%98%ED%95%98%EB%8A%94-%EC%B6%94%EC%84%9D-%EC%99%84/dashboard)를 통해 자극을 받아 본격적으로 학습을 시작하게 되었고,  
**2025 추석에도 어김없이 스터디를 이어가며 모던 자바에 더욱 익숙해지는 것**을 목표로 합니다.  

---

<details>
  <summary><strong>📂 강의 목차</strong></summary>

<br/>

<details>
  <summary>🔹 섹션 1. 강의 소개와 자료</summary>

<br/>

- 강의 소개  
- 수업 자료  
- 강의 소스 코드  

</details>

<details>
  <summary>🔹 섹션 2. 람다가 필요한 이유</summary>

<br/>

- 프로젝트 환경 구성  
- 람다가 필요한 이유1  
- 람다가 필요한 이유2  
- 람다가 필요한 이유3  
- 함수 vs 메서드  
- 람다 시작  

</details>

<details>
  <summary>🔹 섹션 3. 람다</summary>

<br/>

- 람다 정의  
- 함수형 인터페이스  
- 람다와 시그니처  
- 람다와 생략  
- 람다의 전달  
- 고차 함수  
- 문제와 풀이1  
- 문제와 풀이2  
- 문제와 풀이3  
- 정리  

</details>

<details>
  <summary>🔹 섹션 4. 함수형 인터페이스</summary>

<br/>

- 함수형 인터페이스와 제네릭1  
- 함수형 인터페이스와 제네릭2  
- 람다와 타겟 타입  
- 기본 함수형 인터페이스  
- 특화 함수형 인터페이스  
- 기타 함수형 인터페이스  
- 문제와 풀이  
- 정리  

</details>

<details>
  <summary>🔹 섹션 5. 람다 활용</summary>

<br/>

- 필터 만들기1  
- 필터 만들기2  
- 맵 만들기1  
- 맵 만들기2  
- 필터와 맵 활용1  
- 필터와 맵 활용2  
- 스트림 만들기1  
- 스트림 만들기2  
- 스트림 만들기3  
- 스트림 만들기4  
- 정리  

</details>

<details>
  <summary>🔹 섹션 6. 람다 vs 익명 클래스</summary>

<br/>

- 람다 vs 익명 클래스1  
- 람다 vs 익명 클래스2  
- 정리  

</details>

<details>
  <summary>🔹 섹션 7. 메서드 참조</summary>

<br/>

- 메서드 참조가 필요한 이유  
- 메서드 참조1 - 시작  
- 메서드 참조2 - 매개변수1  
- 메서드 참조3 - 임의 객체의 인스턴스 메서드 참조  
- 메서드 참조4 - 활용1  
- 메서드 참조5 - 활용2  
- 메서드 참조6 - 매개변수2  
- 정리  

</details>

<details>
  <summary>🔹 섹션 8. 스트림 API1 - 기본</summary>

<br/>

- 스트림 API 시작  
- 스트림 API란?  
- 파이프라인 구성  
- 지연 연산  
- 지연 연산과 최적화  

</details>

<details>
  <summary>🔹 섹션 9. 스트림 API2 - 기능</summary>

<br/>

- 스트림 생성  
- 중간 연산  
- FlatMap  
- Optional 간단 설명  
- 최종 연산  
- 기본형 특화 스트림  

</details>

<details>
  <summary>🔹 섹션 10. 스트림 API3 - 컬렉터</summary>

<br/>

- 컬렉터1  
- 컬렉터2  
- 다운 스트림 컬렉터1  
- 다운 스트림 컬렉터2  
- 정리  

</details>

<details>
  <summary>🔹 섹션 11. Optional</summary>

<br/>

- 옵셔널이 필요한 이유  
- Optional의 생성과 값 획득  
- Optional 값 처리  
- 즉시 평가와 지연 평가1  
- 즉시 평가와 지연 평가2  
- 즉시 평가와 지연 평가3  
- orElse() vs orElseGet()  
- 실전 활용1 - 주소 찾기  
- 실전 활용2 - 배송  
- 옵셔널 - 베스트 프랙티스  
- 정리  

</details>

<details>
  <summary>🔹 섹션 12. 디폴트 메서드</summary>

<br/>

- 디폴트 메서드가 등장한 이유  
- 디폴트 메서드 소개  
- 디폴트 메서드의 올바른 사용법  
- 정리  

</details>

<details>
  <summary>🔹 섹션 13. 병렬 스트림</summary>

<br/>

- 단일 스트림  
- 스레드 직접 사용  
- 스레드 풀 사용  
- Fork/Join 패턴  
- Fork/Join 프레임워크1 - 소개  
- Fork/Join 프레임워크2 - 작업 훔치기  
- 작업 훔치기 알고리즘  
- Fork/Join 프레임워크3 - 공용 풀  
- 자바 병렬 스트림  
- 병렬 스트림 사용시 주의점1  
- 병렬 스트림 사용시 주의점2  
- 정리  

</details>

<details>
  <summary>🔹 섹션 14. 함수형 프로그래밍</summary>

<br/>

- 프로그래밍 패러다임  
- 함수형 프로그래밍이란?  
- 자바와 함수형 프로그래밍1  
- 자바와 함수형 프로그래밍2  
- 자바와 함수형 프로그래밍3  
- 정리  

</details>

<details>
  <summary>🔹 섹션 15. 다음으로</summary>

<br/>

- 다음으로  

</details>

</details>
