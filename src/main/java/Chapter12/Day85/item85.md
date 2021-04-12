# 자바 직렬화의 대안을 찾으라.

## ObjectInputStream 의 readObject()
 - 객체 그래프가 역직렬화된다.
 - 클래스패스 안의 거의 모든 타입의 객체를 만들어낼 수 있다.
 - 바이트 스트림을 역직렬화하는 과정에서 그 타입들 안의 모든 코드를 수행할 수 있다.
 - 따라서 이 메서드를 이용하면 거의 모든 코드가 공격 범위이다.
 
 > 신뢰할 수 없는 스트림을 역직렬화하면, 원격 코드 실행, 서비스 거부 등의 공격으로 이어질 수 있다. 잘못한게 없어도 위험하다.

### 가젯
 - 자바 라이브러리, 구아바 아파치커먼즈 같은 서드파티 라이브러리에서 직렬화가능 타입 중 역직렬화 과정에서 호출되어 잠재적으로 위험한 동작을 수행하는 메서드.
 - 이 가젯들이 여러개 묶여서 사용되면 가젯 체인이라고 한다.
 - 가젯 체인으로는 공격자가 기반 하드웨어의 네이티브 코드를 마음대로 실행할 수 있기도 한다.
 - 따라서, 아주 신중히 제작한 바이트 스트림만 역직렬화해야 한다.
 
### 역직렬화 폭탄
 - 역직렬화가 오래 걸리는 짧은 스트림을 많이 역직렬화 할 때 발생.
 - Dos (서비스 거부) 에 노출된다.
 - 예를들면 아래의 상황이 있다.
    - HashSet 이 있다.
    - 원소로는 2개의 HashSet 을 가질 수 있다.
    - 이 이진 트리 해시셋을 깊이가 100 까지 만들었다 치자. (객체 그래프를 만들었다.)
    - 이 스트림 전체를 역직렬화하려면, 2^100 번의 hashCode 메서드를 실행해야 한다.
    - 이 역직렬화는 영원히 끝나지 않으며, 무엇인가 잘못됬다는 신호조차 주지 않는다.
    
    
### 직렬화 위험을 피하는 방법은, 아무것도 역직렬화하지 않는 것.
 - 우리가 작성하는 새로운 시스템에서 자바 직렬화를 써야 할 이유는 전혀 없다.
    
### 대신, 크로스-플랫폼 구조화된 데이터 표현을 쓰자 !
 - JSON, 프로토콜 버퍼가 대표적이다.
 
### 직렬화를 사용해야 할 때, 차선책으로는 신뢰할 수 없는 데이터는 절대 역직렬화하지 말자.
 - 자바의 공식 보안 코딩 지침
    - **신뢰할 수 없는 데이터의 역직렬화는 본질적으로 위험하므로 절대 피해야한다.**
 - 신뢰할 말한 데이터인지 알 수 없다면 ?
    - 역직렬화 필터링을 이용하라.
    - java.io.ObjectInputFilter
    - 클래스 단위로 특정 클래스를 받아들이기, 특정 클래스를 거부하기 를 할 수 있다.
    
### 역직렬화 필터링
 - 화이트리스트 (추천)
    - 기본 거부 : 화이트리스트에 기록된 안전한 클래스만 수용
    - swat 이라는 도구로 화이트리스트를 자동으로 생성 가능.
 - 블랙리스트
    - 기본 수용 : 블랙리스트에 기록된 위험한 클래스들을 거부