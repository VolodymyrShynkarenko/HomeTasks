package mod11;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

public class Task5 {

    public static Stream zip(Stream first, Stream second) {
        Iterator one = first.iterator();
        Iterator two = second.iterator();
        List result = new ArrayList<>();
        while (one.hasNext() && two.hasNext()) {
            result.add(one.next());
            result.add(two.next());
        } return result.stream();
    }

    public static void main(String[] args) {
        Stream first = Stream.of(1, 2, 3, 4, 5);
        Stream second = Stream.of(10, 20, 30, 40);
        Stream result = zip(first, second);
        result.forEach(System.out::println);
    }
}
