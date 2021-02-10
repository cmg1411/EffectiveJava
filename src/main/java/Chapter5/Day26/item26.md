# 로 타입은 사용하지 말라

 - 제네릭 클래스, 제네릭 인터페이스 : 선언에 타입 매개변수가 쓰이는 클래스, 인터페이스
 - 제네릭 타입 : 제네릭 인터페이스 + 제네릭 클래스, 일련의 매개변수화 타입을 정의한다.
 
 - 로 타입 : List<E> 는 제네릭 타입, List 는 로 타입. 제네릭이 생기기 이전의 하위호환성을 위해 만든 기능이다.   때문에 제네릭 타입
 도 내부적으로는 제네릭을 때고 로 타입으로 동작하긴 한다.
 
 - RowBadExample.java 를 보면 알 수 있듯이, 로 타입을 쓰면 다른 두 종류의 타입을 넣어도 경고만 표시할 뿐 컴파일이 가능하다.
 
 - 하지만 꺼내려 할 때 Paper 로 꺼내겠다 ! 라고 정하고 코딩하면 Coin 이 나와 오류가 발생한다.;;
 
 - **코드 오류는 가능한 발생 즉시, 이상적으로는 컴파일 타임에 발견하는 것이 좋다.**
 - 하지만 이 경우는 컴파일타임에 알 수 없고, 나중에 찾기도 힘들다.
 
 - 따라서 제네릭 을 활용하여 들어갈 수 있는 타입을 애초에 제한한다. 그럼 컴파일 타임에서 오류를 발견할 수 있따.
 
 
 > 로 타입은 절떄로 쓰면 안떈따 !!!


 - List<Object> 는 괜찮다. 모든 종류를 허용한다고 컴파일러에게 알려준 것이기 때문이다.
 
 
 - 와일드카드의 add 는 넣을 수 있는 데이터 유형이 null 이외에 막혀있다 ! 따라서 안전하다.
 
 
 
## <Object> <?> <T> 차이는 무엇일까