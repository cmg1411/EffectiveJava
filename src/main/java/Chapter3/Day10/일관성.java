package Chapter3.Day10;

/**
 * x.equals(y) 가 true 면
 * 어떠한 경우라도 계속 true
 *
 * 가변 객체는 비교 시점에 따라 다를 수 있지만,
 * 불변 객체는 한번 다르면 끝까지 달라야 한다. 불변 클래스일때 equals 의 일관성을 고려해야 한다.
 *
 * 일단 클래스가 불변이든 가변이든, equals 메소드에 신뢰할 수 없는 자원이 동치성에 관여해서는 안된다.
 *
 * java.net.URL 의 equals 는 가변적인 네트워크의 IP 주소 때문에 위의 내용을 위반한다.
 *
 * equals 는 항시 메모리에 존재하는 객체만을 사용한 결정적 계산만 수행해야 한다.
 */
public class 일관성 {
}
