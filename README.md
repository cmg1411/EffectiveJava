# 🖊 이펙티브 자바 공부
 - 이펙티브 자바 3/E 를 읽고 공부하며 책에 나오는 예제 코드를 작성한 내용입니다.
 - 중간 중간에 공부하면서 배운 내용과 정리를 주석과 마크다운으로 표현하였습니다.
 - MeetCoder 스터디를 진행하면서  발표 내용은 해당 아이템의 패키지에 __MarkDown__ 문서로 추가합니다.

[챕터별 코드 보기](https://github.com/cmg1411/effectiveJava/tree/master/src/main/java)  
[MeetCoder 스터디 Github](https://github.com/Meet-Coder-Study/book-effective-java)

<br>
<br>

---
#### 2장 객체 생성과 파괴
1. [x] 1 생성자 대신 정적 펙토리 메서드를 고려하라. ✊[발표](https://github.com/cmg1411/effectiveJava/blob/master/src/main/java/Chapter2/Day1/item1_presentation.md)
1. [x] 2 생성자에 매개변수가 많다면 빌더를 고려하라.  
1. [x] 3 private 생성자나 열거 타입으로 싱글턴임을 보증하라.  
1. [x] 4 인스턴스화를 막으려거든 private 생성자를 사용하라.  
1. [x] 5 자원을 직접 명시하지 말고 의존 객체 주입을 사용하라.
1. [x] 6 불필요한 객체 생성을 피하라.
1. [x] 7 다 쓴 객체 참조를 해제하라.
1. [x] 8 Finalizer 와 Cleaner 사용을 피하라.
1. [x] 9 try-finally 보다는 try-with-resources를 사용하라.

#### 3장 모든 객체의 공통 메서드
1. [x] 10 equals 는 일반 규약을 지켜 재정의하라.
1. [x] 11 equals 를 재정의하려거든 hashCode 도 재정의하라.
1. [x] 12 toString을 항상 재정의하라.
1. [x] 13 clone 재정의는 주의해서 진행하라. ✊[발표](https://github.com/cmg1411/effectiveJava/blob/master/src/main/java/Chapter3/Day13/item13.md)
1. [x] 14 Comparable 을 구현할지 고려하라.

#### 4장 클래스와 인터페이스
1. [x] 15 클래스와 멤버의 접근 권한을 최소화하라.
1. [x] 16 public 클래스에서는 public 필드가 아닌 접근자 메서드를 사용하라.
1. [x] 17 변경 가능성을 최소화하라. ✊[발표](https://github.com/cmg1411/effectiveJava/blob/master/src/main/java/Chapter4/Day17/item17.md)
1. [x] 18 상속보다는 컴포지션을 사용하라.
1. [x] 19 상속을 고려하여 설계하고 문서화하라. 그러지 않았다면 상속을 금지하라.
1. [x] 20 추상 클래스보다는 인터페이스를 우선하라.
1. [x] 21 인터페이스는 구현하는 쪽을 생각해 설계하라.
1. [x] 22 인터페이스는 타입을 정의하는 용도로만 사용하라.
1. [x] 23 태그 달린 클래스보다는 클래스 계층구조를 활용하라.
1. [x] 24 멤버클래스는 되도록 static 으로 만들라. ✊[발표](https://github.com/cmg1411/effectiveJava/blob/master/src/main/java/Chapter4/Day24/item24.md)
1. [x] 25 톱 레벨 클래스는 한 파일에 하나만 담으라.

#### 5장 제네릭
1. [x] 26 로 타입은 사용하지 말라.
1. [x] 27 비검사 경고를 제거하라.
1. [x] 28 배열보다는 리스트를 사용하라.
1. [x] 29 이왕이면 제네릭 타입으로 만들라. ✊[발표](https://github.com/cmg1411/effectiveJava/blob/master/src/main/java/Chapter5/Day29/item29.md)
1. [x] 30 이왕이면 제네릭 메서드로 만들라.
1. [x] 31 한정적 와일드카드를 사용해 API 유연성을 높이라.
1. [x] 32 제네릭과 가변인수를 함께 쓸 때는 신중하라.
1. [x] 33 타입 안전 이종 컨테이너를 고려하라.

#### 6장 열거 타입과 애너테이션
1. [x] 34 int 상수 대신 열거 타입을 사용하라.
1. [x] 35 ordinal 메서드 대신 인스턴스 필드를 사용하라.
1. [x] 36 비트 필드 대신 EnumSet 을 사용하라.
1. [x] 37 ordinal 인덱싱 대신 EnumMap 을 사용하라.
<br>
<br>

---

 - [스터디 Github](https://github.com/Blog-Posting/book-effective-java)  
 - [Effective Java 공식 Github](https://github.com/WegraLee/effective-java-3e-source-code)  
 - [번역 용어 해설](https://github.com/WegraLee/effective-java-3e-source-code)
 - [백기선님과 같이 공부하기](http://bit.ly/2Lu4BGi)
 - [Effective Java 책 정보](https://www.aladin.co.kr/shop/wproduct.aspx?ItemId=171196410)
 - [JavaBom 스터디](https://github.com/Java-Bom/ReadingRecord/issues)
 - [쟈미블로그](https://github.com/Java-Bom/ReadingRecord/issues)