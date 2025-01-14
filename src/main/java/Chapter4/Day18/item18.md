## 상속보다는 컴포지션을 이용하라.

재사용할 수 있는 전달 클래스를 인터페이스마다 하나씩 만들어 두면, 원하는 기능을 덧씌우는 전달 클래스들을 아주 손쉽게 구현할 수 있다.

상속은 [B] is-a [A] 관계가 성립해야 쓸 수 있다. 그러면 A를 상속하는 B를 만들 수 있따.  
ex) macBook is a Computer.
ex) Stack is a Vector. (x)
ex) Properties is a HashTable. (x)

is-a 가 아니다! 면 A를 private 인스턴스로 두고, A와는 다른 API 를 제공한다.  
즉, A는 B의 필수 구성요소가 아니라, 구현하는 방법중 하나이다.

is-a 가 성립하더라도 상속을 이용하기 이전에,  
하위 클래스가 상위 클래스의 패키지와 다르고, 상위 클래스가 확장을 고려해 설계되지 않았다면, 문제가 발생한다.  
따라서 다음을 고려해야 한다.

 - 확장하려는 클래스의 API 가 결함이 없는가?  
 - 결함이 있다면, 이결함이 우리 클래스의 API 까지 전파되도 괜찮은가?  

를 자문해야 한다.