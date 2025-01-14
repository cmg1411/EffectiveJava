# 복구할 수 있는 상황에는 검사 예외를, 프로그래밍 오류에는 런타임 예외를 사용하라.

자바는 예외처리를 위해 Throwable 인터페이스와 하위의 클래스들을 제공한다.  
이 인터페이스 하위의 클래스는 자바의 표준 예외를 제공한다.  

이번 장에서는 이 Checked Exception, Unchecked Exception 중 무엇을 결정해야 하는지에 대한 팁을 제공한다.  
100% 정해진 답은 없기에 더 맞다 생각되는 쪽을 사용하면 되겠다.

## 호출하는 곳에서 복구하리라 예상되는 상황이라면 검사 예외를 사용하라.
 - 검사 예외, 즉 RuntimeException 하위의 클래스가 아닌 Exception 클래스 하위 클래스들을 말한다.
 - 이 예외들은 무조건 try-catch 문으로 처리를 해야한다.
 - 이 특징이 의미하는 바는, 검사 예외가 선언된 메서드는 그 예외가 일어날 확률이 높다는 것을 뜻한다.
 - 또 달리 말하면, 호출하는 곳에서 그 예외를 반드시 처리해야함을 의미한다.
 
## 비검사 예외.
 - Error 와 RuntimeException 하위의 클래스들이다.
 - 이 에러는 프로그램에서 잡을 필요가 없거나, 잡지 않아야한다.
 - 이 예외들의 의미는 예외를 잡아 처리하든 뭘 하든 더 진행하면 실이 더 많다는 뜻이다.
 
## 프로그램의 예외를 던질때는 런타임 예외를 사용하자.
 - 배열의 인덱스로 음수를 지정하면 `ArrayIndexOutOfBoundsException` 을 발생시킨다.
 - 배열의 인덱스가 음수로 설정되었을때를 생각해보자. try-catch 로 잡아서 프로그램상에서 적절한 처리를 할 수 있는가?
 - 음수가 사용되지 않는 코드를 다시 짜는게 맞다.
 - 이렇듯, 런타임 예외는 API 명세의 전제조건에 맞지 않게 사용했을 때 발생하는 예외다. 
 
 ### 예외가 복구가능한 상황인지 아닌지는 알기 어렵다.
  - 자원 고갈이라는 예외가 났다고 생각해보자.
  - 일시적으로 메모리 자원이 부족해서 발생했다면 시간을 기다리거나 프로그램적으로 처리할 수 있다.
  - 하지만 사용자가 말도 안되는 큰 크기의 배열을 설정해서 발생핬다면 런타임 예외를 쓰는 것이 적절해보인다.
  
  > 헷갈린다면 그냥 런타임예외를 사용하자.

## Throwable, Error 클래스를 직접적으로 사용하지 말라.
 - Error 도 비검사 예외의 종류지만 사용하지 않는 것이 확고한 관례다.
 - 우리가 구현하는 비검사 예외는 모두 RuntimeException 의 하위여야한다.
 - Throwable 예외는 좋은점도 없고 사용자를 헷갈리게 하니 쓰지말라.
 
## 검사 예외와 정보를 알려주는 메서드
 - 검사 예외는 일반적으로 복구할 수 있는 조건일때 발생한다 했다.
 - 따라서 호출자 쪽에서 복구를 할 수 있게 예외가 발생한 해당 상황 정보를 알려주는 메서드를 제공해야한다.