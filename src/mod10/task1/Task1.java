package mod10.task1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Task1 {

    private final static String PHONE_REGEX_1 = "/^(\\(\\d{3}\\))|(\\d{3}-)\\d{3}-\\d{4}$";
    private final static String PHONE_REGEX_2 = "^\\(\\d{3}\\) \\d{3}-\\d{4}$";
    private final static String FILE_PATH = "src/mod10/task1/file.txt";


    private static BufferedReader bufferedReaderBuilder (String filePath) throws FileNotFoundException {
        return new BufferedReader(new FileReader(filePath));
    }

    private static void lineValidatorOutPut(String regex1, String regex2, String line) {
        if (line.matches(regex1) || line.matches(regex2)) {
            System.out.println(line);
        }
    }

    private static void closeBufferedReader (BufferedReader bufferedReader) throws IOException {
        bufferedReader.close();
    }

    public static void phoneValidator () {
        String line;
        try {
            BufferedReader bufferedReader = bufferedReaderBuilder(FILE_PATH);

            while ((line = bufferedReader.readLine()) != null) {
                lineValidatorOutPut(PHONE_REGEX_1, PHONE_REGEX_2, line);
            }
            closeBufferedReader(bufferedReader);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        phoneValidator();
    }
}
