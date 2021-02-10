# 한정적 와일드카드를 사용해 API 유연성을 높이라.

 - ```List<Object>``` 는 ```List<Integer>```의 상위 타입이 아니다. 불공변이니까.
 - 리스코프 치환 원칙에 의해서도 ```List<Object>``` 가 하는 일을 ```List<Integer>``` 가 다 못하니 상 하위 클래스가 아니다.
 
## 생산성을 극대화시키고 싶다면  원소의 생산자나 소비자용 입력 매개변수에 와일드카드 타입을 사용하라.

> 펙스 PECS
> 생산자 - extends, 소비자 - super

 - 쉽게말해, 입력 매개변수에 있는 것을 꺼내서 일을 할거라면 선언된 매개변수의 하위 타입들은 다 괜찮으니까 extends  
입력 매개변수에다가 뭔가를 넣을 거라면 선언된 매개변수의 상위 타입이면 다 괜찮으니까 super.

 - 한편 생산자와 소비자의 역할을 둘 다 한다면, 한정적 와일드카드를 사용하면 안된다.

### 클래스 사용자가 와일드카드 타입을 신경써야 한다면 그 API 에 무슨 문제가 있을 가능성이 크다 !!

### 일반적으로 Comparable, Comparator 은 그냥 ```<E>``` 보다는 ```<? super E>``` 가 훨 낫다.
 - Comparator, Comparable 매개변수를 받아서 그걸로 순서를 매겨서 순서를 반환하는 그런 역할이니까.
 - 즉 소비자 super.
 
 
## 타입 매개변수```<E>```와 와일드카드```<?>```에는 공통되는 부분이 있어서, 메서드를 정의할 때 둘 중 어느 것을 사용해도 괜찮을 때가 많다.
 - 기본 규칙 : 메서드 선언에 타입 매개변수가 한 번만 나오면 와일드 카드로 대체하라.
 - swap 같은 경우에는 와일드 카드의 타입의 실제 타입을 알려주는 메서드를 private 도우미 메서드로 작성.
 - 내부에서는 더 복잡하게 구현됬지만, 클라이언트 입장에서는 와일드카드 기반의 깔끔한 메서드를 이용할 수 있다.
 - [와일드 카드 기반이 제네릭 타입 E 보다 좋은 이유](https://stackoverflow.com/questions/18142009/type-parameter-vs-unbounded-wildcard)
 
#### 인자 vs 매개변수
 - 매개변수는 메서드에 선언된 것.
 - 인자는 매개변수에 들어가는 값 자체.