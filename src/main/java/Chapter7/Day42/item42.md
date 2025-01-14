# 익명 클래스보다는 람다를 사용하라.

 - 함수형 인터페이스
   - 자바에서 함수 타입을 표현할 때 추상 메서드를 하나만 담은 인터페이스.
   - 특정한 함수나 동작을 나타낼 때 사용.
   - 이런 인터페이스로 만든 객체를 **함수객체**라고 함.
 - 함수객체를 사용하는 방법
   - 익명 클래스
   - java 8 부터 **람다 표현식**
   
   
## 람다 표현식
 - 줄여서 람다식, 람다
 - 타입 추론을 바탕으로 컴파일러가 타입을 정해줌.
 - 타입을 명시해야 의미가 명확할 때를 제외하고는 람다의 모든 매개변수의 타입은 생략해서 추론하도록 하자.
 - 자바의 타입 추론은 매우 복잡하며, 알 필요가 없다. 
 - 타입 추론이 필요하여 오류를 뱉을 때 그때그때 명시적으로 타입을 지정해주면 됨.
 - 람다의 타입 추론은 제네릭으로부터 대부분의 정보를 받으며, 따라서 제네릭 타입과 같이 쓸 때 주의가 필요하다.
 
 
## 람다 표현식을 어디 사용할까 ?
 - Lambdas.java 에서 Comparator 도 함수형 인터페이스이기 때문에, Comparator 객체를 필요로 하는 sort 같은 메서드에서도 활용할 수 있다.
 - EnumLambda.java 에서 추상 메서드를 정의하고, 함수 몸체를 각각 쓰는 방법보단, 함수형 인터페이스 타입 필드를 정의하고 람다를 쓰고, apply 를 통해 실행하는 것이 가독성이 훨씬 좋다.
 
## 람다는 어디 쓰면 안될까 ?
 - 람다식이 3줄이 넘어가면 심각하게 가독성이 떨아진다.
 - 문서화를 못하고 이름도 없으므로, 코드 자체로 설명이 명확하게 되지 않으면 쓰면 안된다.
 - 특수한 경우, 예를 들어 enum 의 생성자에서의 람다는 열거 타입의 인스턴스 멤버에 접근할 수 없다. (상수별 클래스 몸체 사용)
 - 인터페이스가 아닌 추상 클래스의 경우나 추상 메서드가 하나 이상인 경우는 람다를 쓸 수 없다.
 - 람다에서는 this 키워드를 사용할 수 없다.
 
## 직렬화 ?
 - 람다와 익명 클래스 모두 직렬화를 하면 안된다.
 - 직렬화 형태가 구현별로 (가령 가상머신별로) 다르기 때문이다.
 - 직렬화가 필요하다면, private static 중첩 클래스의 인스턴스를 사용하자. 