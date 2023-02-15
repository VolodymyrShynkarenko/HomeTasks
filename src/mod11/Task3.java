package mod11;

import java.util.Arrays;
import java.util.stream.Stream;

public class Task3 {
    static String[] numbers = new String[]{"1, 2, 0", "4, 5"};

    public static void reversUpperWords() {
        String[] allNumbers = Stream.of(numbers)
                .flatMap(str -> Arrays.stream(str.split(", ")))
                .sorted().toArray(String[]::new);

        String output = String.join(", ", allNumbers);
        System.out.println(output);

    }

    public static void main(String[] args) {
        reversUpperWords();
    }
}
