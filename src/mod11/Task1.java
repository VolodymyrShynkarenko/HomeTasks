package mod11;

import java.util.ArrayList;
import java.util.List;

public class Task1 {
    public static String getOddNames() {
        List<String> names= new ArrayList<>();
        names.add("Din");
        names.add("Jon");
        names.add("Bill");
        names.add("Fill");
        names.add("Tom");

        StringBuilder sb = new StringBuilder();
        names.stream()
                .filter(name -> names.indexOf(name) % 2 != 1)
                .forEach(name -> sb.append(" ")
                        .append(names.indexOf(name) + 1)
                        .append(". ")
                        .append(name).append(","));
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(getOddNames());
    }
}
