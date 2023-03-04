package mod13;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Scanner;


public class Task2 {
    public static void main(String[] args) throws IOException, JSONException {
        int userId = 1;

        JSONObject lastPost = getLastPostForUser(userId);
        int postId = 0;
        try {
            postId = lastPost.getInt("id");
        } catch (JSONException e) {
            e.printStackTrace();
        }

        JSONArray comments = getCommentsForPost(postId);

        String fileName = "user-" + userId + "-post-" + postId + "-comments.json";
        writeCommentsToFile(fileName, comments);
    }

    private static JSONObject getLastPostForUser(int userId) throws IOException, JSONException {
        URL url = new URL("https://jsonplaceholder.typicode.com/users/" + userId + "/posts");
        InputStream stream = url.openConnection().getInputStream();
        Scanner scanner = new Scanner(stream);
        String response = scanner.useDelimiter("\\A").next();
        JSONArray posts = new JSONArray(response);
        JSONObject lastPost = posts.getJSONObject(posts.length() - 1);
        return lastPost;
    }

    private static JSONArray getCommentsForPost(int postId) throws IOException, JSONException {
        URL url = new URL("https://jsonplaceholder.typicode.com/posts/" + postId + "/comments");
        InputStream stream = url.openConnection().getInputStream();
        Scanner scanner = new Scanner(stream);
        String response = scanner.useDelimiter("\\A").next();
        JSONArray comments = new JSONArray(response);
        return comments;
    }

    private static void writeCommentsToFile(String fileName, JSONArray comments) throws IOException {
        FileWriter fileWriter = new FileWriter(fileName);
        fileWriter.write(comments.toString());
        fileWriter.close();
    }
}