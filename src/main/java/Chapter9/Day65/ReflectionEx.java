package Chapter9.Day65;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Set;

public class ReflectionEx {

    public static void main(String[] args) {
        Class<? extends Set<String>> cl = null;
        try {
            cl = (Class<? extends Set<String>>) Class.forName(args[0]);
        } catch (ClassNotFoundException e) {
            fatalError("클래스를 찾을 수 없습니다 !!");
        }

        Constructor<? extends Set<String>> cons = null;
        try {
            cons = cl.getConstructor();
        } catch (NoSuchMethodException e) {
            fatalError("매개변수없는 생성자가 없습니다 !!");
        }

        Set<String> s = null;
        try {
            s = cons.newInstance();
        } catch (IllegalAccessException e) {
            fatalError("생성자에 접근할 수 없습니다.");
        } catch (InstantiationException e) {
            fatalError("클래스를 인스턴스화할 수 없습니다.");
        } catch (InvocationTargetException e) {
            fatalError("생성자가 예외를 던졌습니다." + e.getCause());
        } catch (ClassCastException e) {
            fatalError("Set 을 구현하지 않은 클래스입니다.");
        }

        s.addAll(Arrays.asList(args).subList(1, args.length));
        System.out.println(s);
    }

    private static void fatalError(String msg) {
        System.err.println(msg);
        System.exit(1);

        // HashSet [a, b, c, d, e, f, z, j, k, l]
        // TreeSet [a, b, c, d, e, f, j, k, l, z]
    }
}
