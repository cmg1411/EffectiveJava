## equals 는 일반 규약을 지켜 재정의하라

#### 다음 경우중 하나에 해당하면 equals 재정의는 하지마라
 - 각 인스턴스가 본질적으로 고유 (Thread 가 좋은 예)
 - 논리적 동치성을 검사할 일이 없을 때 
 - 상위 클래스의 equals 정의가 하위 클래스 equals 정의와도 딱 들어맞을 때 (Set 구현체는 AbstractSet 의 equals 를 그대로 씀)
 - 클래스가 private 이라 equals 메소드를 호출할 일이 없을 때 (equals 재정의에 예외만 던지면 안전하게 막을 수 있다)
  
 <br>

#### 다음 경우에 equals 오버라이딩을 하라
 - 논리적 동치성을 검사해야하는데, 상위 클래스의 equals 가 논리적 동치성을 검사하도록 되어있지 않을 때
 - 주로 값 객체들이 여기에 해당한다.
 - Enum 과 같이 같은 인스턴스가 둘 이상 만들어지지 않음이 보장되면, equals 를 재정의 하지 않아도 괜찮다. (객체가 유일하다면 같은 객체는 값도 같음을 의미)
 
 <br>
 
#### equals() 구현 동치관계 규약
 1. 반사성 : 모든 x 에 x.equals(x) 는 true
 1. 대칭성 : x.equals(y) 가 true 이면 y.equals(x) 도 true
 1. 추이성 : x.equals(y) 가 true, y.equals(z) 가 true 이면 x.equals(z) 도 true
 1. 일관성 : x.equals(y) 가 true 이면 반복해서 실행해도 항상 true
 1. null-아님 : null 이 아닌 모든 x 에 대해x.equals(null) 은 false
 
 
 <br>
 
 
#### equals() 재대로 구현하기
  1. == 를 사용하여 자기 객체와 같은 객체인지 검사. (성는 최적화용)
  2. instanceOf 를 이용하여 **올바른** 객체 타입인지 검사. (인터페이스, 상속을 고려하여야 함)
  3. typeCasting
  4. 캐스팅된 객체의 **핵심** 필드들이 같은지를 검사 (논리적 검사)
  
기본타입의 필드는 == 연산자로,
참조타입의 필드는 equals 로,
배열은 각 원소마다 비교,
float, double 은 Float.compare(float, float), Double.compare(double, double) 로 비교하자.

Float.equals, Double.equals 메서드는 오토박싱이 일어날 수 있어서 성능적으로 문제가 있을 수 있다.
배열의 모든 원소가 핵심 필드라면, Arrays.equals() 를 활용할 수 있다.

비교 알고리즘이 복잡하다면, 필드의 **표준형** 을 정해놓고 비교하면 효율적이다.
가변객체는 바뀔 때 마다 표준형을 바꿔줘야해서 가변객체보다 불변객체에 효율적인 방법이다.

다를 가능성이 더 크거나, 비교하는 비용이 싼 필드를 먼저 비교하는 것이 성능이 좋다.

핵심필드로 계산해낼 수 있는 파생 필드는 비교하지 않는 것이 좋을 수 도 있고,
파생 필드를 비교하는 것이 더 효율적일 수 도 있으니 고민해보고 쓰는 것이 좋다.


#### equals 를 다 구현하고 자문 할 것
 1. 대칭적인가 ?
 1. 추이성이 있는가 ?
 1. 일관적인가 ?
 
 나머지 두 항목은 틀릴일이 거의 없다.
 
 
#### 마지막 팁
 1. equals 를 재정의할 때에는 hashCode 도 같이 재정의
 1. 너무 복잡하게 해결하려 들지 말자.
 1. equals() 의 매개변수 타입은 항상 Object 로 하자. (그렇지 않으면 재정의가 아닌 다중정의 이다.)
 
 
#### 프레임워크 사용
 **구글의 AutoValue**
 **Lombok**

<br>

#### 