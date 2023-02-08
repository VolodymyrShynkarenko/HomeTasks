package mod10.task3;

import java.io.*;
import java.util.*;


public class Task3 {
    public static void frequencyWord() {
        Map<String, Integer> wordCounts = new HashMap<>();
        try {
            File file = new File("src/mod10/task3/words.txt");
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line;

            while ((line = bufferedReader.readLine()) != null) {
                String[] words = line.split("\\s+");
                for (String word : words) {
                    word = word.toLowerCase();
                    if (wordCounts.containsKey(word)) {
                        int count = wordCounts.get(word);
                        wordCounts.put(word, ++count);
                    } else {
                        wordCounts.put(word, 1);
                    }
                }
            }
            fileReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        List<Map.Entry<String, Integer>> list = new ArrayList<>(wordCounts.entrySet());
        list.sort((o1, o2) -> o2.getValue().compareTo(o1.getValue()));

        for (Map.Entry<String, Integer> entry : list) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        frequencyWord();
    }
}
