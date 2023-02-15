package mod11;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Task2 {

    public static void getOddNames() {
        List<String> names = new ArrayList<>();
        names.add("Din");
        names.add("Jon");
        names.add("Bill");
        names.add("Fill");
        names.add("Tom");

        System.out.println(names.stream().map(String::toUpperCase)
                .sorted((o1, o2) -> -o1.compareTo(o2))
                .distinct().collect(Collectors.toList()));
    }

    public static void main(String[] args) {
        getOddNames();
    }
}