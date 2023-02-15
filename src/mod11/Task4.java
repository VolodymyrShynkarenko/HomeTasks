package mod11;

import java.util.List;
import java.util.stream.Stream;
import java.util.stream.Collectors;

public class Task4 {
    private static final long a = 0x5DEECE66DL;
    private static final long c = 11;
    private static final long m = 2 ^ 48;

    public static List<Long> createRandomStream() {

        Stream<Long> stream = Stream.iterate(1L, x -> (a * x + c) % m);
        return stream
                .limit(10)
                .peek(System.out::println)
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        createRandomStream();
    }
}
