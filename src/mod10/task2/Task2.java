package mod10.task2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class Task2 {
    public static void transformation() {
        String line;

        List userList = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader("src/mod10/task2/file.txt"))) {
            String headerLine = br.readLine();

            while ((line = br.readLine()) != null) {
                String[] fields = line.split(" ");
                User user = new User();
                user.setName(fields[0]);
                user.setAge(Integer.parseInt(fields[1]));
                userList.add(user);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        try (FileWriter fw = new FileWriter("user.json")) {
            StringBuilder sb = new StringBuilder();
            sb.append("[");
            for (Object user : userList) {
                sb.append("{\n");
                sb.append("\"name\":" + "\"" + User.getName() + "\",\n");
                sb.append("\"age\":" + User.getAge() + "\n");
                sb.append("},\n");
            }
            sb.append("]");
            fw.write(sb.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class User {
    private static String name;
    private static int age;

    public static String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public static void main(String[] args) {
        Task2.transformation();
    }
}