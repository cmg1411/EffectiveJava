# item 59) 라이브러리를 익히고 사용하라.

## 랜덤값을 구해오는 라이브러리들
 1. java.util.Random 의 `nextInt() % bound;` `java 1.0`
 1. java.util.Random 의 `nextInt(int bound);` `java 1.2`
 1. java.util.concurrent.ThreadLocalRandom `java 1.7`
 1. java.util.SplittableRandom `java 1.8`
 
 <br>

## 1번) nextInt() % n 방식의 문제점
 - n 이 크지 않은 2의 제곱수라면, 일정 범위에서 같은 수열이 반복된다.
 - n 이 2의 제곱수가 아니라면, 몇몇 숫자가 더 자주 반환된다.
 - 지정 범위 바깥 수가 종종 반환된다.

<br> 

## 2번) nextInt(int bound) 는 위 방식의 문제점을 모두 해결한다.

<br>

## 3번) ThreadLocalRandom : 싱글 스레드에서 1, 2 번보다 더 고품질의 난수와 속도를 제공한다.
 - ThreadLocalRandom 은 Random 함수를 확장하고 있다.

```java
    private static final int BOUND = 2 * (Integer.MAX_VALUE / 3);
    private static final int REPEAT_NUM = 100000000;

    public static void main(String[] args) {
        Random random = new Random();
        ThreadLocalRandom threadLocalRandom = ThreadLocalRandom.current();

        for (int j = 0; j < 10; j++) {
            System.out.println("-----------" + (j+1) + "회차---------------");
            Instant now = Instant.now();

            for (int i = 0; i < REPEAT_NUM; i++) {
                makeRandomNumber(random);
            }
            System.out.println("일반 랜덤 1억번 시간 : " + (Instant.now().toEpochMilli() - now.toEpochMilli()));

            now = Instant.now();

            for (int i = 0; i < REPEAT_NUM; i++) {
                makeRandomNumber(threadLocalRandom);
            }
            System.out.println("ThreadLocalRandom 1억번 시간 : " + (Instant.now().toEpochMilli() - now.toEpochMilli()));
        }
    }

    private static int makeRandomNumber(Random random) {
        return random.nextInt(BOUND);
    }
```

![threadLocalRandom](tlr.png)


<br>

## 4번) fork-join 풀, 병렬 스트림에서는 SplittableRandom 이 더 빠르다.
```java
    private static final Long REPEAT_NUM = 100000L;

    public static void main(String[] args) {
        timeWithThreadLocalRandomWithParallel();
        timeWithSplittableRandomWithParallel();
    }

    public static void timeWithThreadLocalRandomWithParallel() {
        long l = System.currentTimeMillis();
        OptionalDouble max = ThreadLocalRandom.current()
            .doubles()
            .parallel()
            .limit(REPEAT_NUM)
            .max();
        System.out.println("최댓값 : " + max.getAsDouble() + " / 걸린시간 : "  + (System.currentTimeMillis() - l));
    }

    public static void timeWithSplittableRandomWithParallel() {
        SplittableRandom splittableRandom = new SplittableRandom();
        long l = System.currentTimeMillis();
        OptionalDouble max = splittableRandom
            .doubles()
            .parallel()
            .limit(REPEAT_NUM)
            .max();
        System.out.println("최댓값 : " + max.getAsDouble() +  " / 걸린시간 : "  + (System.currentTimeMillis() - l));
    }
```

![img](spli.png)

#### 그 외
 - 보안을 강화 java.util.security 의 SecureRandom한
 
 <br>
 
 
## 표준 라이브러리를 쓰면 좋은 점
 1. 우리보다 고수 개발자와 선배 개발자의 경험을 활용할 수 있다.
 1. 우리 에플리케이션 기능 개발에 집중할 수 있다.
 1. 가만히 둬도 성능이 개선된다.
 1. 가만히 둬도 기능이 많아진다.
 1. 많은 개발자들에게 익숙한 코드가 되어 읽기 좋고, 유지보수하기 좋고, 재사용하기 좋은 코드가 된다. 
 
<br>

## 몰라서 못쓰지는 말자.
 - 메이저 릴리즈마다 라이브러리에 많은 기능이 추가된다.
 - 새로운 기능을 찾아보자.
 - [java 11 릴리즈 노트](https://www.oracle.com/java/technologies/javase/jdk-11-relnote.html#NewFeature)
 - [Spring 공식 블로그](https://spring.io/blog/)
 
<br>

## 공부해야할 패키지
 - java.lang 하위
 - java.util 하위
 - java.io 하위
 
## 공부해야할 라이브러리
 - 컬렉션 프레임워크
 - 스트림 라이브러리
 - java.util.concurrent 동시성 기능
 
 
<br>

## 기능 구현할때 순서
 1. 표준 라이브러리에서 제공하는 기능인지 찾아본다.
 1. 서드파티 라이브러리에서 제공하는 기능인지 찾아본다.
    - [구글 구아바](https://github.com/google/guava)
    - [아파치 커먼즈](https://commons.apache.org)
 1. 직접 구현한다.
 1. ~~포기한다.~~
 
 
 
## 구아바 예제
```java
// JDK
Map<Integer, String> map1 = new HashMap<>();
// GUAVA
Map<Integer, String> map2 = Maps.newHashMap();

Multimap<Integer, String> multimap = HashMultimap.create();
multimap.put(1, "A");
multimap.put(1, "B");
System.out.println(multimap.get(1));
// 출력 [A, B]

BiMap<Integer, Integer> biMap = HashBiMap.create();
biMap.put(1, 2);
biMap.put(3, 2);
// 에러
```