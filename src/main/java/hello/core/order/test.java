package hello.core.order;

import java.util.stream.Stream;

public class test {
    public static void main(String[] args) {

        Stream<Integer> test = Stream.iterate(1, n -> n + 1).limit(6).distinct();
        test.forEach(System.out::println);

    }
}
