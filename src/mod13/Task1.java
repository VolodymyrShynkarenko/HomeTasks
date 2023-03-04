package mod13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class Task1 {
    public static String createUser(String userJson) {
        String url = "https://jsonplaceholder.typicode.com/users";
        String response = "";

        try {
            URL link = null;
            try {
                link = new URL(url);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
            HttpURLConnection con = (HttpURLConnection) link.openConnection();
            try {
                con.setRequestMethod("POST");
            } catch (ProtocolException e) {
                e.printStackTrace();
            }
            con.setRequestProperty("Content-Type", "application/json; utf-8");
            con.setRequestProperty("Accept", "application/json");
            con.setDoOutput(true);

            try (OutputStream os = con.getOutputStream()) {
                byte[] input = userJson.getBytes(StandardCharsets.UTF_8);
                os.write(input, 0, input.length);
            }

            try (BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(), StandardCharsets.UTF_8))) {
                StringBuilder responseSB = new StringBuilder();
                String responseLine = null;
                while ((responseLine = br.readLine()) != null) {
                    responseSB.append(responseLine.trim());
                }
                response = responseSB.toString();
            }
        } catch (IOException ex) {
            System.out.println(ex);
        }
        return response;

    }

    public static String updateUser(String userJson, int id) {
        String url = "https://jsonplaceholder.typicode.com/users/" + id;
        String response = "";

        try {
            URL link = new URL(url);
            HttpURLConnection con = (HttpURLConnection) link.openConnection();
            con.setRequestMethod("PUT");
            con.setRequestProperty("Content-Type", "application/json; utf-8");
            con.setRequestProperty("Accept", "application/json");
            con.setDoOutput(true);

            try (OutputStream os = con.getOutputStream()) {
                byte[] input = userJson.getBytes(StandardCharsets.UTF_8);
                os.write(input, 0, input.length);
            }

            try (BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(), StandardCharsets.UTF_8))) {
                StringBuilder responseSB = new StringBuilder();
                String responseLine = null;
                while ((responseLine = br.readLine()) != null) {
                    responseSB.append(responseLine.trim());
                }
                response = responseSB.toString();
            }
        } catch (IOException ex) {
            System.out.println(ex);
        }
        return response;
    }

    public static int deleteUser(int id) {
        String url = "https://jsonplaceholder.typicode.com/users/" + id;
        int responseCode = 0;

        try {
            URL link = new URL(url);
            HttpURLConnection con = (HttpURLConnection) link.openConnection();
            con.setRequestMethod("DELETE");
            con.setRequestProperty("Content-Type", "application/json; utf-8");
            con.setRequestProperty("Accept", "application/json");

            responseCode = con.getResponseCode();
        } catch (IOException ex) {
            System.out.println(ex);
        }
        return responseCode;
    }

    public static String getAllUsers() {
        String url = "https://jsonplaceholder.typicode.com/users";
        String response = "";

        try {
            URL link = new URL(url);
            HttpURLConnection con = (HttpURLConnection) link.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("Content-Type", "application/json; utf-8");
            con.setRequestProperty("Accept", "application/json");

            try (BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(), StandardCharsets.UTF_8))) {
                StringBuilder responseSB = new StringBuilder();
                String responseLine = null;
                while ((responseLine = br.readLine()) != null) {
                    responseSB.append(responseLine.trim());
                }
                response = responseSB.toString();
            }
        } catch (IOException ex) {
            System.out.println(ex);
        }
        System.out.println(response);
        return response;
    }

    public static String getUserById(int id) {
        String url = "https://jsonplaceholder.typicode.com/users/" + id;
        String response = "";

        try {
            URL link = new URL(url);
            HttpURLConnection con = (HttpURLConnection) link.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("Content-Type", "application/json; utf-8");
            con.setRequestProperty("Accept", "application/json");

            try (BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(), StandardCharsets.UTF_8))) {
                StringBuilder responseSB = new StringBuilder();
                String responseLine = null;
                while ((responseLine = br.readLine()) != null) {
                    responseSB.append(responseLine.trim());
                }
                response = responseSB.toString();
            }
        } catch (IOException ex) {
            System.out.println(ex);
        }
        return response;
    }

    public static String getUserByUsername(String username) {
        String url = "https://jsonplaceholder.typicode.com/users?username=" + username;
        String response = "";

        try {
            URL link = new URL(url);
            HttpURLConnection con = (HttpURLConnection) link.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("Content-Type", "application/json; utf-8");
            con.setRequestProperty("Accept", "application/json");

            try (BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(), StandardCharsets.UTF_8))) {
                StringBuilder responseSB = new StringBuilder();
                String responseLine = null;
                while ((responseLine = br.readLine()) != null) {
                    responseSB.append(responseLine.trim());
                }
                response = responseSB.toString();
            }
        } catch (IOException ex) {
            System.out.println(ex);
        }
        System.out.println(response);
        return response;
    }

    public static void main(String[] args) {
        Task1.createUser("Bob Nilson");
        Task1.updateUser("Bob Nilson", Integer.parseInt("1"));
        Task1.deleteUser(3);
        Task1.getAllUsers();
        Task1.getUserById(4);
        Task1.getUserByUsername("Deckow-Crist");
    }
}




